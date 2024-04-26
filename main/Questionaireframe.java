package main;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Questionaireframe extends JPanel {
    private static Questionaire questionaire; // Change: Made questionaire static
    private int currentQuestionIndex; // To keep track of the current question index

    public Questionaireframe(Questionaire questionaire) {
        Questionaireframe.questionaire = questionaire;
        this.currentQuestionIndex = 0; // Start from the first question
        displayCurrentQuestion();
    }

    private void displayCurrentQuestion() {
        removeAll(); // Clear the panel before adding new components
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(255, 225, 168)); // Light orange background color

        List<Question> questions = questionaire.getQuestions();
        if (currentQuestionIndex >= 0 && currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);

            // Display the current question
            JLabel questionLabel = new JLabel(currentQuestion.getText());
            questionLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            questionLabel.setForeground(Color.WHITE);
            add(questionLabel);

            // Display the options for the current question
            List<String> options = currentQuestion.getOptions();
            for (String option : options) {
                JRadioButton radioButton = new JRadioButton(option);
                radioButton.setFont(new Font("Arial", Font.PLAIN, 16));
                radioButton.setBackground(new Color(255, 225, 168));
                radioButton.setForeground(Color.WHITE);
                add(radioButton);
            }

            // Add "Next" button
            JButton nextButton = new JButton("Next");
            nextButton.setFont(new Font("Arial", Font.BOLD, 20));
            nextButton.setBackground(new Color(226, 109, 92)); // Light red background color
            nextButton.setForeground(Color.WHITE);
            nextButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            nextButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    processSelectedAnswers();
                    currentQuestionIndex++; // Move to the next question
                    displayCurrentQuestion(); // Display the next question
                }
            });
            add(nextButton);

            revalidate(); // Refresh the panel to reflect the changes
        }
    }

    void processSelectedAnswers() {
        // Process selected answers
        // This method should handle the logic for processing the selected answers
        // For example, updating the selected answers list in the Questionnaire object
        // Or performing any necessary calculations or validations
    }

    public static Questionaire getQuestionnaire() {
        return questionaire;
    }
}
