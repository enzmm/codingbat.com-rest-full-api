package pdp.uz.appcodingbat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appcodingbat.entity.Category;
import pdp.uz.appcodingbat.entity.User;
import pdp.uz.appcodingbat.payload.Result;
import pdp.uz.appcodingbat.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> getUsers()
    {
        return  userRepository.findAll();
    }

    @DeleteMapping(value = "/api/user/{userId}")
    public Result deleteUser(@PathVariable Integer userId){
        userRepository.deleteById(userId);
        return new Result("delete",true);
    }

    @PostMapping
    public Result addUser(@RequestBody User user) {
        User user1 = new User();
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        userRepository.save(user1);
        return new Result("user", false);
    }

    @PutMapping("/api/user/{userId}")
    public Result editUser(@PathVariable Integer userId , @RequestBody User user) {
        Optional<User> optionalUser = userRepository.findById(user.getUserId());
        if (optionalUser.isPresent()) {
            User user1 = optionalUser.get();
            user1.setEmail(user.getEmail());
            user1.setPassword(user.getPassword());
            userRepository.save(user1);
        }
        return new Result("edit qilindi", true);
    }
}
