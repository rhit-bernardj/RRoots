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

    // this should help make it look nice when called in the results
    @Override
    public String toString() {
        return name + " (" + points + " points)";
    }
}
