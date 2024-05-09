package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultsTest {

    private List<SelectedAnswer> selectedAnswers;

    // @BeforeEach
    // public void setUp() {
    //     selectedAnswers = new ArrayList<>();
    //     // Add selected answers for testing
    //     // You can add your selected answers here for testing different scenarios
    //     // For the extreme case, let's select all options for all questions
    //     for (int i = 0; i < 10; i++) {
    //         selectedAnswers.add(new SelectedAnswer(getAllOptionsForQuestion(i)));
    //     }
    // }

    @Test
    public void testGetTopThreeArtists() {
        Results results = new Results(selectedAnswers);
        List<String> expectedTopArtists = List.of("Dua Lipa", "Fred again..", "Kirk Franklin");

        List<String> actualTopArtists = results.getTopThreeArtists().stream()
                .map(artist -> artist.getName())
                .toList();

        assertEquals(expectedTopArtists, actualTopArtists);
    }

    @Test
    public void testAllOptionsSelected() {
        Results results = new Results(selectedAnswers);
        Map<String, Integer> artistPoints = results.getArtistPoints();

        // Check if all options have been selected for all questions
        for (int i = 0; i < 10; i++) {
            List<String> options = getAllOptionsForQuestion(i);
            for (String option : options) {
                assertTrue(artistPoints.containsKey(option));
            }
        }
    }

    @Test
    public void testNoAnswersSelected() {
        Results results = new Results(new ArrayList<>());
        Map<String, Integer> artistPoints = results.getArtistPoints();

        // Check if no points have been assigned if no answers are selected
        assertTrue(artistPoints.isEmpty());
    }

    @Test
    public void testSingleAnswerSelected() {
        List<SelectedAnswer> singleAnswer = List.of(new SelectedAnswer(List.of("Amp me up with intense beats")));
        Results results = new Results(singleAnswer);
        Map<String, Integer> artistPoints = results.getArtistPoints();

        // Check if points are assigned only for the selected answer
        assertEquals(3, artistPoints.size());
        assertTrue(artistPoints.containsKey("Travis Scott"));
        assertTrue(artistPoints.containsKey("Kendrick Lamar"));
        assertTrue(artistPoints.containsKey("Calvin Harris"));
    }

    @Test
    public void testEqualPointsForMultipleAnswers() {
        List<SelectedAnswer> equalPoints = List.of(
                new SelectedAnswer(List.of("Amp me up with intense beats", "Let's get moving with uplifting rhythms")),
                new SelectedAnswer(List.of("The storytelling in the lyrics", "A catchy, memorable hook")),
                new SelectedAnswer(List.of("Exploring global sounds and rhythms", "Through high-energy playlists for my workouts"))
        );
        Results results = new Results(equalPoints);
        Map<String, Integer> artistPoints = results.getArtistPoints();

        // Check if points are assigned equally for multiple selected answers
        assertEquals(6, artistPoints.size()); // 2 options for each question selected, 3 questions in total
        assertTrue(artistPoints.containsKey("Travis Scott"));
        assertTrue(artistPoints.containsKey("Kendrick Lamar"));
        assertTrue(artistPoints.containsKey("Calvin Harris"));
        assertTrue(artistPoints.containsKey("Dua Lipa"));
        assertTrue(artistPoints.containsKey("Jon Pardi"));
        assertTrue(artistPoints.containsKey("Keb' Mo'"));
    }

    // Utility method to get all options for a specific question
    private List<String> getAllOptionsForQuestion(int questionIndex) {
        switch (questionIndex) {
            case 0:
                return List.of("Amp me up with intense beats", "Let's get moving with uplifting rhythms",
                        "I crave soul-touching melodies", "Take me on a journey with deep lyrics",
                        "Feel inspired by soul-lifting gospel and blues");
            case 1:
                return List.of("The storytelling in the lyrics", "A catchy, memorable hook",
                        "The energy and rhythm that get me moving", "The emotional pull of the vocals",
                        "The intricacy of the instrumental arrangement");
            case 2:
                return List.of("Exploring global sounds and rhythms", "Through high-energy playlists for my workouts",
                        "In the background of cozy nights or dinners", "By delving into artists with deep, meaningful messages",
                        "Discovering tracks with powerful messages and community spirit");
            case 3:
                return List.of("Discovering new hobbies and experiences", "Enjoying lively parties and social gatherings",
                        "Relaxing with a book or a movie", "Engaging in active or outdoor activities",
                        "Exploring creative expression and introspection");
            case 4:
                return List.of("Heartfelt ballads and soulful tunes", "Dynamic beats and energetic anthems",
                        "Light-hearted pop and catchy melodies", "Inspirational lyrics and powerful messages",
                        "The soothing harmony of instrumental music");
            case 5:
                return List.of("Soulful R&B", "Soothing Acoustic vibe", "Light soulful melodies",
                        "Easy-listening jazz", "Intimate indie tunes");
            case 6:
                return List.of("Up-tempo pop to make cooking fun",
                        "Vibrant Afrosoul rhythms that stir the spirit and uplift the room",
                        "Soul classics to enrich the culinary experience",
                        "Instrumental world music for culinary inspiration",
                        "Rock anthems to energize the kitchen");
            case 7:
                return List.of("Pop energy that lights up the room",
                        "An electronic dance track that's all the rage",
                        "Hip-hop with a powerful punch",
                        "An indie anthem with a catchy chorus",
                        "A blues-infused track with a groove",
                        "Country beats with a lively tempo");
            case 8:
                return List.of("Cozy acoustic vibes", "Smooth jazz", "Reflective smooth songs",
                        "Soft rock ballads", "Emotional blues and soul");
            case 9:
                return List.of("Upbeat hits to turn traffic time into a sing-along session",
                        "Uplifting stories in song",
                        "Energizing rock songs to beat the traffic blues",
                        "Pumping electronic beats", "Pop anthems for mood lifting");
            default:
                return new ArrayList<>();
        }
    }
}

