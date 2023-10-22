package com.example.notesapp.models;

public class NoteContentDTO {
    private String content;

    public NoteContentDTO(Note note) {
        this.content = note.getContent();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
