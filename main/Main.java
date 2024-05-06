package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create a new questionnaire
            Questionaire questionnaire = new Questionaire();

            // Create a JFrame to host the Questionaireframe
            JFrame frame = new JFrame("Music Questionnaire");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            // Create a Questionaireframe and add it to the JFrame's content pane
            Questionaireframe questionnaireFrame = new Questionaireframe(questionnaire);
            frame.add(questionnaireFrame);

            // Display the JFrame
            frame.setVisible(true);
        });
    }
}
