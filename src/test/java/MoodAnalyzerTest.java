import com.bridgelabz.moodanalyzer.MoodAnalysisException;
import com.bridgelabz.moodanalyzer.MoodAnalyzer;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {
    @Test
    public void givenMessage_WhenMoodSad_ShouldReturnSAD() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Sad Mood");
        String analyseMood = null;
        try {
            analyseMood = moodAnalyzer.analyseMood();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("SAD", analyseMood);
    }

    @Test
    public void givenMessage_WhenMoodHappy_ShouldReturnHAPPY() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Happy Mood");
        String analyseMood = null;
        try {
            analyseMood = moodAnalyzer.analyseMood();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("HAPPY", analyseMood);
    }

    @Test
    public void givenNullMessage_thenThrowException() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        try {
            moodAnalyzer.analyseMood(null);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NULL, e.type);
        }
    }

    @Test
    public void givenEmptyMessage_thenThrowException() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        try {
            moodAnalyzer.analyseMood("");
        } catch (MoodAnalysisException e) {

            Assert.assertEquals(MoodAnalysisException.ExceptionType.EMPTY, e.type);
        }
    }

    @Test
    public void givenMoodAnalyzerClass_WhenProper_ShouldReturnObject() {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer();
            Assert.assertEquals(new MoodAnalyzer(), moodAnalyzer);
        } catch (Exception e) {
            e.getStackTrace();
        }

    }
}
