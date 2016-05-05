package edu.htc.gamedata.config;


import edu.htc.gamedata.entities.Game;
import edu.htc.gamedata.entities.Tag;
import edu.htc.gamedata.repositories.GameRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class GameDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private GameRepository gameRepository;

    private Logger log = Logger.getLogger(GameDataLoader.class);

    @Autowired
    public void setGameRepository(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        /*
        GAME ONE
         */
        Game game = new Game();
        game.setName("Final Fantasy XIV: A Realm Reborn");
        game.setReleaseDate("2006");
        game.setPlatform("PC");
        ArrayList tags = new ArrayList<Tag>();
        tags.add(new Tag("MMO"));
        tags.add(new Tag("RPG"));
        gameRepository.save(game);

        log.info("Saved Game - name: " + game.getName() + " id = " + game.getId());

        /*
        GAME TWO
         */
        Game game2 = new Game();
        game2.setName("Doom");
        game2.setReleaseDate("1995");
        game2.setPlatform("PC");
        ArrayList tags2 = new ArrayList<Tag>();
        tags2.add(new Tag("RPG"));
        gameRepository.save(game2);

        log.info("Saved Game2 - name: " + game2.getName() + " id = " + game2.getId());

        /*
        GAME THREE
         */
        Game game3 = new Game();
        game3.setName("Captain Comic");
        game3.setReleaseDate("1995");
        game3.setPlatform("PC");
        ArrayList tags3 = new ArrayList<Tag>();
        tags3.add(new Tag("Run and Jump"));
        gameRepository.save(game3);

        log.info("Saved Game3 - name: " + game3.getName() + " id = " + game3.getId());

    }
}
