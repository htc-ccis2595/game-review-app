package edu.htc.gamedata.repositories;

import edu.htc.gamedata.entities.Reviewer;
import org.springframework.data.repository.CrudRepository;


public interface ReviewerRepository extends CrudRepository<Reviewer, String> {

}
