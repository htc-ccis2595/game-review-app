package edu.htc.gamedata.config;

import edu.htc.gamedata.entities.Review;
import edu.htc.gamedata.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.apache.log4j.Logger;
/**
 * Created by Student on 5/2/2016.
 */
public class ReviewController {

    private ReviewRepository reviewRepository;
    private Logger log = Logger.getLogger(ReviewController.class);

    @Autowired
    public void setReviewRepository(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    @RequestMapping("/search/review")
    public Review findReview(@RequestParam(value ="id") int id){
        Review review = reviewRepository.findOne(id);

        return review;
    }






}
