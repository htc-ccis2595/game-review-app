package edu.htc.gamedata.repositories;

import edu.htc.gamedata.entities.Reviewer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ReviewerRepository extends CrudRepository<Reviewer, String> {
    @Query("SELECT r FROM Reviewer r WHERE r.userName = :userName")
    public List<Reviewer> findReviewerByUserName(@Param("userName") String userName);

    @Query("SELECT r FROM Reviewer r WHERE r.name = :name")
    public List<Reviewer> findReviewerByName(@Param("name") String name);

    @Query("SELECT r FROM Reviewer r WHERE r.age = :age")
    public List<Reviewer> findReviewerByAge(@Param("age") int age);

    @Query("SELECT r FROM Reviewer r WHERE r.gender = :gender")
    public List<Reviewer> findReviewerByGender(@Param("gender") String gender);

    @Query("SELECT r FROM Reviewer r WHERE r.comments = :comments")
    public List<Reviewer> findReviewerByComments(@Param("comments") String comments);

    @Query("SELECT r FROM Reviewer r WHERE r.password = :password")
    public List<Reviewer> findReviewerByPassword(@Param("password") String password);


}
