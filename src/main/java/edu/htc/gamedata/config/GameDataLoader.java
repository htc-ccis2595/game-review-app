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
        persistMineCraft1();
        persistffxiv();
        persistCandyCrush();

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
    private void persistMineCraft1() {
        Game minecraft1 = new Game();
        minecraft1.setName("MineCraft");
        minecraft1.setReleaseDate("2006");
        minecraft1.setPlatform("PlayStation");
        ArrayList minecraftTags = new ArrayList<Tag>();
        minecraftTags.add(tagRepository.findOrCreateTag("HD Graphics"));
        minecraft1.setTags(minecraftTags);
        gameRepository.save(minecraft1);
        log.info("Saved Game - name: " + minecraft1.getName() + ", game_id = " + minecraft1.getId());
    }

    //@Transactional
    private void persistffxiv() {
        Game ffxiv = new Game();
        ffxiv.setName("Final Fantasy XIV: A Realm Reborn");
        ffxiv.setReleaseDate("2006");
        ffxiv.setPlatform("PC");

        ArrayList tags = new ArrayList<Tag>();

        tags.add(new Tag("MMO"));
        tags.add(new Tag("RFG"));

        gameRepository.save(ffxiv);

        log.info("Saved Game - name: " + ffxiv.getName() + " id = " + ffxiv.getId());
    }

    //@Transactional
    private void persistCandyCrush() {

        Game ccsaga = new Game();
        ccsaga.setName("Candy Crush Saga 2.0");
        ccsaga.setReleaseDate("2016");
        ccsaga.setPlatform("PC");

        ArrayList tags = new ArrayList<Tag>();

        tags.add(new Tag("multi-level"));
        tags.add(new Tag("game rewards"));

        gameRepository.save(ccsaga);

        log.info("Saved Game - name: " + ccsaga.getName() + " id = " + ccsaga.getId());
    }
}
