package com.duenasworld.leafuno.presentation.fx;

import com.duenasworld.leafuno.application.HelloService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.stereotype.Component;

/**
 * FxMainController – der Fernbedienung der Oberfläche
 * Gehört zur FXML-Datei: Alle Buttons, Labels und Eingabefelder aus plant-view.fxml steuert man über ihn.
 * Wegen @Component ist auch er eine Spring-Bean – deshalb kannst du ihm Services übergeben.
 */
@Component
public class FxMainController {

    private final HelloService helloService;

    public FxMainController(HelloService helloService) {
        this.helloService = helloService;
    }

    @FXML
    private Label welcomeLabel;

    @FXML
    public void initialize() {
        welcomeLabel.setText(helloService.gruesse());
    }
}