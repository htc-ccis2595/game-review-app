package edu.htc.gamedata.config;

import edu.htc.gamedata.entities.Game;
import edu.htc.gamedata.entities.Reviewer;
import edu.htc.gamedata.repositories.ReviewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.apache.log4j.Logger;

/**
 * Created by Student on 5/2/2016.
 */
public class ReviewerController {


    private ReviewerRepository reviewerRepository;
    private Logger log = Logger.getLogger(ReviewerDataLoader.class);

    @Autowired
    public void setReviewerRepository(ReviewerRepository reviewerRepository){
        this.reviewerRepository = reviewerRepository;
    }


    @RequestMapping("/search/reviewer")
    public Reviewer findReviewer (@RequestParam(value="id") int id) {

        Reviewer reviewer = reviewerRepository.findOne("id");

        return reviewer;
       }


}
