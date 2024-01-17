package com.microservicePost.payload;

import lombok.Data;


import java.util.List;

@Data
public class PostDto {
    private String postId;
    private String title;
    private String content;
    private String description;
    private List<Comment> comments;
}
