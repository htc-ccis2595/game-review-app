package edu.htc.gamedata.repositories;

import edu.htc.gamedata.entities.Review;
import org.springframework.data.repository.CrudRepository;


public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
