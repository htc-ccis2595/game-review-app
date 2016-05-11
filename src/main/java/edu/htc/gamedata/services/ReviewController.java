package edu.htc.gamedata.services;

import edu.htc.gamedata.entities.Review;
import edu.htc.gamedata.repositories.ReviewRepository;
import org.apache.log4j.Logger;
import org.aspectj.internal.lang.reflect.StringToType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

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
    @RequestMapping("/search/findByComments")
    public List<Review> findByComments(@RequestParam(value="comments") String comments) {
        List<Review> review =  reviewRepository.findByComments(comments);
        return review;
    }
    @RequestMapping("/search/findByStarRating")
    public List<Review> findByStarRatinge(@RequestParam(value="starRating") int starRating) {
        List<Review> review =  reviewRepository.findByStarRating(starRating);
        return review;
    }
    @RequestMapping("/search/findByUserName")
    public List<Review> findByUserName(@RequestParam(value="userName") String userName) {
        List<Review> review =  reviewRepository.findByUserName(userName);
        return review;
    }
}

