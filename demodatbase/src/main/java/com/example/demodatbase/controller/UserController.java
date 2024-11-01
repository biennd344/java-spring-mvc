package com.example.demodatbase.controller;


import com.example.demodatbase.dto.request.ApiResponse;
import com.example.demodatbase.dto.request.UserCreationRequest;
import com.example.demodatbase.dto.request.UserUpdateRequest;
import com.example.demodatbase.dto.response.UserResponse;
import com.example.demodatbase.entity.User;
import com.example.demodatbase.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
//    @Autowired
     UserService userService;


//    @PostMapping("/users")
    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request){
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));
        return  apiResponse;
    }
//    @GetMapping("/users")
    @GetMapping
    List<User> getUser(){
        return userService.getUsers();
    }
    @GetMapping("/{userID}")
    UserResponse getUser(@PathVariable("userID") String userID){
        return userService.getUser(userID);
    }
    @PutMapping("/{userID}")
    UserResponse updateUser(@PathVariable String userID, @RequestBody UserUpdateRequest request){
        return userService.updateUser(userID,request);
    }
    @DeleteMapping("/{userID}")
    String deleteUser(@PathVariable String userID){
        userService.deleteUser(userID);
        return "user has been deleted";
    }



}
