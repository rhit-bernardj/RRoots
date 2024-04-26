package main;
import java.util.ArrayList;
import java.util.List;

public class Question {
    private String text;
    private List<String> options;

    public Question(String text, List<String> options) {
        this.text = text;
        this.options = options;
    }

    public String getText() {
        return text;
    }

    public List<String> getOptions() {
        return options;
    }

    // question one
    public static Question createQuestion1() {
        String text = "When you need a musical boost, what's your vibe?";
        List<String> options = new ArrayList<>();
        options.add("Amp me up with intense beats");
        options.add("Let's get moving with uplifting rhythms");
        options.add("I crave soul-touching melodies");
        options.add("Take me on a journey with deep lyrics");
        options.add("Feel inspired by soul-lifting gospel and blues");
        return new Question(text, options);
    }
    
    // question two
    public static Question createQuestion2() {
        String text = "What draws you to a song first?";
        List<String> options = new ArrayList<>();
        options.add("The storytelling in the lyrics");
        options.add("A catchy, memorable hook");
        options.add("The energy and rhythm that get me moving");
        options.add("The emotional pull of the vocals");
        options.add("The intricacy of the instrumental arrangement");
        return new Question(text, options);
    }

    // question three
    public static Question createQuestion3() {
        String text = "How do you like to discover new music?";
        List<String> options = new ArrayList<>();
        options.add("Exploring global sounds and rhythms");
        options.add("Through high-energy playlists for my workouts");
        options.add("In the background of cozy nights or dinners");
        options.add("By delving into artists with deep, meaningful messages");
        options.add("Discovering tracks with powerful messages and community spirit");
        return new Question(text, options);
    }
 // Question four
    public static Question createQuestion4() {
        String text = "How do you prefer to spend your leisure time?";
        List<String> options = new ArrayList<>();
        options.add("Discovering new hobbies and experiences");
        options.add("Enjoying lively parties and social gatherings");
        options.add("Relaxing with a book or a movie");
        options.add("Engaging in active or outdoor activities");
        options.add("Exploring creative expression and introspection");
        return new Question(text, options);
    }

    // Question five
    public static Question createQuestion5() {
        String text = "When you're feeling down, what's your go-to music?";
        List<String> options = new ArrayList<>();
        options.add("Heartfelt ballads and soulful tunes");
        options.add("Dynamic beats and energetic anthems");
        options.add("Light-hearted pop and catchy melodies");
        options.add("Inspirational lyrics and powerful messages");
        options.add("The soothing harmony of instrumental music");
        return new Question(text, options);
    }

    // Question six
    public static Question createQuestion6() {
        String text = "What's your go-to vibe for a relaxing evening at home after a busy market day?";
        List<String> options = new ArrayList<>();
        options.add("Soulful R&B");
        options.add("Soothing Acoustic vibe");
        options.add("Light soulful melodies");
        options.add("Easy-listening jazz");
        options.add("Intimate indie tunes");
        return new Question(text, options);
    }

    // Question seven
    public static Question createQuestion7() {
        String text = "What music background do you prefer while cooking your favorite Nigerian dish?";
        List<String> options = new ArrayList<>();
        options.add("Up-tempo pop to make cooking fun");
        options.add("Uplifting Spirituals");
        options.add("Soul classics to enrich the culinary experience");
        options.add("Instrumental world music for culinary inspiration");
        options.add("Rock anthems to energize the kitchen");
        return new Question(text, options);
    }

    // Question eight
    public static Question createQuestion8() {
        String text = "Which song from a recent dance challenge can you not get enough of?";
        List<String> options = new ArrayList<>();
        options.add("A pop hit with infectious energy");
        options.add("An electronic dance track that's all the rage");
        options.add("A hip-hop banger with an unforgettable beat");
        options.add("An indie anthem with a catchy chorus");
        options.add("A blues-infused track with a groove");
        options.add("Country grooves with a catchy beat");
        return new Question(text, options);
    }

    // Question nine
    public static Question createQuestion9() {
        String text = "What music do you listen to during a rainy day?";
        List<String> options = new ArrayList<>();
        options.add("Cozy acoustic vibes");
        options.add("Smooth jazz");
        options.add("Reflective smooth songs");
        options.add("Soft rock ballads");
        options.add("Emotional blues and soul");
        return new Question(text, options);
    }

    // Question ten
    public static Question createQuestion10() {
        String text = "Your go-to sound for Lagos traffic?";
        List<String> options = new ArrayList<>();
        options.add("Upbeat hits to turn traffic time into a sing-along session");
        options.add("Uplifting stories in song");
        options.add("Energizing rock songs to beat the traffic blues");
        options.add("Pumping electronic beats");
        options.add("Pop anthems for mood lifting");
        return new Question(text, options);
    }
}
