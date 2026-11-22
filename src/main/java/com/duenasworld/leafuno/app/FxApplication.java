package com.duenasworld.leafuno.app;

import com.duenasworld.leafuno.LeafunoApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * FxApplication – der Regisseur - Das eigentliche Fenster. Sie erbt von Application und steuert den
 * Lebenszyklus:
 *
 * init(): startet Spring (den Server und alle Services)
 * start(): baut die Oberfläche auf, indem sie die FXML-Datei lädt – und übergibt Spring als „Fabrik"
 *          für den Controller
 * stop(): fährt Spring herunter, wenn das Fenster geschlossen wird
 */
public class FxApplication extends Application {

    private ConfigurableApplicationContext springContext;

    @Override
    public void init() {
        springContext = new SpringApplicationBuilder(LeafunoApplication.class).run();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/view/fx/plant-view.fxml"));
        loader.setControllerFactory(springContext::getBean);
        Scene scene = new Scene(loader.load(), 400, 300);
        stage.setScene(scene);
        stage.setTitle("Leafuno");
        stage.show();
    }
    @Override
    public void stop() {
        springContext.close();
    }
}