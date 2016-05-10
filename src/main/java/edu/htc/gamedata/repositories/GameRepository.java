package edu.htc.gamedata.repositories;

import edu.htc.gamedata.entities.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface GameRepository extends CrudRepository<Game, Integer> {
    public List<Game> findGameByName (String name);

    List<Game> findByReleaseDate(String releaseDate);

    @Query("SELECT g FROM Game g  WHERE g.platform = :platform")
    public List<Game> findByPlatform(@Param("platform") String platform);

    @Query("SELECT g FROM Game g")
    public List<Game> findAllGames();
}
