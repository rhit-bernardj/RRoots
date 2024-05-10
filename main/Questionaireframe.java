package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Questionaireframe extends JFrame {

    private Questionaire questionnaire;
    private int currentQuestionIndex;
    private String region;

    private JLabel questionLabel;
    private JPanel optionsPanel;
    private JButton nextButton;
    private JButton backButton;

    private List<SelectedAnswer> selectedAnswers;

    public Questionaireframe(String region) {
        super("Questionnaire");
        this.region = region;
        this.questionnaire = new Questionaire();
        this.currentQuestionIndex = 0;
        this.selectedAnswers = new ArrayList<>();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Set to fullscreen
        setUndecorated(true); // Remove window decorations

        initializeUI();
        displayQuestion();
    }

    private void initializeUI() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(ColorControl.getBackgroundColor(region)); // Set panel color based on region
        add(mainPanel);

        // Create the close button
        JButton closeButton = new JButton("X");
        closeButton.setFont(new Font("Arial", Font.PLAIN, 16));
        closeButton.addActionListener(e -> dispose()); // Close the frame when button is clicked

        // Panel to hold the close button in the top right corner
        JPanel closeButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        closeButtonPanel.setBackground(ColorControl.getBackgroundColor(region)); // Set panel color based on region
        closeButtonPanel.add(closeButton);

        mainPanel.add(closeButtonPanel, BorderLayout.NORTH);

        // Panel to hold the label and options
        JPanel centerPanel = new JPanel(new BorderLayout());
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Create label for displaying questions
        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.BOLD, 24));
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(questionLabel, BorderLayout.NORTH);

        // Panel to hold options (checkboxes)
        optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(0, 1));
        optionsPanel.setBackground(ColorControl.getBackgroundColor(region)); // Set panel color based on region
        JScrollPane scrollPane = new JScrollPane(optionsPanel);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        // Panel for navigation buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 20));
        backButton.addActionListener(e -> processPreviousQuestion());
        buttonPanel.add(backButton);

        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.PLAIN, 20));
        nextButton.addActionListener(e -> processNextQuestion());
        buttonPanel.add(nextButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Apply theme colors to all components in the frame
        ColorControl.setTheme(region, this);
    }

    private void displayQuestion() {
        List<Question> questions = questionnaire.getQuestions();
        if (currentQuestionIndex >= 0 && currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            questionLabel.setText((currentQuestionIndex + 1) + ". " + currentQuestion.getText());

            optionsPanel.removeAll();
            for (String option : currentQuestion.getOptions()) {
                JCheckBox checkBox = new JCheckBox(option);
                checkBox.setFont(new Font("Arial", Font.PLAIN, 20));
                optionsPanel.add(checkBox);
            }

            backButton.setEnabled(currentQuestionIndex > 0);
            nextButton.setEnabled(true);

            revalidate(); // Refresh the layout
            repaint();    // Repaint the frame
        } else {
            showResults();
        }
    }

    private void processNextQuestion() {
        if (validateCurrentQuestion()) {
            List<String> selectedOptions = new ArrayList<>();
            Component[] components = optionsPanel.getComponents();
            for (Component component : components) {
                if (component instanceof JCheckBox) {
                    JCheckBox checkBox = (JCheckBox) component;
                    if (checkBox.isSelected()) {
                        selectedOptions.add(checkBox.getText());
                    }
                }
            }
            selectedAnswers.add(new SelectedAnswer(currentQuestionIndex + 1, selectedOptions));
            currentQuestionIndex++;
            displayQuestion();
        } else {
            JOptionPane.showMessageDialog(this, "Please select at least one answer.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validateCurrentQuestion() {
        Component[] components = optionsPanel.getComponents();
        for (Component component : components) {
            if (component instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) component;
                if (checkBox.isSelected()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void processPreviousQuestion() {
        if (currentQuestionIndex > 0) {
            currentQuestionIndex--;
            displayQuestion();
        }
    }

    private void showResults() {
        Results results = new Results(selectedAnswers);
        ResultsFrame resultsFrame = new ResultsFrame(results, region);
        resultsFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        resultsFrame.setUndecorated(true);
        resultsFrame.setVisible(true);
        dispose(); // Close the current QuestionnaireFrame
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Questionaireframe("RegionName").setVisible(true);
        });
    }
}
