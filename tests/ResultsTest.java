public class ResultsTest {

    // Test method for calculating top artists with sample data
    public void testCalculateTopArtists() {
        // Create a sample questionnaire
        Questionnaire questionnaire = createSampleQuestionnaire();

        // Create a Results instance with the sample questionnaire
        Results results = new Results(questionnaire);

        // Calculate top artists
        Map<String, Integer> topArtists = results.calculateTopArtists();

        // Assert the expected results
        assertEquals(3, topArtists.size()); // Expected number of top artists
        assertEquals(25, (int) topArtists.get("Artist A")); // Expected points for Artist A
        assertEquals(20, (int) topArtists.get("Artist B")); // Expected points for Artist B
        assertEquals(15, (int) topArtists.get("Artist C")); // Expected points for Artist C
    }

    // Test method for displaying top artists with sample data
    public void testDisplayTopArtists() {
        // Create a sample questionnaire
        Questionnaire questionnaire = createSampleQuestionnaire();

        // Create a Results instance with the sample questionnaire
        Results results = new Results(questionnaire);

        // Redirect System.out to ByteArrayOutputStream to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Display top artists
        results.displayTopArtists();

        // Restore original System.out
        System.setOut(System.out);

        // Assert the expected output
        String expectedOutput = "Top Artists:\n" +
                                "Artist A: 25 points\n" +
                                "Artist B: 20 points\n" +
                                "Artist C: 15 points\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    // Helper method to create a sample questionnaire with selected answers
    private Questionnaire createSampleQuestionnaire() {
        // Create a questionnaire
        Questionnaire questionnaire = new Questionnaire();

        // Add selected answers to the questionnaire
        questionnaire.addSelectedAnswer(new Answer("Question 1", "Artist A", 10));
        questionnaire.addSelectedAnswer(new Answer("Question 2", "Artist B", 5));
        questionnaire.addSelectedAnswer(new Answer("Question 3", "Artist A", 15));
        questionnaire.addSelectedAnswer(new Answer("Question 4", "Artist C", 10));
        questionnaire.addSelectedAnswer(new Answer("Question 5", "Artist B", 15));

        return questionnaire;
    }
}
