package fr.iutmontpellier.tpoge.application;

import fr.iutmontpellier.tpoge.ihm.stage.note.NoteStage;
import fr.iutmontpellier.tpoge.metier.entite.Etudiant;
import fr.iutmontpellier.tpoge.metier.entite.Ressource;
import fr.iutmontpellier.tpoge.ihm.stage.etudiant.EditionEtudiantStage;
import fr.iutmontpellier.tpoge.ihm.stage.etudiant.NouvelEtudiantStage;
import fr.iutmontpellier.tpoge.ihm.stage.ressource.EditionRessourceStage;
import fr.iutmontpellier.tpoge.ihm.stage.ressource.NouvelleRessourceStage;
import fr.iutmontpellier.tpoge.metier.manager.EtudiantManager;
import fr.iutmontpellier.tpoge.metier.manager.RessourceManager;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.IOException;

public class GestionController {

    @FXML
    private ListView<Ressource> ressources;

    @FXML
    private ListView<Etudiant> etudiants;

    @FXML
    public void initialize() {
        this.rafraichirListeEtudiants();
        this.rafraichirListeRessources();
    }

    @FXML
    public void creerNouvelleRessource() throws IOException {
        NouvelleRessourceStage newRessource = new NouvelleRessourceStage();
        this.rafraichirListeRessources();
    }

    @FXML
    public void editerRessource() throws IOException {
        Ressource ressource = ressources.getSelectionModel().getSelectedItem();
        if(ressource != null) {
            EditionRessourceStage editionRessource = new EditionRessourceStage(ressource.getIdRessource());
            this.rafraichirListeRessources();
            this.rafraichirListeEtudiants();
        }
    }

    @FXML
    public void supprimerRessource() {
        Ressource ressource = ressources.getSelectionModel().getSelectedItem();
        if(ressource != null) {
            RessourceManager.getInstance().deleteRessource(ressource.getIdRessource());
        }
        this.rafraichirListeRessources();
        this.rafraichirListeEtudiants();
    }

    @FXML
    public void creerNouvelEtudiant() throws IOException {
        NouvelEtudiantStage newEtudiant = new NouvelEtudiantStage();
        this.rafraichirListeEtudiants();
    }

    @FXML
    public void editerEtudiant() throws IOException {
        Etudiant etudiant = etudiants.getSelectionModel().getSelectedItem();
        if(etudiant != null) {
            EditionEtudiantStage editionEtudiant = new EditionEtudiantStage(etudiant.getIdEtudiant());
            this.rafraichirListeEtudiants();
        }
    }

    @FXML
    public void supprimerEtudiant() {
        Etudiant etudiant = etudiants.getSelectionModel().getSelectedItem();
        if(etudiant != null) {
            EtudiantManager.getInstance().deleteEtudiant(etudiant.getIdEtudiant());
        }
        this.rafraichirListeEtudiants();
    }

    @FXML
    public void rafraichirListeRessources() {
        this.ressources.setItems(null);
        this.ressources.setItems(FXCollections.observableArrayList(RessourceManager.getInstance().getRessources()));
    }

    @FXML
    public void rafraichirListeEtudiants() {
        this.etudiants.setItems(null);
        this.etudiants.setItems(FXCollections.observableArrayList(EtudiantManager.getInstance().getEtudiants()));
    }

    @FXML
    public void ouvrirNotes() throws IOException {
        Etudiant etudiant = etudiants.getSelectionModel().getSelectedItem();
        if(etudiant != null) {
            new NoteStage(etudiant.getIdEtudiant());
        }
    }
}
