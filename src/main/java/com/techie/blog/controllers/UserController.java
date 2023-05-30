package com.techie.blog.controllers;

import com.techie.blog.entities.User;
import com.techie.blog.payloads.ApiResponse;
import com.techie.blog.payloads.UserDto;
import com.techie.blog.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
//  POST -create a new user
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createdUserDto=this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }
    //    PUT-update the existing user
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer userId){
        UserDto updatedUser=this.userService.UpdateUser(userDto,userId);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }
//    DELETE-delete the existing user
@DeleteMapping("/{userId}")
public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId){
        this.userService.deleteUser(userId);
        return  new ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully",true),HttpStatus.OK);
}
//    GET-get the user by ID
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Integer userId){
       UserDto user=this.userService.getUser(userId);
        return new ResponseEntity<>(user,HttpStatus.FOUND);
    }
//    GET-get all the users
@GetMapping("/all")
public ResponseEntity<List<UserDto>> getAlUsers(){
     List<UserDto> users=this.userService.getAllUsers();
    return new ResponseEntity<>(users,HttpStatus.FOUND);
}
}
