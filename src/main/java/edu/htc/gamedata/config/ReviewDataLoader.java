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

/**
 * Created by clifford.mauer on 5/2/2016.
 */
@Component
public class ReviewDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private ReviewRepository reviewRepository;
    private Logger log = Logger.getLogger(ReviewDataLoader.class);

    @Autowired
    public void setReviewRepository(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Game ffvii = new Game();
        ffvii.setName("Final Fantasy VII");
        ffvii.setReleaseDate("1999");
        ffvii.setPlatform("PC");
        ArrayList tags = new ArrayList<Tag>();
        tags.add(new Tag("RPG"));

        Review review = new Review();
        review.setGame(ffvii);
        review.setStarRating(5);

        reviewRepository.save(review);

        log.info("Saved Review - name: " + review.getGame().getName() + " id = " + review.getId());

        Game minecraft = new Game();
        minecraft.setName("MineCraft 1.0");
        minecraft.setReleaseDate("2014");
        minecraft.setPlatform("PC");
        tags = new ArrayList<Tag>();
        tags.add(new Tag("builder"));

        review = new Review();
        review.setGame(minecraft);
        review.setStarRating(4);
        reviewRepository.save(review);

        log.info("Saved Review - name: " + review.getGame().getName() + " id = " + review.getId());


        Game battleship = new Game();
        battleship.setName("Battleship 2.3");
        battleship.setReleaseDate("2015");
        battleship.setPlatform("PS");
        tags = new ArrayList<Tag>();
        tags.add(new Tag("targets"));

        review = new Review();
        review.setGame(battleship);
        review.setStarRating(4);

        reviewRepository.save(review);

        log.info("Saved Review - name: " + review.getGame().getName() + " id = " + review.getId());

    }

}
