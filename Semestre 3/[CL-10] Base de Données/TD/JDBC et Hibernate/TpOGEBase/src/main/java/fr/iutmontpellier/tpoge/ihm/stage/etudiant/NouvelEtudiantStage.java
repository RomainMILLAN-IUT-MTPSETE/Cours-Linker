package fr.iutmontpellier.tpoge.ihm.stage.etudiant;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class NouvelEtudiantStage extends Stage {

    public NouvelEtudiantStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("fr/iutmontpellier/tpoge/ihm/view/etudiant/nouveau.fxml"));
        Scene scene = new Scene(loader.load(), 400, 250);
        this.setScene(scene);
        this.setTitle("Nouvel etudiant");
        this.setResizable(false);
        this.sizeToScene();
        this.initModality(Modality.APPLICATION_MODAL);
        this.showAndWait();
    }
}