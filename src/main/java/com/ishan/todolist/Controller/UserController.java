package com.ishan.todolist.Controller;

import com.ishan.todolist.model.User;
import com.ishan.todolist.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("create")
    public User createUser(@Valid @RequestBody User user){
        return userService.createUser(user);
    }
    @GetMapping("get")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PutMapping("put")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id){ return userService.deleteUser(id); }
}
