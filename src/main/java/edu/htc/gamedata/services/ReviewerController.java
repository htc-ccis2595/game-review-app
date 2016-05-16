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

    @RequestMapping("/search/reviewerByUsername")
    public Reviewer findReviewer(@RequestParam(value="username") String userName) {
        Reviewer reviewer =  reviewerRepository.findOne(userName);
        return reviewer;
    }
    @RequestMapping("/search/reviewersByGender")
    public List<Reviewer> findReviewersByGender(@RequestParam(value="gender") String gender){
        List<Reviewer> reviewer = reviewerRepository.findByGender(gender);
        return reviewer;
    }
    @RequestMapping("/search/reviewersByName")
    public List<Reviewer> findReviewersByName(@RequestParam(value="name") String name){
        List<Reviewer> reviewer = reviewerRepository.findByNameIgnoreCase(name);
        return reviewer;
    }
}
