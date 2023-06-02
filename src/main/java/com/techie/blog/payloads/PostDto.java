package com.techie.blog.payloads;

import com.techie.blog.entities.Category;
import com.techie.blog.entities.User;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
public class PostDto {
    private String title;
    private String content;
    private String imageName;
    private Category categoryId;
    private User userId;
}
