package teamrocket.model;

import teamrocket.util.Util;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class UserService {

    private static final Path USERS_PATH = Paths.get(".", "src", "main", "resources", "user");

    public static User createUserObject(String FavoriteGame, String TypeOfGame) {
        return new User (FavoriteGame, TypeOfGame);
    }

    public static User getUserFromConsole() {
        String FavoriteGame = Util.readInputWithMessage("FavouriteGame: ");
        String TypeOfGame = Util.readInputWithMessage("TypeOfGame: ");
        return createUserObject( FavoriteGame, TypeOfGame);
    }

    public static void addUser(User game) throws IOException {
        String userString = game.toString() + "\n";
        Util.writeToFile(USERS_PATH, userString.getBytes());
    }

    public static User[] getUsers() throws IOException {
        List<String> linesFromFile = Util.readFileContent(USERS_PATH);

        User[] usersArray = new User[linesFromFile.size()];

        for(int i = 0 ; i < usersArray.length ; i++){
            usersArray[i] = new User (linesFromFile.get(i));
        }

        return usersArray;
    }

    public static void list(User[] users){
        for(User user : users){
            System.out.println(user);
        }
    }
}