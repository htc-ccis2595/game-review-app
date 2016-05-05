package edu.htc.gamedata.config;

import edu.htc.gamedata.entities.Game;
import edu.htc.gamedata.entities.Review;
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
 * Created by Administrator on 5/2/16.
 */
@Component
public class ReviewDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private ReviewRepository reviewRepository;
    private GameRepository gameRepository;

    private Logger log = Logger.getLogger(ReviewDataLoader.class);

    @Autowired
    public void setReviewRepository(ReviewRepository reviewRepository) {this.reviewRepository = reviewRepository;}

    @Autowired
    public void setGameRepository(GameRepository gameRepository) {this.gameRepository = gameRepository;}

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Game game3 = new Game();
        game3.setName("Final Fantasy");
        game3.setReleaseDate("2001");
        game3.setPlatform("PC");
        ArrayList tags = new ArrayList<Tag>();
        tags.add(new Tag("RPG"));


        Review review = new Review();
        review.setGame(game3);
        review.setComments("This game rocks");
        review.setStarRating(4);
        review.setReviewDate(new Date());
        reviewRepository.save(review);

        log.info("Saved review - name: " + review.getGame().getName() + " id = " + review.getId());

        Game game4 = new Game();
        game4.setName("Final Fantasy");
        game4.setReleaseDate("2001");
        game4.setPlatform("PC");
        ArrayList tags3 = new ArrayList<Tag>();
        tags3.add(new Tag("RPG"));

        Review review2 = new Review();
        review2.setGame(game4);
        review2.setComments("Nothing better");
        review2.setStarRating(5);
        review2.setReviewDate(new Date());
        reviewRepository.save(review2);

        log.info("Saved review2 - name: " + review2.getGame().getName() + " id = " + review2.getId());

        Game game5 = new Game();
        game5.setName("Final Fantasy");
        game5.setReleaseDate("2001");
        game5.setPlatform("PC");
        ArrayList tags5 = new ArrayList<Tag>();
        tags5.add(new Tag("RPG"));

        Review review3 = new Review();
        review3.setGame(game5);
        review3.setComments("This game is a throw back to 1980 development");
        review3.setStarRating(1);
        review3.setReviewDate(new Date());
        reviewRepository.save(review3);

        log.info("Saved review3 - name: " + review3.getGame().getName() + " id = " + review3.getId());

    }
}
