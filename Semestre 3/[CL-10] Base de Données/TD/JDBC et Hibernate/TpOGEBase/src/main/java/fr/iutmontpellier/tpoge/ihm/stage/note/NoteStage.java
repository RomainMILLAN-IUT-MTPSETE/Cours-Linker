package fr.iutmontpellier.tpoge.ihm.stage.note;

import fr.iutmontpellier.tpoge.application.note.NoteController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class NoteStage extends Stage {

    public NoteStage(int idEtudiant) throws IOException {
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("fr/iutmontpellier/tpoge/ihm/view/note/notes.fxml"));
        Scene scene = new Scene(loader.load(), 300,400);
        NoteController controller = loader.getController();
        controller.setIdEtudiant(idEtudiant);
        this.setScene(scene);
        this.setTitle("Notes");
        this.sizeToScene();
        this.initModality(Modality.APPLICATION_MODAL);
        this.showAndWait();
    }

}
