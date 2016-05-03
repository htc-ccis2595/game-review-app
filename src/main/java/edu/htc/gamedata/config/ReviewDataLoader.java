package edu.htc.gamedata.config;

import edu.htc.gamedata.entities.Game;
import edu.htc.gamedata.entities.Review;
import edu.htc.gamedata.entities.Reviewer;
import edu.htc.gamedata.entities.Tag;
import edu.htc.gamedata.repositories.GameRepository;
import edu.htc.gamedata.repositories.ReviewRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;


/**
 * Created by Student on 5/2/2016.
 */
@Component
public class ReviewDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ReviewRepository reviewRepository;


    private Logger log = Logger.getLogger(ReviewDataLoader.class);

    @Autowired
    public void setReviewRepository(ReviewRepository reviewRepository) {this.reviewRepository = reviewRepository;}

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
        Review review = new Review();

        Game game = new Game();
        game.setName("Diablo III");
        game.setReleaseDate("2014");
        game.setPlatform("PC");
        //ArrayList tags = new ArrayList<Tag>();
       // game.setTags(tags);
       // tags.add(new Tag("RPG"));
        review.setGame(game);
        Date date = new Date(2016,05,02);
        review.setReviewDate(date);
        Reviewer reviewer = new Reviewer();
        reviewer.setUserName("thisone");
        review.setReviewer(reviewer);
        review.setComments("I don't get enough time to play this game to give it a proper review.");
        review.setStarRating(3);
        reviewRepository.save(review);
        log.info("Saved Review - game: " + review.getGame().getName() + " id = " + review.getId());


        Review review1 = new Review();
        Game game1 = new Game();
        game1.setName("Family Guy: Quest for Stuff");
        game1.setReleaseDate("2015");
        game1.setPlatform("Mobile");
       // ArrayList tags1 = new ArrayList<Tag>();
       // tags1.add(new Tag("Android"));
       // tags1.add(new Tag("Apple"));
        review1.setGame(game1);
        Date date1 = new Date(2016,05,01);
        review1.setReviewDate(date1);
        Reviewer reviewer1 = new Reviewer();
        reviewer1.setUserName("thisonetoo");
        review1.setReviewer(reviewer1);
        review1.setComments("Surprisingly addicting, but not enough ways to earn clams.");
        review1.setStarRating(4);
        review1 = reviewRepository.save(review1);
        log.info("Saved Review - game: " + review1.getGame().getName() + " id = " + review1.getId());

        Review review2 = new Review();
        Game game2 = new Game();
        game2.setName("Super Mario 3");
        game2.setReleaseDate("1988");
        game2.setPlatform("NES");
        //ArrayList tags2 = new ArrayList<Tag>();
        //tags2.add(new Tag("Old School"));
        //tags2.add(new Tag("No Saving"));
        review2.setGame(game2);
        Date date2 = new Date(2016,04,30);
        review2.setReviewDate(date2);
        Reviewer reviewer2 = new Reviewer();
        reviewer2.setUserName("thatone");
        review2.setReviewer(reviewer2);
        review2.setComments("This one brings back memories!");
        review2.setStarRating(5);
        review2 = reviewRepository.save(review2);
        log.info("Saved Review - game: " + review2.getGame().getName() + " id = " + review2.getId());



    }
}
