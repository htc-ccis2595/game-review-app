package edu.htc.gamedata.repositories;


import edu.htc.gamedata.entities.Review;


import edu.htc.gamedata.entities.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface ReviewRepository extends CrudRepository<Review, Integer> {

    //List<Review> findByReviewDate (Date date);

    List<Review> findByStarRating(int starRating);

    @Query("SELECT r FROM Review r WHERE r.starRating > 2")
    List<Review> findReviewAboveRatingTwo();








//    @Query("SELECT AVG(r.starRating) FROM Review r WHERE r.game.id = :gameId")
//    double getAverageRating(@Param("gameId") int gameId);
}
