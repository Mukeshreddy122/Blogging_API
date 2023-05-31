package com.techie.blog.repositories;

import com.techie.blog.entities.Category;
import com.techie.blog.entities.Post;
import com.techie.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
