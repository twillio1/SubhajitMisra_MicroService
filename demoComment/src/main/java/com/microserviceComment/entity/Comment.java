package com.microserviceComment.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@Data
public class Comment {
    @Id
    private String commentId;
    private String name;
    private String email;
    private String body;
    private String postId;
}
