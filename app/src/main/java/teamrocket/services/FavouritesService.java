package teamrocket.services;

import teamrocket.model.Game;
import teamrocket.util.Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static teamrocket.model.Game.showAllGames;

public class FavouritesService {

    private static final Path FAVOURITES_PATH = Paths.get(".", "web", "src", "main", "resources", "favouriteGames.csv");
    private static Set<Game> favouriteGamesSet = new HashSet<>();

    public static void addGameToFavourites() throws IOException {
        System.out.println("Lista gier w bazie : ");
        showAllGames();
        System.out.println("Podaj ID gry, którą chcesz dodać do ulubionych : ");
        int userInput = Util.readUserInputInteger();
        int setSize = favouriteGamesSet.size();
        System.out.println("set size before + " + setSize);
        for (Game game : Game.getGamesArray())
            if (game.getGameId() == userInput) {
                String gameString = game.toString() + "\n";
                Util.writeToFileWtihTruncate(FAVOURITES_PATH, gameString.getBytes());
                favouriteGamesSet.add(game);
                System.out.println("result size after + " + favouriteGamesSet.size());
                printInformationForUser(favouriteGamesSet, setSize);
            }
        printInformationIfNoSuchGame(favouriteGamesSet);
    }

    public static void showFavouriteGames() throws IOException {
        Util.printHeading();
        Set<Game> favouriteGamesArray = createFavouriteGamesSetFromRepository();
        for (Game game : favouriteGamesArray) {
            Game.printGames(game);
        }
    }

    public static void resetRepo() throws IOException {
        Files.deleteIfExists(FAVOURITES_PATH);
        Files.createFile(FAVOURITES_PATH);
    }

    private static void printInformationIfNoSuchGame(Set<Game> result) {
        if (result.isEmpty()) {
            System.out.println("Gra o podanym ID nie istnieje !");
        }
    }

    private static void printInformationForUser(Set<Game> gameSet, int sizeBefore) {
        if (gameSet.size() == sizeBefore) {
            System.out.println("Wybrana przez Ciebie gra została dodana do ulubionych już wcześniej !");
        } else {
            System.out.println("Wybraną przez Ciebie Grę dodano do ulubionych.");
        }
    }

    private static Set<Game> createFavouriteGamesSetFromRepository() throws IOException {
        List<String> gameList = Util.readFileContent(FAVOURITES_PATH);
        for (int i = 0; i < gameList.size(); i++) {
            favouriteGamesSet.add(new Game(gameList.get(i)));
        }
        return favouriteGamesSet;
    }
}

