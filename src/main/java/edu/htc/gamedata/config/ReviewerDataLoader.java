package edu.htc.gamedata.config;

import edu.htc.gamedata.entities.Reviewer;
import edu.htc.gamedata.repositories.GameRepository;
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
 * Created by Prince Roka on 5/9/16.
 */
@Component
public class ReviewerDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ReviewerRepository reviewerRepository;

    private Logger log = Logger.getLogger(GameDataLoader.class);

    @Autowired
    public void setReviewerRepository(ReviewerRepository reviewerRepository) {
        this.reviewerRepository = reviewerRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        persistJerome();
        persistIma();
    }

    //@Transactional
    private void persistJerome() {
        Reviewer jerome = new Reviewer();
        jerome.setName("Jerome Nettle Opul");
        jerome.setUserName("Jerry");
        jerome.setAge(42);
        jerome.setGender("Male");
        jerome.setComments("Jerom e no");
        jerome.setPassword("Splink");
        reviewerRepository.save(jerome);
        log.info("Saved Reviewer - name: " + jerome.getName() + ", username: = " + jerome.getUserName());
    }

    //@Transactional
    private void persistIma() {
        Reviewer ima = new Reviewer();
        ima.setName("Ima Biga Kidnow");
        ima.setUserName("Imacrazi");
        ima.setAge(22);
        ima.setGender("Female");
        ima.setComments("All grown up");
        ima.setPassword("Splunk");
        reviewerRepository.save(ima);
        log.info("Saved Reviewer - name: " + ima.getName() + ", username: = " + ima.getUserName());
    }
}
