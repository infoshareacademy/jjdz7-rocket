package teamrocket.model;

import teamrocket.util.Util;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Game {
    /**
     * Class that represents a Board Game - tabletop game that involves counters or pieces moved or placed on a
     * pre-marked surface or "board", according to a set of rules.
     */

    private static final Path GAMEREPO_PATH = Paths.get("./src/main/java/teamrocket/repositories/gameRepoSeba.csv");
    private static final String DELIMITER = ",";

    // Fields - more than needed
    private int id;
    private String gameName;
    private String gameType;
    private int minPlayers;
    private int maxPlayers;
    private int minAge;
    private int minTime;
    private int maxTime;
    private int avgTime;
    boolean isAdvanced;
    private String gameCreator;
    private String gameDistributor;

     // Class constructors

    public Game() {
    }

    public Game(String formattedGame) {
        if(formattedGame.contains(DELIMITER)){
            String[] splitGameParameters = formattedGame.split(DELIMITER);
            this.id = parseInt(splitGameParameters[0]);
            this.gameName = splitGameParameters[1];
            this.gameType = splitGameParameters[2];
            this.gameCreator = splitGameParameters[3];
            this.gameDistributor = splitGameParameters[4];
            this.minPlayers = parseInt(splitGameParameters[5]);
            this.maxPlayers = parseInt(splitGameParameters[6]);
            this.minAge = parseInt(splitGameParameters[7]);
            this.minTime = parseInt(splitGameParameters[8]);
            this.maxTime = parseInt(splitGameParameters[9]);
            this.avgTime = parseInt(splitGameParameters[10]);
        }
    }

    public int getId() { return id; }

    public String getGameName() {
        return gameName;
    }

    public String getGameType() {
        return gameType;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    // JJDZTR-7 - draft / propozycje metod

    String addSpaces(int i, String str){
        StringBuilder str1 = new StringBuilder();
        for(int j=0;j<i-str.length();j++)
        { str1.append(" "); }
        str = str + str1;
        return str;
    }

    // zobaczyć listę gier znajdujących się w systemie
    public Game[] showGames() throws IOException {
        System.out.println("GAME_ID  |" +
                " GAME_NAME                   " +
                "| GAME_TYPE                   " +
                "| NUMBER_OF_PLAYERS");
        List<String> gameList = Util.readFileContent(GAMEREPO_PATH);
        Game[] gamesArray = new Game[gameList.size()];
        for(int i = 0 ; i < gamesArray.length ; i++){
            gamesArray[i] = new Game(gameList.get(i));
            System.out.print(gamesArray[i].addSpaces(10, String.valueOf(gamesArray[i].getId())));
            System.out.print(gamesArray[i].addSpaces(30,gamesArray[i].getGameName()));
            System.out.print(gamesArray[i].addSpaces(30,gamesArray[i].getGameType()));
            System.out.print(gamesArray[i].addSpaces(15, getMinPlayers() + " - " + gamesArray[i].getMaxPlayers()));
            System.out.print("\n");
        }
        return gamesArray;
    }

    public <T> void gameFilter(T filter){} // filtrowanie wg. typu gry oraz ilości graczy
    public void findGame(String keyword){} // wyszukiwanie gier po nazwie

    // JJDZTR-8 - draft / propozycje metod
    public void showFavourites(){} // podejrzeć listę ulubionych gier
    public void removeFromFavourites(){} // usunąć grę z listy ulubionych gier

    // JJDZTR-10
    public void addToFavourites(){} // dodać grę do ulubionych - lista przechowywana w oddzielnym pliku
}

