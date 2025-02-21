package com.atlas.Mo_on_Life.controller;

import com.atlas.Mo_on_Life.service.PostService;
import com.atlas.Mo_on_Life.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class TagController {


    TagService tagService;

    PostService postService;

    @Autowired
    public TagController(TagService tagService, PostService postService) {
        this.tagService = tagService;
        this.postService = postService;
    }


    @GetMapping("/{tag}/top-10")
    public String getTopPostsWithTag(@PathVariable String tag, Model model){

        tagService.findTagByName(tag);


        return "tag/toptags";
    }
}
