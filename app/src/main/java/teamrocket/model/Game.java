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
    private static final Path GAMEREPO_PATH = Paths.get(".", "web", "src", "main", "resources", "gamesRepository.csv");
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

    public int getGameId() {
        return gameId;
    }

    public Game() {
    }

    @Override
    public String toString() {
        return gameId + DELIMITER +
                gameName + DELIMITER +
                gameDesigner + DELIMITER +
                gamePublisher + DELIMITER +
                gameArtist + DELIMITER +
                yearPublished + DELIMITER +
                minPlayers + DELIMITER +
                maxPlayers + DELIMITER +
                minPlayTime + DELIMITER +
                maxPlayTime + DELIMITER +
                minAge + DELIMITER +
                bggRank + DELIMITER +
                averageWeight + DELIMITER +
                category + DELIMITER +
                mechanic + DELIMITER;
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

    public static Path getGamerepoPath() {
        return GAMEREPO_PATH;
    }

    public static String getDELIMITER() {
        return DELIMITER;
    }

    public static List<Game> getGamesArray() {
        return gamesArray;
    }

    public String getGameName() {
        return gameName;
    }

    public String getGameDesigner() {
        return gameDesigner;
    }

    public String getGamePublisher() {
        return gamePublisher;
    }

    public String getGameArtist() {
        return gameArtist;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getMinPlayTime() {
        return minPlayTime;
    }

    public int getMaxPlayTime() {
        return maxPlayTime;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getBggRank() {
        return bggRank;
    }

    public double getAverageWeight() {
        return averageWeight;
    }

    public String getCategory() {
        return category;
    }

    public String getMechanic() {
        return mechanic;
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

    public static List<Game> createGamesArrayFromRepository() throws IOException {
        List<String> gameList = Util.readFileContent(GAMEREPO_PATH);

        for (int i = 0; i < gameList.size(); i++) {
            gamesArray.add(new Game(gameList.get(i)));
        }
        return gamesArray;
    }

    public static void showAllGames() {
        Util.printHeading();
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
            Util.printHeading();
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
                Util.printHeading();
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
            Util.printHeading();
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

    public static void printGames(Game game) {
        System.out.print(Util.addSpaces(8, String.valueOf(game.gameId)));
        System.out.print(Util.addSpaces(75, game.gameName));
        System.out.print(Util.addSpaces(16, game.minPlayers + " - " + game.maxPlayers));
        System.out.print(Util.addSpaces(30, game.category));
        System.out.print("\n");
    }

    private static Set<String> createGameTypesSet() {
        Set<String> gameTypes = new HashSet<>();
        for (Game game : gamesArray) {
            if (game.category.contains(",")) {
                String[] splitted = game.category.split(", ");
                for (String str : splitted) {
                    gameTypes.add(str);
                }
            } else {
                gameTypes.add(game.category);
            }
        }
        return gameTypes;
    }
}


