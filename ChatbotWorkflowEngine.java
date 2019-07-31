package com.philips.chatbot;

import java.util.Scanner;

import com.philips.chatbot.db.DatabaseConnection;
import com.philips.chatbot.exception.NoDataException;
import com.philips.chatbot.exception.NoUserInputException;
import com.philips.chatbot.model.QuestionList;
import com.philips.chatbot.util.UtilityFunctions;

public class ChatbotWorkflowEngine {
	private static QuestionList ql = new QuestionList();
	private static UtilityFunctions ufun = new UtilityFunctions();
	private static DatabaseConnection db;
	private static String features[] = new String[10];
	private Scanner sc = null;

	public ChatbotWorkflowEngine(Scanner sc) {
		this.sc = sc;
	}

	public String[] getProductList() throws NoDataException, NoUserInputException {
		String optionalModules[];
		String product_list[] = null;
		db = new DatabaseConnection();
		askQuestion(sc, 0, db.showMonitorTypes());

		askQuestion(sc, 1, db.showScreenTypes(features[0]));

		askQuestion(sc, 2, db.showScreenSizes(features[0], features[1]));

		if (features[0].equals("Preconfigured")) {
			System.out.println(
					"\nBelow monitor(s) will have preconfigured EDG, SpO2, NIBP, Respiration and Temperature modules.");
		} else {
			optionalModules = askModules(sc);
		}

		product_list = db.getMonitors(features[0], features[1], features[2]);

		return product_list;

	}

	public void askQuestion(Scanner sc, int questionIndex, String[] answers)
			throws NoDataException, NoUserInputException {
		int i;
		for (i = 0; i < 3; i++) {
			System.out.println("\nChatbot:" + ql.getQuestions().get(questionIndex).getQuestion());

			String options[] = answers;

			// validate if the db data is present else throw an exception
			if (options == null) {
				throw new NoDataException();
			}

			for (int k = 1; k <= answers.length; k++) {
				System.out.print(k + ".");
				System.out.println(answers[k - 1]);
			}

			if (answers.length == 1) {
				features[questionIndex] = answers[0];
				break;
			} else {
				features[questionIndex] = getUserInput(sc, options);
				// System.out.println(features[questionIndex]);
				if (features[questionIndex] == null) {
					System.out.println("\nChatbot:Invalid input. Please select any one from the available choices.");
				} else {
					break;
				}
			}
		}

		if (i == 3) {
			throw new NoUserInputException();
		}
	}
	// ---------getInput-----------------

	public String getUserInput(Scanner sc, String[] answerChoices) {
		System.out.print("Customer:");
		String user_choice = sc.next();
		// System.out.print( user_choice );
		if (ufun.isNumber(user_choice)) {
			int userChoiceInt = Integer.parseInt(user_choice);
			if (ufun.valid(userChoiceInt - 1, answerChoices.length)) {
				return answerChoices[userChoiceInt - 1];
			}
			return null;
		} else {
			return null;
		}
	}

	// -----------Ask Modules--------------
	public String[] askModules(Scanner sc) throws NoDataException, NoUserInputException {
		String parameters[] = new String[5];
		String[] answers = { "Yes", "No" };

		for (int p = 3; p < 8; p++) {
			askQuestion(sc, p, answers);
		}
		return parameters;
	}
	
//===========Ask Customer Details==========

	public static String askDetails(Scanner sc, String str)
			throws NoDataException, NoUserInputException {
		String ans=null;
		int i;
		for (i = 0; i < 3; i++) {
			//System.out.println("\nChatbot:" + ql.getQuestions().get(questionIndex).getQuestion());
			if(str.equals("name")) {
				System.out.println("\nChatbot:May I know your name please?");
				System.out.print("Customer:");
				ans=sc.next();
				if(ufun.isAlphaNumeric(ans)) {
					break;
				}else {
					System.out.println("\nPlease enter the valid name");
				}				
			}if(str.equals("contact")) {
				System.out.println("\nChatbot:Please provide your contact number");
				System.out.print("Customer:");
				ans=sc.next();
				if(ufun.isNumber(ans)) {
					break;
				}else {
					System.out.println("\nPlease enter your valid contact number");
				}
			}
			else if(str.equals("address")){
				System.out.println("\nChatbot:Please provide your hospital address");
				System.out.print("Customer:");
				ans=sc.next();
				break;
			}
			
		}			
		if (i == 3) {
			throw new NoUserInputException();
		}

		return ans;
	}

	
}
