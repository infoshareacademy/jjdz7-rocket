package teamrocket.domain;

import javax.persistence.*;

@Entity
@Table(name = "games")
public class Games {

    @Id
    @GeneratedValue
    private int gameId;

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
}


