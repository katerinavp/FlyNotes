package com.example.a8androidpetukhova_diploma;

public class ItemData {

    private String title;
    private String note;
    private String deadline;

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
