package fr.iutmontpellier.tpoge.application.note;

import fr.iutmontpellier.tpoge.metier.entite.Note;
import fr.iutmontpellier.tpoge.metier.entite.Ressource;
import fr.iutmontpellier.tpoge.metier.manager.NoteManager;
import fr.iutmontpellier.tpoge.metier.manager.RessourceManager;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditionNoteController {

    @FXML
    private TextField noteField;

    @FXML
    private ComboBox<Ressource> ressourceBox;

    @FXML
    private VBox container;

    private int idNote;

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    @FXML
    public void initialize() {
        Platform.runLater(() -> {
            this.ressourceBox.getItems().addAll(RessourceManager.getInstance().getRessources());
            Note note = NoteManager.getInstance().getNote(idNote);
            this.ressourceBox.getSelectionModel().select(note.getRessource());
            this.noteField.setText(Integer.toString(note.getNote()));
        });
    }

    @FXML
    public void modifierNote() {
        try {
            int note = Integer.parseInt(this.noteField.getText());
            if(note < 0 || note > 20) {
                throw new NumberFormatException();
            }
            Ressource ressource = this.ressourceBox.getSelectionModel().getSelectedItem();
            if(ressource != null) {
                NoteManager.getInstance().updateNote(idNote, note);
                Stage stage = (Stage) container.getScene().getWindow();
                stage.close();
            }
        }
        catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Erreur de saisie");
            alert.setContentText("La note saisie est invalide!");
            alert.showAndWait();
        }
    }

    @FXML
    public void validerFormulaire(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER) {
            this.modifierNote();
        }
    }
}
