import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Question {
    private String questionText;  // Stores the text of each question
    private List<String> responses;  // Stores the response options for each question
    private Map<String, List<String>> responseToArtistsMap;  // Maps each response to a list of artists

    // Static list to hold all question instances
    private static List<Question> allQuestions = new ArrayList<>();

    // Constructor to initialize the question text, response list, and artist map
    public Question(String questionText) {
        this.questionText = questionText;
        this.responses = new ArrayList<>();
        this.responseToArtistsMap = new HashMap<>();
    }

    // Add a response and its associated artists to the question
    public void addResponse(String response, List<String> artists) {
        responses.add(response);
        responseToArtistsMap.put(response, artists);
    }

    // Static method to add a new question to the list of all questions
    public static void addQuestion(Question question) {
        allQuestions.add(question);
    }

    // Getters for accessing the question text, responses, and artists
    public String getQuestionText() {
        return questionText;
    }

    public List<String> getResponses() {
        return responses;
    }

    public List<String> getArtistsForResponse(String response) {
        return responseToArtistsMap.get(response);
    }

    // Static method to get all questions (if needed for reference or testing)
    public static List<Question> getAllQuestions() {
        return allQuestions;
    }

    // Example initialization (can be modified or expanded based on actual application needs)
    public static void initializeQuestions() {
        Question q1 = new Question("When you need a musical boost, what's your vibe?");
        q1.addResponse("Amp me up with intense beats");
        q1.addResponse("Let's get moving with uplifting rhythms");

        Question q2 = new Question("What draws you to a song first?");
        q2.addResponse("The storytelling in the lyrics");
        q2.addResponse("A catchy, memorable hook");

        addQuestion(q1);
        addQuestion(q2);
    }
}