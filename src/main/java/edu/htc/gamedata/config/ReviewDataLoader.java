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
 * Created by Student on 5/2/2016.
 */
@Component
public class ReviewDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ReviewRepository reviewRepository;


    private Logger log = Logger.getLogger(GameDataLoader.class);

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
        tags.add("TRR");


        Review review = new Review();
        review = reviewRepository.save(review);
        //review.setId(1);
        review.setComments("Cool Game");
        review.setReviewDate(new Date());
        review.setStarRating(4);
        review.setGame(ffvii);

        log.info("Saved Review for Game - name: " + ffvii.getName() + " id = " + ffvii.getId());


        Game fifa = new Game();
        fifa.setName("Fifa 2016");
        fifa.setReleaseDate("2016");
        fifa.setPlatform("Xbox");
        ArrayList tagsFifa = new ArrayList<Tag>();
        tagsFifa.add("GTT");

        Review reviewFifa = new Review();
        review = reviewRepository.save(review);
        review.setComments("love soccor");
        review.setReviewDate(new Date());
        review.setStarRating(5);
        review.setGame(fifa);

        log.info("Saved Review for Game - name: " + fifa.getName() + " id = " + fifa.getId());



        Game cod = new Game();
        fifa.setName("Call of Duty 5");
        fifa.setReleaseDate("2014");
        fifa.setPlatform("Xbox");
        ArrayList tagsCod = new ArrayList<Tag>();
        tagsCod.add("GTP");

        Review reviewCod = new Review();
        review = reviewRepository.save(review);
        review.setComments("love this game");
        review.setReviewDate(new Date());
        review.setStarRating(5);
        review.setGame(cod);

        log.info("Saved Review for Game - name: " + cod.getName() + " id = " + cod.getId());

    }

}
