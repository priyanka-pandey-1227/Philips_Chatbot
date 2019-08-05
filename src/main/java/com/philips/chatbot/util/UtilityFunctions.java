package com.philips.chatbot.util;

public class UtilityFunctions {

	public boolean isNumber(String choice) {
		boolean number = false;
		try {
			Integer.parseInt(choice);
			number = true;
		} catch (NumberFormatException e) {
			number = false;
		}
		return number;
	}

	public boolean valid(int userChoiceInt, int length) {
		if (userChoiceInt < 0 || userChoiceInt >= length) {
			return false;
		}
		return true;
	}

	public boolean isAlphaNumeric(String str) {
		String expression = "^[a-z.A-Z\\s]+";
		return str.matches(expression);
	}
	
	public boolean isContact(String str) {
		String expression = "^[0-9]{10}$";
		return str.matches(expression);
	}
}