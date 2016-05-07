package edu.htc.gamedata.repositories;

import edu.htc.gamedata.entities.Game;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface GameRepository extends CrudRepository<Game, Integer> {

    public List<Game> findByNameIgnoreCase(String name);
}
