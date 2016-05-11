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
import java.util.Calendar;

@Component
public class ReviewDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ReviewRepository reviewRepository;
    private ReviewerRepository reviewerRepository;
    private TagRepository tagRepository;
    private GameRepository gameRepository;


    private Logger log = Logger.getLogger(ReviewDataLoader.class);

    @Autowired
    public void setReviewRepository(ReviewRepository repository) {
        this.reviewRepository = repository;
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

        Review reviewOne = new Review();
        Game game = createFinalFantasyXiv();


        reviewOne.setGame(game);
        reviewOne.setReviewer(reviewer);



         reviewRepository.save(reviewOne);


        Review reviewTwo = new Review();
        Game gameTwo = createEveOnline();


        reviewTwo.setGame(gameTwo);
        reviewTwo.setReviewer(reviewer);



          reviewRepository.save(reviewTwo);

        Review reviewThree = new Review();
        Game gameThree = createUtlimaOnline();


        reviewThree.setGame(gameThree);
        reviewThree.setReviewer(reviewer);



           reviewRepository.save(reviewThree);

    }

    private Game createFinalFantasyXiv() {
        Game game = new Game();
        game.setName("Final Fantasy XIV");
        game.setReleaseDate("2010");
        game.setPlatform("PC");
        ArrayList ffxivtags = new ArrayList<Tag>();

        ffxivtags.add(tagRepository.findOrCreateTag("MMO"));
        ffxivtags.add(tagRepository.findOrCreateTag("RPG"));
        game.setTags(ffxivtags);
        return game;
    }

    private Game createEveOnline() {
        Game game = new Game();
        game.setName("Eve Online");
        game.setReleaseDate("2006");
        game.setPlatform("PC");
        ArrayList Evetags = new ArrayList<Tag>();

        Evetags.add(tagRepository.findOrCreateTag("MMO"));
        Evetags.add(tagRepository.findOrCreateTag("Sci-Fi"));
        game.setTags(Evetags);
        return game;
    }

    private Game createUtlimaOnline() {
        Game game = new Game();
        game.setName("Ultima Online");
        game.setReleaseDate("1999");
        game.setPlatform("PC");
        ArrayList Evetags = new ArrayList<Tag>();

        Evetags.add(tagRepository.findOrCreateTag("MMO"));
        Evetags.add(tagRepository.findOrCreateTag("RPG"));
        game.setTags(Evetags);
        return game;
    }


}
