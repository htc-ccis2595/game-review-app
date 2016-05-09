package edu.htc.gamedata.config;

/**
 * Created by Student on 5/2/2016.
 */
import edu.htc.gamedata.entities.Game;
import edu.htc.gamedata.entities.Reviewer;
import edu.htc.gamedata.entities.Tag;
import edu.htc.gamedata.repositories.ReviewerRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ReviewerDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ReviewerRepository reviewerRepository;

    private Logger log = Logger.getLogger(ReviewerDataLoader.class);

    @Autowired
    public void setReviewerRepository(ReviewerRepository reviewerRepository) {this.reviewerRepository = reviewerRepository;}

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){

        Reviewer reviewer = new Reviewer();
        reviewer.setUserName("BCP27");
        reviewer.setAge(24);
        reviewer.setName("Brian");
        reviewer.setGender("M");
        reviewer.setComments("didn't actually play it");
        reviewer.setPassword("REDACTED");
        ArrayList favoriteGames = new ArrayList<Game>();
        favoriteGames.add(new Game("Final Fantasy XIV: A Realm Reborn"));
        reviewerRepository.save(reviewer);
        log.info("Saved Reviewer - UserName: " + reviewer.getUserName());
    }
}
