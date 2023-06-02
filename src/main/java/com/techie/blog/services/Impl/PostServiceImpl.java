package com.techie.blog.services.Impl;

import com.techie.blog.entities.Category;
import com.techie.blog.entities.Post;
import com.techie.blog.entities.User;
import com.techie.blog.exceptions.ResourceNotFoundException;
import com.techie.blog.payloads.PostDto;
import com.techie.blog.repositories.CategoryRepo;
import com.techie.blog.repositories.PostRepo;
import com.techie.blog.repositories.UserRepo;
import com.techie.blog.services.PostService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    Logger logger =  LoggerFactory.getLogger(PostServiceImpl.class);
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public PostDto createPost(PostDto postdto,Integer userId,Integer categoryId) {
        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
        Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Id",categoryId));
        Post post =this.modelMapper.map(postdto,Post.class);
        post.setImageName("default.png");
        post.setCreatedDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post createdPost=this.postRepo.save(post);
        return this.modelMapper.map(createdPost,PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postdto, Integer postId) {
        Post post =this.modelMapper.map(postdto,Post.class);
        Post foundPost=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","Id",postId));
        post.setTitle(foundPost.getTitle());
        post.setContent(foundPost.getContent());
        Post newPost=this.postRepo.save(foundPost);
        return this.modelMapper.map(newPost,PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public Post getPostById(Integer postId) {
        Post foundPost=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","Id",postId));
        return null;
    }

    @Override
    public List<Post> getAllPosts() {
        return null;
    }

    @Override
    public List<Post> getPostByCategory(Integer categoryId) {
        return null;
    }

    @Override
    public List<Post> getPostByUser(Integer userId) {
        return null;
    }

    @Override
    public List<Post> searchPost(String searchKey) {
        return null;
    }

}
