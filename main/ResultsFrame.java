package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ResultsFrame extends JFrame {
    private Results results; // Store the Results object

    public ResultsFrame(Results results) {
        this.results = results; // Initialize the Results object
        setTitle("Top Artists Recommendations");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        displayTopArtists(); // Display the top artists
    }

    private void displayTopArtists() {
        List<Artist> topArtists = results.getTopThreeArtists();
        if (topArtists != null) {
            setLayout(new GridLayout(topArtists.size() + 1, 1));

            JLabel titleLabel = new JLabel("Top 3 Recommended Artists:");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
            add(titleLabel);

            for (Artist artist : topArtists) {
                JLabel artistLabel = new JLabel(artist.getName() + " (" + artist.getPoints() + " points)");
                add(artistLabel);
            }
        }
    }

    public static void main(String[] args) {
        // This part should be handled in the QuestionnaireFrame class
        List<SelectedAnswer> selectedAnswers = new ArrayList<>();
        // Populate selectedAnswers with questionnaire responses

        SwingUtilities.invokeLater(() -> {
            // Create a Results object from selected answers
            Results results = new Results(selectedAnswers);

            // Create a ResultsFrame with the Results object
            ResultsFrame resultsFrame = new ResultsFrame(results);
            resultsFrame.pack();
            resultsFrame.setLocationRelativeTo(null); // Center the frame on the screen
            resultsFrame.setVisible(true);
        });
    }
}
