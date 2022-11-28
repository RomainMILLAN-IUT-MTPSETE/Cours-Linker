package fr.iutmontpellier.tpoge.application.etudiant;

import fr.iutmontpellier.tpoge.metier.entite.Ressource;
import fr.iutmontpellier.tpoge.metier.manager.EtudiantManager;
import fr.iutmontpellier.tpoge.metier.manager.RessourceManager;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NouvelEtudiantController {

    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private ComboBox<Ressource> ressourceBox;

    @FXML
    private VBox container;

    @FXML
    public void initialize() {
        this.ressourceBox.getItems().addAll(RessourceManager.getInstance().getRessources());
        this.ressourceBox.getSelectionModel().select(0);
    }

    public void creerEtudiant() {
        Ressource ressource = this.ressourceBox.getSelectionModel().getSelectedItem();
        String nom = this.nomField.getText();
        String prenom = this.prenomField.getText();
        if(ressource != null && !nom.equals("") && !prenom.equals("")) {
            EtudiantManager.getInstance().createEtudiant(nom, prenom, ressource.getIdRessource());
            Stage stage = (Stage) container.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    public void validerFormulaire(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER) {
            this.creerEtudiant();
        }
    }
}
