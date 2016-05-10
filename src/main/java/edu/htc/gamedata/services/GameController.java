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

    @RequestMapping("/search/game")
    public Game findGame(@RequestParam(value="id") int id) {
        Game game =  gameRepository.findOne(id);
        return game;
    }

    @RequestMapping("/search/gameById")
    public Game findGameById(@RequestParam(value="id") int id) {
        Game game =  gameRepository.findOne(id);
        //**double avgRating = reviewRepository.getAverageRating(id);
        //**log.info("Average rating = " + avgRating);
        //**game.setAvgRating(avgRating);
        return game;
    }

    @RequestMapping("/search/gamesByName")
    public List<Game> findGamesByName(@RequestParam(value="name") String str) {
        log.info("Find games by name " + str);
        List<Game> game = gameRepository.findByName(str);
        return game;
    }

    @RequestMapping("/search/gamesByReleaseDate")
    public List<Game> findGamesByReleaseDate(@RequestParam(value="releaseDate") String str) {
        log.info("Find games by release date " + str);
        List<Game> game =  gameRepository.findByReleaseDate(str);
        return game;
    }

    @RequestMapping("/search/gamesByPlatform")
    public List<Game> findGamesByPlatform(@RequestParam(value="platform") String str) {
        log.info("Find games by platform " + str);
        List<Game> game =  gameRepository.findByPlatform(str);
        return game;
    }

    @RequestMapping("/search/games")
    public List<Game> findGames() {
        log.info("Find all games.");
        List<Game> game =  gameRepository.findAllGames();
        return game;
    }

    @RequestMapping("/search/games/pc")
    public List<Game> findPCGames() {
        log.info("Find all PC games.");
        List<Game> game =  gameRepository.findAllPcGames();
        return game;
    }
}
