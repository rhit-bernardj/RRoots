import java.util.ArrayList;
import java.util.List;

public class Questionaire {
    private List<Question> questions;
    private List<Answer> selectedAnswers;

    public Questionaire() {
        this.questions = new ArrayList<>();
        this.selectedAnswers = new ArrayList<>();
        // Initialize questions
        initializeQuestions();
    }

    // Method to initialize questions
    private void initializeQuestions() {
        // Add questions to the questionnaire
        questions.add(Question.createQuestion1());
        // Add more questions here if needed
    }

    // Method to get the current question
    public Question getCurrentQuestion(int questionIndex) {
        if (questionIndex >= 0 && questionIndex < questions.size()) {
            return questions.get(questionIndex);
        }
        return null;
    }

    // Method to select an answer for the current question
    public void selectAnswer(int questionIndex, int optionIndex) {
        Question currentQuestion = getCurrentQuestion(questionIndex);
        if (currentQuestion != null) {
            List<String> options = currentQuestion.getOptions();
            if (optionIndex >= 0 && optionIndex < options.size()) {
                String selectedOption = options.get(optionIndex);
                selectedAnswers.add(new Answer(currentQuestion.getText(), selectedOption));
            }
        }
    }

    // Method to get the selected answers
    public List<Answer> getSelectedAnswers() {
        return selectedAnswers;
    }
}
