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

        Review review = new Review();
        Game game = createFinalFantasyXiv();
        review.setGame(game);
        review.setReviewer(reviewer);

        reviewRepository.save(review);
        log.info("Saved Review for game: " + review.getGame().getName() + " review_id = " + review.getId());

        review = new Review();
        game = createBorderlands2();
        review.setGame(game);
        review.setReviewer(reviewer);

        reviewRepository.save(review);
        log.info("Saved Review for game: " + review.getGame().getName() + " review_id = " + review.getId());

        review = new Review();
        game = createSkate3();
        review.setGame(game);
        review.setReviewer(reviewer);

        reviewRepository.save(review);
        log.info("Saved Review for game: " + review.getGame().getName() + " review_id = " + review.getId());

        Reviewer reviewer1 = new Reviewer();
        reviewer1.setUserName("jllrk");
        review = new Review();
        review.setGame(game);
        review.setReviewer(reviewer1);

        reviewRepository.save(review);
        log.info("Saved Review for game: " + review.getGame().getName() + " review_id = " + review.getId());
    }

    private Game createFinalFantasyXiv() {
        Game game = new Game();
        game.setName("Final Fantasy XIV: A Realm Reborn");
        game.setReleaseDate("2006");
        game.setPlatform("PC");
        ArrayList game1tags = new ArrayList<Tag>();
        game1tags.add(tagRepository.findOrCreateTag("MMO"));
        game1tags.add(tagRepository.findOrCreateTag("RPG"));
        game.setTags(game1tags);
        return game;
    }

    private Game createBorderlands2() {
        Game game = new Game();
        game.setName("Borderlands 2");
        game.setReleaseDate("2012");
        game.setPlatform("PS3");
        ArrayList game2Tags = new ArrayList<Tag>();
        game2Tags.add(tagRepository.findOrCreateTag("Shooter"));
        game2Tags.add(tagRepository.findOrCreateTag("RPG"));
        game.setTags(game2Tags);
        gameRepository.save(game);
        return game;
    }
    private Game createSkate3() {
        Game game = new Game();
        game.setName("Skate 3");
        game.setReleaseDate("2010");
        game.setPlatform("PS3");
        ArrayList game3Tags = new ArrayList<Tag>();
        game3Tags.add(tagRepository.findOrCreateTag("Sports"));
        game.setTags(game3Tags);
        return game;
    }


}
