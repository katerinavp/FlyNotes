package com.katerinavp.flynote;

public class ItemData {

    private int noteId;
    private String title;
    private String note;
    private String deadline;

    public int getNoteId() {
        return noteId;
    }

    public ItemData(int noteId, String title, String note, String deadline) {
        this.noteId = noteId;
        this.title = title;
        this.note = note;
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
    }

    public String getDeadline() {
        return deadline;
    }
}
