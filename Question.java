import java.util.Arrays;
import java.util.List;

public class Question {
     private String text;
     private List<String> options;
 
     public Question(String text, List<String> options) {
         this.text = text;
         this.options = options;
     }
 
     // Getters
     public String getText() {
         return text;
     }
 
     public List<String> getOptions() {
         return options;
     }
 
     // Static method to create the first question
     public static Question createQuestion1() {
         String questionText = "When you need a musical boost, what's your vibe?";
         List<String> options = Arrays.asList(
             "Amp me up with intense beats",
             "Let's get moving with uplifting rhythms",
             "I crave soul-touching melodies",
             "Take me on a journey with deep lyrics",
             "Feel inspired by soul-lifting gospel and blues:"
         );
         return new Question(questionText, options);
     }
 }
 