package teamrocket.model;

public class GameProperties {
    private String gameCreator;
    private String gameDistributor;

    public GameProperties() {
    }

    public GameProperties(String gameCreator, String gameDistributor) {
        this.gameCreator = gameCreator;
        this.gameDistributor = gameDistributor;
    }

    public String getGameCreator() {
        return gameCreator;
    }

    public void setGameCreator(String gameCreator) {
        this.gameCreator = gameCreator;
    }

    public String getGameDistributor() {
        return gameDistributor;
    }

    public void setGameDistributor(String gameDistributor) {
        this.gameDistributor = gameDistributor;
    }
}
