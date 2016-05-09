package edu.htc.gamedata.config;

import edu.htc.gamedata.entities.Game;
import edu.htc.gamedata.entities.Reviewer;
import edu.htc.gamedata.entities.Tag;
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
 * Created by joe on 5/2/2016.
 */
@Component
public class ReviewerDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ReviewerRepository reviewerRepository;
    private GameRepository gameRepository;

    private Logger log = Logger.getLogger(GameDataLoader.class);

    @Autowired
    public void setReviewerRepository(ReviewerRepository reviewerRepository) {this.reviewerRepository = reviewerRepository;}

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

       Reviewer reviewerOne = new Reviewer();
        reviewerOne.setUserName("Joe1993");
        reviewerOne.setName("Joseph");
        reviewerOne.setAge(23);
        reviewerOne.setGender("M");
        reviewerOne.setPassword("Password");


        reviewerRepository.save(reviewerOne);

        Reviewer reviewerTwo = new Reviewer();
        reviewerTwo.setUserName("Billy9385");
        reviewerTwo.setName("Bill T");
        reviewerTwo.setAge(55);
        reviewerTwo.setGender("M");
        reviewerTwo.setPassword("NasCar");


        reviewerRepository.save( reviewerTwo);

        Reviewer reviewerThree = new Reviewer();
        reviewerThree.setUserName("TheSteelHustler");
        reviewerThree.setName("David Powers");
        reviewerThree.setAge(32);
        reviewerThree.setGender("M");
        reviewerThree.setPassword("QWERTY");


        reviewerRepository.save( reviewerThree);

    }
}






