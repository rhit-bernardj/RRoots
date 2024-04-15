import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Results {
    private Questionaire questionnaireItem;

    // Constructor to initialize the Results object with a Questionnaire instance
    public Results(Questionaire questionnaireItem) {
        this.questionnaireItem = questionnaireItem;
    }

    // Method to calculate the top artists based on selected answers
    public Map<String, Integer> calculateTopArtists() {
        // Map to store artist names and their corresponding points
        Map<String, Integer> artistPoints = new HashMap<>();

        // Get the list of selected answers from the questionnaire
        List<Answer> selectedAnswers = questionnaireItem.getSelectedAnswers();

        // Iterate through the selected answers and accumulate points for each artist
        for (Answer answer : selectedAnswers) {
            String artist = answer.getArtist(); // Get the artist name from the answer
            int points = answer.getPoints(); // Get the points associated with the answer
            // Update the artistPoints map with the accumulated points for each artist
            artistPoints.put(artist, artistPoints.getOrDefault(artist, 0) + points);
        }

        return artistPoints; // Return the map containing artist points
    }

    // Method to display the top artists along with their points
    public void displayTopArtists() {
        Map<String, Integer> topArtists = calculateTopArtists(); // Calculate the top artists

        // Display the top artists based on points in descending order
        System.out.println("Top Artists:");
        topArtists.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " points"));
    }

    // Main method for testing the Results class
    public static void main(String[] args) {
        // Create a questionnaire (or question) and add selected answers (placeholder)
        Questionaire questionnaireItem = new Questionaire(); // Instantiate a questionnaire
        // Add selected answers to the questionnaire (placeholder)

        // Create a Results instance with the questionnaire
        Results results = new Results(questionnaireItem);

        // Display the top artists based on the selected answers
        results.displayTopArtists();
    }
}
