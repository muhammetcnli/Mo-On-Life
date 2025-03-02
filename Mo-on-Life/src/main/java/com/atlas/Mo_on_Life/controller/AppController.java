package com.atlas.Mo_on_Life.controller;

import com.atlas.Mo_on_Life.entity.Post;
import com.atlas.Mo_on_Life.entity.Tag;
import com.atlas.Mo_on_Life.repository.PostRepository;
import com.atlas.Mo_on_Life.service.PostService;
import com.atlas.Mo_on_Life.service.TagService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.*;

@Controller
public class AppController {

    private final PostService postService;
    private final TagService tagService;

    @Autowired
    public AppController(PostService postService, TagService tagService) {
        this.postService = postService;
        this.tagService = tagService;
    }

    @GetMapping({"/", "index"})
    public String index1(Model model){
        List<Post> posts = postService.getAllPosts(0,20);
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/new")
    public String newPost(Model model){
        // Create an empty post form object
        model.addAttribute("post", new Post());

        // Get all existing tags for potential suggestions (if needed)
        List<Tag> allTags = tagService.getAllTags();
        model.addAttribute("allTags", allTags);

        return "post/new";
    }

    @PostMapping("/post")
    public String createPost(
            @ModelAttribute Post post,
            @RequestParam("tagsInput") String tagsInput,
            RedirectAttributes redirectAttributes) {

        try {
            // Process tags
            Set<Tag> postTags = new HashSet<>();
            String[] tagNames = tagsInput.split(",");

            for (String name : tagNames) {
                name = name.trim();
                if (!name.isEmpty()) {
                    Tag tag = tagService.findTagByName(name);
                    if (tag == null) {
                        tag = new Tag(name);
                        tagService.saveTag(tag);
                    }
                    postTags.add(tag);
                }
            }

            // Set tags and save post
            post.setTags(postTags);
            postService.savePost(post);

            // Add success message
            redirectAttributes.addFlashAttribute("successMessage", "Post successfully created!");

            return "redirect:/";
        } catch (Exception e){
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            return "redirect:/new";
        }
    }
}