package edu.htc.gamedata.config;

import edu.htc.gamedata.entities.Game;
import edu.htc.gamedata.repositories.GameRepository;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by joe on 5/2/2016.
 */
@RestController
public class GameController {
    private GameRepository gameRepository;

    private Logger log = Logger.getLogger(GameController.class);

    @Autowired
    public void setGameRepository(GameRepository gameRepository){this.gameRepository = gameRepository;}

 @RequestMapping("/search/game")
        public Game findGame(@RequestParam(value="id") int id) {
                Game game =  new Game();

                        game.setName("Test Game");
            game.setPlatform("PC");
               game.setYearReleased("1984");

                        return game;
            }

}
