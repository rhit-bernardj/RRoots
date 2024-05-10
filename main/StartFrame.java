package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame extends JFrame {

    public StartFrame() {
        setTitle("Rhythm Roots");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null); // centers on frame

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(255, 225, 168)); // background color

        // Logo
        JLabel logoLabel = new JLabel("Rhythm Roots");
        logoLabel.setFont(new Font("Jockey One", Font.PLAIN, 32));
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(50)); // vertical spacing
        panel.add(logoLabel);

        // Region dropdown
        String[] regions = {"Congo", "Nigeria"};
        JComboBox<String> regionComboBox = new JComboBox<>(regions);
        regionComboBox.setFont(new Font("Inter", Font.PLAIN, 18));
        regionComboBox.setMaximumSize(new Dimension(200, 40));
        regionComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(regionComboBox);
        panel.add(Box.createVerticalStrut(20)); //Vertical spacing

        // we need to add the image path here
        ImageIcon ourlogo = new ImageIcon("path_to_your_hero_image.png");
        JLabel heroImageLabel = new JLabel(ourlogo);
        heroImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(heroImageLabel);

        // welcome screen message
        JLabel welcomeLabel = new JLabel("Hello Welcome!");
        welcomeLabel.setFont(new Font("Jockey One", Font.PLAIN, 45));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(40)); // Vertical spacing
        panel.add(welcomeLabel);

        JLabel welcomeTextLabel = new JLabel("<html>Welcome to Rhythm Roots.<br/>Let's get to the roots of your music taste!</html>");
        welcomeTextLabel.setFont(new Font("Inter", Font.PLAIN, 20));
        welcomeTextLabel.setForeground(new Color(71, 45, 48));
        welcomeTextLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcomeTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(welcomeTextLabel);

        // Start button
        JButton startButton = new JButton("Start");
        startButton.setFont(new Font("Inter", Font.BOLD, 24));
        startButton.setBackground(new Color(114, 61, 70));
        startButton.setForeground(new Color(226, 109, 92));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setPreferredSize(new Dimension(200, 60));
        startButton.addActionListener(new ActionListener() {
        	
        	
        	
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedRegion = (String) regionComboBox.getSelectedItem();
                handleStartClick(selectedRegion);
            }
        });
        panel.add(Box.createVerticalStrut(80)); // Vertical spacing
        panel.add(startButton);

        add(panel);
    }

    private void handleStartClick(String selectedRegion) {
        // Create and show the home frame before modifying this frame
        SwingUtilities.invokeLater(() -> {
            HomeFrame homeFrame = new HomeFrame(selectedRegion, selectedRegion);
            homeFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            homeFrame.setVisible(true);
        });

        // Hide the current frame
        setVisible(false);
        
        // Dispose the current frame
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StartFrame startFrame = new StartFrame();
            startFrame.setVisible(true);
        });
    }
}
