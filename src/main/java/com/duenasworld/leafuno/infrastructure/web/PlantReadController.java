package com.duenasworld.leafuno.infrastructure.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** Temporary web endpoint for the repository skeleton. */
@RestController
public class PlantReadController {

    @GetMapping("/")
    public String status() {
        return "Leafuno-Server läuft!";
    }
}
