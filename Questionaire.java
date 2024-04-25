

import java.util.ArrayList;
import java.util.List;

public class Questionaire extends Question {
        
public Questionaire(String question, ArrayList<String> answerOptions) {
      super(question, answerOptions);
   }

private ArrayList display;
private Object UserChoice;
private List<String> selectedAnswers;




public void displayQuestions() {
   display = super.answerOptions;
   System.out.println();
}



public List<Answer> getSelectedAnswers() {
   // This method should return a list of selected answers
   return selectedAnswers();
}



 // Select answers
 public void selectedAnswers(List<Integer> userChoices, Question question) {
   for (int choice : userChoices) {
       selectedAnswers.add(question.getAnswerOptions().get(choice - 1));
   }
}

}