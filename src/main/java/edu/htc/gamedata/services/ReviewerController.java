package edu.htc.gamedata.services;

/**
 * Created by cheey on 5/9/2016.
 */
import edu.htc.gamedata.entities.Game;
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
    public Reviewer findReviewer(@RequestParam(value="username") String userName) {
        Reviewer reviewer =  reviewerRepository.findOne(userName);
        return reviewer;
    }

    @RequestMapping("/search/username")
    public Reviewer findByUserName(@RequestParam(value="username") String userName) {
        Reviewer uName = reviewerRepository.findByUserName(userName);
        return uName;
    }

    //--http://localhost:8080/search/username?username=Shantotto

    @RequestMapping("/search/name")
    public Reviewer findByName(@RequestParam(value="name") String name){
        Reviewer rName = reviewerRepository.findByName(name);
        return rName;
    }

    //--http://localhost:8080/search/name?name=Ago
}
