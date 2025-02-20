package com.atlas.Mo_on_Life.controller;

import com.atlas.Mo_on_Life.entity.Post;
import com.atlas.Mo_on_Life.entity.Tag;
import com.atlas.Mo_on_Life.service.PostService;
import com.atlas.Mo_on_Life.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.*;

@Controller
public class AppController {

    PostService postService;
    TagService tagService;

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
        model.addAttribute("post", new Post());

        return "post/new";
    }

    @PostMapping("/post")
    public String createPost(@ModelAttribute Post post, @RequestParam("tagsInput"), String tagsInput){

        Set<Tag> postTags = new HashSet<>();

        String[] tagNames = tagsInput.split(",");

        for (String name: tagNames){
            name = name.trim();
            if (!name.isEmpty()){
                Optional<Tag> existingTag = tagService.findTagByName(name);


            }
        }


        if(post.getTags() != null && !post.getTags().isEmpty()){

            Set<String> parsedTags = Arrays.stream(post.getTags().iterator().next().split(","))
                    .
        }


        postService.savePost(post);
        return "redirect:/";
    }
}
