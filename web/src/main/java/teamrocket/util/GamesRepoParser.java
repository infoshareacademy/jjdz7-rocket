package teamrocket.util;

import teamrocket.dao.GamesDaoBean;
import teamrocket.domain.Game;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GamesRepoParser {

    private List<Game> gamesEntityList = new ArrayList<>();

    private GamesDaoHelper gamesDaoHelper;

    public GamesRepoParser(EntityManager em) {
        this.gamesDaoHelper = new GamesDaoHelper();
        gamesDaoHelper.setEntityManager(em);
    }

    @Transactional
    public void parseFileRepoFromAppModuleToDb() throws IOException {
        List<teamrocket.model.Game> gameList = getGamesListFromFileInAppModule();
        convertGameListToGamesEntityDto(gameList, gamesEntityList);
        for (Game games : gamesEntityList) {
            gamesDaoHelper.add(games);
        }
    }

    @Transactional
    public void parseFileRepoToDb(InputStream fileContent) {
        gamesEntityList = (List<Game>) new InputStreamReader(fileContent);
        for (Game games : gamesEntityList) {
            gamesDaoHelper.add(games);
        }
    }

    public Game convertDtoToEntity(teamrocket.model.Game game) {
        Game gamesEntity = new Game();
        gamesEntity.setAverageWeight(game.getAverageWeight());
        gamesEntity.setBggRank(game.getBggRank());
        gamesEntity.setCategory(game.getCategory());
        gamesEntity.setGameArtist(game.getGameArtist());
        gamesEntity.setGameDesigner(game.getGameDesigner());
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

    private List<teamrocket.model.Game> getGamesListFromFileInAppModule() throws IOException {
        return teamrocket.model.Game.createGamesArrayFromRepository();
    }

    private void convertGameListToGamesEntityDto(List<teamrocket.model.Game> gameList, List<Game> gamesEntityList) {
        for (teamrocket.model.Game game : gameList) {
            gamesEntityList.add(convertDtoToEntity(game));
        }
    }

    private class GamesDaoHelper extends GamesDaoBean {
        public void setEntityManager(EntityManager em) {
            entityManager = em;
        }
    }
}
