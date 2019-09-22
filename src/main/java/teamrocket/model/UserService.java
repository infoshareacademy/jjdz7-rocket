package teamrocket.model;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class UserService {

    private static final Path USERS_PATH = Paths.get("./src/main/resources/user");

    public static User createUserObject(String FavoriteGame, String TypeOfGame) {
        return new User (FavoriteGame, TypeOfGame);
    }

    public static User getUserFromConsole() {
        String FavoriteGame = FavoriteG.readInputWithMessage("FavoriteGame: ");
        String TypeOfGame = FavoriteG.readInputWithMessage("TypeOfGame: ");
        return createUserObject( FavoriteGame, TypeOfGame);
    }

    public static void addUser(User game) throws IOException {
        String userString = game.toString() + "\n";
        FavoriteG.writeToFile(USERS_PATH, userString.getBytes());
    }

    public static User[] getUsers() throws IOException {
        List<String> linesFromFile = FavoriteG.readFileContent(USERS_PATH);

        User[] usersArray = new User[linesFromFile.size()];

        for(int i = 0 ; i < usersArray.length ; i++){
            usersArray[i] = new User (linesFromFile.get(i));
        }

        return usersArray;
    }
}