package edu.htc.gamedata.repositories;


import edu.htc.gamedata.entities.Game;
import edu.htc.gamedata.entities.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ReviewRepository extends CrudRepository<Review, Integer> {

    List<Review> findByStarRating(int intStarRating);

    //**List<Review> findReviewsByReviewDate(String reviewDate);

    @Query("SELECT r FROM Review r WHERE r.game.name = :game")
    List<Review> findByGame(@Param("game") String game);

    //**@Query("SELECT r FROM Review r ")
    //**List<Review> findAllReviews();


}
