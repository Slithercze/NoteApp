package com.example.notesapp.repositories;

import com.example.notesapp.models.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
    @Override
    List<Note> findAll();
    List<Note> findAllByType(String type);
    boolean existsNoteByType(String type);

    @Override
    void deleteById(Long id);
}
