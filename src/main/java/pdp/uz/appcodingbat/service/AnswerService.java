package pdp.uz.appcodingbat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appcodingbat.entity.Answer;
import pdp.uz.appcodingbat.entity.Example;
import pdp.uz.appcodingbat.entity.Task;
import pdp.uz.appcodingbat.entity.User;
import pdp.uz.appcodingbat.payload.AnswerDto;
import pdp.uz.appcodingbat.payload.ExampleDto;
import pdp.uz.appcodingbat.payload.Result;
import pdp.uz.appcodingbat.repository.AnswerRepository;
import pdp.uz.appcodingbat.repository.TaskRepository;
import pdp.uz.appcodingbat.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserRepository userRepository;

    @PostMapping
    public Result addAnswer(@RequestBody AnswerDto answerDto) {
        Optional<Task> optionalTask = taskRepository.findById(answerDto.getTaskId());
        if (!optionalTask.isPresent())
            return new Result("BUnday task mavjud emas", false);
        Optional<User> optionalUser = userRepository.findById(answerDto.getUserId());
        if (!optionalUser.isPresent())
            return new Result("BUnday user mavjud emas", false);
        Answer answer = new Answer();
        answer.setCorrect(answerDto.getCorrect());
        answer.setTask(optionalTask.get());
        answer.setUsers(optionalUser.get());
        answerRepository.save(answer);
        return new Result("Answer", true);
    }

    @DeleteMapping(value = "/api/answer/{answerId}")
    public Result deleteAnswer(@PathVariable Integer answerId){
        answerRepository.deleteById(answerId);
        return new Result("delete",true);
    }

    @PutMapping("/api/answer/{answerId}")
    public Result editAnswer(@PathVariable Integer answerId , @RequestBody AnswerDto answerDto) {
        Optional<Answer> optionalAnswer = answerRepository.findById(answerDto.getAnswerId());
        if (optionalAnswer.isPresent()) {
            Answer answer = optionalAnswer.get();
            answer.setCorrect(answerDto.getCorrect());
            answer.setText(answerDto.getText());
            answer.setTask(taskRepository.getById(answerDto.getTaskId()));
            answer.setUsers(userRepository.getById(answerDto.getUserId()));
            answerRepository.save(answer);
        }
        return new Result("edit qilindi", true);
    }

    @GetMapping
    public List<Answer> getAnswers()
    {
        return  answerRepository.findAll();
    }
}
