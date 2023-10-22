package com.example.notesapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/notes-form")
    public String notesForm(){
        return "notes-form.html";
    }
    @GetMapping("/notes-main")
    public String notesMain(){
        return "notes-main.html";
    }
}
