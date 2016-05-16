package edu.htc.gamedata.repositories;


import edu.htc.gamedata.entities.Reviewer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ReviewerRepository extends CrudRepository<Reviewer, String> {

    public List<Reviewer> findByNameIgnoreCase(String name);

    @Query("SELECT r FROM Reviewer r WHERE r.gender = :gender")
    List<Reviewer> findByGender(@Param("gender")String gender);
}
