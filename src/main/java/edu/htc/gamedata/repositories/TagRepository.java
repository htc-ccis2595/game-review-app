package edu.htc.gamedata.repositories;

import edu.htc.gamedata.entities.Tag;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, String> {

    default public Tag findOrCreateTag(String tagName){
        Tag tag = this.findOne(tagName);
        if (tag == null) {
            tag = new Tag(tagName);
        }
        return tag;
    }
}
