package main;
public class Artist {
    private String name;
    private int points;

    public Artist(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    // You can optionally override toString() for better display of Artist object
    @Override
    public String toString() {
        return name + " (" + points + " points)";
    }
}
