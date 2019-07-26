package com.philips.chatbot;

import java.util.Scanner;

public class UtilityFunctions {

    String choice[] = new String[12];
    Scanner sc = new Scanner(System.in);
    QuestionList ql = new QuestionList();

    public String getInput(String[] array) {
        int a_size = array.length;
        String ch = null;
        System.out.print("You:");
        choice[2] = sc.nextLine();
        if (choiceValidity(choice[2])) {
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

    public String[] askModules() {
        String parameters[] = new String[5];
        SelectECG:
        for (int i = 0; i < 1; i++) {
            System.out.println("\nC:" + ql.getQuestions().get(3).getQuestion());
            System.out.print("You:");

            choice[5] = sc.nextLine();
            if (choiceValidity(choice[5])) {
                int c = Integer.parseInt(choice[5]);
                switch (c) {
                    case 1:
                        parameters[0] = "Yes";
                        break;
                    case 2:
                        parameters[0] = "No";
                        break;
                    default:
                        i = -1;
                        System.out.println("\nC:Invalid input. Please select your choice again.");
                        continue SelectECG;
                }
            }
        }

        SelectSPO2:
        for (int i = 0; i < 1; i++) {
            System.out.println("\nC:" + ql.getQuestions().get(4).getQuestion());
            System.out.print("You:");

            choice[6] = sc.nextLine();
            if (choiceValidity(choice[6])) {
                int c = Integer.parseInt(choice[6]);
                switch (c) {
                    case 1:
                        parameters[1] = "Yes";
                        break;
                    case 2:
                        parameters[1] = "No";
                        break;
                    default:
                        i = -1;
                        System.out.println("\nC:Invalid input. Please select your choice again.");
                        continue SelectSPO2;
                }
            }
        }

        SelectNIBP:
        for (int i = 0; i < 1; i++) {
            System.out.println("\nC:" + ql.getQuestions().get(5).getQuestion());
            System.out.print("You:");

            choice[7] = sc.nextLine();
            if (choiceValidity(choice[7])) {
                int c = Integer.parseInt(choice[7]);
                switch (c) {
                    case 1:
                        parameters[2] = "Yes";
                        break;
                    case 2:
                        parameters[2] = "No";
                        break;
                    default:
                        i = -1;
                        System.out.println("\nC:Invalid input. Please select your choice again.");
                        continue SelectNIBP;
                }
            }
        }

        SelectResp:
        for (int i = 0; i < 1; i++) {
            System.out.println("\nC:" + ql.getQuestions().get(6).getQuestion());
            System.out.print("You:");

            choice[8] = sc.nextLine();
            if (choiceValidity(choice[8])) {
                int c = Integer.parseInt(choice[8]);
                switch (c) {
                    case 1:
                        parameters[3] = "Yes";
                        break;
                    case 2:
                        parameters[3] = "No";
                        break;
                    default:
                        i = -1;
                        System.out.println("\nC:Invalid input. Please select your choice again.");
                        continue SelectResp;
                }
            }

        }

        SelectTemp:
        for (int i = 0; i < 1; i++) {
            System.out.println("\nC:" + ql.getQuestions().get(7).getQuestion());
            System.out.print("You:");

            choice[9] = sc.nextLine();
            if (choiceValidity(choice[9])) {
                int c = Integer.parseInt(choice[9]);
                switch (c) {
                    case 1:
                        parameters[4] = "Yes";
                        break;
                    case 2:
                        parameters[4] = "No";
                        break;
                    default:
                        i = -1;
                        System.out.println("\nC:Invalid input. Please select your choice again.");
                        continue SelectTemp;
                }
            }

        }
        return parameters;
    }
}
