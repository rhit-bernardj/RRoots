package main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Results {
    private List<SelectedAnswers> selectedAnswers;

    public Results(List<SelectedAnswers> selectedAnswers) {
        this.selectedAnswers = selectedAnswers;
    }

    // Should calculate the points based on the selected answers
    public Map<String, Integer> calculatePoints() {
        Map<String, Integer> points = new HashMap<>();

        for (SelectedAnswers selectedAnswer : selectedAnswers) {
            String question = selectedAnswer.getQuestion();
            String option = selectedAnswer.getOption();

            switch (question) {
                case "When you need a musical boost, what's your vibe?":
                    calculatePointsForVibe(option, points);
                    break;
                // should put other questions here too
            }
        }

        return points;
    }

    // this should assign and calculate the answers
    private void calculatePointsForVibe(String option, Map<String, Integer> points) {
        switch (option) {
            case "Amp me up with intense beats":
                addPoints(points, "Travis Scott", 2);
                addPoints(points, "Kendrick Lamar", 1);
                addPoints(points, "Fred again..", 2);
                addPoints(points, "Calvin Harris", 2);
                break;
            case "Let's get moving with uplifting rhythms":
                addPoints(points, "Taylor Swift", 2);
                addPoints(points, "Dua Lipa", 2);
                addPoints(points, "Jon Pardi", 2);
                break;
            case "I crave soul-touching melodies":
                addPoints(points, "Beyoncé", 2);
                addPoints(points, "Frank Ocean", 2);
                addPoints(points, "Gary Clark Jr.", 2);
                addPoints(points, "Keb' Mo'", 2);
                addPoints(points, "Kamasi Washington", 1);
                addPoints(points, "Michael Bublé", 1);
                break;
            case "Take me on a journey with deep lyrics":
                addPoints(points, "Tame Impala", 2);
                addPoints(points, "The 1975", 2);
                addPoints(points, "Foo Fighters", 1);
                addPoints(points, "Green Day", 1);
                break;
            case "Feel inspired by soul-lifting gospel and blues":
                addPoints(points, "Kirk Franklin", 2);
                addPoints(points, "Sunday Service Choir", 1);
                break;
        }
    }

    // points assigner
    private void addPoints(Map<String, Integer> points, String artist, int pointsToAdd) {
        points.put(artist, points.getOrDefault(artist, 0) + pointsToAdd);
    }

    // recommend based off points
    public List<String> calculateRecommendedArtists() {
        Map<String, Integer> points = calculatePoints();
        List<String> recommendedArtists = new ArrayList<>();
        int maxPoints = 0;

        // this should find the artists with the highest points
        for (Map.Entry<String, Integer> entry : points.entrySet()) {
            if (entry.getValue() > maxPoints) {
                recommendedArtists.clear(); // Clear previous recommendations
                recommendedArtists.add(entry.getKey());
                maxPoints = entry.getValue();
            } else if (entry.getValue() == maxPoints) {
                recommendedArtists.add(entry.getKey());
            }
        }
        return recommendedArtists;
    }

	public Object getExplanation() {
		// TODO Auto-generated method stub
		return null;
	}
}
