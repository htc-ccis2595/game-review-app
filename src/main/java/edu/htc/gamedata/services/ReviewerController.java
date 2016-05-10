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
    public Reviewer findReviewer(@RequestParam(value="username") String userName) {
        Reviewer reviewer =  reviewerRepository.findOne(userName);
        return reviewer;
    }

    @RequestMapping("/search/userName")
    public List<Reviewer> findReviewerByUserName(@RequestParam(value="userName") String userName) {
        List<Reviewer> reviewer =  reviewerRepository.findReviewerByUserName(userName);
        return reviewer;
    }


    @RequestMapping("/search/name")
    public List<Reviewer> findReviewerByName(@RequestParam(value="name") String name) {
        List<Reviewer> reviewer =  reviewerRepository.findReviewerByName(name);
        return reviewer;
    }


    @RequestMapping("/search/age")
    public List<Reviewer> findReviewerByAge(@RequestParam(value="age") int age) {
        List<Reviewer> reviewer =  reviewerRepository.findReviewerByAge(age);
        return reviewer;
    }

    @RequestMapping("/search/gender")
    public List<Reviewer> findReviewerByGender(@RequestParam(value="gender") String gender) {
        List<Reviewer> reviewer =  reviewerRepository.findReviewerByGender(gender);
        return reviewer;
    }

    @RequestMapping("/search/comments")
    public List<Reviewer> findReviewerByComments(@RequestParam(value="comments") String comments) {
        List<Reviewer> reviewer =  reviewerRepository.findReviewerByComments(comments);
        return reviewer;
    }

    @RequestMapping("/search/password")
    public List<Reviewer> findReviewerByPassword(@RequestParam(value="password") String password) {
        List<Reviewer> reviewer =  reviewerRepository.findReviewerByPassword(password);
        return reviewer;
    }




}
