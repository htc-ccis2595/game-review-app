package edu.htc.gamedata.services;

import edu.htc.gamedata.entities.Game;
import edu.htc.gamedata.entities.Review;
import edu.htc.gamedata.repositories.ReviewRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {

    private ReviewRepository reviewRepository;

    private Logger log = Logger.getLogger(ReviewController.class);

    @Autowired
    public void setReviewRepository(ReviewRepository repository) {
        this.reviewRepository = repository;
    }

    @RequestMapping("/search/reviewsByStarRating")
    //**http://localhost:8080/search/reviewsByStarRating?starRating=4
    public List<Review> findByStarRating(@RequestParam(value="starRating") int intStarRating) {
        log.info("Find reviews by star rating " + intStarRating);
        List<Review> review = reviewRepository.findByStarRating(intStarRating);
        return review;
    }

    @RequestMapping("/search/reviewsByGame")
    //**http://localhost:8080/search/reviewsByGame?game=Final Fantasy XIV
    public List<Review> findByGame(@RequestParam(value="game") String strGame) {
        log.info("Find reviews by game name " + strGame);
        List<Review> review = reviewRepository.findByGame(strGame);
        return review;
    }
}
