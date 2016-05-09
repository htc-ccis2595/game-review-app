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
        Reviewer reviewer2 = new Reviewer();
        reviewer2.setUserName("jllrk");



        Review review = new Review();
        Game ffxiv = createFinalFantasyXiv();
        review.setGame(ffxiv);
        review.setReviewer(reviewer);

        reviewRepository.save(review);
        log.info("Saved Review for game: " + review.getGame().getName() + " review_id = " + review.getId());

        Review review2 = new Review();
        Game Btfld4 = createBattlefield4();
        review2.setGame(Btfld4);
        review2.setReviewer(reviewer2);

        reviewRepository.save(review2);
        log.info("Saved Review for game: " + review2.getGame().getName() + " review_id = " + review2.getId());

        Review review3 = new Review();
        Game Sprsmsh = createSuperSmashBros();
        review3.setGame(Sprsmsh);
        review3.setReviewer(reviewer);

        reviewRepository.save(review3);
        log.info("Saved Review for game: " + review3.getGame().getName() + " review_id = " + review3.getId());



       // reviewRepository.save(review);
       // log.info("Saved Review for game: " + review.getGame().getName() + " review_id = " + review.getId());
    }

    private Game createFinalFantasyXiv() {
        Game ffxiv = new Game();
        ffxiv.setName("Final Fantasy XIV: A Realm Reborn");
        ffxiv.setReleaseDate("2006");
        ffxiv.setPlatform("PC");
        ArrayList xxivrrTags = new ArrayList<Tag>();
        xxivrrTags.add(tagRepository.findOrCreateTag("MMO"));
        xxivrrTags.add(tagRepository.findOrCreateTag("RPG"));
        ffxiv.setTags(xxivrrTags);
        return ffxiv;
    }

    private Game createBattlefield4() {
        Game Btfld4 = new Game();
        Btfld4.setName("BattleField 4");
        Btfld4.setReleaseDate("2013");
        Btfld4.setPlatform("PS4");
        ArrayList battlefieldTags = new ArrayList<Tag>();
        battlefieldTags.add(tagRepository.findOrCreateTag("MMO"));
        //battlefieldTags.add(tagRepository.findOrCreateTag("First-Person"));
        //battlefieldTags.add(tagRepository.findOrCreateTag("multi-player"));
        Btfld4.setTags(battlefieldTags);
        return Btfld4;
    }
    private Game createSuperSmashBros() {
        Game spsmsh = new Game();
        spsmsh.setName("Super Smash Brothers");
        spsmsh.setReleaseDate("1999");
        spsmsh.setPlatform("Nintendo 64");
        ArrayList sprsmshTags = new ArrayList<Tag>();
        sprsmshTags.add(tagRepository.findOrCreateTag("multi-player fighter"));
        spsmsh.setTags(sprsmshTags);
        return spsmsh;
    }


}
