package com.senai.atividade1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Welcome {
    @GetMapping
    public String welcome() {
        return "Boas vindas!";
    }

    @GetMapping ("/dev")
    public String dev() {
        return "Rhana Santos";
    }
}
