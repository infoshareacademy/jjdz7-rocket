package teamrocket.dao;

import teamrocket.model.Game;

import javax.ejb.Stateless;
import java.io.IOException;
import java.util.List;

@Stateless
public class GamesDaoBean implements GamesDao {

    Game game = new Game();

    @Override
    public List<Game> getGamesList() throws IOException {
      //  List<String> gameList = Util.readFileContent(Paths.get(".","web", "src", "main", "resources", "gamesRepository.csv"));
      //  List<Game> games = new ArrayList<>();
//
      //  for (int i = 0; i < gameList.size(); i++){
      //      games.add( new Game(gameList.get(i)));
      //  }
      //  return games;
        return game.createGamesArrayFromRepository();
    }
}
