package UI;

public class Reward {

    public String name;
    public int pointsWorth;

    public Reward(String name, int worth) {
        this.name = name;
        this.pointsWorth = worth;
    }

    public String getName() {
        return name;
    }
    public int getPoints() { return pointsWorth; }
}
