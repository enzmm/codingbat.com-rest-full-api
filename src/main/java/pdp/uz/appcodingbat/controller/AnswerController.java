package pdp.uz.appcodingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appcodingbat.entity.Answer;
import pdp.uz.appcodingbat.entity.Example;
import pdp.uz.appcodingbat.payload.AnswerDto;
import pdp.uz.appcodingbat.payload.ExampleDto;
import pdp.uz.appcodingbat.payload.Result;
import pdp.uz.appcodingbat.service.AnswerService;

import java.util.List;

@RestController
@RequestMapping("/api/answer")
public class AnswerController {
    @Autowired
    AnswerService answerService;

    @PostMapping
    public Result addAnswer(@RequestBody AnswerDto answerDto) {
        Result result = answerService.addAnswer(answerDto);
        return result;
    }

    //Delete
    @DeleteMapping(value = "/api/answer/{answerId}")
    public Result deleteAnswer(@PathVariable Integer answerId) {
        Result result = answerService.deleteAnswer(answerId);
        return result;
    }

    //Update
    @PutMapping (value = "/api/answer/{answerId}")
    public Result editAnswer(@PathVariable Integer answerId, @RequestBody AnswerDto answerDto) {
        Result result = answerService.editAnswer(answerId, answerDto);
        return result;
    }

    @GetMapping
    public List<Answer> getAnswers() {
        List<Answer> answers = answerService.getAnswers();
        return answers;
    }

}
