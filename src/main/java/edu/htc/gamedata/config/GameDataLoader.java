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

        Game gameone = new Game();
        gameone.setId(1);
        gameone.setName("Final Fantasy XIV: A Realm Reborn");
        gameone.setReleaseDate("2006");
        gameone.setPlatform("PC");
        ArrayList<Tag> gameOneTags = new ArrayList<Tag>();
        gameOneTags.add(new Tag("MMO"));
        gameOneTags.add(new Tag("RPG"));

        gameRepository.save(gameone);

        log.info("Saved Game - name: " + gameone.getName());

        Game gameTwo = new Game();
        gameTwo.setId(2);
        gameTwo.setName("eve Online");
        gameTwo.setReleaseDate("2004");
        gameTwo.setPlatform("PC");
        ArrayList<Tag> gameTwoTags = new ArrayList<Tag>();
        gameTwoTags.add(new Tag("MMO"));
        gameTwoTags.add(new Tag("RPG"));

        gameRepository.save(gameTwo);

        log.info("Saved Game - name: " + gameTwo.getName());

        Game gameThree = new Game();
        gameThree.setId(3);
        gameThree.setName("Fallout 4");
        gameThree.setReleaseDate("2016");
        gameThree.setPlatform("XBOX One");
        ArrayList<Tag> gameThreeTags = new ArrayList<Tag>();
        gameThreeTags.add(new Tag("RPG"));

        gameRepository.save(gameThree);

        log.info("Saved Game - name: " + gameThree.getName());


    }
}
