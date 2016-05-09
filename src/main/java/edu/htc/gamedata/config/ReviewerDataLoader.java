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

import java.util.ArrayList;

/**
 * Created by Joel on 5/2/2016.
 */
public class ReviewerDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ReviewRepository reviewRepository;
    private ReviewerRepository reviewerRepository;
    private TagRepository tagRepository;



    private GameRepository gameRepository;

    private Logger log = Logger.getLogger(GameDataLoader.class);

    @Autowired
    public void setGameRepository(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Autowired
    public void setReviewerRepository(ReviewerRepository reviewerRepository) {
        this.reviewerRepository = reviewerRepository;
    }
    @Autowired
    public ReviewRepository getReviewRepository() {
        return reviewRepository;
    }
    @Autowired
    public TagRepository getTagRepository() {
        return tagRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Reviewer reviewer1 = new Reviewer();

        Review review1 = new Review();
        Game ffxiv = createFinalFantasyXiv();
        review1.setGame(ffxiv);
        review1.setReviewer(reviewer1);

        reviewerRepository.save(reviewer1);
        log.info("Saved Reviewer: " + reviewer1.getName() + " review_id = " + reviewer1.getUserName() + " reviews they did: " + reviewer1.getReviews());
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



    }

