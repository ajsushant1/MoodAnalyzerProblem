package com.bridgelabz.moodanalyzer;

public class MoodAnalyzer {
    private String message;
    //DEFAULT CONSTRUCTOR
    public MoodAnalyzer() {
    }
    //PARAMETERIZED CONSTRUCTOR
    public MoodAnalyzer(String message) {
        this.message = message;
    }
    //PARAMETERIZED METHOD TO SET THE MESSAGE
    public String analyseMood(String message)throws MoodAnalysisException {
        this.message=message;
        return analyseMood();
    }
    //METHOD TO ANALYSE MOOD
    public String analyseMood() throws MoodAnalysisException{
        try {
            if (message.length() == 0) {
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.EMPTY,"You entered Empty mood,Please enter proper mood");
            }
            if (message.contains("Sad")) {
                return "SAD";
            } else {
                return "HAPPY";
            }
        }catch ( NullPointerException e )
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NULL,"You entered null mood,Please enter proper mood");
        }

    }

    //METHOD CHECK TWO OBJECT ARE EQUAL OR NOT
    public boolean equals(Object another){
        if (this.message.equals(((MoodAnalyzer)another).message))
            return true;
        return false;
    }

    //MAIN METHOD
    public static void main(String[] args) {
        System.out.println("/**************************/ WELCOME TO MOOD ANALYZER /**************************/");
        MoodAnalyzer m=new MoodAnalyzer();
        try {
            m.analyseMood(null);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }
}
