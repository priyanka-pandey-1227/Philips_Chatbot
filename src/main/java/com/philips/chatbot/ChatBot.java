package com.philips.chatbot;

import java.io.IOException;
import java.util.Scanner;


import com.philips.chatbot.exception.NoDataException;
import com.philips.chatbot.exception.NoUserInputException;

public class ChatBot {
	static Scanner sc = new Scanner(System.in);
	static ChatbotWorkflowEngine workflow = new ChatbotWorkflowEngine(sc);
	
	public static void main(String[] args) throws IOException {
		String details[] = new String[3];
		try {

			details = defaultMessages(sc);

			String productlist[] = workflow.getProductList();
			  for(String i:productlist){  
				     if(i!=null)
				    	 System.out.println(i);  // use Foreach to print Product list
				   }
			

		} catch (NoDataException e) {
			System.out.println("System Error. Please contact your administrator.");
		} catch (NoUserInputException e) {
			System.out.println("Wrong input given 3 times. Please try again.");		
		}
		finally {
			if(details[0]==null) {
				details[0]="";
			}
			System.out.print("\nPhilia: Thank you "+details[0]+"!"); // This would saved to database in next version
			sc.close();
			System.exit(0);
		}
	}

	// ----------Default messages--------------
	public static String[] defaultMessages(Scanner sc) throws NoDataException, NoUserInputException {
		String details[] = new String[3];
		System.out.println("Hello! I am Philia. Welcome to Philips. ");	
		details[0] = workflow.askDetails(sc,"name");
		details[1] = workflow.askDetails(sc,"contact");
		details[2] = workflow.askDetails(sc,"address");
		return details;
	}
}