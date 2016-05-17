package edu.htc.gamedata.repositories;


import edu.htc.gamedata.entities.Review;
import edu.htc.gamedata.entities.Reviewer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ReviewerRepository extends CrudRepository<Reviewer, String> {

    @Query("SELECT r FROM Reviewer r ")
    List<Reviewer> findAllReviewers();


}
