package com.duenasworld.leafuno;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * LeafunoApplication – der Türsteher Sie enthält nur die main-Methode, also den allerersten Punkt,
 * wenn du javafx:run startest. Ihre einzige Aufgabe: JavaFX sagen „starte das Fenster"
 * (Application.launch(FxApplication.class, ...)). Sie ist außerdem mit @SpringBootApplication
 * markiert – das ist die „Konfigurationsadresse", von der aus Spring weiß, welche Beans es gibt
 */
@SpringBootApplication
public class LeafunoApplication {

	static void main(String[] args) {
		Application.launch(FxApplication.class, args);
	}

}
