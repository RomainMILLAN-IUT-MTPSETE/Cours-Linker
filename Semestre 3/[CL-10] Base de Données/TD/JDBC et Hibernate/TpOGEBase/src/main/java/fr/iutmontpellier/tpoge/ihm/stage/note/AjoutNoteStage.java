package fr.iutmontpellier.tpoge.ihm.stage.note;

import fr.iutmontpellier.tpoge.application.note.AjoutNoteController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AjoutNoteStage extends Stage {

    public AjoutNoteStage(int idEtudiant) throws IOException {
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("fr/iutmontpellier/tpoge/ihm/view/note/ajout.fxml"));
        Scene scene = new Scene(loader.load(), 300,200);
        AjoutNoteController controller = loader.getController();
        controller.setIdEtudiant(idEtudiant);
        this.setScene(scene);
        this.setTitle("Ajout d'une note");
        this.sizeToScene();
        this.initModality(Modality.APPLICATION_MODAL);
        this.showAndWait();
    }

}
