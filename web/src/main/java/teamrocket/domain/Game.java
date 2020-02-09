package teamrocket.domain;

import javax.persistence.*;
import java.util.StringJoiner;

@NamedQueries(
        @NamedQuery(
                name = "Game.findAll",
                query = "SELECT g FROM Game g")
)


@Entity
@Table(name = "games")
public class Game {

    private static final String DELIMITER = ",";

    @Id
    @GeneratedValue
    private int gameId;

    @Column(name = "extra_look", columnDefinition = "TINYINT(1)")
    private boolean extraLook;

    @Column(name = "game_name")
    private String gameName;

    @Column(name = "game_designer")
    private String gameDesigner;

    @Column(name = "game_publisher")
    private String gamePublisher;

    @Column(name = "game_artist")
    private String gameArtist;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "year_published")
    private int yearPublished;

    @Column(name = "min_players")
    private int minPlayers;

    @Column(name = "max_players")
    private int maxPlayers;

    @Column(name = "min_play_time")
    private int minPlayTime;

    @Column(name = "max_play_time")
    private int maxPlayTime;

    @Column(name = "min_Age")
    private int minAge;

    @Column(name = "bgg_rank")
    private double bggRank;

    @Column(name = "average_weight")
    private double averageWeight;

    @Column(name = "category")
    private String category;

    @Column(name = "mechanic")
    private String mechanic;

    public Game() {
    }

    public Game(String bufferedString) {
        if (bufferedString.contains(DELIMITER)) {
            String[] splitGameParameters = bufferedString.split(DELIMITER);

            this.gameName = splitGameParameters[1];

            this.gameDesigner = splitGameParameters[2];

            this.gamePublisher = splitGameParameters[3];

            this.lastName = splitGameParameters[4];

            this.yearPublished = Integer.parseInt(splitGameParameters[5]);

            this.minPlayers = Integer.parseInt(splitGameParameters[6]);

            this.maxPlayers = Integer.parseInt(splitGameParameters[7]);

            this.minPlayTime = Integer.parseInt(splitGameParameters[8]);

            this.maxPlayTime = Integer.parseInt(splitGameParameters[9]);

            this.minAge = Integer.parseInt(splitGameParameters[10]);

            this.bggRank = Double.parseDouble(splitGameParameters[11]);

            this.averageWeight = Double.parseDouble(splitGameParameters[12]);

            this.category = splitGameParameters[13];

            this.mechanic = splitGameParameters[14];

        }
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public boolean isExtraLook() {
        return extraLook;
    }

    public void setExtraLook(boolean extraLook) {
        this.extraLook = extraLook;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameDesigner() {
        return gameDesigner;
    }

    public void setGameDesigner(String gameDesigner) {
        this.gameDesigner = gameDesigner;
    }

    public String getGamePublisher() {
        return gamePublisher;
    }

    public void setGamePublisher(String gamePublisher) {
        this.gamePublisher = gamePublisher;
    }

    public String getGameArtist() {
        return gameArtist;
    }

    public void setGameArtist(String gameArtist) {
        this.gameArtist = gameArtist;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getMinPlayTime() {
        return minPlayTime;
    }

    public void setMinPlayTime(int minPlayTime) {
        this.minPlayTime = minPlayTime;
    }

    public int getMaxPlayTime() {
        return maxPlayTime;
    }

    public void setMaxPlayTime(int maxPlayTime) {
        this.maxPlayTime = maxPlayTime;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public double getBggRank() {
        return bggRank;
    }

    public void setBggRank(int bggRank) {
        this.bggRank = bggRank;
    }

    public double getAverageWeight() {
        return averageWeight;
    }

    public void setAverageWeight(double averageWeight) {
        this.averageWeight = averageWeight;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMechanic() {
        return mechanic;
    }

    public void setMechanic(String mechanic) {
        this.mechanic = mechanic;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Game.class.getSimpleName() + "[", "]")
                .add("gameId=" + gameId)
                .add("extraLook=" + extraLook)
                .add("gameName='" + gameName + "'")
                .add("gameDesigner='" + gameDesigner + "'")
                .add("gamePublisher='" + gamePublisher + "'")
                .add("gameArtist='" + gameArtist + "'")
                .add("lastName='" + lastName + "'")
                .add("yearPublished=" + yearPublished)
                .add("minPlayers=" + minPlayers)
                .add("maxPlayers=" + maxPlayers)
                .add("minPlayTime=" + minPlayTime)
                .add("maxPlayTime=" + maxPlayTime)
                .add("minAge=" + minAge)
                .add("bggRank=" + bggRank)
                .add("averageWeight=" + averageWeight)
                .add("category='" + category + "'")
                .add("mechanic='" + mechanic + "'")
                .toString();
    }
}


