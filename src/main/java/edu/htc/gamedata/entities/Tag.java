package edu.htc.gamedata.entities;

import org.springframework.data.domain.Persistable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tag {

    @Id
    String tag;

    public Tag() {}

    public Tag(String tag){
        this.tag = tag.toUpperCase();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag.toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag1 = (Tag) o;

        return tag.equals(tag1.tag);

    }

    @Override
    public int hashCode() {
        return tag.hashCode();
    }
}
