import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Results {
    private Questionaire questionnaire;

    public Results(Questionaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    // Method to calculate the top artists based on selected answers
    public Map<String, Integer> calculateTopArtists() {
        Map<String, Integer> artistPoints = new HashMap<>();
        List<Answer> selectedAnswers = questionnaire.getSelectedAnswers();

        // Sample artists data
        Artists artists = new Artists();

        // Calculate points for each artist based on selected answers
        for (Answer answer : selectedAnswers) {
            String artist = answer.getArtist();
            int points = answer.getPoints();
            if (artist != null && !artist.isEmpty()) {
                artistPoints.put(artist, artistPoints.getOrDefault(artist, 0) + points);
            }
        }

        return artistPoints;
    }

    // Method to generate HTML code for displaying top artists
    public String generateTopArtistsHTML() {
        Map<String, Integer> topArtists = calculateTopArtists();
        StringBuilder html = new StringBuilder();

        // Add HTML for each top artist
        for (Map.Entry<String, Integer> entry : topArtists.entrySet()) {
            String artist = entry.getKey();
            int points = entry.getValue();
            html.append("<div>").append(artist).append(": ").append(points).append(" points</div>");
        }

        return html.toString();
    }
}
