package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ResultsFrame extends JFrame {
    private Results results; 

    public ResultsFrame(Results results) {
        this.results = results; 
        setTitle("Top Artists Recommendations");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(255, 225, 168)); 
        displayTopArtists(); 
        //display the artist results
    }

    private void displayTopArtists() {
        
        List<Artist> topArtists = results.getTopThreeArtists();
        if (topArtists != null) {
            setLayout(new GridLayout(topArtists.size() + 1, 1));

            //set color and text for title
            JLabel titleLabel = new JLabel("Top 3 Recommended Artists:");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
            titleLabel.setForeground(new Color(125, 187, 195));
            titleLabel.setHorizontalAlignment((int) Component.CENTER_ALIGNMENT);
            add(titleLabel);

            //set color and text for resulting artists
            for (Artist artist : topArtists) {
                JLabel artistLabel = new JLabel(artist.getName() + " (" + artist.getPoints() + " points)");
                artistLabel.setForeground(new Color(125, 187, 195));
                artistLabel.setHorizontalAlignment((int) Component.CENTER_ALIGNMENT);
                add(artistLabel);
            }

            // construct and show download results button
            JButton downloadButton = new JButton("Download Results");
            downloadButton.setBackground(new Color(72, 133, 237));
            downloadButton.setForeground(Color.WHITE);       
            downloadButton.setHorizontalAlignment((int) Component.CENTER_ALIGNMENT);
            add(downloadButton);
            downloadButton.setPreferredSize(new Dimension(100, 35));
        }
            
    }

    public static void main(String[] args) {
        List<SelectedAnswer> selectedAnswers = new ArrayList<>();
        // Create a Results object from selected answers
        Results results = new Results(selectedAnswers);
        // Create a ResultsFrame with the Results object
        ResultsFrame resultsFrame = new ResultsFrame(results);
        resultsFrame.pack();
        resultsFrame.setVisible(true);
    }
    
}
