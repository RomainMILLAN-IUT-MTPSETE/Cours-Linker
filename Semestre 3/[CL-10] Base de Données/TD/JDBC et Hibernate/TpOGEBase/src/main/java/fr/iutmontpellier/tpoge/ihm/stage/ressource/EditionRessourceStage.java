package fr.iutmontpellier.tpoge.ihm.stage.ressource;

import fr.iutmontpellier.tpoge.application.ressource.EditionRessourceController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class EditionRessourceStage extends Stage {

    public EditionRessourceStage(int idRessource) throws IOException {
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("fr/iutmontpellier/tpoge/ihm/view/ressource/edition.fxml"));
        Scene scene = new Scene(loader.load(), 300,150);
        EditionRessourceController controller = loader.getController();
        controller.setIdRessource(idRessource);
        this.setScene(scene);
        this.setTitle("Edition ressource");
        this.setResizable(false);
        this.sizeToScene();
        this.initModality(Modality.APPLICATION_MODAL);
        this.showAndWait();
    }
}