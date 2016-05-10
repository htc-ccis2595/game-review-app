package edu.htc.gamedata.config;

import edu.htc.gamedata.entities.Game;
import edu.htc.gamedata.entities.Reviewer;
import edu.htc.gamedata.repositories.ReviewerRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by volkg_000 on 5/2/2016.
 */
@Component
public class ReviewerDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ReviewerRepository reviewerRepository;


    private Logger log = Logger.getLogger(ReviewerDataLoader.class);

    @Autowired
    public void setReviewerRepository(ReviewerRepository reviewerRepository) {
        this.reviewerRepository = reviewerRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Reviewer reviewer = new Reviewer();

        Game game = new Game();
        game.setName("Fallout 4");

        reviewer.setComments("Had trouble installing");
        reviewer.setAge(19);
        reviewer.setName("Jordan");
        reviewer.setGender("Male");
        reviewer.setUserName("jordovolk");
        reviewer.setPassword("123456789");
        ArrayList<Game> favoriteGames = new ArrayList<>();
        favoriteGames.add(game);
        reviewer.setFavoriteGames(favoriteGames);

        reviewerRepository.save(reviewer);

        log.info("Saved Reviewer - name: " + reviewer.getName() + " userName: " + reviewer.getUserName() + " gender: " + reviewer.getGender());


        Reviewer reviewer2 = new Reviewer();

        Game game2 = new Game();
        game2.setName("Call of duty: Black Ops 3");

        reviewer2.setComments("Makes me rage and throw things");
        reviewer2.setAge(20);
        reviewer2.setName("Josh L");
        reviewer2.setGender("Male");
        reviewer2.setUserName("joshL");

        favoriteGames.add(game2);
        reviewer2.setFavoriteGames(favoriteGames);

        reviewerRepository.save(reviewer2);

        log.info("Saved Reviewer - name: " + reviewer2.getName() + " userName: " + reviewer2.getUserName() + " gender: " + reviewer2.getGender());


        Reviewer reviewer3 = new Reviewer();

        Game game3 = new Game();
        game3.setName("Battlefield 4");

        reviewer3.setComments("Very intense game play");
        reviewer3.setAge(30);
        reviewer3.setName("Monica");
        reviewer3.setGender("Female");
        reviewer3.setUserName("monicaV");

        favoriteGames.add(game3);
        reviewer3.setFavoriteGames(favoriteGames);

        reviewerRepository.save(reviewer3);

        log.info("Saved Reviewer - name: " + reviewer3.getName() + " userName: " + reviewer3.getUserName() + " gender: " + reviewer3.getGender());



    }


}
