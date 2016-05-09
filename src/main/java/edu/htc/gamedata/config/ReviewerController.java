package edu.htc.gamedata.config;

import edu.htc.gamedata.entities.Reviewer;
import edu.htc.gamedata.repositories.ReviewerRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by clifford.mauer on 5/2/2016.
 */
@RestController
public class ReviewerController {

    private ReviewerRepository reviewerRepository;
    private Logger log = Logger.getLogger(ReviewerController.class);

    @Autowired
    public void setReviewRepository(ReviewerRepository reviewRepository){
        this.reviewerRepository = reviewRepository;
    }

    @RequestMapping("/search/reviewer")
    public Reviewer findReviewer(@RequestParam(value="id") int id) {
        Reviewer reviewer =  reviewerRepository.findOne(id);

        return reviewer;
    }

}
