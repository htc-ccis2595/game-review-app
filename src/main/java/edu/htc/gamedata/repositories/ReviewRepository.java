package edu.htc.gamedata.repositories;

import edu.htc.gamedata.entities.Game;
import edu.htc.gamedata.entities.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface ReviewRepository extends CrudRepository<Review, Integer> {

    public List<Review> findByComments(String comments);

    @Query("SELECT AVG(r.starRating) FROM Review r WHERE r.game.id = :gameId GROUP BY r.game.id")
    Double getAverageRating(@Param("gameId") int gameId);

    @Query("SELECT r FROM Review r WHERE r.starRating = :starRating")
    List<Review> findByStarRating(@Param("starRating") int starRating);

    @Query("SELECT r FROM Review r WHERE r.reviewer.userName = :userName")
    List<Review> findByUserName(@Param("userName") String userName);

}
