package com.philips.chatbot;

import java.util.Scanner;

public class ChatBot {
	String choice[] = new String[12];
	static QuestionList ql = new QuestionList();
	UtilityFunctions ufun = new UtilityFunctions();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String features[] = new String[10];
		String details[] = new String[4];

		ChatBot obj = new ChatBot();
		details = obj.defaultMessages();
		DatabaseConnection db = new DatabaseConnection();

		for (int i = 0; i < 1; i++) {
			System.out.println("\nC:" + ql.getQuestions().get(0).getQuestion());
			String monitortypes[] = db.showMonitorTypes();// Show all monitor types

			if (monitortypes != null) {
				features[0] = obj.getInput(sc, monitortypes);// Get user selected monitor type

				if (features[0] == null) {
					System.out.println("\nC:Invalid input. Please select any one from the available choices.");
					i = -1;
					continue;// Invalid input, go back to monitor type list
				} else {

					for (i = 0; i < 1; i++) {
						System.out.println("\nC:" + ql.getQuestions().get(1).getQuestion());
						String screen_types[] = db.showScreenTypes(features[0]);

						// If there is only 1 screen type(like in Goldway)-----
						if (screen_types.length == 1) {
							features[1] = screen_types[0];
						} // Otherwise-----
						else {
							features[1] = obj.getInput(sc, screen_types);
						}

						if (features[1] == null) {
							System.out.println("\nC:Invalid input. Please select any one from the available choices.");
							i = -1;
							continue;// Invalid input, go back to screen type list
						} else {

							for (i = 0; i < 1; i++) {
								System.out.println("\nC:" + ql.getQuestions().get(2).getQuestion());
								String screen_sizes[] = db.showScreenSizes(features[0], features[1]);

								features[2] = obj.getInput(sc, screen_sizes);

								if (features[2] == null) {
									System.out.println(
											"\nC:Invalid input. Please select any one from the available choices.");
									i = -1;
									continue;// Invalid input, go back to screen size list

								} else {
									String parameters[] = null;
									if (features[0].equals("Preconfigured")) {
										System.out.println(
												"\nBelow monitor(s) will have preconfigured EDG, SpO2, NIBP, Respiration and Temperature modules.");
										// } else if (features[0].equals("Semi-modular")) {
										// parameters = obj.askModules(sc);
									} else {
										parameters = obj.askModules(sc);
									}
									db.getMonitors(features[0], features[1], features[2]);

									db.insertUsers(details, features, parameters);
								}
							}
						}
					}
				}
			}
		}
	}

	// ---Scanner input-----------
	public String input(Scanner sc, String print) {
		System.out.print(print);
		String choice = sc.next();
		return choice;
	}

	// ---------getInput-----------------

	public String getInput(Scanner sc, String[] array) {
		int a_size = array.length;
		String ch = null;
		choice[2] = input(sc, "You:");

		if (ufun.choiceValidity(choice[2])) {
			int c1 = Integer.parseInt(choice[2]);
			for (int c = 0; c < a_size; c++) {
				if ((c1 - 1) == c) {
					ch = array[c];
					break;
				}
			}
		}
		return ch;
	}

	// -----------Ask Modules--------------
	public String[] askModules(Scanner sc) {
		String parameters[] = new String[5];

		for (int p = 0; p < 5; p++) {
			for (int i = 0; i < 1; i++) {
				System.out.println("\nC:" + ql.getQuestions().get(p + 3).getQuestion());
				
				choice[5] = input(sc,"You:");
				if (ufun.choiceValidity(choice[5])) {
					int c = Integer.parseInt(choice[5]);
					switch (c) {
					case 1:
						parameters[p + 0] = "Yes";
						break;
					case 2:
						parameters[p + 0] = "No";
						break;
					default:
						i = -1;
						System.out.println("\nC:" + ql.getQuestions().get(8).getQuestion());
						continue;
					}
				}else {
					i = -1;
					System.out.println("\nC:" + ql.getQuestions().get(8).getQuestion());
					continue;
				}
			}
		}
		return parameters;
	}

	// ----------Default messages--------------
	public String[] defaultMessages() {
		String details[] = new String[4];
		int greet = (int) (Math.random() * 3 + 1);
		if (greet == 1) {
			System.out.println("C:Hello and Welcome!!");
			input(sc,"You:");
		} else if (greet == 2) {
			System.out.println("C:Hiii!!!");
			input(sc,"You:");
		} else if (greet == 3) {
			System.out.println("C:Hi there! Welcome to Philips!!");
			input(sc,"You:");
		}
		System.out.println("\nC:Please enter your name: ");
		details[0] = input(sc,"You:");
		
		System.out.println("\nC:Please enter your contact number:");
		details[1] = input(sc,"You:");
		
		System.out.println("\nC:Please enter your hospital address:");
		details[2] = input(sc,"You:");
		
		return details;
	}
}
