package com.philips.chatbot;

public class UtilityFunctions {

    public boolean choiceValidity(String choice) {
        boolean number = false;
        try {
            Integer.parseInt(choice);
            number = true;
        } catch (NumberFormatException e) {
            number = false;
        }
        return number;
    }
}
