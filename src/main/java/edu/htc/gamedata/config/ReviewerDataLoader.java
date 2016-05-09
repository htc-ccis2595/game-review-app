package edu.htc.gamedata.config;

import edu.htc.gamedata.entities.Game;
import edu.htc.gamedata.entities.Review;
import edu.htc.gamedata.entities.Reviewer;
import edu.htc.gamedata.entities.Tag;
import edu.htc.gamedata.repositories.GameRepository;
import edu.htc.gamedata.repositories.ReviewRepository;
import edu.htc.gamedata.repositories.ReviewerRepository;
import edu.htc.gamedata.repositories.TagRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Created by Joel on 5/2/2016.
 */
@Component
public class ReviewerDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ReviewRepository reviewRepository;
    private ReviewerRepository reviewerRepository;
    private TagRepository tagRepository;
    private GameRepository gameRepository;

    private Logger log = Logger.getLogger(ReviewerDataLoader.class);

    @Autowired
    public void setGameRepository(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Autowired
    public void setReviewerRepository(ReviewerRepository reviewerRepository) {
        this.reviewerRepository = reviewerRepository;
    }
    @Autowired
    public ReviewRepository getReviewRepository() {
        return reviewRepository;
    }
    @Autowired
    public TagRepository getTagRepository() {
        return tagRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Reviewer reviewer1 = new Reviewer();
        reviewer1.setUserName("jllrk");
        reviewer1.setAge(23);
        reviewer1.setName("Joel");
        reviewer1.setGender("M");
        reviewer1.setPassword("PasswordJ");

        reviewerRepository.save(reviewer1);
        log.info("Saved Reviewer: " + reviewer1.getName() + ", reviewer_username = " + reviewer1.getUserName());


        Reviewer reviewer2 = new Reviewer();
        reviewer2.setUserName("greenzel");
        reviewer2.setAge(44);
        reviewer2.setName("Thomas");
        reviewer2.setGender("M");
        reviewer2.setPassword("PasswordT");


        reviewerRepository.save(reviewer2);
        log.info("Saved Reviewer: " + reviewer2.getName() + ", reviewer_username = " + reviewer2.getUserName());

        Reviewer reviewer3 = new Reviewer();
        reviewer3.setUserName("llama27");
        reviewer3.setAge(16);
        reviewer3.setName("Beth");
        reviewer3.setGender("F");
        reviewer3.setPassword("PasswordB");

        reviewerRepository.save(reviewer3);
        log.info("Saved Reviewer: " + reviewer3.getName() + ", reviewer_username = " + reviewer3.getUserName());
    }



    }

