package com.greenbelly.metraz.model;

public class Message {

    public Message(String message, String tipe) {
        this.message = message;
        this.tipe = tipe;
    }

    String message;
    String tipe;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }
}
