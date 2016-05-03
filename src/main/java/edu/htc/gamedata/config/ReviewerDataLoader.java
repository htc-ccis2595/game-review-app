package edu.htc.gamedata.config;

import edu.htc.gamedata.entities.Review;
import edu.htc.gamedata.entities.Reviewer;
import edu.htc.gamedata.repositories.GameRepository;
import edu.htc.gamedata.repositories.ReviewRepository;
import edu.htc.gamedata.repositories.ReviewerRepository;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;


/**
 * Created by Student on 5/2/2016.
 */
public class ReviewerDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ReviewerRepository reviewerRepository;
    private GameRepository gameRepository;

    private Logger log = Logger.getLogger(ReviewerDataLoader.class);

    @Autowired
    public void setReviewerRepository(ReviewerRepository reviewerRepository) {this.reviewerRepository = reviewerRepository;}

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Reviewer reviewer = new Reviewer();
        reviewer.setName("Sam");
        reviewer.setUserName("sam720");
        reviewer.setAge(32);
        reviewer.setGender("female");
        reviewer.setPassword("pwd12345");

        Reviewer reviewer1 = new Reviewer();
        reviewer1.setName("Logan");
        reviewer1.setUserName("dethgod");
        reviewer1.setAge(27);
        reviewer1.setGender("male");
        reviewer1.setPassword("12345678");


        Reviewer reviewer2 = new Reviewer();
        reviewer2.setName("Brandon");
        reviewer2.setUserName("giraffe");
        reviewer2.setAge(24);
        reviewer2.setGender("other");
        reviewer2.setPassword("12345pwd");


    }

}
