package teamrocket.domain;

import javax.persistence.*;

@NamedQueries(
        @NamedQuery(
                name = "Game.findAll",
                query = "SELECT g FROM Game g")
)


@Entity
@Table(name = "games")
public class Game {

    @Id
    private int gameId;

    @Column(name = "extra_look")
    private boolean extraLook;

    @Column(name = "game_name")
    private String gameName;

    @Column(name = "game_designer")
    private String gameDesinger;

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
    private int bggRank;

    @Column(name = "average_weight")
    private double averageWeight;

    @Column(name = "category")
    private String category;

    @Column(name = "mechanic")
    private String mechanic;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameDesinger() {
        return gameDesinger;
    }

    public void setGameDesinger(String gameDesinger) {
        this.gameDesinger = gameDesinger;
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

    public int getBggRank() {
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
}


