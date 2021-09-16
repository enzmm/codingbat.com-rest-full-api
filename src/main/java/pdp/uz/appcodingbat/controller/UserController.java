package pdp.uz.appcodingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appcodingbat.entity.Category;
import pdp.uz.appcodingbat.entity.User;
import pdp.uz.appcodingbat.payload.Result;
import pdp.uz.appcodingbat.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getUsers() {
        List<User> users = userService.getUsers();
        return users;
    }

    //Delete
    @DeleteMapping(value = "/api/user/{userId}")
    public Result deleteUser(@PathVariable Integer userId) {
        Result result = userService.deleteUser(userId);
        return result;
    }

    @PostMapping
    public Result addUser(@RequestBody User user){
        Result result = userService.addUser(user);
        return result;
    }

    //Update
    @PutMapping (value = "/api/user/{userId}")
    public Result editUser(@PathVariable Integer userId, @RequestBody User user) {
        Result result = userService.editUser(userId,user);
        return result;
    }


}
