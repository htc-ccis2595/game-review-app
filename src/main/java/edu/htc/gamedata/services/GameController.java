package edu.htc.gamedata.services;

import edu.htc.gamedata.entities.Game;
import edu.htc.gamedata.repositories.GameRepository;
import edu.htc.gamedata.repositories.ReviewRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController {

    private GameRepository gameRepository;
    private ReviewRepository reviewRepository;

    private Logger log = Logger.getLogger(GameController.class);

    @Autowired
    public void setGameRepository(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Autowired
    public void setReviewRepository(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @RequestMapping("/search/gameById")
    public Game findGameById(@RequestParam(value="id") int id) {
        Game game =  gameRepository.findOne(id);
        //double avgRating = reviewRepository.getAvgRating(id);
        //log.info("Average rating = " + avgRating);
        //game.setAvgRating(avgRating);
        return game;
    }

    @RequestMapping("/search/gamesByName")
    public List<Game> findGamesByName(@RequestParam(value = "name") String name) {
        List<Game> game =  gameRepository.findGameByName(name);
        return game;
    }

    @RequestMapping("/search/gamesByPlatform")
    public List<Game> findGamesByPlatform(@RequestParam(value = "platform") String platform) {
        List<Game> game =  gameRepository.findGameByPlatform(platform);
        return game;
    }

    @RequestMapping("/search/games")
    public List<Game> findAllGames() {
        List<Game> game =  gameRepository.findAllGames();

        return game;

    }

    @RequestMapping("/search/gamesByReleaseDate")
    public List<Game> findGamesByReleaseDate(@RequestParam(value = "year") String year) {
        List<Game> game =  gameRepository.findByReleaseDate(year);
        return game;
    }

}
