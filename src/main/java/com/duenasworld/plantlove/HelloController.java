package com.duenasworld.plantlove;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController – der Telefonanschluss für den Browser * @RestController + @GetMapping("/"):
 * Wenn jemand localhost:8080 im Browser aufruft, antwortet er. Er gehört nur zur Web-Welt, das JavaFX-Fenster
 * nutzt ihn nicht.
 */

@RestController
public class HelloController {

    @GetMapping("/")
    public String hallo() {
        return "PlantLove-Server läuft!";
    }
}
