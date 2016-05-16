package edu.htc.gamedata.repositories;

import edu.htc.gamedata.entities.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface GameRepository extends CrudRepository<Game, Integer> {

    List<Game> findByName(String name);

    List<Game> findByReleaseDate(String year);

    @Query("SELECT g FROM Game g WHERE g.platform = :platform")
    List<Game> findByPlatform(@Param("platform") String platform);

    @Query("SELECT g FROM Game g ")
    List<Game> findAllGames();

    @Query("SELECT g FROM Game g WHERE g.platform = 'PC'")
    List<Game> findAllPcGames();
}
