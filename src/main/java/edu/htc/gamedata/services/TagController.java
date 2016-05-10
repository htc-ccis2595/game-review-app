package edu.htc.gamedata.services;

import edu.htc.gamedata.entities.Tag;
import edu.htc.gamedata.repositories.TagRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TagController {

    private TagRepository tagRepository;

    private Logger log = Logger.getLogger(TagController.class);

    @Autowired
    public void setReviewerRepository(TagRepository repository) {
        this.tagRepository = repository;
    }

    @RequestMapping("/search/tags")
    public List<Tag> findAllTags() {
        List<Tag> tags =  new ArrayList<Tag>();
        for (Tag tag : tagRepository.findAll()){
            tags.add(tag);
        }
        return tags;
    }
}
