package com.example.demodatbase.mapper;


import com.example.demodatbase.dto.request.UserCreationRequest;
import com.example.demodatbase.dto.request.UserUpdateRequest;
import com.example.demodatbase.dto.response.UserResponse;
import com.example.demodatbase.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
//    @Mapping(source = "firstName", target = "lastName")
//              or ignore = true)
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
