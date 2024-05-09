package main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ResultsTest {

    private static List<SelectedAnswer> selectedAnswers;

    @Before
    public void setUp() throws Exception {
        selectedAnswers = new ArrayList<>();
        selectedAnswers.add(new SelectedAnswer(1, Arrays.asList("Amp me up with intense beats")));
        selectedAnswers.add(new SelectedAnswer(2, Arrays.asList("Let's get moving with uplifting rhythms")));
        selectedAnswers.add(new SelectedAnswer(3, Arrays.asList("I crave soul-touching melodies")));
    }

    @Test
    public void testResults() {
        Results results = new Results(selectedAnswers);
        assertNotNull(results);
    }

    @Test
    public void testGetTopThreeArtists() {
        Results results = new Results(selectedAnswers);
        List<Artist> topArtists = results.getTopThreeArtists();
        assertEquals(3, topArtists.size());
    }

    @Test
    public void testGetArtistPoints() {
        Results results = new Results(selectedAnswers);
        List<Artist> topArtists = results.getTopThreeArtists();
        assertNotNull(topArtists);
    }

    @Test
    public void testAllAnswersSelected() {
        List<SelectedAnswer> allSelectedAnswers = new ArrayList<>();
        allSelectedAnswers.add(new SelectedAnswer(1, Arrays.asList(
                "Amp me up with intense beats",
                "Let's get moving with uplifting rhythms",
                "I crave soul-touching melodies"
        )));
        Results results = new Results(allSelectedAnswers);
        List<Artist> topArtists = results.getTopThreeArtists();
        assertEquals(3, topArtists.size());
    }

    @Test
    public void testEmptySelectedAnswers() {
        List<SelectedAnswer> emptySelectedAnswers = new ArrayList<>();
        Results results = new Results(emptySelectedAnswers);
        List<Artist> topArtists = results.getTopThreeArtists();
        assertEquals(0, topArtists.size());
    }

    
}
