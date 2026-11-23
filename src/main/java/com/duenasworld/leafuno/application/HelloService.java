package com.duenasworld.leafuno.application;

import org.springframework.stereotype.Service;

/**
 * HelloService – der Facharbeiter enthält Logik/Daten
 * (später: Pflanzen speichern, berechnen, aus einer Datenbank laden…).
 * Wegen @Service erzeugt Spring automatisch eine einzige Instanz davon und verwaltet sie.
 */

@Service
public class HelloService {

    public String greet() {
        return "Leafuno läuft! 🌱 (Gruss aus Spring)";
    }
}
