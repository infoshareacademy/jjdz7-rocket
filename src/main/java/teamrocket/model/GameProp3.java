package teamrocket.model;

public class GameProp3 {
    private int minTime;
    private int maxTime;
    private int avgTime;

    public GameProp3(int minTime, int maxTime, int avgTime) {
        this.minTime = minTime;
        this.maxTime = maxTime;
        this.avgTime = avgTime;
    }

    public int getMinTime() {
        return minTime;
    }

    public void setMinTime(int minTime) {
        this.minTime = minTime;
    }

    public int getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(int maxTime) {
        this.maxTime = maxTime;
    }

    public int getAvgTime() {
        return avgTime;
    }

    public void setAvgTime(int avgTime) {
        this.avgTime = avgTime;
    }
}


