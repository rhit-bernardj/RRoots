package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Questionaire {
    private List<Question> questions;
    private Map<Integer, List<String>> selectedAnswers; 

    // emtpty questionaire list to store selected answers 
    public Questionaire() {
        this.questions = new ArrayList<>();
        this.selectedAnswers = new HashMap<>(); // Initialize selectedAnswers as a HashMap
        initializeQuestions(); // Populate the questionnaire with initial questions
    }

    // Method to initialize the questionnaire with predefined questions
    private void initializeQuestions() {
        // Create and add questions to the questionnaire
        questions.add(createQuestion1());
        questions.add(createQuestion2());
        questions.add(createQuestion3());
        questions.add(createQuestion4());
        questions.add(createQuestion5());
        questions.add(createQuestion6());
        questions.add(createQuestion7());
        questions.add(createQuestion8());
        questions.add(createQuestion9());
        questions.add(createQuestion10());
        // Add more questions here if needed
    }

    // Getter method to retrieve all questions in the questionnaire
    public List<Question> getQuestions() {
        return questions;
    }

    // Method to select answers for a specific question
    public void selectAnswers(int questionIndex, List<String> selectedOptions) {
        if (questionIndex >= 0 && questionIndex < questions.size()) {
            selectedAnswers.put(questionIndex, selectedOptions);
        }
    }

    // Getter method to retrieve the map of selected answers
    public Map<Integer, List<String>> getSelectedAnswers() {
        return selectedAnswers;
    }
    // Utility method to create the first question with its options
    private Question createQuestion1() {
        String text = "When you need a musical boost, what's your vibe?";
        List<String> options = List.of(
                "Amp me up with intense beats",
                "Let's get moving with uplifting rhythms",
                "I crave soul-touching melodies",
                "Take me on a journey with deep lyrics",
                "Feel inspired by soul-lifting gospel and blues"
        );
        

        return new Question(text, options);
    }

    private Question createQuestion2() {
        String text = "What draws you to a song first?";
        List<String> options = List.of(
                "The storytelling in the lyrics",
                "A catchy, memorable hook",
                "The energy and rhythm that get me moving",
                "The emotional pull of the vocals",
                "The intricacy of the instrumental arrangement"
        );

        return new Question(text, options);
    }

    private Question createQuestion3() {
        String text = "How do you like to discover new music?";
        List<String> options = List.of(
                "Exploring global sounds and rhythms",
                "Through high-energy playlists for my workouts",
                "In the background of cozy nights or dinners",
                "By delving into artists with deep, meaningful messages",
                "Discovering tracks with powerful messages and community spirit"
        );

        return new Question(text, options);
    }

    private Question createQuestion4() {
        String text = "How do you prefer to spend your leisure time?";
        List<String> options = List.of(
                "Discovering new hobbies and experiences",
                "Enjoying lively parties and social gatherings",
                "Relaxing with a book or a movie",
                "Engaging in active or outdoor activities",
                "Exploring creative expression and introspection"
        );

        return new Question(text, options);
    }

    private Question createQuestion5() {
        String text = "When you're feeling down, what's your go-to music?";
        List<String> options = List.of(
                "Heartfelt ballads and soulful tunes",
                "Dynamic beats and energetic anthems",
                "Light-hearted pop and catchy melodies",
                "Inspirational lyrics and powerful messages",
                "The soothing harmony of instrumental music"
        );

        return new Question(text, options);
    }

    private Question createQuestion6() {
        String text = "What's your go-to vibe for a relaxing evening at home after a busy market day?";
        List<String> options = List.of(
                "Soulful R&B",
                "Soothing Acoustic vibe",
                "Light soulful melodies",
                "Easy-listening jazz",
                "Intimate indie tunes"
        );

        return new Question(text, options);
    }

    private Question createQuestion7() {
        String text = "What music background do you prefer while cooking your favorite Nigerian dish?";
        List<String> options = List.of(
                "Up-tempo pop to make cooking fun",
                "Vibrant Afrosoul rhythms that stir the spirit and uplift the room",
                "Soul classics to enrich the culinary experience",
                "Instrumental world music for culinary inspiration",
                "Rock anthems to energize the kitchen"
        );

        return new Question(text, options);
    }

    private Question createQuestion8() {
        String text = "Select the musical style that gets you moving to the beat?";
        List<String> options = List.of(
                "Pop energy that lights up the room",
                "An electronic dance track that's all the rage",
                "Hip-hop with a powerful punch",
                "An indie anthem with a catchy chorus",
                "A blues-infused track with a groove",
                "Country beats with a lively tempo"
        );

        return new Question(text, options);
    }

    private Question createQuestion9() {
        String text = "What music do you listen to during a rainy day?";
        List<String> options = List.of(
                "Cozy acoustic vibes",
                "Smooth jazz",
                "Reflective smooth songs",
                "Soft rock ballads",
                "Emotional blues and soul"
        );

        return new Question(text, options);
    }

    private Question createQuestion10() {
        String text = "Your go-to sound for Lagos traffic?";
        List<String> options = List.of(
                "Upbeat hits to turn traffic time into a sing-along session",
                "Uplifting stories in song",
                "Energizing rock songs to beat the traffic blues",
                "Pumping electronic beats",
                "Pop anthems for mood lifting"
        );

        return new Question(text, options);
    }
}