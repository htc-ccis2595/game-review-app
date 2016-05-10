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

    @RequestMapping("/search/reviewById")
    public Review findReview(@RequestParam(value="id") int id) {
        Review review =  reviewRepository.findOne(id);
        return review;
    }

    @RequestMapping("/search/reviewByRatingAboveTwo")
    public List<Review> findReviewByRating(){
        log.debug("Find review by star rating");
        List<Review> reviews = reviewRepository.findReviewAboveRatingTwo();
        return reviews;


    }

    @RequestMapping("/search/reviewByStarRating")
    public List<Review> findReviewByRating(@RequestParam(value="starRating") int starRating) {
        List<Review> reviews =  reviewRepository.findByStarRating(starRating);
        return reviews;
    }
}
