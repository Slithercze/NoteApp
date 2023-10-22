package com.example.notesapp.services;

import com.example.notesapp.models.Note;
import com.example.notesapp.models.NoteExpection;
import com.example.notesapp.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceCRUD implements NoteService {
    private final NoteRepository noteRepository;

    @Autowired
    public NoteServiceCRUD(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note save(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public List<Note> allNotes() {
        return noteRepository.findAll();
    }

    @Override
    public List<Note> noteByType(String type) {
        return noteRepository.findAllByType(type);
    }

    @Override
    public boolean existByType(String type) {
        return noteRepository.existsNoteByType(type);
    }

    @Override
    public Note delete(Long id) throws Exception {
        if (noteRepository.existsById(id)){
            Optional<Note> temp = noteRepository.findById(id);
            noteRepository.deleteById(id);
            return temp.get();
        } else {
            throw new NoteExpection("Note with id " + id + " does not exist");
        }
    }
}
