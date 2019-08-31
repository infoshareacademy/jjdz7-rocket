package teamrocket.model;

public class Game {
    /**
     * Class that represents a Board Game - tabletop game that involves counters or pieces moved or placed on a
     * pre-marked surface or "board", according to a set of rules.
     */

    // Fields - more than needed
    private String gameName;
    private String gameType;
    private String gameCreator;
    private String gameDistributor;
    private int minPlayers;
    private int maxPlayers;
    private int minTime;
    private int maxTime;
    private int avgTime;
    private int minAge;
    boolean isAdvanced;

     // Class constructors

    public Game() {
    }

    public Game(String gameName, String gameType) {
        this.gameName = gameName;
        this.gameType = gameType;
    }

    // Getters and Setters for all fields

    public String getGameName() { return gameName; }

    public void setGameName(String gameName) { this.gameName = gameName; }

    public String getGameType() { return gameType; }

    public void setGameType(String gameType) { this.gameType = gameType; }

    public String getGameCreator() { return gameCreator; }

    public void setGameCreator(String gameCreator) { this.gameCreator = gameCreator; }

    public String getGameDistributor() { return gameDistributor; }

    public void setGameDistributor(String gameDistributor) { this.gameDistributor = gameDistributor; }

    public int getMinPlayers() { return minPlayers; }

    public void setMinPlayers(int minPlayers) { this.minPlayers = minPlayers; }

    public int getMaxPlayers() { return maxPlayers; }

    public void setMaxPlayers(int maxPlayers) { this.maxPlayers = maxPlayers; }

    public int getAvgTime() { return avgTime; }

    public void setAvgTime(int avgTime) { this.avgTime = avgTime; }

    public int getMinAge() { return minAge; }

    public void setMinAge(int minAge) { this.minAge = minAge; }

    public int getMinTime() { return minTime; }

    public void setMinTime(int minTime) { this.minTime = minTime; }

    public int getMaxTime() { return maxTime; }

    public void setMaxTime(int maxTime) { this.maxTime = maxTime; }

    public boolean isAdvanced() { return isAdvanced; }

    public void setAdvanced(boolean advanced) { isAdvanced = advanced; }

    // JJDZTR-2 zakładam, że w klasie typu "UTIL" będą metody do załadowywania plików z danymi na temat gier
    // JJDZTR-3 j/w
    // JJDZTR-4 n/d
    // JJDZTR-5 n/d
    // JJDZTR-6 n/d
    // JJDZTR-7 - draft / propozycje metod

    public void gameList(){} // zobaczyć listę gier znajdujących się w systemie
    public <T> void gameFilter(T filter){} // filtrowanie wg. typu gry oraz ilości graczy
    public void findGame(String keyword){} // wyszukiwanie gier po nazwie

    // JJDZTR-8 - draft / propozycje metod
    public void showFavourites(){} // podejrzeć listę ulubionych gier
    public void removeFromFavourites(){} // usunąć grę z listy ulubionych gier

    // JJDZTR-9 n/d
    // JJDZTR-10
    public void addToFavourites(){} // dodać grę do ulubionych - lista przechowywana w oddzielnym pliku
}
