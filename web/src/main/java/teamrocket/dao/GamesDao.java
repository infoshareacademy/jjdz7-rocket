package teamrocket.dao;

import teamrocket.model.Game;

import javax.ejb.Local;
import java.io.IOException;
import java.util.List;

@Local
public interface GamesDao {

    List<Game> getGamesList() throws IOException;

}
