package edu.htc.gamedata.config;

import edu.htc.gamedata.entities.Game;
import edu.htc.gamedata.entities.Reviewer;
import edu.htc.gamedata.entities.Review;

import edu.htc.gamedata.entities.Tag;
import edu.htc.gamedata.repositories.GameRepository;
import edu.htc.gamedata.repositories.ReviewRepository;
import edu.htc.gamedata.repositories.ReviewerRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 5/2/16.
 */
@Component
public class ReviewerDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ReviewerRepository reviewerRepository;
    private ReviewRepository reviewRepository;
    private GameRepository gameRepository;

    private Logger log = Logger.getLogger(ReviewerDataLoader.class);

    @Autowired
    public void setReviewerRepository(ReviewerRepository reviewerRepository) {
        this.reviewerRepository = reviewerRepository;
    }

    @Autowired
    public void setReviewRepository(ReviewRepository repository) {
        this.reviewRepository = repository;
    }

    @Autowired
    public void setGameRepository(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        //tom joness
        Game game = createKingOfHearts();
        Review review = new Review();
        review.setGame(game);
        ArrayList<Review> reviews = new ArrayList<Review>();
        reviews.add(review);

        Reviewer reviewer = new Reviewer();
        reviewer.setUserName("tomjones");
        reviewer.setName("Tom Jones");
        reviewer.setAge(23);
        reviewer.setGender("Male");
        reviewer.setComments("best game ever");
        reviewer.setPassword("Password1");
        reviewer.setFavoriteGames(gameRepository.findByNameIgnoreCase("Doom"));
        reviewer.setReviews(reviews);
        reviewerRepository.save(reviewer);
        log.info("Saved Reviewer for game: " + reviewer.getName());

        //Mary poppins
        Game game2 = createKingOfHearts();
        Review review2 = new Review();
        review2.setGame(game2);
        ArrayList<Review> reviews2 = new ArrayList<Review>();
        reviews2.add(review2);

        Reviewer reviewer2 = new Reviewer();
        reviewer2.setUserName("marypoppins");
        reviewer2.setName("Mary Poppins");
        reviewer2.setAge(16);
        reviewer2.setGender("Female");
        reviewer2.setComments("best game");
        reviewer2.setPassword("Password2");
        reviewer2.setFavoriteGames(gameRepository.findByNameIgnoreCase("Doom"));
        reviewer2.setReviews(reviews);
        reviewerRepository.save(reviewer2);
        log.info("Saved Reviewer for game: " + reviewer2.getName());

        //martin lewis
        Game game3 = createKingOfHearts();
        game.setAverageRating(1.6);

        Review review3 = new Review();
        review3.setGame(game3);
        ArrayList<Review> reviews3 = new ArrayList<Review>();
        reviews3.add(review3);

        Reviewer reviewer3 = new Reviewer();
        reviewer3.setUserName("martinlewis");
        reviewer3.setName("Martin Lewis");
        reviewer3.setAge(34);
        reviewer3.setGender("Male");
        reviewer3.setComments("did not like it");
        reviewer3.setPassword("Password3");
        reviewer3.setReviews(reviews);
        reviewerRepository.save(reviewer3);
        log.info("Saved Reviewer for game: " + reviewer3.getName());

    }


    private Game createKingOfHearts() {
        Game game = new Game();
        game.setName("King of Hearts");
        game.setAverageRating(4.6);
        game.setReleaseDate("2013");
        game.setPlatform("Playstation");
        return game;
    }


}
