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
    private static Set<Game> favouriteGamesArray = new HashSet<>();

    public static void addGameToFavourites() throws IOException {
        System.out.println("Lista gier w bazie : ");
        showAllGames();
        System.out.println("Podaj ID gry, którą chcesz dodać do ulubionych : ");
        int userInput = Util.readUserInputInteger();
        Set<Game> result = new HashSet<>();
        for (Game game : Game.getGamesArray())
            if (game.getGameId() == userInput) {
                String gameString = game.toString() + "\n";
                Util.writeToFileWtihTruncate(FAVOURITES_PATH, gameString.getBytes());
                result.add(game);
            }
        printInformationIfNoSuchGame(result);
    }

    public static void showFavouriteGames() throws IOException {
        Util.printHeading();
        Set<Game> favouriteGamesArray = createFavouriteGamesArrayFromRepository();
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

    private static Set<Game> createFavouriteGamesArrayFromRepository() throws IOException {
        List<String> gameList = Util.readFileContent(FAVOURITES_PATH);
        for (int i = 0; i < gameList.size(); i++) {
            favouriteGamesArray.add(new Game(gameList.get(i)));
        }
        return favouriteGamesArray;
    }
}

