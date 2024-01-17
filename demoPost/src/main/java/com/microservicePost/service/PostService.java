package com.microservicePost.service;

import com.microservicePost.configure.RestTemplateConfig;
import com.microservicePost.entity.Post;
import com.microservicePost.payload.PostDto;
import com.microservicePost.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private RestTemplateConfig restTemplateConfig;

    public Post savePost(Post post) {

        String id = UUID.randomUUID().toString();
        post.setPostId(id);
        Post saved = postRepository.save(post);
        return saved;
    }

    public Post findPostById(String postId) {
        Post post = postRepository.findById(postId).get();
        return post;
    }

    public PostDto findCommentsByPostId(String postId) {
        ArrayList comments = restTemplateConfig.restTemplate().getForObject("http://COMMENT-SERVICE/api/comments/" + postId, ArrayList.class);

        Post post = postRepository.findById(postId).get();

        PostDto postDto=new PostDto();
        postDto.setPostId(postId);
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setDescription(post.getDescription());
        postDto.setComments(comments);

        return postDto;

    }
}
