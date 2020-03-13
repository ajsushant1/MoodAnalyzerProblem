import com.bridgelabz.moodanalyzer.MoodAnalysisException;
import com.bridgelabz.moodanalyzer.MoodAnalyzer;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

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
            MoodAnalyzer moodAnalyzer1 = new MoodAnalyzer();
            Constructor<?> constructor = MoodAnalyzerFactory.getConstructor("com.bridgelabz.moodanalyzer.MoodAnalyzer");
            Object result = MoodAnalyzerFactory.createMoodAnalyzer(constructor);
            Assert.assertEquals(moodAnalyzer1, result);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Test
    public void givenInvalidMethodParameter_WhenImproper_ShouldThrowException() {
        try {
          MoodAnalyzerFactory.getConstructor("com.bridgelabz.moodanalyzer.MoodAnalyzer", Integer.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }

    @Test
    public void givenInvalidClassName_WhenImproper_ShouldThrowException() {
        try {
          MoodAnalyzerFactory.getConstructor("com.bridgelabz.moodanalyzer.MooAnalyzer", String.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.type);
        }
    }

    @Test
    public void givenMoodAnalyzerClassConstructorWithParameter_WhenProper_ShouldReturnObject() {
        try {
            MoodAnalyzer moodAnalyzer1 = new MoodAnalyzer();
            Constructor<?> constructor = MoodAnalyzerFactory.getConstructor("com.bridgelabz.moodanalyzer.MoodAnalyzer");
            Object result = MoodAnalyzerFactory.createMoodAnalyzer(constructor,"I am in Happy mood");
            Assert.assertEquals(moodAnalyzer1, result);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzerClassConstructorWithParameterAndInvalidMethodParameter_WhenImproper_ShouldThrowException() {
        try {
            Constructor<?> constructor = MoodAnalyzerFactory.getConstructor("com.bridgelabz.moodanalyzer.MoodAnalyzer", Integer.class);
            MoodAnalyzerFactory.createMoodAnalyzer(constructor,"I am in Happy mood");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }

    @Test
    public void givenMoodAnalyzerClassConstructorWithParameterInvalidClassName_WhenImproper_ShouldThrowException() {
        try {
            Constructor<?> constructor = MoodAnalyzerFactory.getConstructor("com.bridgelabz.moodanalyzer.MooAnalyzer", String.class);
            MoodAnalyzerFactory.createMoodAnalyzer(constructor,"I am in Happy mood");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.type);
        }
    }
}
