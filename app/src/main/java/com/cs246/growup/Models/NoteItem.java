package com.cs246.growup.Models;

public class NoteItem extends Item {
    private String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String body;

    public NoteItem(String title) {
        super(title);
    }
}
