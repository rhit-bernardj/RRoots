package main;
import java.util.ArrayList;
import java.util.List;

public class Questionaire {
    private List<Question> questions;
    private List<SelectedAnswers> selectedAnswers;

    public Questionaire() {
        this.questions = new ArrayList<>();
        this.selectedAnswers = new ArrayList<>();
        initializeQuestions();
    }

    private void initializeQuestions() {
        // Add questions to the questionnaire
        questions.add(Question.createQuestion1());
        // Add more questions here if needed
    }

    
    
    
    
    // Method to grab questions
    public List<Question> getQuestions() {
        return questions;
    }
    
    
    

    // Method to pick answer from question
    public void selectAnswer(int questionIndex, int optionIndex) {
        Question current = getCurrentQuestion(questionIndex);
        if (current != null) {
            List<String> options = current.getOptions();
            if (optionIndex >= 0 && optionIndex < options.size()) {
                String selectedOption = options.get(optionIndex);
                selectedAnswers.add(new SelectedAnswers(current.getText(), selectedOption));
            }
        }
    }

    // method to get the selected answers
    public List<SelectedAnswers> getSelectedAnswers() {
        return selectedAnswers;
    }

    // method to get the current question
    Question getCurrentQuestion(int questionIndex) {
        if (questionIndex >= 0 && questionIndex < questions.size()) {
            return questions.get(questionIndex);
        }
        return null;
    }
}
