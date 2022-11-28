package fr.iutmontpellier.tpoge.application.etudiant;

import fr.iutmontpellier.tpoge.metier.entite.Etudiant;
import fr.iutmontpellier.tpoge.metier.entite.Ressource;
import fr.iutmontpellier.tpoge.metier.manager.EtudiantManager;
import fr.iutmontpellier.tpoge.metier.manager.RessourceManager;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditionEtudiantController {

    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private ComboBox<Ressource> ressourceBox;

    @FXML
    private VBox container;

    private int idEtudiant;

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    @FXML
    public void initialize() {
        Platform.runLater(() -> {
            Etudiant etudiant = EtudiantManager.getInstance().getEtudiant(idEtudiant);
            this.nomField.setText(etudiant.getNom());
            this.prenomField.setText(etudiant.getPrenom());
            this.ressourceBox.getItems().addAll(RessourceManager.getInstance().getRessources());
            this.ressourceBox.getSelectionModel().select(etudiant.getRessourceFavorite());
        });
    }

    @FXML
    public void modifierEtudiant() {
        Ressource ressource = this.ressourceBox.getSelectionModel().getSelectedItem();
        String nom = this.nomField.getText();
        String prenom = this.prenomField.getText();
        if(ressource != null && !nom.equals("") && !prenom.equals("")) {
            EtudiantManager.getInstance().updateEtudiant(idEtudiant, nom, prenom, ressource.getIdRessource());
            Stage stage = (Stage) container.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    public void validerFormulaire(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER) {
            this.modifierEtudiant();
        }
    }
}
