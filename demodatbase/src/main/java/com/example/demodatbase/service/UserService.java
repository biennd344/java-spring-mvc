package com.example.demodatbase.service;

import com.example.demodatbase.dto.request.UserCreationRequest;
import com.example.demodatbase.dto.request.UserUpdateRequest;
import com.example.demodatbase.dto.response.UserResponse;
import com.example.demodatbase.entity.User;
import com.example.demodatbase.exception.AppException;
import com.example.demodatbase.exception.ErrorCode;
import com.example.demodatbase.mapper.UserMapper;
import com.example.demodatbase.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
//    @Autowired
    UserRepository userRepository;
//    @Autowired
    UserMapper userMapper;
    public User createUser(UserCreationRequest request){

        if (userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toUser(request);

        return userRepository.save(user);

    }


//    public User createUser(UserCreationRequest request){
//        User user = new User();
//        if (userRepository.existsByUsername(request.getUsername()))
//            throw new AppException(ErrorCode.USER_EXISTED);
//
////        UserCreationRequest request1 = UserCreationRequest.builder()
////                .username("")
////                .firstname("")
////
////                .build();
//
//        user.setUsername(request.getUsername());
//        user.setPassword(request.getPassword());
//        user.setFirstname(request.getFirstname());
//        user.setLastName(request.getLastName());
//        user.setDob(request.getDob());
//
//        return userRepository.save(user);
//
//    }
//    public User updateUser(String userID, UserUpdateRequest request){
//        User user = getUser(userID);
//        user.setPassword(request.getPassword());
//        user.setFirstname(request.getFirstname());
//        user.setLastName(request.getLastName());
//        user.setDob(request.getDob());
//        return userRepository.save(user);
//    }
    public UserResponse updateUser(String userID, UserUpdateRequest request){
        User user = userRepository.findById(userID)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userMapper.updateUser(user, request);
        return userMapper.toUserResponse(userRepository.save(user));
    }
    public void deleteUser(String userID){
        userRepository.deleteById(userID);
    }


    public List<User> getUsers(){
        return  userRepository.findAll();
    }
    public UserResponse getUser(String id){
        return  userMapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found")));
    }




}
