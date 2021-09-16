package pdp.uz.appcodingbat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appcodingbat.entity.Example;
import pdp.uz.appcodingbat.entity.Task;
import pdp.uz.appcodingbat.payload.ExampleDto;
import pdp.uz.appcodingbat.payload.Result;
import pdp.uz.appcodingbat.repository.ExampleRepository;
import pdp.uz.appcodingbat.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExampleService {
    @Autowired
    ExampleRepository exampleRepository;
    @Autowired
    TaskRepository taskRepository;

    @PostMapping
    public Result addExample(@RequestBody ExampleDto exampleDto) {
        Optional<Task> optionalTask = taskRepository.findById(exampleDto.getTaskId());
        if (!optionalTask.isPresent())
            return new Result("BUnday example mavjud emas", false);
        Example example1 = new Example();
        example1.setExampleText(exampleDto.getExampleText());
        example1.setTask(optionalTask.get());
        exampleRepository.save(example1);
        return new Result("Example", true);
    }

    @DeleteMapping(value = "/api/example/{exampleId}")
    public Result deleteExample(@PathVariable Integer exampleId){
        exampleRepository.deleteById(exampleId);
        return new Result("delete",true);
    }

    @PutMapping("/api/example/{exampleId}")
    public Result editExample(@PathVariable Integer exampleId , @RequestBody ExampleDto exampleDto) {
        Optional<Example> optionalExample = exampleRepository.findById(exampleDto.getExampleId());
        if (optionalExample.isPresent()) {
            Example example1 = optionalExample.get();
            example1.setExampleText(exampleDto.getExampleText());
            example1.setTask(taskRepository.getById(exampleDto.getTaskId()));
            exampleRepository.save(example1);
        }
        return new Result("edit qilindi", true);
    }

    @GetMapping
    public List<Example> getExamples()
    {
        return  exampleRepository.findAll();
    }
}
