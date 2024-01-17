package com.microservicePost.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="posts")
@Data
public class Post {

    @Id
    private String postId;
    private String title;
    private String description;
    private String content;
}
