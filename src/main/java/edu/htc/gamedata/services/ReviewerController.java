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
    public Reviewer findByUserName(@RequestParam(value="username") String str) {
        log.info("Finding reviewer by username " + str);
        Reviewer reviewer = reviewerRepository.findByUserName(str);
        return reviewer;
    }

    @RequestMapping("/search/reviewersByGender")
    public List<Reviewer> findReviewerGender(@RequestParam(value="gender") String gender) {
        log.info("Finding reviewers of the " + gender + " gender");
        List<Reviewer> reviewers = reviewerRepository.findByGender(gender);
        return reviewers;
    }
}
