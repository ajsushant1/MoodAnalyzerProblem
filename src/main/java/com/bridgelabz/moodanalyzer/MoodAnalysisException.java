package com.bridgelabz.moodanalyzer;

public class MoodAnalysisException extends Exception {

    //ENUM
    public enum ExceptionType {
        EMPTY, NULL, NO_SUCH_CLASS, NO_SUCH_METHOD, NO_SUCH_FIELD;
    }

    public ExceptionType type;

    //PARAMETERISED CONSTRUCTOR
    public MoodAnalysisException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
