package edu.htc.gamedata.config;

import edu.htc.gamedata.entities.Reviewer;
import edu.htc.gamedata.repositories.GameRepository;
import edu.htc.gamedata.repositories.ReviewerRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by cheey on 5/2/2016.
 */

@Component
public class ReviewerDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private ReviewerRepository reviewerRepository;

    private Logger log = Logger.getLogger(ReviewDataLoader.class);

    @Autowired
    public void setReviewerRepository(ReviewerRepository reviewerRepository) {
        this.reviewerRepository = reviewerRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        //--CREATE REVIEWER
        Reviewer reviewer = new Reviewer();
        //--SET VARIABLES
        reviewer.setUserName("Alphinaud");
        reviewer.setName("Ago");
        reviewer.setAge(17);
        reviewer.setGender("male");
        reviewer.setPassword("Alisaie");
        //--SAVE REVIEWER TO REPOSITORY
        reviewer = reviewerRepository.save(reviewer);
        //--PRINT REVIEWER TO LOGFILE
        log.info("New Reviewer Created! " + "Reviewer Username: " + reviewer.getUserName());

        //--REVIEWER2
        Reviewer reviewer1 = new Reviewer();
        reviewer1.setUserName("Shantotto");
        reviewer1.setPassword("tarutaru");
        reviewer1.setName("Bago");
        reviewer1.setAge(15);
        reviewer1.setGender("female");
        reviewer1 = reviewerRepository.save(reviewer1);
        log.info("New Reviewer Created! " + "Reviewer Username: " + reviewer1.getUserName());

        //--REVIEWER3
        Reviewer reviewer2 = new Reviewer();
        reviewer2.setUserName("Yuna");
        reviewer2.setPassword("Tidus");
        reviewer2.setName("Cago");
        reviewer2.setAge(18);
        reviewer2.setGender("female");
        reviewer2 = reviewerRepository.save(reviewer2);
        log.info("New Reviewer Created! " + "Reviewer Username: " + reviewer2.getUserName());

        //--REVIEWER4
        Reviewer reviewer3 = new Reviewer();
        reviewer3.setUserName("Cloud");
        reviewer3.setPassword("Tifa");
        reviewer3.setName("Dago");
        reviewer3.setAge(19);
        reviewer3.setGender("male");
        reviewer3 = reviewerRepository.save(reviewer3);
        log.info("New Reviewer Created! " + "Reviewer Username: " + reviewer2.getUserName());

    }


}
