package fr.iutmontpellier.tpoge.ihm.stage.etudiant;

import fr.iutmontpellier.tpoge.application.etudiant.EditionEtudiantController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class EditionEtudiantStage extends Stage {

    public EditionEtudiantStage(int idEtudiant) throws IOException {
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("fr/iutmontpellier/tpoge/ihm/view/etudiant/edition.fxml"));
        Scene scene = new Scene(loader.load(), 400, 250);
        EditionEtudiantController controller = loader.getController();
        controller.setIdEtudiant(idEtudiant);
        this.setScene(scene);
        this.setTitle("Edition etudiant");
        this.setResizable(false);
        this.sizeToScene();
        this.initModality(Modality.APPLICATION_MODAL);
        this.showAndWait();
    }
}