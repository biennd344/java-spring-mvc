package com.example.demodatbase.service;

import com.example.demodatbase.dto.request.UserCreationRequest;
import com.example.demodatbase.dto.request.UserUpdateRequest;
import com.example.demodatbase.entity.User;
import com.example.demodatbase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstname());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return userRepository.save(user);

    }
    public User updateUser(String userID, UserUpdateRequest request){
        User user = getUser(userID);
        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstname());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());
        return userRepository.save(user);
    }
    public void deleteUser(String userID){
        userRepository.deleteById(userID);
    }


    public List<User> getUsers(){
        return  userRepository.findAll();
    }
    public  User getUser(String id){
        return  userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }




}
