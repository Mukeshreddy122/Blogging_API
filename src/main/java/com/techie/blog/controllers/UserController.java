package com.techie.blog.controllers;

import com.techie.blog.entities.User;
import com.techie.blog.payloads.UserDto;
import com.techie.blog.services.UserService;
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
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto createdUserDto=this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }
    //    PUT-update the existing user
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") Integer userId){
        UserDto updatedUser=this.userService.UpdateUser(userDto,userId);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }
//    DELETE-delete the existing user
@DeleteMapping("/{userId}")
public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer userId){
        this.deleteUser(userId);
        return  new ResponseEntity(Map.of("Message","User deleted Successfully "),HttpStatus.OK);
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
