package com.School_ERP.entity;

public class Message {

    private String text;

    private String to;

    public Message(String text, String to) {
        this.text = text;
        this.to = to;
    }

    public Message() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
