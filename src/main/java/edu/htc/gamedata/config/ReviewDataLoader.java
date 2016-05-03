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

import java.util.ArrayList;
import java.util.Date;


/**
 * Created by Student on 5/2/2016.
 */
public class ReviewDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ReviewRepository reviewRepository;
    private GameRepository gameRepository;

    private Logger log = Logger.getLogger(ReviewDataLoader.class);

    @Autowired
    public void setReviewRepository(ReviewRepository reviewRepository) {this.reviewRepository = reviewRepository;}

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
        Review review = new Review();
        review = reviewRepository.save(review);
        Game game = new Game();
        game.setName("Diablo III");
        game.setReleaseDate("2014");
        game.setPlatform("PC");
        ArrayList tags = new ArrayList<Tag>();
        tags.add(new Tag("MMO"));
        tags.add(new Tag("RPG"));
        game = gameRepository.save(game);
        log.info("Saved Game - name: " + game.getName() + " id = " + game.getId());
        review.setGame(game);
        Date date = new Date(2016,05,02);
        review.setReviewDate(date);
        Reviewer reviewer = new Reviewer();
        review.setReviewer(reviewer);
        review.setComments("I don't get enough time to play this game to give it a proper review.");
        review.setStarRating(3);


        Review review1 = new Review();
        review1 = reviewRepository.save(review1);
        Game game1 = new Game();
        game1.setName("Family Guy: Quest for Stuff");
        game1.setReleaseDate("2015");
        game1.setPlatform("Mobile");
        ArrayList tags1 = new ArrayList<Tag>();
        tags1.add(new Tag("Android"));
        tags1.add(new Tag("Apple"));
        game1 = gameRepository.save(game1);
        log.info("Saved Game - name: " + game1.getName() + " id = " + game1.getId());
        review1.setGame(game1);
        Date date1 = new Date(2016,05,01);
        review1.setReviewDate(date1);
        Reviewer reviewer1 = new Reviewer();
        review1.setReviewer(reviewer1);
        review1.setComments("Surprisingly addicting, but not enough ways to earn clams.");
        review1.setStarRating(4);

        Review review2 = new Review();
        review2 = reviewRepository.save(review2);
        Game game2 = new Game();
        game2.setName("Super Mario 3");
        game2.setReleaseDate("1988");
        game2.setPlatform("NES");
        ArrayList tags2 = new ArrayList<Tag>();
        tags2.add(new Tag("Old School"));
        tags2.add(new Tag("No Saving"));
        game2 = gameRepository.save(game1);
        log.info("Saved Game - name: " + game2.getName() + " id = " + game2.getId());
        review1.setGame(game1);
        Date date2 = new Date(2016,04,30);
        review2.setReviewDate(date2);
        Reviewer reviewer2 = new Reviewer();
        review1.setReviewer(reviewer2);
        review1.setComments("This one brings back memories!");
        review1.setStarRating(5);



    }
}
