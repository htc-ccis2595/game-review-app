package edu.htc.gamedata.config;

import edu.htc.gamedata.entities.Game;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @RequestMapping("/search/game")
    public Game findGame(@RequestParam(value="name") String name) {
        Game game =  new Game();

        game.setName("Test Game");
        game.setPlatform("PC");
        game.setReleaseDate("1984");

        return game;
    }
}
