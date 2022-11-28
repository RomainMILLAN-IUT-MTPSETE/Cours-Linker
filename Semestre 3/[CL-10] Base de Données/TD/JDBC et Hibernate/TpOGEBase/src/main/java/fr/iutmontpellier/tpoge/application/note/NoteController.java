package fr.iutmontpellier.tpoge.application.note;

import fr.iutmontpellier.tpoge.ihm.stage.note.AjoutNoteStage;
import fr.iutmontpellier.tpoge.metier.entite.Etudiant;
import fr.iutmontpellier.tpoge.metier.entite.Note;
import fr.iutmontpellier.tpoge.metier.manager.EtudiantManager;
import fr.iutmontpellier.tpoge.metier.manager.NoteManager;
import fr.iutmontpellier.tpoge.ihm.stage.note.EditionNoteStage;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.IOException;

public class NoteController {

    @FXML
    private ListView<Note> notes;

    private int idEtudiant;

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    @FXML
    public void initialize() {
        Platform.runLater(() -> {
            this.rafracihirListeNotes();
        });
    }

    @FXML
    public void rafracihirListeNotes() {
        this.notes.setItems(null);
        Etudiant etudiant = EtudiantManager.getInstance().getEtudiant(idEtudiant);
        this.notes.setItems(FXCollections.observableArrayList(etudiant.getNotes()));
    }

    @FXML
    public void ajouterNote() throws IOException {
        AjoutNoteStage ajoutNoteStage = new AjoutNoteStage(this.idEtudiant);
        this.rafracihirListeNotes();
    }

    @FXML
    public void editerNote() throws IOException {
        Note note = this.notes.getSelectionModel().getSelectedItem();
        if(note != null) {
            EditionNoteStage editionNoteStage = new EditionNoteStage(note.getIdNote());
            this.rafracihirListeNotes();
        }
    }

    @FXML
    public void supprimerNote() {
        Note note = this.notes.getSelectionModel().getSelectedItem();
        if(note != null) {
            NoteManager.getInstance().deleteNote(note.getIdNote());
            this.rafracihirListeNotes();
        }
    }
}
