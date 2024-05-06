package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Questionaireframe extends JPanel {
    private Questionaire questionaire;
    private int currentQuestionIndex;

    private JLabel questionLabel;
    private JPanel optionsPanel;
    private JButton nextButton;
    private JButton backButton;

    public Questionaireframe(Questionaire questionaire) {
        this.questionaire = questionaire;
        this.currentQuestionIndex = 0;

        initializeUI();
        displayQuestion();
    }

    private void initializeUI() {
        setPreferredSize(new Dimension(600, 400));
        setBackground(new Color(255, 225, 168));
        setLayout(new BorderLayout());

        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(questionLabel, BorderLayout.NORTH);

        optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(0, 1));
        add(optionsPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 225, 168));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        backButton = new JButton("Back");
        backButton.setBackground(new Color(72, 133, 237));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processPreviousQuestion();
            }
        });
        buttonPanel.add(backButton);

        nextButton = new JButton("Next");
        nextButton.setBackground(new Color(226, 109, 92));
        nextButton.setForeground(Color.WHITE);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processNextQuestion();
            }
        });
        buttonPanel.add(nextButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void displayQuestion() {
        List<Question> questions = questionaire.getQuestions();
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            questionLabel.setText((currentQuestionIndex + 1) + ". " + currentQuestion.getText());

            optionsPanel.removeAll();
            for (String option : currentQuestion.getOptions()) {
                JCheckBox checkBox = new JCheckBox(option);
                optionsPanel.add(checkBox);
            }

            backButton.setEnabled(currentQuestionIndex > 0);

            revalidate();
            repaint();
        } else {
            showResults();
        }
    }

    private void processNextQuestion() {
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

        if (!selectedOptions.isEmpty()) {
            questionaire.selectAnswers(currentQuestionIndex, selectedOptions);
            currentQuestionIndex++;
            displayQuestion();
        } else {
            JOptionPane.showMessageDialog(this, "Please select at least one option.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void processPreviousQuestion() {
        if (currentQuestionIndex > 0) {
            currentQuestionIndex--;
            displayQuestion();
        }
    }

    private void showResults() {
        SwingUtilities.getWindowAncestor(this).dispose();
        
        // Assuming questionaire.getSelectedAnswers() returns a Map<Integer, List<String>>
        Map<Integer, List<String>> selectedOptionsMap = questionaire.getSelectedAnswers();
        List<SelectedAnswer> selectedAnswers = new ArrayList<>();

        // Convert the map entries into SelectedAnswer objects
        for (Map.Entry<Integer, List<String>> entry : selectedOptionsMap.entrySet()) {
            Integer questionIndex = entry.getKey();
            List<String> options = entry.getValue();
            SelectedAnswer selectedAnswer = new SelectedAnswer(questionIndex, options);
            selectedAnswers.add(selectedAnswer);
        }

        // Now create Results using the converted List<SelectedAnswer>
        Results results = new Results(selectedAnswers);
        ResultsFrame resultsFrame = new ResultsFrame(results);
        resultsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        resultsFrame.setSize(800, 600);
        resultsFrame.setVisible(true);
    }
}
