package com.bridgelabz.moodanalyzer;

public class MoodAnalyzer {
    //METHOD TO ANALYSE MOOD
    public String analyseMood(String message) {
        if (message.contains("Sad")){
            return "SAD";
        }
        else {
            return "HAPPY";
        }
    }

    public static void main(String[] args) {
        System.out.println("/**************************/ WELCOME TO MOOD ANALYZER /**************************/");
    }
}
