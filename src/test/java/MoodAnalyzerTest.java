import com.bridgelabz.moodanalyzer.MoodAnalyzer;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    //TEST CASE TO ANALYSE SAD MOOD
    @Test
    public void givenMessage_WhenMoodSad_ShouldReturnSAD() {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer("I am in Sad Mood");
        String analyseMood = moodAnalyzer.analyseMood();
        Assert.assertEquals("SAD",analyseMood);
    }
    //TEST CASE TO ANALYSE HAPPY OR ANY MOOD
    @Test
    public void givenMessage_WhenMoodHappyOrAny_ShouldReturnHAPPY() {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer("I am in Happy Mood");
        String analyseMood = moodAnalyzer.analyseMood();
        Assert.assertEquals("HAPPY",analyseMood);
    }
}
