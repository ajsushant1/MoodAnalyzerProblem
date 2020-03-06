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
    //METHOD TO ANALYSE MOOD
    public String analyseMood() {
        try {
            if (message.contains("Sad")) {
                return "SAD";
            } else {
                return "HAPPY";
            }
        }
        catch (Exception e){
            e.getStackTrace();
        }
        return "HAPPY";
    }

    public static void main(String[] args) {
        System.out.println("/**************************/ WELCOME TO MOOD ANALYZER /**************************/");
    }
}
