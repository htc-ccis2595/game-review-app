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
        persistFinalFantasyVii();
        persistFinalFantasyViii();
        persistDoom();
    }


//@Transactional
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

    //@Transactional
    private void persistDoom() {
        Game doom = new Game();
        doom.setName("Doom");
        doom.setReleaseDate("1995");
        doom.setPlatform("PC");
        ArrayList doomTags = new ArrayList<Tag>();
        doomTags.add(tagRepository.findOrCreateTag("RPG"));
        doom.setTags(doomTags);
        gameRepository.save(doom);
        log.info("Saved Game - name: " + doom.getName() + ", game_id = " + doom.getId());


    }
}
