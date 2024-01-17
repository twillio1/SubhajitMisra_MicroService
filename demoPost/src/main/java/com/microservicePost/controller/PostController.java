package com.microservicePost.controller;

import com.microservicePost.entity.Post;
import com.microservicePost.payload.PostDto;
import com.microservicePost.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post)
    {
        Post saved=postService.savePost(post);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> findPostById(@PathVariable String postId)
    {
        Post post=postService.findPostById(postId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/{postId}/comments")
    public ResponseEntity<PostDto> findCommentsByPostId(@PathVariable String postId)
    {
        PostDto postDto=postService.findCommentsByPostId(postId);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }
}
