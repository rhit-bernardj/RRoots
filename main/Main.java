package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // this is the creater for the questionaireframe
            Questionaire questionnaire = new Questionaire();

            // the actual jframe of the questionare
            JFrame frame = new JFrame("Music Questionnaire");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            Questionaireframe questionnaireFrame = new Questionaireframe(questionnaire);
            frame.add(questionnaireFrame);

            //so you can see it
            frame.setVisible(true);
        });
    }
}
