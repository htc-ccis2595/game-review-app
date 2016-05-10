package edu.htc.gamedata.config;

/**
 * Created by karennilson on 5/9/16.
 */

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

@Component
public class ReviewerDataLoader implements ApplicationListener<ContextRefreshedEvent> {


    private ReviewerRepository reviewerRepository;


    private Logger log = Logger.getLogger(ReviewDataLoader.class);

    @Autowired
    public void setReviewerRepository(ReviewerRepository repository) {
        this.reviewerRepository = repository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Reviewer reviewer = reviewerRepository.findOne("TestUser1");
        if (reviewer == null) {
            reviewer = new Reviewer();
            reviewer.setUserName("TestUser1");
        }

        Reviewer reviewer1 = new Reviewer();
        reviewer1.setName("Karen");
        reviewer1.setUserName("Sallymander");
        reviewer1.setAge(33);
        reviewer1.setGender("F");
        reviewer1.setPassword("191624");
        reviewerRepository.save(reviewer1);
        log.info("Saved reviewer " + reviewer1.getName() + " as username " + reviewer1.getUserName());

        Reviewer reviewer2 = new Reviewer();
        reviewer2.setName("Mary");
        reviewer2.setUserName("Kodex");
        reviewer2.setAge(38);
        reviewer2.setGender("F");
        reviewer2.setPassword("249033");
        reviewerRepository.save(reviewer2);
        log.info("Saved reviewer " + reviewer2.getName() + " as username " + reviewer2.getUserName());

        Reviewer reviewer3 = new Reviewer();
        reviewer3.setName("Steve");
        reviewer3.setUserName("Manimal1");
        reviewer3.setAge(36);
        reviewer3.setGender("M");
        reviewer3.setPassword("666666");
        reviewerRepository.save(reviewer3);
        log.info("Saved reviewer " + reviewer3.getName() + " as username " + reviewer3.getUserName());
    }
}
