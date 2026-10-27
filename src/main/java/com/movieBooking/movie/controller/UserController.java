package com.movieBooking.movie.controller;

import com.movieBooking.movie.entity.User;
import com.movieBooking.movie.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUser(){
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById (@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping(value = "/users", params = "name")
    public List<User> findUserByName (@RequestParam String name){
        return userService.getAllUserByName(name);
    }

    @GetMapping(value = "/users", params = {"name", "age"})
    public List<User> findUserByNameAndAge(@RequestParam String name, @RequestParam Integer age){
        return userService.getUserByNameAndAge(name, age);
    }

    @GetMapping(value = "/users", params = {"minAge", "maxAge"})
    public List<User> findUserRange(@RequestParam Integer minAge, @RequestParam Integer maxAge){
        return userService.findUserAgeRange(minAge, maxAge);
    }

    @GetMapping(value = {"/users"}, params = "minAge")
    public List<User> findSortedUser(@RequestParam Integer minAge){
        return  userService.findSortedUser(minAge);
    }

    @PostMapping("/users")
    public User createUser (@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/users")
    public User updateUser (@PathVariable Long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById (@PathVariable Long id){
        userService.deleteUser(id);
    }

}
