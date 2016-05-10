package edu.htc.gamedata.repositories;


import edu.htc.gamedata.entities.Reviewer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ReviewerRepository extends CrudRepository<Reviewer, String> {


    //List<Reviewer> findReviewer(String name);

}
