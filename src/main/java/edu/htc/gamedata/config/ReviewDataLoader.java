package edu.htc.gamedata.config;



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
/**
 * Created by cheey on 5/2/2016.
 */

@Component
public class ReviewDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ReviewRepository reviewRepository;
    private ReviewerRepository reviewerRepository;
    private TagRepository tagRepository;
    private GameRepository gameRepository;


    private Logger log = Logger.getLogger(ReviewDataLoader.class);

    @Autowired
    public void setReviewRepository(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Autowired
    public void setReviewerRepository(ReviewerRepository repository) {
        this.reviewerRepository = repository;
    }

    @Autowired
    public void setTagRepository(TagRepository repository) {
        this.tagRepository = repository;
    }

    @Autowired
    public void setGameRepository(GameRepository repository) {
        this.gameRepository = repository;
    }

    @Override
    @Transactional

    public void onApplicationEvent(ContextRefreshedEvent event) {

        Reviewer reviewer = reviewerRepository.findOne("TestUser1");
        if (reviewer == null) {
            reviewer = new Reviewer();
            reviewer.setUserName("TestUser1");
        }

        //--CREATE GAME
        Game game = new Game();
        //--SET VARIABLES FOR GAME
        game.setName("Final Fantasy XIV: A Realm Reborn");
        game.setReleaseDate("2006");
        game.setPlatform("PC");
        //--CREATE & ADD TO ARRAYLIST
        ArrayList tags = new ArrayList<Tag>();
        tags.add(tagRepository.findOrCreateTag("MMO"));
        tags.add(tagRepository.findOrCreateTag("RPG"));
        //--CREATE REVIEW
        Review review = new Review();
        review.setGame(game);
        review.setStarRating(4);
        //--SAVE REVIEW TO REPOSITORY
        review = reviewRepository.save(review);
        //--PRINT REVIEW TO LOGFILE
        log.info("Review saved for game: " + review.getGame().getName() + " -- " + " Review ID =  " + review.getId());

        //--REVIEW2
        Game game2 = new Game();
        game2.setName("Final Fantasy XI Online");
        game2.setReleaseDate("2003");
        game2.setPlatform("PC");
        ArrayList tags2 = new ArrayList<Tag>();
        tags2.add(new Tag("MMO"));
        tags2.add(new Tag("RPG"));
        Review review2 = new Review();
        review2.setGame(game2);
        review2.setStarRating(5);
        review2 = reviewRepository.save(review2);
        log.info("Review saved for game: " + review2.getGame().getName() + " -- " + " Review ID =  " + review2.getId());

        //--REVIEW3
        Game game3 = new Game();
        game3.setName("Final Fantasy X");
        game3.setReleaseDate("2003");
        game3.setPlatform("PC");
        ArrayList tags3 = new ArrayList<Tag>();
        tags3.add(new Tag("RPG"));
        Review review3 = new Review();
        review3.setGame(game3);
        review3.setStarRating(4);
        review3 = reviewRepository.save(review3);
        log.info("Review saved for game: " + review3.getGame().getName() + " -- " + " Review ID =  " + review3.getId());

        //--REVIEW4
        Game game4 = new Game();
        game4.setName("Final Fantasy VII");
        game4.setReleaseDate("2003");
        game4.setPlatform("PC");
        ArrayList tags4 = new ArrayList<Tag>();
        tags4.add(new Tag("RPG"));
        Review review4 = new Review();
        review4.setGame(game4);
        review4.setStarRating(5);
        review4 = reviewRepository.save(review4);
        log.info("Review saved for game: " + review4.getGame().getName() + " -- " + " Review ID =  " + review4.getId());
    }

}
