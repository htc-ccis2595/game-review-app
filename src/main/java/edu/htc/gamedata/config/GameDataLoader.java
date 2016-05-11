package edu.htc.gamedata.config;


import edu.htc.gamedata.entities.Game;
import edu.htc.gamedata.entities.Tag;
import edu.htc.gamedata.repositories.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
     //   Game gameOne = createFinalFantasyXiv();
    //    Game gameTwo = createEveOnline();
    //    Game gameThree = createUtlimaOnline();

        Game gameOne = new Game();
        gameOne.setName("Final Fantasy XIV");
        gameOne.setReleaseDate("2010");
        gameOne.setPlatform("playstation");
        ArrayList ffxivtags = new ArrayList<Tag>();


        ffxivtags.add(tagRepository.findOrCreateTag("Fantasy"));
        gameOne.setTags(ffxivtags);


        gameRepository.save(gameOne);
        log.info("Saved Game - name: " + gameOne.getName() + " id = " + gameOne.getId());

        Game gameTwo = new Game();
    gameTwo.setName("Eve Online");
    gameTwo.setReleaseDate("2006");
    gameTwo.setPlatform("PC");
        ArrayList Evetags = new ArrayList<Tag>();

        Evetags.add(tagRepository.findOrCreateTag("MMO"));

    gameTwo.setTags(Evetags);

        gameRepository.save(gameTwo);
        log.info("Saved Game - name: " + gameTwo.getName() + " id = " + gameTwo.getId());


        Game gameThree = new Game();
        gameThree.setName("Ultima Online");
        gameThree.setReleaseDate("1999");
        gameThree.setPlatform("PC");
        ArrayList Ultimatags = new ArrayList<Tag>();


        Ultimatags.add(tagRepository.findOrCreateTag("RPG"));
        gameThree.setTags(Ultimatags);



        gameRepository.save(gameThree);
        log.info("Saved Game - name: " + gameThree.getName() + " id = " + gameThree.getId());


    }


}
