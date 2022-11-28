package fr.iutmontpellier.tpoge;

import fr.iutmontpellier.tpoge.ihm.stage.GestionStage;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        new GestionStage();
    }

    public static void main(String[] args) {
        launch();
    }
}
