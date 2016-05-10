package edu.htc.gamedata.repositories;

import edu.htc.gamedata.entities.Game;
import edu.htc.gamedata.entities.Reviewer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ReviewerRepository extends CrudRepository<Reviewer, String> {
    //public Reviewer findByName(String name);

    @Query("SELECT r FROM Reviewer r WHERE r.userName = :userName")
    Reviewer findByUserName(@Param("userName") String userName);

    @Query("SELECT r FROM Reviewer r WHERE r.name = :name")
    Reviewer findByName(@Param("name") String name);

}
