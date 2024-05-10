package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeFrame extends JFrame {

    private JTextArea recommendationsTextArea;
	private String region;

    public HomeFrame(String region, String recommendations) {
        setTitle("Rhythm Roots");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        this.region = region;

        initializeUI();
        updateRecommendations(recommendations); // Update recommendations text

        // Apply color theme based on selected region
        ColorControl.setTheme(region, getContentPane()); // Apply color theme to the entire content pane
        ColorControl.setTheme(region, recommendationsTextArea); // Apply color theme to the recommendations text area
    }

    private void initializeUI() {
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout());
        add(rootPanel);

        JPanel topPanel = new JPanel(new BorderLayout());
        rootPanel.add(topPanel, BorderLayout.NORTH);

        // Red "X" button for closing the frame
        JButton closeButton = new JButton("X") {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                
                
            }
        };
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setFocusPainted(false);
        closeButton.setOpaque(false);
        closeButton.addActionListener(e -> dispose());
        topPanel.add(closeButton, BorderLayout.EAST);

        // Tree image (assuming you have a valid path to "Tree.png")
        ImageIcon treeIcon = new ImageIcon(getClass().getResource("/Tree.png"));
        JLabel treeLabel = new JLabel(treeIcon);
        rootPanel.add(treeLabel, BorderLayout.CENTER);

        JPanel recommendationsPanel = new JPanel();
        recommendationsPanel.setBackground(Color.WHITE);
        recommendationsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        recommendationsPanel.setLayout(new BoxLayout(recommendationsPanel, BoxLayout.Y_AXIS));
        topPanel.add(recommendationsPanel, BorderLayout.CENTER);

        JLabel recommendationsLabel = new JLabel("Recent Recommendations");
        recommendationsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        recommendationsLabel.setFont(new Font("Arial", Font.BOLD, 18));
        recommendationsPanel.add(recommendationsLabel);

        recommendationsTextArea = new JTextArea(5, 20);
        recommendationsTextArea.setEditable(false);
        recommendationsTextArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        recommendationsTextArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        recommendationsTextArea.setLineWrap(true);
        recommendationsTextArea.setWrapStyleWord(true);
        recommendationsPanel.add(recommendationsTextArea);

        JButton actionButton = new JButton("Find New Roots");
        actionButton.setFont(new Font("Roboto", Font.BOLD, 20));
        actionButton.addActionListener(e -> openQuestionnaire(getRegion())); // Pass region to openQuestionnaire
        rootPanel.add(actionButton, BorderLayout.SOUTH);
    }
    
    public String getRegion() {
        return region;
    }

    public void updateRecommendations(String recommendations) {
        recommendationsTextArea.setText(recommendations); // Update recommendations text
    }

    private void openQuestionnaire(String region) {
        // Open questionnaire frame (pass region to QuestionnaireFrame constructor)
        dispose(); // Close the current frame (HomeFrame)
        Questionaireframe questionnaireFrame = new Questionaireframe(region); // Instantiate QuestionnaireFrame with region
        questionnaireFrame.setVisible(true); // Make the QuestionnaireFrame visible
    }
}
