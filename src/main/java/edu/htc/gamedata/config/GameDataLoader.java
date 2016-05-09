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

        Game game = new Game();
        game.setName("Final Fantasy XIV: A Realm Reborn");
        game.setReleaseDate("2006");
        game.setPlatform("PC");

        ArrayList tags = new ArrayList<Tag>();

        tags.add(new Tag("MMO"));
        tags.add(new Tag("RFG"));

        gameRepository.save(game);

        log.info("Saved Game - name: " + game.getName() + " id = " + game.getId());

        game = new Game();
        game.setName("MineCraft 1.0");
        game.setReleaseDate("2006");
        game.setPlatform("PC");

        tags = new ArrayList<Tag>();

        tags.add(new Tag("multi-level"));
        tags.add(new Tag("HD graphics"));

        gameRepository.save(game);

        log.info("Saved Game - name: " + game.getName() + " id = " + game.getId());

        game = new Game();
        game.setName("Candy Crush Saga 2.0");
        game.setReleaseDate("2016");
        game.setPlatform("PC");

        tags = new ArrayList<Tag>();

        tags.add(new Tag("multi-level"));
        tags.add(new Tag("game rewards"));

        gameRepository.save(game);

        log.info("Saved Game - name: " + game.getName() + " id = " + game.getId());
    }
}
