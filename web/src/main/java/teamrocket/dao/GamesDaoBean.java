package teamrocket.dao;


import teamrocket.model.Game;
import teamrocket.util.Util;

import javax.ejb.Stateless;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class GamesDaoBean implements GamesDao {


    @Override
    public List<Game> getGamesList() throws IOException {

        List<String> stringList = new ArrayList<>();
        stringList = Util.readFileContent(Paths.get("/home/jumps/IdeaProjects/jjdz7-rocket/web/src/main/resources/gamesRepository.csv"));

        List<Game> gamesList = new ArrayList<>();
        for (int i = 0; i< stringList.size(); i++){
            gamesList.add(new Game(stringList.get(i)));

        }
        return gamesList;
    }
}
