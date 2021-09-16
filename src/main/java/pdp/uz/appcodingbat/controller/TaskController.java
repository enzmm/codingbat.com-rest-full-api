package pdp.uz.appcodingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appcodingbat.entity.Example;
import pdp.uz.appcodingbat.entity.Task;
import pdp.uz.appcodingbat.payload.ExampleDto;
import pdp.uz.appcodingbat.payload.Result;
import pdp.uz.appcodingbat.payload.TaskDto;
import pdp.uz.appcodingbat.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping
    public Result addTask(@RequestBody TaskDto taskDto) {
        Result result = taskService.addTask(taskDto);
        return result;
    }

    //Delete
    @DeleteMapping(value = "/api/task/{taskId}")
    public Result deleteTask(@PathVariable Integer taskId) {
        Result result = taskService.deleteTask(taskId);
        return result;
    }

    //Update
    @PutMapping (value = "/api/task/{taskId}")
    public Result editTask(@PathVariable Integer taskId, @RequestBody TaskDto taskDto) {
        Result result = taskService.editTask(taskId, taskDto);
        return result;
    }

    @GetMapping
    public List<Task> getTasks() {
        List<Task> tasks = taskService.getTasks();
        return tasks;
    }
}
