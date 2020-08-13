package com.example.a8androidpetukhova_diploma;

public class ItemData {

    private int noteId;
    private String title;
    private String note;
    private String deadline;

    public int getNoteId() {
        return noteId;
    }
    public ItemData(String title, String note, String deadline) {
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
