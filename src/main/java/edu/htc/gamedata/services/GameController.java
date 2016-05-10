package edu.htc.gamedata.services;

import edu.htc.gamedata.entities.Game;
import edu.htc.gamedata.repositories.GameRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController {

    private GameRepository gameRepository;

    private Logger log = Logger.getLogger(GameController.class);

    @Autowired
    public void setGameRepository(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @RequestMapping("/search/gameById")
    public Game findGame(@RequestParam(value="id") int id) {
        Game game =  gameRepository.findOne(id);
        return game;
    }

    @RequestMapping("/search/games")
    public List findGames() {
        List<Game> game = gameRepository.findAllGames();
        return game;
    }

    @RequestMapping("/search/gamesByName")
    public List<Game> findGameByName(@RequestParam(value="name") String name) {
        List<Game> game =  gameRepository.findGameByName(name);
        return game;
    }

    @RequestMapping("/search/gamesByPlatform")
    public List<Game> findGameByPlatform(@RequestParam(value="platform") String platform) {
        List<Game> game =  gameRepository.findByPlatform(platform);
        return game;
    }
}
