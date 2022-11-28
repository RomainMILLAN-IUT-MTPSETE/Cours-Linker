package fr.iutmontpellier.tpoge.ihm.stage.note;

import fr.iutmontpellier.tpoge.application.note.EditionNoteController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class EditionNoteStage extends Stage {

    public EditionNoteStage(int idNote) throws IOException {
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("fr/iutmontpellier/tpoge/ihm/view/note/edition.fxml"));
        Scene scene = new Scene(loader.load(), 300,200);
        EditionNoteController controller = loader.getController();
        controller.setIdNote(idNote);
        this.setScene(scene);
        this.setTitle("Edition d'une note");
        this.sizeToScene();
        this.initModality(Modality.APPLICATION_MODAL);
        this.showAndWait();
    }

}