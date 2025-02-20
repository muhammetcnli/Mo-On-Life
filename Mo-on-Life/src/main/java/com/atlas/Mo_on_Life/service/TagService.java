package com.atlas.Mo_on_Life.service;

import com.atlas.Mo_on_Life.entity.Tag;
import com.atlas.Mo_on_Life.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public void saveTag(Tag tag){
        tagRepository.save(tag);
    }

    public List<Tag> getAllTags(){
        return tagRepository.findAll();
    }

    public Optional<Tag> findTagByName(String name){
        return tagRepository.findByName(name);
    }
}
