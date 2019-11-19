package teamrocket.dao;

import teamrocket.model.Game;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class GamesDaoBean implements GamesDao {

    Game game = new Game();

    @Override
    public List<Game> getGamesList() {
       return game.createGamesArrayFromRepository();
    }
}
