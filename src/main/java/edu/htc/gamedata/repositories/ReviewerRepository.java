package edu.htc.gamedata.repositories;

import edu.htc.gamedata.entities.Reviewer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ReviewerRepository extends CrudRepository<Reviewer, String> {


    List<Reviewer> findByName(String name);



    @Query("SELECT r FROM Reviewer r WHERE r.gender = :gender")
    List<Reviewer> findReviewerByGender(@Param("gender") String gender);

    @Query("SELECT r FROM Reviewer r")
    List<Reviewer> findAllReviewers();

}
