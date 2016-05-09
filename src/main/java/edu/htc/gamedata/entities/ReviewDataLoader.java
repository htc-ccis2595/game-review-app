package edu.htc.gamedata.entities;

import edu.htc.gamedata.entities.Review;
import edu.htc.gamedata.entities.Tag;
import edu.htc.gamedata.repositories.ReviewRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by Mary on 5/9/2016.
 */
@Component

public class ReviewDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ReviewRepository reviewRepository;

    private Logger log = Logger.getLogger(ReviewDataLoader.class);

    @Autowired
    public void setGameRepository(ReviewRepository gameRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Review review = new Review();

    }
}
