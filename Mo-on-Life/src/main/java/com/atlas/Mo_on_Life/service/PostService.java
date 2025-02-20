package com.atlas.Mo_on_Life.service;

import com.atlas.Mo_on_Life.entity.Post;
import com.atlas.Mo_on_Life.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts(Integer page, Integer pageSize){
        return postRepository.findAll(PageRequest.of(page, pageSize)).getContent();
    }

    public Optional<Post> getPostCreatedAtAndSlug(String slug, LocalDate createdAt){
        return postRepository.findByCreatedAtAndSlug(createdAt, slug);
    }

    public void savePost(Post post){
        postRepository.save(post);
    }

    public List<Post> getTop10(String name){

        return postRepository.findTop10ByTags_NameOrderByViewCountDesc(name);
    }

    public void incrementViewCount(Post post){
        post.setViewCount(post.getViewCount() + 1);
        postRepository.save(post);

    }


}
