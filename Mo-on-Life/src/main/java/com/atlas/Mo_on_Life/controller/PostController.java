package com.atlas.Mo_on_Life.controller;
import com.atlas.Mo_on_Life.entity.Post;
import com.atlas.Mo_on_Life.exception.PostNotFoundException;
import com.atlas.Mo_on_Life.service.PostService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;


@Controller
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // Getting the post via creation date, and slug (title with better url'ing)
    @GetMapping("/{year}/{month}/{day}/{slug}")
    public String viewPost(@PathVariable String slug,
                           @PathVariable int year,
                           @PathVariable int month,
                           @PathVariable int day,
                           Model model){

        Post post = postService.getPostSlug(slug)
                .orElseThrow(() -> new PostNotFoundException("Post not found"));
        // if post is empty, throws PostNotFoundException. Our custom exception. When thrown the exception returns 404 page

        postService.incrementViewCount(post); // increments and saves the post

        model.addAttribute("post", post); // adds post to the model
        return "post/view";
    }

}
