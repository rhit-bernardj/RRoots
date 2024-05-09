package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Results {
    private Map<String, Integer> artistPoints;

    public Results(List<SelectedAnswer> selectedAnswers) {
        artistPoints = new HashMap<>();
        calculateArtistPoints(selectedAnswers);
    }

    void calculateArtistPoints(List<SelectedAnswer> selectedAnswers) {
        for (SelectedAnswer answer : selectedAnswers) {
            String selectedOption = answer.getSelectedOption();

            // update the artist points based on the selected option
            switch (selectedOption) {
                case "Amp me up with intense beats":
                    artistPoints.merge("Kid Cudi", 1, Integer::sum);
                    artistPoints.merge("Kendrick Lamar", 1, Integer::sum);
                    artistPoints.merge("Calvin Harris", 2, Integer::sum);
                    break;
                case "Let's get moving with uplifting rhythms":
                    artistPoints.merge("Dua Lipa", 1, Integer::sum);
                    artistPoints.merge("Jon Pardi", 2, Integer::sum);
                    break;
                case "I crave soul-touching melodies":
                    artistPoints.merge("Janelle Monáe", 1, Integer::sum);
                    artistPoints.merge("Frank Ocean", 1, Integer::sum);
                    artistPoints.merge("Gary Clark Jr.", 2, Integer::sum);
                    artistPoints.merge("Keb' Mo'", 1, Integer::sum);
                    artistPoints.merge("Kamasi Washington", 2, Integer::sum);
                    artistPoints.merge("Michael Bublé", 1, Integer::sum);
                    break;
                case "Take me on a journey with deep lyrics":
                    artistPoints.merge("Tame Impala", 1, Integer::sum);
                    artistPoints.merge("The 1975", 2, Integer::sum);
                    artistPoints.merge("Foo Fighters", 1, Integer::sum);
                    artistPoints.merge("Green Day", 1, Integer::sum);
                    break;
                case "Feel inspired by soul-lifting gospel":
                    artistPoints.merge("Kirk Franklin", 1, Integer::sum);
                    artistPoints.merge("Sunday Service Choir", 1, Integer::sum);
                    break;
                case "The storytelling in the lyrics":
                    artistPoints.merge("Kendrick Lamar", 2, Integer::sum);
                    artistPoints.merge("Keb' Mo'", 1, Integer::sum);
                    break;
                case "A catchy, memorable hook":
                    artistPoints.merge("Jon Pardi", 1, Integer::sum);
                    artistPoints.merge("Dua Lipa", 1, Integer::sum);
                    artistPoints.merge("Carrie Underwood", 2, Integer::sum);
                    break;
                case "The energy and rhythm that get me moving":
                    artistPoints.merge("Kid Cudi", 1, Integer::sum);
                    artistPoints.merge("Calvin Harris", 2, Integer::sum);
                    break;
                case "The emotional pull of the vocals":
                    artistPoints.merge("Janelle Monáe", 1, Integer::sum);
                    artistPoints.merge("Frank Ocean", 2, Integer::sum);
                    break;
                case "The intricacy of the instrumental arrangement":
                    artistPoints.merge("Kamasi Washington", 2, Integer::sum);
                    artistPoints.merge("Michael Bublé", 1, Integer::sum);
                    artistPoints.merge("Gary Clark Jr.", 1, Integer::sum);
                    artistPoints.merge("Keb Mo", 1, Integer::sum);
                    break;
                case "Exploring global sounds and rhythms":
                    artistPoints.merge("The 1975", 1, Integer::sum);
                    artistPoints.merge("Keb' Mo'", 2, Integer::sum);
                    break;
                case "Through high-energy playlists for my workouts":
                    artistPoints.merge("Calvin Harris", 2, Integer::sum);
                    artistPoints.merge("Green Day", 1, Integer::sum);
                    break;
                case "In the background of cozy nights or dinners":
                    artistPoints.merge("Michael Bublé", 2, Integer::sum);
                    artistPoints.merge("Carrie Underwood", 1, Integer::sum);
                    break;
                case "By delving into artists with deep, meaningful messages":
                    artistPoints.merge("Tame Impala", 1, Integer::sum);
                    artistPoints.merge("Foo Fighters", 1, Integer::sum);
                    artistPoints.merge("Kendrick Lamar", 2, Integer::sum);
                    break;
                case "Discovering tracks with powerful messages and community spirit":
                    artistPoints.merge("Kirk Franklin", 1, Integer::sum);
                    artistPoints.merge("Sunday Service Choir", 1, Integer::sum);
                    break;
                case "Discovering new hobbies and experiences":
                    artistPoints.merge("The 1975", 1, Integer::sum);
                    artistPoints.merge("Tame Impala", 2, Integer::sum);
                    artistPoints.merge("Jon Pardi", 1, Integer::sum);
                    break;
                case "Enjoying lively parties and social gatherings":
                    artistPoints.merge("Dua Lipa", 1, Integer::sum);
                    artistPoints.merge("Gary Clark Jr.", 1, Integer::sum);
                    artistPoints.merge("Kid Cudi", 2, Integer::sum);
                    break;
                case "Relaxing with a book or a movie":
                    artistPoints.merge("Frank Ocean", 2, Integer::sum);
                    artistPoints.merge("Janelle Monáe", 1, Integer::sum);
                    break;
                case "Engaging in active or outdoor activities":
                    artistPoints.merge("Green Day", 2, Integer::sum);
                    artistPoints.merge("Foo Fighters", 1, Integer::sum);
                    break;
                case "Exploring creative expression and introspection":
                    artistPoints.merge("Gary Clark Jr.", 1, Integer::sum);
                    artistPoints.merge("Fred again..", 2, Integer::sum);
                    break;
                case "Heartfelt ballads and soulful tunes":
                    artistPoints.merge("Frank Ocean", 1, Integer::sum);
                    artistPoints.merge("Carrie Underwood", 1, Integer::sum);
                    break;
                case "Dynamic beats and energetic anthems":
                    artistPoints.merge("Kid Cudi", 1, Integer::sum);
                    artistPoints.merge("Calvin Harris", 1, Integer::sum);
                    artistPoints.merge("Fred again..", 2, Integer::sum);
                    break;
                case "Light-hearted pop and catchy melodies":
                    artistPoints.merge("Kacey Musgraves", 2, Integer::sum);
                    artistPoints.merge("Dua Lipa", 1, Integer::sum);
                    break;
                case "Inspirational lyrics and powerful messages":
                    artistPoints.merge("Tame Impala", 1, Integer::sum);
                    artistPoints.merge("Green Day", 2, Integer::sum);
                    artistPoints.merge("Sunday Service Choir", 1, Integer::sum);
                    artistPoints.merge("Kirk Franklin", 1, Integer::sum);
                    artistPoints.merge("The 1975", 1, Integer::sum);
                    break;
                case "The soothing harmony of instrumental music":
                    artistPoints.merge("Kamasi Washington", 2, Integer::sum);
                    artistPoints.merge("Michael Bublé", 1, Integer::sum);
                    break;
                case "Soulful R&B":
                    artistPoints.merge("Janelle Monáe", 1, Integer::sum);
                    artistPoints.merge("Frank Ocean", 1, Integer::sum);
                    break;
                case "Soothing Acoustic vibe":
                    artistPoints.merge("Kacey Musgraves", 1, Integer::sum);
                    artistPoints.merge("Carrie Underwood", 2, Integer::sum);
                    break;
                case "Light soulful melodies":
                    artistPoints.merge("Kirk Franklin", 1, Integer::sum);
                    artistPoints.merge("Sunday Service Choir", 1, Integer::sum);
                    break;
                case "Easy-listening jazz":
                    artistPoints.merge("Michael Bublé", 2, Integer::sum);
                    artistPoints.merge("Kamasi Washington", 1, Integer::sum);
                    break;
                case "Intimate indie tunes":
                    artistPoints.merge("Tame Impala", 2, Integer::sum);
                    artistPoints.merge("The 1975", 1, Integer::sum);
                    break;
                case "Up-tempo pop to make cooking fun":
                    artistPoints.merge("Dua Lipa", 2, Integer::sum);
                    artistPoints.merge("Kacey Musgraves", 1, Integer::sum);
                    artistPoints.merge("Fred again..", 1, Integer::sum);
                    break;
                case "Vibrant Afrosoul rhythms that stir the spirit and uplift the room":
                    artistPoints.merge("Kirk Franklin", 1, Integer::sum);
                    artistPoints.merge("Sunday Service Choir", 1, Integer::sum);
                    break;
                case "Soul classics to enrich the culinary experience":
                artistPoints.merge("Janelle Monáe", 2, Integer::sum);
                artistPoints.merge("Frank Ocean", 1, Integer::sum);
                    break;
                case "Instrumental world music for culinary inspiration":
                 artistPoints.merge("Kamasi Washington", 1, Integer::sum);
                    break;
                case "Rock anthems to energize the kitchen":
                    artistPoints.merge("Foo Fighters", 2, Integer::sum);
                    artistPoints.merge("Green Day", 1, Integer::sum);
                    artistPoints.merge("Gary Clark Jr.", 1, Integer::sum);
                    break;
                case "Pop energy that lights up the room":
                 artistPoints.merge("Dua Lipa", 1, Integer::sum);
                 break;
                case "An electronic dance track that's all the rage":
                    artistPoints.merge("Fred again..", 1, Integer::sum);
                    artistPoints.merge("Calvin Harris", 1, Integer::sum);
                break;
                case "Hip-hop with a powerful punch":
                artistPoints.merge("Kid Cudi", 1, Integer::sum);
                artistPoints.merge("Kendrick Lamar", 1, Integer::sum);
                break;
                case "An indie anthem with a catchy chorus":
                    artistPoints.merge("Tame Impala", 1, Integer::sum);
                    artistPoints.merge("The 1975", 1, Integer::sum);
                    break;
                case "A blues-infused track with a groove":
                artistPoints.merge("Keb' Mo'", 2, Integer::sum);
                case "Country beats with a lively tempo":
                    artistPoints.merge("Jon Pardi", 2, Integer::sum);
                    artistPoints.merge("Carrie Underwood", 1, Integer::sum);
                    break;
                case "Cozy acoustic vibes":
                    artistPoints.merge("Carrie Underwood", 1, Integer::sum);
                    artistPoints.merge("Kacey Musgraves", 2, Integer::sum);
                    break;
                case "Smooth jazz":
                    artistPoints.merge("Michael Bublé", 1, Integer::sum);
                    artistPoints.merge("Kamasi Washington", 1, Integer::sum);
                    break;
                case "Reflective smooth songs":
                    artistPoints.merge("Kendrick Lamar", 1, Integer::sum);
                    break;
                case "Soft rock ballads":
                    artistPoints.merge("Foo Fighters", 1, Integer::sum);
                    break;
                case "Emotional blues and soul":
                    artistPoints.merge("Gary Clark Jr.", 2, Integer::sum);
                    artistPoints.merge("Keb' Mo'", 1, Integer::sum);
                    break;
                case "Upbeat hits to turn traffic time into a sing-along session":
                    artistPoints.merge("Kid Cudi", 1, Integer::sum);
                    artistPoints.merge("Gary Clark Jr.", 1, Integer::sum);
                    break;
                case "Uplifting stories in song":
                    artistPoints.merge("Jon Pardi", 1, Integer::sum);
                    artistPoints.merge("Kirk Franklin", 1, Integer::sum);
                    artistPoints.merge("Sunday Service Choir", 1, Integer::sum);
                    break;
                case "Energizing rock songs to beat the traffic blues":
                    artistPoints.merge("Foo Fighters", 1, Integer::sum);
                    artistPoints.merge("Green Day", 1, Integer::sum);
                    break;
                case "Pumping electronic beats":
                    artistPoints.merge("Calvin Harris", 1, Integer::sum);
                    artistPoints.merge("Fred again..", 1, Integer::sum);
                    break;
                case "Pop anthems for mood lifting":
                    artistPoints.merge("Dua Lipa", 1, Integer::sum);
                    artistPoints.merge("Kacey Musgraves", 1, Integer::sum);
                    break;
                default:
                    break;
            }
        }
    }

   public List<Artist> getTopThreeArtists() {
    List<Artist> artists = new ArrayList<>();
    // iterate through each entry in the artistPoints map
    for (Map.Entry<String, Integer> entry : artistPoints.entrySet()) {
        String artistName = entry.getKey();
        int points = entry.getValue();
        artists.add(new Artist(artistName, points));
    }

    // sort the list of artists based on points in descending order
    Collections.sort(artists, new Comparator<Artist>() {
        @Override
        public int compare(Artist a1, Artist a2) {
            return Integer.compare(a2.getPoints(), a1.getPoints()); // Reversed order
        }
    });

    // return the top three artists or less if fewer than three artists are available
    return artists.subList(0, Math.min(3, artists.size()));
}

}
