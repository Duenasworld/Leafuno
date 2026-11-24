package com.duenasworld.leafuno.app;

import com.duenasworld.leafuno.application.InventoryService;
import javafx.application.Application;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * LeafunoApplication – der Türsteher Sie enthält nur die main-Methode, also den allerersten Punkt,
 * wenn du javafx:run startest. Ihre einzige Aufgabe: JavaFX sagen „starte das Fenster"
 * (Application.launch(FxApplication.class, ...)). Sie ist außerdem mit @SpringBootApplication(scanBasePackages = "com.duenasworld.leafuno")
 * markiert – das ist die „Konfigurationsadresse", von der aus Spring weiß, welche Beans es gibt
 */
@SpringBootApplication(scanBasePackages = "com.duenasworld.leafuno")
public class LeafunoApplication {

	static void main(String[] args) {
		Application.launch(FxApplication.class, args);
	}

	@Bean
    CommandLineRunner printPlantSpecies(InventoryService inventoryService) {
		return args -> {
			inventoryService.getAllPlantSpecies().forEach(species ->
					System.out.println(
							species.getName() + " (" + species.getBotanicalName() + ")"
					)
			);
		};
	}
}
