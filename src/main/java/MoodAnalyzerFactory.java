import com.bridgelabz.moodanalyzer.MoodAnalysisException;
import com.bridgelabz.moodanalyzer.MoodAnalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {

    //METHOD TO CREATE CONSTRUCTOR
    public static Constructor<?> getConstructor(String className,Class<?> ... param) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyzerClass =  Class.forName(className);
            return moodAnalyzerClass.getConstructor(param);

        }
        catch (ClassNotFoundException e){
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS,"No such class");
        }
        catch (NoSuchMethodException e){
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,"No such method");

        }
    }

    //METHOD TO CREATE OBJECT
    public static Object createMoodAnalyzer(Constructor<?> constructor,Object ... message){
        try {
            return constructor.newInstance(message);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}
