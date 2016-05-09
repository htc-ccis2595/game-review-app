package edu.htc.gamedata.config;


import edu.htc.gamedata.entities.Game;
import edu.htc.gamedata.entities.Tag;

import edu.htc.gamedata.repositories.GameRepository;

import edu.htc.gamedata.repositories.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


import java.util.ArrayList;

@Component
public class GameDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private GameRepository gameRepository;
    private TagRepository tagRepository;

    private Logger log = Logger.getLogger(GameDataLoader.class);

    @Autowired
    public void setGameRepository(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Autowired
    public void setTagRepository(TagRepository repository) {
        this.tagRepository = repository;
    }


    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        persistFinalFantasyVii();
        persistFinalFantasyViii();


        Game game = new Game();
        game.setName("Final Fantasy XIV: A Realm Reborn");
        game.setReleaseDate("2006");
        game.setPlatform("PC");
        //ArrayList tags = new ArrayList<Tag>();
        //tags.add(new Tag("MMO"));
        //tags.add(new Tag("RPG"));
        //game.setTags(tags);
        game = gameRepository.save(game);
        log.info("Saved Game - name: " + game.getName() + " id = " + game.getId());

        Game game1 = new Game();
        game1.setName("Fallout 4");
        game1.setReleaseDate("2015");
        game1.setPlatform("PlayStation 4");
        //ArrayList tags1 = new ArrayList<Tag>();
        //tags1.add(new Tag("Single Player"));
        //tags1.add(new Tag("RPG"));
        //game1.setTags(tags1);
        game1 = gameRepository.save(game1);
        log.info("Saved Game - name: " + game1.getName() + " id = " + game1.getId());

        Game game2 = new Game();
        game2.setName("The Sims 4");
        game2.setReleaseDate("2015");
        game2.setPlatform("PC");
        // ArrayList tags2 = new ArrayList<Tag>();
        // tags2.add(new Tag("Simulation"));
        // tags2.add(new Tag("EA"));
        game2 = gameRepository.save(game2);
        log.info("Saved Game - name: " + game2.getName() + " id = " + game2.getId());
    }

    private void persistFinalFantasyVii() {
        Game ffvii = new Game();
        ffvii.setName("Final Fantasy VII");
        ffvii.setReleaseDate("1997");
        ffvii.setPlatform("PlayStation");
        ArrayList ffviiTags = new ArrayList<Tag>();
        ffviiTags.add(tagRepository.findOrCreateTag("RPG"));
        ffvii.setTags(ffviiTags);
        gameRepository.save(ffvii);
        log.info("Saved Game - name: " + ffvii.getName() + ", game_id = " + ffvii.getId());
    }

    //@Transactional
    private void persistFinalFantasyViii() {
        Game ffviii = new Game();
        ffviii.setName("Final Fantasy VIII");
        ffviii.setReleaseDate("1999");
        ffviii.setPlatform("PlayStation");
        ArrayList ffviiiTags = new ArrayList<Tag>();
        ffviiiTags.add(tagRepository.findOrCreateTag("RPG"));
        ffviii.setTags(ffviiiTags);
        gameRepository.save(ffviii);
        log.info("Saved Game - name: " + ffviii.getName() + ", game_id = " + ffviii.getId());


    }


}
