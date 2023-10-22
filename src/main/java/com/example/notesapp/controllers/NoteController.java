package com.example.notesapp.controllers;

import com.example.notesapp.models.*;
import com.example.notesapp.models.Error;
import com.example.notesapp.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class NoteController {
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService)
    {
        this.noteService = noteService;
    }

    @PostMapping("/api/note")
    public ResponseEntity<?> postNote(@RequestBody Note note){
        return ResponseEntity.ok().body(noteService.save(note));
    }
//    @GetMapping("/api/notes")
//    public ResponseEntity<?> getNotes(){
//        return ResponseEntity.ok().body(noteService.allNotes().stream().map(NoteDTO::new));
//    }
    @GetMapping("/api/notes")
    public ResponseEntity<?> getNoteByType(@RequestParam(value = "type") Optional<String> type){
        if (type.isEmpty()) {
            return ResponseEntity.ok().body(noteService.allNotes().stream().map(NoteDTO::new));
        } else {
            if(noteService.existByType(type.get())){
                return ResponseEntity.ok().body(noteService.noteByType(type.get()));
            } else {
                return ResponseEntity.badRequest().body(new Error(type.get() + " type is not existing"));
            }
        }
    }
    @DeleteMapping("/api/notes/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
       try {
           return ResponseEntity.ok().body(new NoteContentDTO(noteService.delete(id)));
       } catch (NoteExpection e){
           return ResponseEntity.badRequest().body(new Error(e.getMessage()));
       }
    }
}
