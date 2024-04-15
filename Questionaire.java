

import java.util.ArrayList;
import java.util.List;

public class Questionaire extends Question {
    
    
private ArrayList display;
private Object UserChoice;

}

public void displayQuestions() {
   display = super.answerOptions;
   System.out.println();
}

public void selectAnswers() {
   ArrayList picks = UserChoice.get();
   return picks;
}

public List<Answer> getSelectedAnswers() {
   // This method should return a list of selected answers
   return null;
}

