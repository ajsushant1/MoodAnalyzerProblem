import com.bridgelabz.moodanalyzer.MoodAnalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {

    //METHOD TO CREATE MOODANALYZER CLASS OBJECT
    public static MoodAnalyzer createMoodAnalyzer() {
        Class<?> moodAnalyzerClass = null;
        try {
            moodAnalyzerClass = Class.forName("com.bridgelabz.moodanalyzer.MoodAnalyzer");
            Constructor<?> moodConstructor = moodConstructor = moodAnalyzerClass.getConstructor(String.class);
            Object instance = instance = moodConstructor.newInstance();
            return (MoodAnalyzer) instance;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
