package teamrocket.model;

import teamrocket.util.Util;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Game {
    /**
     * Class that represents a Board Game - tabletop game that involves counters or pieces moved or placed on a
     * pre-marked surface or "board", according to a set of rules.
     */

    private static final Path GAMEREPO_PATH = Paths.get ( "./src/main/repositories/GamesRepository.csv" );
    private static final String DELIMITER = ";";

    private int id;
    private String gameName;
    private String gameDesigner;
    private String gamePublisher;
    private String gameArtist;
    private int yearPublished;
    private int minPlayers;
    private int maxPlayers;
    private int minPlayTime;
    private int maxPlayTime;
    private int minAge;
    private int bggRank;
    private double averageWeight;
    private String category;
    private String mechanic;
    private static List<Game> gamesArray = new ArrayList<> ();

    public Game(String formattedGame) {
        if (formattedGame.contains ( DELIMITER )) {
            String[] splitGameParameters = formattedGame.split ( DELIMITER );
            this.id = parseInt ( splitGameParameters[0] );
            this.gameName = splitGameParameters[1];
            this.gameDesigner = splitGameParameters[2];
            this.gamePublisher = splitGameParameters[3];
            this.gameArtist = splitGameParameters[4];
            this.yearPublished = parseInt ( splitGameParameters[5] );
            this.minPlayers = parseInt ( splitGameParameters[6] );
            this.maxPlayers = parseInt ( splitGameParameters[7] );
            this.minPlayTime = parseInt ( splitGameParameters[8] );
            this.maxPlayTime = parseInt ( splitGameParameters[9] );
            this.minAge = parseInt ( splitGameParameters[10] );
            this.bggRank = parseInt ( splitGameParameters[11] );
            this.averageWeight = parseDouble ( splitGameParameters[12] );
            this.category = splitGameParameters[13];
            this.mechanic = splitGameParameters[14];
        }
    }


    public int getId() {
        return id;
    }

    public String getGameName() {
        return gameName;
    }

    public String getCategory() {
        return category;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Game game = ( Game ) o;
        return id == game.id &&
                yearPublished == game.yearPublished &&
                minPlayers == game.minPlayers &&
                maxPlayers == game.maxPlayers &&
                minPlayTime == game.minPlayTime &&
                maxPlayTime == game.maxPlayTime &&
                minAge == game.minAge &&
                bggRank == game.bggRank &&
                Double.compare ( game.averageWeight, averageWeight ) == 0 &&
                gameName.equals ( game.gameName ) &&
                gameDesigner.equals ( game.gameDesigner ) &&
                gamePublisher.equals ( game.gamePublisher ) &&
                gameArtist.equals ( game.gameArtist ) &&
                category.equals ( game.category ) &&
                mechanic.equals ( game.mechanic );
    }

    @Override
    public int hashCode() {
        return Objects.hash ( id, gameName, gameDesigner, gamePublisher, gameArtist, yearPublished, minPlayers, maxPlayers, minPlayTime, maxPlayTime, minAge, bggRank, averageWeight, category, mechanic );
    }

    public static List<Game> createArrayFromRepo() {
        List<String> gameList = null;
        try {
            gameList = Util.readFileContent ( GAMEREPO_PATH );
        } catch (IOException e) {
            System.out.println ( "Wrong Path to Repo file or repo doesn't exist" );
            ;
        }
        for (int i = 0; i < gameList.size (); i++) {
            gamesArray.add ( new Game ( gameList.get ( i ) ) );
        }
        return gamesArray;
    }

    private void printHeading() {
        System.out.println ( "GAME_ID  |" +
                " GAME_NAME                                                                               " +
                "| NUMBER_OF_PLAYERS           " +
                "| GAME_TYPE " );
    }

    private void printGames(Game game) {
        System.out.print ( Util.addSpaces ( 10, String.valueOf ( game.getId () ) ) );
        System.out.print ( Util.addSpaces ( 90, game.getGameName () ) );
        System.out.print ( Util.addSpaces ( 30, game.getMinPlayers () + " - " + game.getMaxPlayers () ) );
        System.out.print ( Util.addSpaces ( 30, game.getCategory () ) );
        System.out.print ( "\n" );
    }

    public void showAllGames() {
        printHeading ();
        for (Game game : gamesArray) {
            printGames ( game );
        }
    }

    public void filterByGameType() {
        System.out.println ( "Type game type by which You would like to filter the database: " );
        String userInput = Util.readUserInput ();
        printHeading ();
        for (Game game : gamesArray)
            if (game.getCategory ().toLowerCase ().contains ( userInput.toLowerCase () )) printGames ( game );
    }

    public void filterByNumberOfPlayers() {
        System.out.println ( "Type the number of Players: " );
        int userInput = Util.readUserInputInteger ();
        printHeading ();
        for (Game game : gamesArray)
            if (game.getMinPlayers () <= userInput && game.getMaxPlayers () >= userInput) printGames ( game );
    }

    public void searchGameByName() {
        System.out.println ( "SEARCH : " );
        String userInput = Util.readUserInput ();
        printHeading ();
        for (Game game : gamesArray)
            if (game.getGameName ().toLowerCase ().contains ( userInput.toLowerCase () )) printGames ( game );
    }

    // JJDZTR-8 - draft / propozycje metod
    public void showFavourites() {
    } // podejrzeć listę ulubionych gier

    public void removeFromFavourites() {
    } // usunąć grę z listy ulubionych gier

    // JJDZTR-10
    public void addToFavourites() {
    } // dodać grę do ulubionych - lista przechowywana w oddzielnym pliku


}


