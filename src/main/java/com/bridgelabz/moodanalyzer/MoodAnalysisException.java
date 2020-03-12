package com.bridgelabz.moodanalyzer;

public class MoodAnalysisException extends Exception {

    //ENUM
    public enum ExceptionType{
        EMPTY,NULL;
    }
    public ExceptionType type;

    //PARAMETERISED CONSTRUCTOR
    public MoodAnalysisException(ExceptionType type,String message){
        super(message);
        this.type=type;
    }
}
