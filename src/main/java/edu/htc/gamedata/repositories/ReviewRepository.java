package edu.htc.gamedata.repositories;

import edu.htc.gamedata.entities.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface ReviewRepository extends CrudRepository<Review, Integer> {
    @Query("SELECT AVG(r.starRating) FROM Review r WHERE r.game.id = :gameId")
    double getAvgRating(@Param("gameId") int gameId);
}
