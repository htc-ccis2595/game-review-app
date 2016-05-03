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

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Student on 5/2/2016.
 */
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

//        log.info("Saved Game - name: " + game2.getName() + " id = " + game2.getId());





//        Game game = new Game();
//        game.setName("Final Fantasy XIV: A Realm Reborn");
//        game.setReleaseDate("2006");
//        game.setPlatform("PC");
//        ArrayList tags = new ArrayList<Tag>();
//        tags.add(new Tag("MMO"));
//        tags.add(new Tag("RPG"));
//
//        game = gameRepository.save(game);
//
//        log.info("Saved Game - name: " + game.getName() + " id = " + game.getId());

//
//        Game game1 = new Game();
//        game1.setName("Call of Duty 5");
//        game1.setReleaseDate("2010");
//        game1.setPlatform("XBox360");
//        ArrayList tags1 = new ArrayList<Tag>();
//        tags1.add(new Tag("TST"));
//        tags1.add(new Tag("GRT"));
//
//        game1 = gameRepository.save(game1);
//
//        log.info("Saved Game - name: " + game1.getName() + " id = " + game1.getId());
//
//
//        Game game2 = new Game();
//        game2.setName("Need for Speed VII");
//        game2.setReleaseDate("2014");
//        game2.setPlatform("PS");
//        ArrayList tags2 = new ArrayList<Tag>();
//        tags2.add(new Tag("GGP"));
//        tags2.add(new Tag("STT"));
//
//        game2 = gameRepository.save(game2);
//
//        log.info("Saved Game - name: " + game2.getName() + " id = " + game2.getId());
//

    }

}
