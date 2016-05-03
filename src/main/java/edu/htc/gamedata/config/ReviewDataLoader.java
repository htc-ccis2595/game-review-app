package edu.htc.gamedata.config;

import edu.htc.gamedata.entities.Game;
import edu.htc.gamedata.entities.Review;
import edu.htc.gamedata.entities.Reviewer;
import edu.htc.gamedata.repositories.ReviewRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by volkg_000 on 5/2/2016.
 */
@Component
public class ReviewDataLoader  implements ApplicationListener<ContextRefreshedEvent> {

    private ReviewRepository reviewRepository;


    private Logger log = Logger.getLogger(ReviewDataLoader.class);

    @Autowired
    public void setReviewRepository(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }





    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {


        //review #1
        Review review = new Review();
        Reviewer reviewer = new Reviewer();
        reviewer.setUserName("jordomane");

        Game game = new Game();
        game.setName("Runescape");
        game.setPlatform("PC");
        game.setReleaseDate("1997");
        //ArrayList<Tag> tags = new ArrayList<Tag>();
       // tags.add(new Tag("RPG"));
        //game.setTags(tags);

        review.setComments("Great game");
        review.setStarRating(5);

        review.setGame(game);




        reviewRepository.save(review);


        log.info("Saved Review for Game - name: " + game.getName() + "id = " + game.getId() + " reviewer name: " + reviewer.getUserName() + " comments: " + review.getComments());

        //review #2
        Review review2 = new Review();

        Reviewer reviewer2 = new Reviewer();
        reviewer2.setUserName("Mmosman");

        Game game2 = new Game();
        game2.setName("World of Warcraft");
        game2.setPlatform("PC");
        game2.setReleaseDate("2000");
        //ArrayList<Tag> tags2 = new ArrayList<>();
        //tags2.add(new Tag("RPG"));
        //tags2.add(new Tag("MMO"));
        //game2.setTags(tags);

        review2.setComments("So many things to do, fun.");
        review2.setStarRating(4);

        review2.setGame(game2);




        reviewRepository.save(review2);


        log.info("Saved Review for Game - name: " + game2.getName() + " id = " + game2.getId() + " reviewer name: " + reviewer2.getUserName()  + " comments: " + review2.getComments());


        //review #3
        Review review3 = new Review();
        Reviewer reviewer3 = new Reviewer();
        reviewer3.setUserName("jordovolk");

        Game game3 = new Game();
        game3.setName("Call of duty: Modern Warfare 2");
        game3.setPlatform("Xbox-360");
        game3.setReleaseDate("2008");
       // ArrayList<Tag> tags3 = new ArrayList<>();
        //tags3.add(new Tag("FPS"));

        //game3.setTags(tags);

        review3.setComments("Quickscoping players with intervention is great");
        review3.setStarRating(5);

        review3.setGame(game3);

        review3.setReviewer(reviewer3);




        reviewRepository.save(review3);


        log.info("Saved Review for Game - name: " + game3.getName() + " id = " + game3.getId() + " reviewer name: " + reviewer3.getUserName() + " comments: " + review3.getComments());


    }
}
