import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Results {
    private Questionaire questionnaireItem;

    // results created from questionaire
    public Results(Questionaire questionnaireItem) {
        this.questionnaireItem = questionnaireItem;
    }

    // this should calculate the top artists based on selected answer
    public Map<String, Integer> calculateTopArtists() {
        // A map to store artist names/their points
        Map<String, Integer> artistPoints = new HashMap<>();

        // pull selected answers from the questionnaire
        List<Answer> selectedAnswers = questionnaireItem.getSelectedAnswers();

        // run through all answers to get all the points
        for (Answer answer : selectedAnswers) {
            String artist = answer.getArtist(); // get the artist name from the answer
            int points = answer.getPoints(); // get points assigned to the answer
            //update all the points for artists
            artistPoints.put(artist, artistPoints.getOrDefault(artist, 0) + points);
        }

        return artistPoints; // return the points
    }

    // this should display the points and the artist
    public void displayTopArtists() {
        Map<String, Integer> topArtists = calculateTopArtists(); // calculate the top artists

        // display the top artists from most to least points
        System.out.println("Top Artists:");
        topArtists.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " points"));
    }
}
