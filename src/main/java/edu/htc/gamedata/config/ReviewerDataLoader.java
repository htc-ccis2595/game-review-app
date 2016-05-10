package edu.htc.gamedata.config;


import edu.htc.gamedata.entities.Reviewer;
import edu.htc.gamedata.repositories.ReviewerRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


/**
 * Created by Student on 5/2/2016.
 */
@Component
public class ReviewerDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ReviewerRepository reviewerRepository;


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
        reviewerRepository.save(reviewer);
        log.info("Saved Reviewer - name: " + reviewer.getName() + " username = " + reviewer.getUserName() + " age: " + reviewer.getAge());


        Reviewer reviewer1 = new Reviewer();
        reviewer1.setName("Logan");
        reviewer1.setUserName("dethgod");
        reviewer1.setAge(27);
        reviewer1.setGender("male");
        reviewer1.setPassword("12345678");
        reviewerRepository.save(reviewer1);
        log.info("Saved Reviewer - name: " + reviewer1.getName() + " username = " + reviewer1.getUserName() + " age: " + reviewer1.getAge());



        Reviewer reviewer2 = new Reviewer();
        reviewer2.setName("Brandon");
        reviewer2.setUserName("giraffe");
        reviewer2.setAge(24);
        reviewer2.setGender("other");
        reviewer2.setPassword("12345pwd");
        reviewerRepository.save(reviewer2);
        log.info("Saved Reviewer - name: " + reviewer2.getName() + " username = " + reviewer2.getUserName() + " age: " + reviewer2.getAge());



    }

}
