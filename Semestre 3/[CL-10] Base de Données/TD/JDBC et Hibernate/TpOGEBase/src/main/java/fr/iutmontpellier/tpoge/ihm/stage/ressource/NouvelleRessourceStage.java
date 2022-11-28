package fr.iutmontpellier.tpoge.ihm.stage.ressource;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class NouvelleRessourceStage extends Stage {

    public NouvelleRessourceStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("fr/iutmontpellier/tpoge/ihm/view/ressource/nouveau.fxml"));
        Scene scene = new Scene(loader.load(), 300,150);
        this.setScene(scene);
        this.setTitle("Nouvelle ressource");
        this.setResizable(false);
        this.sizeToScene();
        this.initModality(Modality.APPLICATION_MODAL);
        this.showAndWait();
    }
}
