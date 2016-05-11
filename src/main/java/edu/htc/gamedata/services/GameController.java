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
        Double avgRating = reviewRepository.getAverageRating(id);
        log.info("Average rating = " + avgRating);
        if (avgRating != null) {
            game.setAverageRating(avgRating);
        }
        return game;
    }


    @RequestMapping("/search/gameByName")
    public List<Game> findGameName(@RequestParam(value="name") String name) {
        List<Game> game =  gameRepository.findByNameIgnoreCase(name);
        return game;
    }

    @RequestMapping("/search/gameByPlatform")
    public List<Game> findGameByPlatform(@RequestParam(value="platform") String str){
        List<Game> game = gameRepository.findByPlatform(str);
        return game;
    }

    @RequestMapping("/search/games")
        public List<Game> findGames(){
        List<Game> game = gameRepository.findAllGames();
        return game;
    }
}

