package edu.htc.gamedata.config;


import edu.htc.gamedata.entities.Game;
import edu.htc.gamedata.entities.Tag;
import edu.htc.gamedata.repositories.GameRepository;
import edu.htc.gamedata.repositories.TagRepository;
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
    public void setTagRepository(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        persistFinalFantasyXIV();
        persistBorderLands2();
        persistSkate3();
    }


    private void persistFinalFantasyXIV() {

        Game ffiv = new Game();
        ffiv.setName("Final Fantasy XIV: A Realm Reborn");
        ffiv.setReleaseDate("2006");
        ffiv.setPlatform("PC");
        ArrayList ffivTags = new ArrayList<Tag>();
        ffivTags.add(tagRepository.findOrCreateTag("MMO"));
        ffivTags.add(tagRepository.findOrCreateTag("RPG"));
        ffiv.setTags(ffivTags);
        gameRepository.save(ffiv);
        log.info("Saved Game - name: " + ffiv.getName() + " id = " + ffiv.getId());
    }
    //////////////\\End of game 1\\///////////////
    ///////////////\\Start Game 2\\///////////////
    private void persistBorderLands2() {


        Game game2 = new Game();
        game2.setName("Borderlands 2");
        game2.setReleaseDate("2012");
        game2.setPlatform("PS3");
        ArrayList game2Tags = new ArrayList<Tag>();
        game2Tags.add(tagRepository.findOrCreateTag("Shooter"));
        //game2Tags.add(tagRepository.findOrCreateTag("RPG"));
        game2.setTags(game2Tags);
        gameRepository.save(game2);
        log.info("Saved Game - name: " + game2.getName() + " id = " + game2.getId());
    }
        //////////////\\End of game 2\\///////////////
        ///////////////\\Start Game 3\\///////////////
    private void persistSkate3() {
        Game game3 = new Game();
        game3.setName("Skate 3");
        game3.setReleaseDate("2010");
        game3.setPlatform("PS3");
        ArrayList game3Tags = new ArrayList<Tag>();
        game3Tags.add(tagRepository.findOrCreateTag("Sports"));
        game3.setTags(game3Tags);
        gameRepository.save(game3);
        log.info("Saved Game - name: " + game3.getName() + " id = "  + game3.getId());



        //////////////\\End of game 3\\///////////////

    }


}
