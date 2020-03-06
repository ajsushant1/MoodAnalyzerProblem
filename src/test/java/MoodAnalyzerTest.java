import com.bridgelabz.moodanalyzer.MoodAnalyzer;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {
    MoodAnalyzer moodAnalyzer=new MoodAnalyzer();
    //TEST CASE TO ANALYSE SAD MOOD
    @Test
    public void givenMessage_WhenMoodSad_ShouldReturnSAD() {
        String mood = moodAnalyzer.analyseMood("I am in Sad Mood");
        Assert.assertEquals("SAD",mood);
    }
    //TEST CASE TO ANALYSE HAPPY OR ANY MOOD
    @Test
    public void givenMessage_WhenMoodHappyOrAny_ShouldReturnHAPPY() {
        String mood = moodAnalyzer.analyseMood("I am in Any Mood");
        Assert.assertEquals("HAPPY",mood);
    }
}
