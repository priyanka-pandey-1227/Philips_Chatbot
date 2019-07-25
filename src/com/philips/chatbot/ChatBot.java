package com.philips.chatbot;

//import java.util.*;

public class ChatBot {

    public static void main(String[] args) {

        String features[] = new String[10];

        DefaultMessages dm = new DefaultMessages();
        dm.defaultMessages();
        DatabaseConnection db = new DatabaseConnection();
        UtilityFunctions ufun = new UtilityFunctions();
        QuestionList ql = new QuestionList();

        selectMonitorTypes:
        for (int i = 0; i < 1; i++) {
            System.out.println("\nC:" + ql.getQuestions().get(0).getQuestion());
            String monitortypes[] = db.showMonitorTypes();//Show all monitor types

            if (monitortypes != null) {
                features[0] = ufun.getInput(monitortypes);//Get user selected monitor type

                if (features[0] == null) {
                    System.out.println("\nC:Invalid input. Please select any one from the available choices.");
                    i = -1;
                    continue selectMonitorTypes;//Invalid input, go back to monitor type list
                } else {

                    selectScreenTypes:
                    for (i = 0; i < 1; i++) {
                        System.out.println("\nC:" + ql.getQuestions().get(1).getQuestion());
                        String screen_types[] = db.showScreenTypes(features[0]);//Show all screen types of selected monitor type

                        //If there is only 1 screen type(like in Goldway)-----
                        if (screen_types.length == 1) {
                            features[1] = screen_types[0];
                        } //Otherwise-----
                        else {
                            features[1] = ufun.getInput(screen_types);//Get user selected screen type of selected monitor type
                        }

                        if (features[1] == null) {
                            System.out.println("\nC:Invalid input. Please select any one from the available choices.");
                            i = -1;
                            continue selectScreenTypes;//Invalid input, go back to screen type list
                        } else {

                            selectSize:
                            for (i = 0; i < 1; i++) {
                                System.out.println("\nC:" + ql.getQuestions().get(2).getQuestion());
                                String screen_sizes[] = db.showScreenSizes(features[0], features[1]);//show all screen sizes of selected monitor type & screen type
                                features[2] = ufun.getInput(screen_sizes);//Get user selected screen sizes of selected monitor type & screen type
                                if (features[2] == null) {
                                    System.out.println("\nC:Invalid input. Please select any one from the available choices.");
                                    i = -1;
                                    continue selectSize;//Invalid input, go back to screen size list
                                } else {
                                    System.out.print(features[0]);
                                    String parameters[] = null;
                                    if (features[0].equals("Preconfigured")) {
                                        System.out.println("Below monitor(s) will have preconfigured EDG, SpO2, NIBP, Respiration and Temperature modules.");
                                    } else if (features[0].equals("Semi-modular")) {
                                        parameters = ufun.askModules();
                                    } else {
                                        parameters = ufun.askModules();
                                    }
                                    db.getMonitors(features[0], features[1], features[2]);

                                   // db.insertUsers(features, parameters);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    
}
