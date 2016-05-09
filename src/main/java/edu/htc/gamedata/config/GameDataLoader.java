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

        //--CREATE GAME
        Game game = new Game();
        //--SET VARIABLES
        game.setName("Final Fantasy XIV: A Realm Reborn");
        game.setReleaseDate("2006");
        game.setPlatform("PC");
        //--CREATE & ADD TO ARRAYLIST
        ArrayList tags = new ArrayList<Tag>();
        tags.add(new Tag("MMO"));
        tags.add(new Tag("RPG"));
        //--SAVE GAME TO REPOSITORY
        game = gameRepository.save(game);
        //--PRINT GAME TO LOGFILE
        log.info("Game Saved! Game Title: " + game.getName() + " -- " + " Game ID = " + game.getId());

        //--GAME2
        Game game1 = new Game();
        game1.setName("Final Fantasy XI Online");
        game1.setReleaseDate("1994");
        game1.setPlatform("PC");
        ArrayList tag1 = new ArrayList<Tag>();
        game1 = gameRepository.save(game1);
        log.info("Game Saved! Game Title: " + game1.getName() + " -- " + " Game ID = " + game1.getId());

        //--GAME3
        Game game2 = new Game();
        game2.setName("Final Fantasy X");
        game2.setReleaseDate("2010");
        game2.setPlatform("PS3/PS4");
        ArrayList tag2 = new ArrayList<Tag>();
        tag2.add(new Tag("RPG"));
        game2 = gameRepository.save(game2);
        log.info("Game Saved! Game Title: " + game2.getName() + " -- " + " Game ID = " + game2.getId());

        //--GAME4
        Game game3 = new Game();
        game3.setName("Final Fantasy VII");
        game3.setReleaseDate("2015");
        game3.setPlatform("PS");
        ArrayList tag3 = new ArrayList<Tag>();
        tag3.add(new Tag("RPG"));
        game3 = gameRepository.save(game3);
        log.info("Game Saved! Game Title: " + game3.getName() + " -- " + " Game ID = " + game3.getId());
    }
}
