package com.techie.blog.services;

import com.techie.blog.entities.Post;
import com.techie.blog.payloads.PostDto;

import java.util.List;

public interface PostService {
//    create Post
    PostDto createPost(PostDto postdto);
//    update Post
    PostDto updatePost(PostDto postdto,Integer postId);
//    delete Post
    void deletePost(Integer postId);
//  get post by ID
    List<Post> getAllPosts();
//    get all the posts
    Post getPostById(Integer postId);
//    get post by category
    List<Post> getPostByCategory(Integer categoryId);
//    get all posts by user
    List<Post> getPostByUser(Integer userId);
//    search post
    List<Post> searchPost(String searchKey);
}
