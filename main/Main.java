package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Questionaire questionnaire = new Questionaire();//constructor

            //JFrame for questionaire
            JFrame frame = new JFrame("Music Questionnaire");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            // create a Questionaireframe and add it to the JFrame's content pane
            Questionaireframe questionnaireFrame = new Questionaireframe(questionnaire);
            frame.add(questionnaireFrame);
            frame.setVisible(true);
        });
    }
}
