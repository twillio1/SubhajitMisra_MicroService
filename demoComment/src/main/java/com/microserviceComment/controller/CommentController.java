package com.microserviceComment.controller;

import com.microserviceComment.entity.Comment;
import com.microserviceComment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment)
    {
     Comment saved= commentService.createComment(comment);
     return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<List<Comment>> findCommentsByPostId(@PathVariable String postId)
    {
        List<Comment> comments= commentService.findCommentsByPostId(postId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
}
