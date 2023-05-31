package com.techie.blog.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Table(name = "post")
@Entity
@NoArgsConstructor
@Setter
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String imageName;
    @Column
    private Date createdDate;
    @ManyToOne
    @Column(name = "category_id",nullable = false)
    @JoinColumn
    private Category category;
    @Column(name = "user_id",nullable = false)
    @ManyToOne
    private  User user;


}
