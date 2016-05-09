package edu.htc.gamedata.config;

import edu.htc.gamedata.entities.Game;
import edu.htc.gamedata.entities.Review;
import edu.htc.gamedata.entities.Reviewer;
import edu.htc.gamedata.repositories.ReviewRepository;
import edu.htc.gamedata.repositories.ReviewerRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by Student on 5/2/2016.
 */
@Component
public class ReviewerDataLoader implements ApplicationListener<ContextRefreshedEvent> {


    private ReviewerRepository reviewerRepository;


    private Logger log = Logger.getLogger(GameDataLoader.class);

    @Autowired
    public void setReviewerRepository(ReviewerRepository reviewerRepository) {
        this.reviewerRepository = reviewerRepository;
    }



    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {


        Reviewer reviewer = new Reviewer();
        reviewer = reviewerRepository.save(reviewer);
        Game game = new Game();
        game.setName("Fifa 2016");
        reviewer.setAge(20);
        reviewer.setComments("Love Fifa 2016");
        reviewer.setName("Tim");
        reviewer.setUserName("Timthemachine");
        ArrayList<Game> favouriteGame = new ArrayList<>();
        favouriteGame.add(game);
        reviewer.setFavoriteGames(favouriteGame);

        log.info("Saved Game - name: " + game.getName() + " id = " + game.getId());


        Reviewer reviewer1 = new Reviewer();
        reviewer = reviewerRepository.save(reviewer1);
        Game game1 = new Game();
        game.setName("Call of Duty 5");
        reviewer.setAge(27);
        reviewer.setComments("Love this game");
        reviewer.setName("Joy");
        reviewer.setUserName("JoyGamer");
        ArrayList<Game> favouriteGame1 = new ArrayList<>();
        favouriteGame1.add(game);
        reviewer.setFavoriteGames(favouriteGame1);

        log.info("Saved Game - name: " + game1.getName() + " id = " + game1.getId());



        Reviewer reviewer2 = new Reviewer();
        reviewer = reviewerRepository.save(reviewer1);
        Game game2 = new Game();
        game.setName("Fifa 2016");
        reviewer.setAge(25);
        reviewer.setComments("Love this soccer");
        reviewer.setName("Mike");
        reviewer.setUserName("MikeT");
        ArrayList<Game> favouriteGame2 = new ArrayList<>();
        favouriteGame2.add(game);
        reviewer.setFavoriteGames(favouriteGame2);

        log.info("Saved Game - name: " + game2.getName() + " id = " + game2.getId());

    }

}

