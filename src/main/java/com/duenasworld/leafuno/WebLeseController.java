package com.duenasworld.leafuno;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * WebLeseController – der Telefonanschluss für den Browser * @RestController + @GetMapping("/"):
 * Wenn jemand localhost:8080 im Browser aufruft, antwortet er. Er gehört nur zur Web-Welt, das JavaFX-Fenster
 * nutzt ihn nicht.
 */

@RestController
public class WebLeseController {

    @GetMapping("/")
    public String hallo() {
        return "Leafuno-Server läuft!";
    }
}
