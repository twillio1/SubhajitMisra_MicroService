package com.microserviceComment.service;

import com.microserviceComment.config.RestTemplateConfig;
import com.microserviceComment.entity.Comment;
import com.microserviceComment.payload.Post;
import com.microserviceComment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private RestTemplateConfig restTemplateConfig;

    public Comment createComment(Comment comment) {
        Post post = restTemplateConfig.restTemplate().getForObject("http://POST-SERVICE/api/posts/" + comment.getPostId(), Post.class);

        if(post!=null)
        {
            String id = UUID.randomUUID().toString();
            comment.setCommentId(id);
            Comment saved = commentRepository.save(comment);
            return saved;
        }else {
            return null;
        }
    }

    public List<Comment> findCommentsByPostId(String postId) {
        Post post = restTemplateConfig.restTemplate().getForObject("http://POST-SERVICE/api/posts/" + postId, Post.class);
        if(post!=null)
        {
            List<Comment> comments = commentRepository.findByPostId(postId);
            return comments;
        }else {
            return null;
        }
    }
}
