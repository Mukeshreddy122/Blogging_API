package com.techie.blog.services.Impl;

import com.techie.blog.entities.User;
import com.techie.blog.exceptions.ResourceNotFoundException;
import com.techie.blog.payloads.UserDto;
import com.techie.blog.repositories.UserRepo;
import com.techie.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDto createUser(UserDto userdto) {
        User user=this.dtoToUser(userdto);
        User savedUser=this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto UpdateUser(UserDto userdto, Integer userId) {
        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
        user.setName(userdto.getName());
        user.setEmail(userdto.getEmail());
        user.setAbout(userdto.getAbout());
        user.setPassword(userdto.getPassword());
        User updatedUser=this.userRepo.save(user);
        return this.userToDto(updatedUser);
    }

    @Override
    public UserDto getUser(Integer userId) {
        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users=this.userRepo.findAll();
        List<UserDto> userDtos=users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
        this.userRepo.delete(user);
    }
    private User dtoToUser(UserDto userDto){
        User newUser=new User();
        newUser.setId(userDto.getId());
        newUser.setName(userDto.getName());
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(userDto.getPassword());
        newUser.setAbout(userDto.getAbout());
        return newUser;
    }
    private UserDto userToDto(User user){
        UserDto newUserDto=new UserDto();
        newUserDto.setId(user.getId());
        newUserDto.setName(user.getName());
        newUserDto.setEmail(user.getEmail());
        newUserDto.setPassword(user.getPassword());
        newUserDto.setAbout(user.getAbout());
        return newUserDto;
    }
}
