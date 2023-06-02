package com.techie.blog.controllers;

import com.techie.blog.entities.Post;
import com.techie.blog.payloads.PostDto;
import com.techie.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class PostController {
    @Autowired
    private PostService postService;
//    create a new post
    @PostMapping("user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,@PathVariable Integer categoryId){
        PostDto createdpost=this.postService.createPost(postDto,userId,categoryId);
        return new ResponseEntity<>(createdpost, HttpStatus.CREATED);
    }

}
