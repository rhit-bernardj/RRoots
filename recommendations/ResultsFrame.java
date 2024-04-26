package recommendations;


import javax.swing.*;

import java.awt.*;

public class ResultsFrame extends JFrame {
    private Results results;

    public ResultsFrame(Results results) {
        this.results = results;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Rhythm Roots Results");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        getContentPane().setBackground(new Color(255, 225, 168)); // Sets background color

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(255, 225, 168)); // Set the panel background color

        JLabel titleLabel = new JLabel("Time to grow");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(new Color(125, 187, 195)); // Sets text color
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel);

        JLabel subtitleLabel = new JLabel("Based on your roots");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        subtitleLabel.setForeground(Color.WHITE); // Set text color
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(subtitleLabel);

        JLabel recommendedLabel = new JLabel("We recommended");
        recommendedLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        recommendedLabel.setForeground(new Color(125, 187, 195)); // Sets text color
        recommendedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(recommendedLabel);

        for (String artist : results.calculateRecommendedArtists()) {
            JLabel artistLabel = new JLabel(artist);
            artistLabel.setFont(new Font("Arial", Font.PLAIN, 24));
            artistLabel.setForeground(new Color(125, 187, 195)); // Set text color
            artistLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(artistLabel);
        }

        JLabel alongWithLabel = new JLabel("Along with");
        alongWithLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        alongWithLabel.setForeground(Color.WHITE); // Set text color
        alongWithLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(alongWithLabel);


        JLabel artist2Label = new JLabel("(Artist #2)");
        artist2Label.setFont(new Font("Arial", Font.PLAIN, 24));
        artist2Label.setForeground(Color.WHITE); // Sets text color
        artist2Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(artist2Label);

        JLabel artist3Label = new JLabel("(Artist #3)");
        artist3Label.setFont(new Font("Arial", Font.PLAIN, 24));
        artist3Label.setForeground(Color.WHITE); // Sets text color
        artist3Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(artist3Label);

        JLabel explanationLabel = new JLabel("You would also enjoy (genre) because of (explanation)");
        explanationLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        explanationLabel.setForeground(new Color(226, 109, 92)); // Set text color
        explanationLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(explanationLabel);

        JButton downloadButton = new JButton("Download PDF");
        downloadButton.setFont(new Font("Arial", Font.BOLD, 24));
        downloadButton.setBackground(new Color(226, 109, 92)); // Sets the  button background color
        downloadButton.setForeground(Color.WHITE); // Set button text color
        downloadButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        downloadButton.setBorderPainted(false); // Remove border
        downloadButton.setFocusPainted(false);
        panel.add(downloadButton);

        JButton returnButton = new JButton("Return to Home");
        returnButton.setFont(new Font("Arial", Font.BOLD, 24));
        returnButton.setBackground(new Color(226, 109, 92)); // Settings a different button background color
        returnButton.setForeground(Color.WHITE); // Setting button text color
        returnButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        returnButton.setBorderPainted(false); // Removes button border
        returnButton.setFocusPainted(false); // Remove button focus border
        returnButton.addActionListener(e -> {
            // close the frame
            dispose();
        });
        panel.add(returnButton);

        add(panel);
        setVisible(true);
    }
}
