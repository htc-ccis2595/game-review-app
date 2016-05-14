package edu.htc.gamedata.services;

import edu.htc.gamedata.entities.Reviewer;
import edu.htc.gamedata.repositories.ReviewerRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewerController {

    private ReviewerRepository reviewerRepository;

    private Logger log = Logger.getLogger(ReviewerController.class);

    @Autowired
    public void setReviewerRepository(ReviewerRepository repository) {
        this.reviewerRepository = repository;
    }

    @RequestMapping("/search/reviewer")
    public List<Reviewer> findReviewerByUserName(@RequestParam(value="userName") String userName) {
        List<Reviewer> reviewer =  reviewerRepository.findReviewerByUserName(userName);
        return reviewer;
    }

    @RequestMapping("/search/searchByGreaterThanAge")
    public List<Reviewer> searchByGreaterThanAge(@RequestParam(value="age") int age) {
        List<Reviewer> reviewer =  reviewerRepository.findByGreaterThanAge(age);
        return reviewer;
    }
}

