package Jaxon;

import java.util.ArrayList;

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

}

