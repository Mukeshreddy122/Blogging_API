package com.techie.blog.services;
import com.techie.blog.entities.User;
import com.techie.blog.payloads.UserDto;
import java.util.List;


public interface UserService {

    //    creating the user
    UserDto createUser(UserDto userdto);


    UserDto UpdateUser(UserDto user, Integer userId);
    UserDto getUser(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);
}
