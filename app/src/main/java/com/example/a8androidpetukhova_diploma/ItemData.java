package com.example.a8androidpetukhova_diploma;

public class ItemData implements Comparable<ItemData> {

    private int result;
    private int noteId;
    private String title;
    private String note;
    private String deadline;

    public int getNoteId() {
        return noteId;
    }

    public int compareTo(ItemData deadlineInput) {
        result = this.deadline.compareTo(deadlineInput.deadline);
        return result;
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
