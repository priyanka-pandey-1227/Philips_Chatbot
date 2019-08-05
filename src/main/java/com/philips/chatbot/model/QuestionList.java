package com.philips.chatbot.model;

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
       createQuestionList("Do you want to have the Cardiac Output module?");
       createQuestionList("Do you want to have the NMT module?");
       createQuestionList("Do you want to have the Intellibridge module?");
       createQuestionList("Do you want to have the Recorder module?");
       createQuestionList("Do you want to have the Gas module?"); 
    }
    
    private void createQuestionList(String str){
        Question q=new Question();
        q.setQuestion(str);
        questions.add(q);
    }

    
}
