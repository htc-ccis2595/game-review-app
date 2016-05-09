package edu.htc.gamedata.config;

import edu.htc.gamedata.entities.Game;
import edu.htc.gamedata.entities.Review;
import edu.htc.gamedata.entities.Reviewer;
import edu.htc.gamedata.repositories.GameRepository;
import edu.htc.gamedata.repositories.ReviewRepository;
import edu.htc.gamedata.repositories.ReviewerRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by clifford.mauer on 5/2/2016.
 */
@Component
public class ReviewerDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ReviewerRepository reviewerRepository;
    private ReviewRepository reviewRepository;
    private GameRepository gameRepository;


    private Logger log = Logger.getLogger(ReviewerDataLoader.class);

    @Autowired
    public void setReviewerRepository(ReviewerRepository reviewerRepository) {
        this.reviewerRepository = reviewerRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Reviewer reviewer = new Reviewer();
        reviewer.setName("Clifford J Mauer");
        reviewer.setUserName("cmauer69");
        reviewer.setPassword("Chevy66");
        reviewer.setAge(64);
        reviewer.setGender("Male");
        reviewer.setComments("I was quite surprised about the quality of the game.");

        reviewer = reviewerRepository.save(reviewer);

        log.info("Saved Reviewer - user name: " + reviewer.getUserName()+ " id = " + reviewer.getId());

        reviewer = new Reviewer();
        reviewer.setName("John Wayne");
        reviewer.setUserName("jw1925");
        reviewer.setPassword("Ford6443");
        reviewer.setAge(18);
        reviewer.setGender("Male");
        reviewer.setComments("I have been reviewing games for 35 years.");

        ArrayList<Game> favoritegames = new ArrayList<Game>();
        Game fsim30 = new Game();
        fsim30.setName("Flight Simulator 3.0");
        fsim30.setReleaseDate("12/15/2011");

        Game badgeofhonor50 = new Game();
        badgeofhonor50.setName("Badge of Honor 5.0");
        badgeofhonor50.setReleaseDate("07/15/2010");

        favoritegames.add(fsim30);
        favoritegames.add(badgeofhonor50);
        reviewer.setFavoriteGames(favoritegames);


        reviewer = reviewerRepository.save(reviewer);

        log.info("Saved Reviewer - user name: " + reviewer.getUserName()+ " id = " + reviewer.getId());
        reviewer = new Reviewer();
        reviewer.setName("Bill Murray");
        reviewer.setUserName("bm1968");
        reviewer.setPassword("Italy9999");
        reviewer.setAge(23);
        reviewer.setGender("Male");
        reviewer.setComments("I would reccommend this game as a good one to purchase.");

        reviewer = reviewerRepository.save(reviewer);

        log.info("Saved Reviewer - user name: " + reviewer.getUserName()+ " id = " + reviewer.getId());

        reviewer = new Reviewer();
        reviewer.setName("Jimmy Kimbel");
        reviewer.setUserName("jimmyk39");
        reviewer.setPassword("France2345");
        reviewer.setAge(45);
        reviewer.setComments("I can't wait for the Star Wars game to get released.");

        reviewer = reviewerRepository.save(reviewer);

        log.info("Saved Reviewer - user name: " + reviewer.getUserName()+ " id = " + reviewer.getId());


    }

}
