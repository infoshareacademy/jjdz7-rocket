package Geek;


import Util.Util;
import model.User;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class UserService {

    private static final Path USERS_PATH = Paths.get ( "./src/main/java/com/infoshare/jse/objects/exercise/zad3/users" );

    public User createUserObject(String username, String password, String role) {
        return new User ( username, password, role );
    }

    public User getUserFromConsole() {
        String username = Util.readInputWithMessage ( "Username: " );
        String password = Util.readInputWithMessage ( "Password: " );
        String role = getRole ();
        return createUserObject ( username, password, role );
    }

    private String getRole() {
        String role;
        do {
            role = Util.readInputWithMessage ( "Role: " );
        } while (!role.equals ( "USER" ) && !role.equals ( "ADMIN" ));
        return role;
    }

    public void addUser(User user) throws IOException {
        String userString = user.toString () + "\n";
        Util.writeToFile ( USERS_PATH, userString.getBytes () );
    }

    public User[] getUsers() throws IOException {
        List<String> linesFromFile = Util.readFileContent ( USERS_PATH );

        User[] usersArray = new User[linesFromFile.size ()];

        for (int i = 0; i < usersArray.length; i++) {
            usersArray[i] = new User ( linesFromFile.get ( i ) );
        }

        return usersArray;
    }
}
