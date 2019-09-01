package teamrocket.model;

public class User {
    private static final String DELIMITER = " ! ";

    private String username;
    private String password;
    private String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(String formattedUser) {
        if (formattedUser.contains ( DELIMITER )) {
            String[] splitted = formattedUser.split ( DELIMITER );
            this.username = splitted[0];
            this.password = splitted[1];
            this.role = splitted[2];
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String toString() {
        return username + DELIMITER + password + DELIMITER + role;
    }
}