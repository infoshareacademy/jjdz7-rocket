package teamrocket.model;

import teamrocket.util.Util;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Game {
    /**
     * Class that represents a Board Game - tabletop game that involves counters or pieces moved or placed on a
     * pre-marked surface or "board", according to a set of rules.
     */
    private static final Path GAMEREPO_PATH = Paths.get(".", "src", "main", "resources", "gamesRepository.csv");
    private static final String DELIMITER = ";";
    private static List<Game> gamesArray = new ArrayList<>();
    private int gameId;
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

    public Game() {
    }

    public Game(String formattedGame) {
        if (formattedGame.contains(DELIMITER)) {
            String[] splitGameParameters = formattedGame.split(DELIMITER);
            this.gameId = parseInt(splitGameParameters[0]);
            this.gameName = splitGameParameters[1];
            this.gameDesigner = splitGameParameters[2];
            this.gamePublisher = splitGameParameters[3];
            this.gameArtist = splitGameParameters[4];
            this.yearPublished = parseInt(splitGameParameters[5]);
            this.minPlayers = parseInt(splitGameParameters[6]);
            this.maxPlayers = parseInt(splitGameParameters[7]);
            this.minPlayTime = parseInt(splitGameParameters[8]);
            this.maxPlayTime = parseInt(splitGameParameters[9]);
            this.minAge = parseInt(splitGameParameters[10]);
            this.bggRank = parseInt(splitGameParameters[11]);
            this.averageWeight = parseDouble(splitGameParameters[12]);
            this.category = splitGameParameters[13];
            this.mechanic = splitGameParameters[14];
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return gameId == game.gameId &&
                yearPublished == game.yearPublished &&
                minPlayers == game.minPlayers &&
                maxPlayers == game.maxPlayers &&
                minPlayTime == game.minPlayTime &&
                maxPlayTime == game.maxPlayTime &&
                minAge == game.minAge &&
                bggRank == game.bggRank &&
                Double.compare(game.averageWeight, averageWeight) == 0 &&
                gameName.equals(game.gameName) &&
                gameDesigner.equals(game.gameDesigner) &&
                gamePublisher.equals(game.gamePublisher) &&
                gameArtist.equals(game.gameArtist) &&
                category.equals(game.category) &&
                mechanic.equals(game.mechanic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, gameName, gameDesigner, gamePublisher, gameArtist, yearPublished, minPlayers, maxPlayers, minPlayTime, maxPlayTime, minAge, bggRank, averageWeight, category, mechanic);
    }

    public static List<Game> createGamesArrayFromRepository() {
        List<String> gameList = null;
        try {
            gameList = Util.readFileContent(GAMEREPO_PATH);
        } catch (IOException e) {
            System.out.println("Zła ścieżka do pliku lub plik nie istnieje.");
        }
        for (int i = 0; i < gameList.size(); i++) {
            gamesArray.add(new Game(gameList.get(i)));
        }
        return gamesArray;
    }

    public static void showAllGames() {
        printHeading();
        for (Game game : gamesArray) {
            printGames(game);
        }
    }

    public static void filterByGameType() {
        System.out.println("Poniżej masz wszystkie typy gier:");
        showAllTypes();
        System.out.println("Wpisz typ gry, po którym chciałbyś filtrować bazę gier: ");
        String userInput = Util.readUserInput();
        List<Game> result = new ArrayList<>();
        for (Game game : gamesArray) {
            if (game.category.toLowerCase().contains(userInput.toLowerCase())) {
                result.add(game);
            }
        }
        if (result.isEmpty()) {
            System.out.println("Nie znaleziono gier o wyszukiwanym typie !");
        } else {
            printHeading();
            for (Game element : result) {
                printGames(element);
            }
        }
    }

    public static void filterByNumberOfPlayers() {
        System.out.println("Wpisz minimalną liczbę graczy, po której chciałbyś filtrować bazę gier: ");
        int userInput1 = Util.readUserInputInteger();
        while (userInput1 < 1) {
            System.out.println("Minimalna liczba graczy nie może być mniejsza od 1 ! Podaj minimalną liczbę graczy: ");
            userInput1 = Util.readUserInputInteger();
        }
        System.out.println("Wpisz maksymalną liczbę graczy, po której chciałbyś filtrować bazę gier: ");
        int userInput2 = Util.readUserInputInteger();
        while (userInput2 < userInput1) {
            System.out.println("Błąd. Maksymalna liczba graczy musi być większa lub równa minimalnej liczbie graczy");
            userInput2 = Util.readUserInputInteger();
        }
        System.out.println("Wynikiem są wszystkie gry, których liczba graczy zawiera się w podanym przez Ciebie przedziale.");
        List<Game> result = new ArrayList<>();
        for (Game game : gamesArray) {
            if (game.minPlayers >= userInput1 && game.maxPlayers <= userInput2) {
                result.add(game);
            }

            if (result.isEmpty()) {
                System.out.println("Nie znaleziono gier o podanym przedziale graczy !");
            } else {
                printHeading();
                for (Game element : result) {
                    printGames(element);
                }
            }
        }
    }

    public static void searchGameByName() {
        System.out.println("Szukaj po nazwie gry : ");
        String userInput = Util.readUserInput();
        List<Game> result = new ArrayList<>();
        for (Game game : gamesArray) {
            if (game.gameName.toLowerCase().contains(userInput.toLowerCase())) {
                result.add(game);
            }
        }

        if (result.isEmpty()) {
            System.out.println("Nie znaleziono gier o wyszukiwanej nazwie !");
        } else {
            printHeading();
            for (Game element : result) {
                printGames(element);
            }
        }
    }

    private static void showAllTypes() {
        for (String type : createGameTypesSet()) {
            System.out.println(type);
        }
    }

    }
}

