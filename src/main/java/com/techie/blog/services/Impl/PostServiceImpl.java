package com.techie.blog.services.Impl;

import com.techie.blog.entities.Post;
import com.techie.blog.payloads.PostDto;
import com.techie.blog.repositories.PostRepo;
import com.techie.blog.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public PostDto createPost(PostDto postdto) {
        Post post =this.modelMapper.map(postdto,Post.class);
        post.setImageName("default.png");
        post.setCreatedDate(new Date());

        return null;
    }

    @Override
    public PostDto updatePost(PostDto postdto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public Post getPostById(Integer postId) {
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
