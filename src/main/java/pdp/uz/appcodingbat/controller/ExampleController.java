package pdp.uz.appcodingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appcodingbat.entity.Example;
import pdp.uz.appcodingbat.payload.ExampleDto;
import pdp.uz.appcodingbat.payload.Result;
import pdp.uz.appcodingbat.service.ExampleService;

import java.util.List;

@RestController
@RequestMapping("/api/example")
public class ExampleController {
    @Autowired
    ExampleService exampleService;

    @PostMapping
    public Result addExample(@RequestBody ExampleDto exampleDto) {
        Result result = exampleService.addExample(exampleDto);
        return result;
    }

    //Delete
    @DeleteMapping(value = "/api/example/{exampleId}")
    public Result deleteExample(@PathVariable Integer exampleId) {
        Result result = exampleService.deleteExample(exampleId);
        return result;
    }

    //Update
    @PutMapping (value = "/api/example/{exampleId}")
    public Result editExample(@PathVariable Integer exampleId, @RequestBody ExampleDto exampleDto) {
        Result result = exampleService.editExample(exampleId, exampleDto);
        return result;
    }

    @GetMapping
    public List<Example> getExamples() {
        List<Example> examples = exampleService.getExamples();
        return examples;
    }
}
