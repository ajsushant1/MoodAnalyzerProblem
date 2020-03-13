import com.bridgelabz.moodanalyzer.MoodAnalysisException;
import com.bridgelabz.moodanalyzer.MoodAnalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {

    //METHOD TO GET CONSTRUCTOR
    public static Constructor<?> getConstructor(String className, Class<?>... param) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyzerClass = Class.forName(className);
            return moodAnalyzerClass.getConstructor(param);

        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, "No such class");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "No such method");

        }
    }

    //METHOD TO CREATE OBJECT
    public static Object createMoodAnalyzer(Constructor<?> constructor, Object... message) {
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

    //METHOD TO INVOKE CLASS METHOD
    public static Object invokeMethod(Object result, String methodName) throws MoodAnalysisException {
        try {
            return result.getClass().getMethod(methodName).invoke(result);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "No such method");
        }
        return null;
    }

    //METHOD TO SET FIELD OF METHOD
    public static void setFieldValue(Object result, String fieldName, String fieldValue) throws MoodAnalysisException {
        try {
            if (fieldValue == null) {
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NULL, "Field value is Null");
            }
            Field field = result.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(result, fieldValue);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_FIELD, "No such field");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
