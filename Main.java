package main;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create the main frame
            JFrame frame = new JFrame("Rhythm Roots");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            // Create the questionnaire
            Questionaire questionnaire = new Questionaire(); 

            // Create the questionnaire frame and add it to the main frame
            Questionaireframe questionnaireFrame = new Questionaireframe(questionnaire);
            frame.add(questionnaireFrame, BorderLayout.CENTER);

            // Add a submit button if needed
            // JButton submitButton = new JButton("Submit");
            // submitButton.addActionListener(e -> questionnaireFrame.processSelectedAnswers());
            // frame.add(submitButton, BorderLayout.SOUTH);

            // Make the frame visible
            frame.setVisible(true);
        });
    }
}
