package com.cs246.growup.Models;

/**
 * NoteItem object
 */
public class NoteItem extends Item {

    public String body;

    /**
     * Non-default constructor.
     * @param title Title to set for the item.
     */
    public NoteItem(String title) {
        super(title);
    }

    /**
     * Gets the body of the note item.
     * @return Returns the body as a String.
     */
    private String getBody() {
        return body;
    }

    /**
     * Sets the body of the note item.
     * @param body String to set as the body.
     */
    public void setBody(String body) {
        this.body = body;
    }
}