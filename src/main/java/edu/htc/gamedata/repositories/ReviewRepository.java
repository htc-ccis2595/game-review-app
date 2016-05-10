package edu.htc.gamedata.repositories;

import edu.htc.gamedata.entities.Game;
import edu.htc.gamedata.entities.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface ReviewRepository extends CrudRepository<Review, Integer> {

}
