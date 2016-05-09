package edu.htc.gamedata.config;

import com.sun.istack.internal.logging.Logger;
import edu.htc.gamedata.entities.Game;
import edu.htc.gamedata.entities.Review;
import edu.htc.gamedata.entities.Reviewer;
import edu.htc.gamedata.repositories.GameRepository;
import edu.htc.gamedata.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by joe on 5/2/2016.
 */
@Component
public class ReviewDataLoader implements ApplicationListener<ContextRefreshedEvent>{
    Calendar cal = Calendar.getInstance();
    private ReviewRepository reviewRepository;
    private GameRepository gameRepository;

    private Logger log = Logger.getLogger(GameDataLoader.class);

    @Autowired
    public void setReviewRepository(ReviewRepository reviewRepository){ this.reviewRepository = reviewRepository;}

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){

        Review reviewOne = new Review();
       Game game = new Game();
        Reviewer reviewer = new Reviewer();

        reviewOne.setGame(game);
        reviewOne.setReviewer(reviewer);
        reviewOne.setStarRating(3);
        reviewOne.setReviewDate(cal.getTime());

        reviewRepository.save(reviewOne);


        Review reviewTwo = new Review();
        Game gameTwo = new Game();
        Reviewer reviewerTwo = new Reviewer();

        reviewTwo.setGame(gameTwo);
        reviewTwo.setReviewer(reviewer);
        reviewTwo.setStarRating(3);
        reviewTwo.setReviewDate(cal.getTime());

        reviewRepository.save(reviewTwo);

        Review reviewThree = new Review();
        Game gameThree = new Game();
        Reviewer reviewerThree = new Reviewer();

        reviewThree.setGame(gameThree);
        reviewThree.setReviewer(reviewerThree);
        reviewThree.setStarRating(3);
        reviewThree.setReviewDate(cal.getTime());

        reviewRepository.save(reviewThree);
    }



}




