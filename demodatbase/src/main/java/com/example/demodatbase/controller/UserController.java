package com.example.demodatbase.controller;


import com.example.demodatbase.dto.request.UserCreationRequest;
import com.example.demodatbase.dto.request.UserUpdateRequest;
import com.example.demodatbase.entity.User;
import com.example.demodatbase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


//    @PostMapping("/users")
    @PostMapping
    User create(@RequestBody UserCreationRequest request){
        return  userService.createUser(request);
    }
//    @GetMapping("/users")
    @GetMapping
    List<User> getUser(){
        return userService.getUsers();
    }
    @GetMapping("/{userID}")
    User getUser(@PathVariable("userID") String userID){
        return userService.getUser(userID);
    }
    @PutMapping("/{userID}")
    User updateUser(@PathVariable String userID, @RequestBody UserUpdateRequest request){
        return userService.updateUser(userID,request);
    }
    @DeleteMapping("/{userID}")
    String deleteUser(@PathVariable String userID){
        userService.deleteUser(userID);
        return "user has been deleted";
    }



}
