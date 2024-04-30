package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Questionaireframe extends JPanel {
    private Questionaire questionaire;
    private int currentQuestionIndex;

    private JLabel questionLabel;
    private JComboBox<String> optionsComboBox;
    private JButton nextButton;
    private JButton backButton;

    public Questionaireframe(Questionaire questionaire) {
        this.questionaire = questionaire;
        this.currentQuestionIndex = 0;

        initializeUI();
        displayQuestion();
    }

    private void initializeUI() {
        setPreferredSize(new Dimension(600, 200));
        setBackground(new Color(255, 225, 168)); // Set background color
        setLayout(new FlowLayout());

        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        questionLabel.setForeground(new Color(125, 187, 195)); // Set text color
        add(questionLabel);

        optionsComboBox = new JComboBox<>();
        optionsComboBox.setPreferredSize(new Dimension(300, 30));
        add(optionsComboBox);

        nextButton = new JButton("Next");
        nextButton.setBackground(new Color(226, 109, 92)); // Set button background color
        nextButton.setForeground(Color.WHITE); // Set button text color
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processNextQuestion();
            }
        });
        add(nextButton);

        backButton = new JButton("Back");
        backButton.setBackground(new Color(72, 133, 237)); // Set button background color
        backButton.setForeground(Color.WHITE); // Set button text color
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processPreviousQuestion();
            }
        });
        add(backButton);
    }

    private void displayQuestion() {
        List<Question> questions = questionaire.getQuestions();
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            questionLabel.setText(currentQuestion.getText());

            optionsComboBox.removeAllItems();
            for (String option : currentQuestion.getOptions()) {
                optionsComboBox.addItem(option);
            }

            // Enable or disable back button based on current question index
            backButton.setEnabled(currentQuestionIndex > 0);

            // Repaint the panel to reflect the updated components
            revalidate();
            repaint();
        } else {
            showResults();
        }
    }

    private void processNextQuestion() {
        int selectedOptionIndex = optionsComboBox.getSelectedIndex();
        if (selectedOptionIndex != -1) {
            questionaire.selectAnswer(currentQuestionIndex, selectedOptionIndex);
            currentQuestionIndex++;
            displayQuestion(); // Display the next question
        } else {
            JOptionPane.showMessageDialog(this, "Please select an option.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void processPreviousQuestion() {
        if (currentQuestionIndex > 0) {
            currentQuestionIndex--;
            displayQuestion(); // Display the previous question
        }
    }

    private void showResults() {
        // Assuming this component will be added to a JFrame elsewhere
        SwingUtilities.getWindowAncestor(this).dispose(); // Close the current frame

        Results results = new Results(questionaire.getSelectedAnswers());
        ResultsFrame resultsFrame = new ResultsFrame(results);
        // Assuming ResultsFrame is designed to be a standalone JFrame
        resultsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        resultsFrame.setSize(800, 600);
        resultsFrame.setVisible(true);
    }
}
