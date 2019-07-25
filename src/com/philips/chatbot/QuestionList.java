package com.philips.chatbot;

import java.util.ArrayList;
import java.util.List;

public class QuestionList {
    
    private List<Question> questions = new ArrayList<Question>();

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    
    public QuestionList() {
       createQuestionList("Which monitor type you want?");
       createQuestionList("Which screen type you want for your monitor?");
       createQuestionList("Which screen size you want for your monitor?");
       createQuestionList("Do you want to have the ECG module?\n 1. Yes \n 2. No");
       createQuestionList("Do you want to have the SpO2 module?\n 1. Yes \n 2. No");
       createQuestionList("Do you want to have the NIBF module?\n 1. Yes \n 2. No");
       createQuestionList("Do you want to have the Respiration module?\n 1. Yes \n 2. No");
       createQuestionList("Do you want to have the Temperature module?\n 1. Yes \n 2. No"); 
    }
    
    private void createQuestionList(String str){
        Question q=new Question();
        q.setQuestion(str);
        questions.add(q);
    }

    
}
