package fr.iutmontpellier.tpoge.ihm.stage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GestionStage extends Stage {

    public GestionStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("fr/iutmontpellier/tpoge/ihm/view/gestion.fxml"));
        Scene scene = new Scene(loader.load(), 600,500);
        this.setScene(scene);
        this.setTitle("OGE");
        this.sizeToScene();
        this.show();
    }

}
