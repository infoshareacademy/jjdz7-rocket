package teamrocket.model;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FavouriteGames {
    private static final Path FavouritesRepo_PATH = Paths.get("./src/main/java/teamrocket/repositories/FavouritesGame");


    public static Game createGameObject(String FavouriteGames) {
        return new Game (FavouriteGames);
    }

    public static Game getUserFromConsole() {
        String FavouriteGames = Game.readInputWithMessage("FavouriteGames: ");

        return createGameObject(FavouriteGames);
    }

    public static void addGame(Game game) throws IOException {
        String userString = game.toString() + "\n";
        Game.File(FavouritesRepo_PATH, userString.getBytes());
    }

    public Game[] getGame() throws IOException {
        List<String> linesFromFile = Game.readFileContent(FavouritesRepo_PATH);

        Game[] FavouriteGames = new Game[linesFromFile.size()];

        for(int i = 0 ; i < FavouriteGames.length ; i++){
            FavouriteGames[i] = new Game (linesFromFile.get(i));
        }

        return FavouriteGames;
    }
    private static final String DELIMITER = " ! ";

    private String favouriteGames;

    public FavouriteGames(String formattedUser) {
        if (formattedUser.contains ( DELIMITER )) {
            String[] slitted = formattedUser.split ( DELIMITER );
            this.favouriteGames = slitted[0];
        }
    }

    public String toString() {
        return favouriteGames + DELIMITER ;
    }
}
