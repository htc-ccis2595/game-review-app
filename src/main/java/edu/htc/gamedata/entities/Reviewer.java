package edu.htc.gamedata.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Reviewer {

    @Id
    private String userName;

    private String name;
    private int age;
    private String gender;
    private String comments;
    private String password;

    @ManyToMany(cascade= CascadeType.ALL)
    private List<Game> favoriteGames;

    @OneToMany(cascade=CascadeType.ALL)
    private List<Review> reviews;


}
