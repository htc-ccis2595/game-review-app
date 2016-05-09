package edu.htc.gamedata.services;

import edu.htc.gamedata.entities.Review;
import edu.htc.gamedata.repositories.ReviewRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {

    private ReviewRepository reviewRepository;

    private Logger log = Logger.getLogger(ReviewController.class);

    @Autowired
    public void setReviewRepository(ReviewRepository repository) {
        this.reviewRepository = repository;
    }

    @RequestMapping("/search/review")
    public Review findGame(@RequestParam(value="id") int id) {
        Review review =  reviewRepository.findOne(id);
        return review;
    }
}
