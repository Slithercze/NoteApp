package com.example.notesapp.services;

import com.example.notesapp.models.Note;

import java.util.List;

public interface NoteService {
    Note save(Note note);
    List<Note> allNotes();
    List<Note> noteByType(String type);
    boolean existByType(String type);

    Note delete(Long id) throws Exception;
}
