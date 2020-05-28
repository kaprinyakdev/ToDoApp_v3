package com.example.todoapp_v3;


public class Task {

    private String text, creationDate;

    public Task(){

    }

    public Task(String text, String creationDate){
        this.text = text;
        this.creationDate = creationDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

}
