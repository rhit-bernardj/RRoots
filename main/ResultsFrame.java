package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ResultsFrame extends JFrame {

    private Results results;
    private String region;

    public ResultsFrame(Results results, String region) {
        this.results = results;
        this.region = region;

        setTitle("Top Artists Recommendations");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeUI();
        displayTopArtists();
        addHomeAndDownloadButtons();

        // Set frame properties before making it visible
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
    }

    private void initializeUI() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE); // Set background color

        JLabel titleLabel = new JLabel("Top 3 Recommended Artists:");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(125, 187, 195));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane();
        JPanel artistsPanel = new JPanel();
        artistsPanel.setLayout(new BoxLayout(artistsPanel, BoxLayout.Y_AXIS));
        artistsPanel.setBackground(Color.WHITE); // Set background color for artists panel
        scrollPane.setViewportView(artistsPanel);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        getContentPane().add(mainPanel);
    }

    private void displayTopArtists() {
        List<Artist> topArtists = results.getTopThreeArtists();
        if (topArtists != null) {
            JPanel artistsPanel = new JPanel(new GridLayout(0, 1)); // Create a panel to hold artist labels
            for (Artist artist : topArtists) {
                JLabel artistLabel = new JLabel(artist.getName() + " (" + artist.getPoints() + " points)");
                artistLabel.setForeground(new Color(125, 187, 195));
                artistLabel.setHorizontalAlignment(SwingConstants.CENTER);
                artistsPanel.add(artistLabel); // Add artist label to the panel
            }

            // Create a scroll pane to contain the artistsPanel
            JScrollPane scrollPane = new JScrollPane(artistsPanel);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            // Add the scroll pane to the ResultsFrame
            getContentPane().add(scrollPane, BorderLayout.CENTER);
            revalidate(); // Refresh the layout
            repaint();    // Repaint the frame
        }
    }


    private void addHomeAndDownloadButtons() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.WHITE); // Set background color for button panel

        JButton homeButton = new JButton("Home");
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToHomeFrameWithMatchingTheme();
            }
        });

        JButton downloadButton = new JButton("Download Results");
        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSaveFileDialog();
            }
        });

        buttonPanel.add(homeButton);
        buttonPanel.add(downloadButton);

        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    private void showSaveFileDialog() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Results");
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            saveResultsToFile(selectedFile);
        }
    }

    private void saveResultsToFile(File file) {
        try (FileWriter writer = new FileWriter(file)) {
            List<Artist> topArtists = results.getTopThreeArtists();
            if (topArtists != null) {
                for (Artist artist : topArtists) {
                    writer.write(artist.getName() + " (" + artist.getPoints() + " points)\n");
                }
                JOptionPane.showMessageDialog(this, "Results downloaded successfully!", "Download", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Failed to download results.", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    
    private String generateRecommendations() {
        StringBuilder recommendations = new StringBuilder();

        List<Artist> topArtists = results.getTopThreeArtists();
        if (topArtists != null && !topArtists.isEmpty()) {
            recommendations.append("Here are your top 3 recommended artists:\n");
            for (Artist artist : topArtists) {
                recommendations.append("- ").append(artist.getName()).append(" (").append(artist.getPoints()).append(" points)").append("\n");
            }
        } 
        
        return recommendations.toString();
    }
          

    private void goToHomeFrameWithMatchingTheme() {
        String recommendations = generateRecommendations();
        HomeFrame newHomeFrame = new HomeFrame(region, recommendations);
        newHomeFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        newHomeFrame.setUndecorated(true);
        newHomeFrame.setVisible(true);
        dispose();
        
        for (Frame frame : Frame.getFrames()) {
            if (frame instanceof Questionaireframe) {
                frame.dispose();
                break;
            }// Close the current ResultsFrame
        }
    }
}
