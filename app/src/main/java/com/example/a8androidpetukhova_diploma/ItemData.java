package com.example.a8androidpetukhova_diploma;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ItemData {

    @PrimaryKey
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
