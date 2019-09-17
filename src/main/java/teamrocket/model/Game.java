package teamrocket.model;

import teamrocket.util.Util;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Game {
    public void createArrayFromRepo() {
    }

    public void showAllGames() {
    }

    public void searchGameByName() {
    }

    public void filterByGameType() {
    }

    public void filterByNumberOfPlayers() {
    }
    /**
     * Class that represents a Board Game - tabletop game that involves counters or pieces moved or placed on a
     * pre-marked surface or "board", according to a set of rules.
     */

/*
    private static final Path GAMEREPO_PATH = Paths.get("./src/main/java/teamrocket/repositories/gameRepoSeba.csv");
    private static final String DELIMITER = ",";

    // Fields - more than needed
    private String gameName;
    private String gameType;
    private String gameCreator;
    private String gameDistributor;
    private String minPlayers;
    private String maxPlayers;
    private String minAge;
    private String minTime;
    private String maxTime;
    private String avgTime;
    boolean isAdvanced;



     // Class constructors

    public Game() {
    }

    public Game(String gameName, String gameType) {
        this.gameName = gameName;
        this.gameType = gameType;
    }

    public Game(String gameName, String gameType, GameProperties gameProperties){
        this.gameName = gameName;
        this.gameType = gameType;
    }

    public Game(String formattedGame) {
        if(formattedGame.contains(DELIMITER)){
            String[] splitGameParameters = formattedGame.split(DELIMITER);
            this.gameName = splitGameParameters[0];
            this.gameType = splitGameParameters[1];
            this.gameCreator = splitGameParameters[2];
            this.gameDistributor = splitGameParameters[3];
            this.minPlayers = splitGameParameters [4];
            this.maxPlayers = splitGameParameters[5];
            this.minAge = splitGameParameters[6];
            this.minTime = splitGameParameters[7];
            this.maxTime = splitGameParameters[8];
            this.avgTime = splitGameParameters[9];
        }
    }

    // Getters and Setters for all fields

    public String getGameName() { return gameName; }

    public String getGameType() { return gameType; }


    public boolean isAdvanced() { return isAdvanced; }

    public void setAdvanced(boolean advanced) { isAdvanced = advanced; }

    // JJDZTR-2 zakładam, że w klasie typu "UTIL" będą metody do załadowywania plików z danymi na temat gier
    // JJDZTR-3 j/w
    // JJDZTR-4 n/d
    // JJDZTR-5 n/d
    // JJDZTR-6 n/d
    // JJDZTR-7 - draft / propozycje metod

    // zobaczyć listę gier znajdujących się w systemie
    public Game[] showGames() throws IOException {
        List<String> gameList = Util.readFileContent(GAMEREPO_PATH);
        Game[] gamesArray = new Game[gameList.size()];
        for(int i = 0 ; i < gamesArray.length ; i++){
            gamesArray[i] = new Game(gameList.get(i));
            System.out.println(gameList.get(i));
        }
        return gamesArray;
    }


    public <T> void gameFilter(T filter){} // filtrowanie wg. typu gry oraz ilości graczy
    public void findGame(String keyword){} // wyszukiwanie gier po nazwie

    // JJDZTR-8 - draft / propozycje metod
    public void showFavourites(){} // podejrzeć listę ulubionych gier
    public void removeFromFavourites(){} // usunąć grę z listy ulubionych gier

    // JJDZTR-9 n/d
    // JJDZTR-10
    public void addToFavourites(){} // dodać grę do ulubionych - lista przechowywana w oddzielnym pliku

 */
}

