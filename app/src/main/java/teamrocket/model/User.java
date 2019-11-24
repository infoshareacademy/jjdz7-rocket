package teamrocket.model;

public class User {
    private static final String DELIMITER = " ! ";

    private String favoriteGame;
    private String typeofgame;


    public User(String FavoriteGame, String Typeofgame) {
        this.favoriteGame = FavoriteGame;
        this.typeofgame = Typeofgame;
        
    }

    public User(String formattedUser) {
        if (formattedUser.contains ( DELIMITER )) {
            String[] splitted = formattedUser.split ( DELIMITER );
            this.favoriteGame = splitted[0];
            this.typeofgame = splitted[1];
        }
    }

    public String getFavoriteGame() {
        return favoriteGame;
    }

    public String getTypeofgame() {
        return typeofgame;
    }

    public String toString() {
        return favoriteGame + DELIMITER + typeofgame + DELIMITER ;
    }
}