package teamrocket.model;

import teamrocket.util.Util;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static teamrocket.model.Game.gamesArray;

public class UserService {

    private static final Path USERS_PATH = Paths.get ( ".", "src", "main", "resources", "user" );

    public static User createUserObject(String FavoriteGame, String TypeOfGame) {
        return new User ( FavoriteGame, TypeOfGame );
    }

    public static User getUserFromConsole() {
        String FavoriteGame = Util.readInputWithMessage ( "Ulubiona Gra: " );
        String TypeOfGame = Util.readInputWithMessage ( "Typ Gry: " );
        return createUserObject ( FavoriteGame, TypeOfGame );
    }

    public static void addUser(User game) throws IOException {
        String userString = game.toString () + "\n";
        Util.writeToFile ( USERS_PATH, userString.getBytes () );
    }

    public static User[] getUsers() throws IOException {
        List<String> linesFromFile = Util.readFileContent ( USERS_PATH );

        User[] usersArray = new User[linesFromFile.size ()];

        for (int i = 0; i < usersArray.length; i++) {
            usersArray[i] = new User ( linesFromFile.get ( i ) );
        }

        return usersArray;
    }

    public static void addToFavourites() {
        System.out.println ( "Podaj ID gdy ktora chcesz dodac do ulubionych : " );
        int userInput = Util.readUserInputInteger ();
        for (Game game : gamesArray)
            if (game.getGameId () == userInput) {
                // tu logika, ktora wezmie wszystkie parametry tej gry (getterami) i dopisze do repo
                // w jednej linijcie z uzyciem delimitera (srednika). Podobnie jak na zajeciach z Lukaszem.
            }
    }
}