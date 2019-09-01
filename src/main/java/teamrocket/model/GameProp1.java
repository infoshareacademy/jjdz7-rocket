package teamrocket.model;

public class GameProp1 {
    private String gameCreator;
    private String gameDistributor;

    public GameProp1(String gameCreator, String gameDistributor) {
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
