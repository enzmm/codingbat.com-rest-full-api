package pdp.uz.appcodingbat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appcodingbat.entity.Example;
import pdp.uz.appcodingbat.entity.Language;
import pdp.uz.appcodingbat.entity.Task;
import pdp.uz.appcodingbat.payload.ExampleDto;
import pdp.uz.appcodingbat.payload.Result;
import pdp.uz.appcodingbat.payload.TaskDto;
import pdp.uz.appcodingbat.repository.LanguageRepository;
import pdp.uz.appcodingbat.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    LanguageRepository languageRepository;

    @PostMapping
    public Result addTask(@RequestBody TaskDto taskDto) {
        Optional<Language> optionalLanguage = languageRepository.findById(taskDto.getLanguageId());
        if (!optionalLanguage.isPresent())
            return new Result("BUnday language mavjud emas", false);
        Task task = new Task();
        task.setTaskName(taskDto.getTaskName());
        task.setTaskText(taskDto.getTaskText());
        task.setHint(taskDto.getHint());
        task.setMethod(taskDto.getMethod());
        task.setSolution(taskDto.getSolution());
        taskRepository.save(task);
        return new Result("Task", true);
    }

    @DeleteMapping(value = "/api/task/{taskId}")
    public Result deleteTask(@PathVariable Integer taskId){
        taskRepository.deleteById(taskId);
        return new Result("delete",true);
    }

    @PutMapping("/api/task/{taskId}")
    public Result editTask(@PathVariable Integer taskId , @RequestBody TaskDto taskDto) {
        Optional<Task> optionalTask = taskRepository.findById(taskDto.getTaskId());
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setTaskName(taskDto.getTaskName());
            task.setTaskText(taskDto.getTaskText());
            task.setHint(taskDto.getHint());
            task.setMethod(taskDto.getMethod());
            task.setSolution(taskDto.getSolution());
            task.setLanguage(languageRepository.getById(taskDto.getLanguageId()));
            taskRepository.save(task);
        }
        return new Result("edit qilindi", true);
    }

    @GetMapping
    public List<Task> getTasks()
    {
        return  taskRepository.findAll();
    }
}
