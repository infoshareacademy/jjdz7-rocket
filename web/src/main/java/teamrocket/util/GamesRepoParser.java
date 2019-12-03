package teamrocket.util;

import teamrocket.dao.GamesDaoBean;
import teamrocket.domain.Games;
import teamrocket.model.Game;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GamesRepoParser {

    private List<Games> gamesEntityList = new ArrayList<>();

    private GamesDaoHelper gamesDaoHelper;

    GamesRepoParser(EntityManager em) {
        this.gamesDaoHelper = new GamesDaoHelper();
        gamesDaoHelper.setEntityManager(em);
    }

    @Transactional
    public void parseFileRepoFromAppModuleToDb() throws IOException {
        List<Game> gameList = getGamesListFromFileInAppModule();
        convertGameListToGamesEntityDto(gameList, gamesEntityList);
        for (Games games : gamesEntityList) {
            gamesDaoHelper.add(games);
        }
    }

    public void parseFileRepoToDb() {
        //TODO: get file from web page and reuse convert method, then use add method
       /* List<Game> gameList = getGamesListFromFileInAppModule();
        convertGameListToGamesEntityDto(gameList, gamesEntityList);*/
        for (Games games : gamesEntityList) {
            gamesDaoHelper.add(games);
        }
    }

    public Games convertDtoToEntity(Game game) {
        Games gamesEntity = new Games();
        gamesEntity.setAverageWeight(game.getAverageWeight());
        gamesEntity.setBggRank(game.getBggRank());
        gamesEntity.setCategory(game.getCategory());
        gamesEntity.setGameArtist(game.getGameArtist());
        gamesEntity.setGameDesinger(game.getGameDesigner());
        gamesEntity.setGameId(game.getGameId());
        gamesEntity.setGameName(game.getGameName());
        gamesEntity.setGamePublisher(game.getGamePublisher());
        gamesEntity.setLastName("");
        gamesEntity.setMaxPlayers(game.getMaxPlayers());
        gamesEntity.setMaxPlayTime(game.getMaxPlayTime());
        gamesEntity.setMechanic(game.getMechanic());
        gamesEntity.setMinAge(game.getMinAge());
        gamesEntity.setMinPlayers(game.getMinPlayers());
        gamesEntity.setMinPlayTime(game.getMinPlayTime());
        gamesEntity.setYearPublished(game.getYearPublished());
        return gamesEntity;
    }

    private List<Game> getGamesListFromFileInAppModule() throws IOException {
        return Game.createGamesArrayFromRepository();
    }

    private void convertGameListToGamesEntityDto(List<Game> gameList, List<Games> gamesEntityList) {
        for (Game game : gameList) {
            gamesEntityList.add(convertDtoToEntity(game));
        }
    }

    private class GamesDaoHelper extends GamesDaoBean {
        public void setEntityManager(EntityManager em) {
            entityManager = em;
        }
    }
}
