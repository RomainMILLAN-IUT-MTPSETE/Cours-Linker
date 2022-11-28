package fr.iutmontpellier.tpoge.application.ressource;

import fr.iutmontpellier.tpoge.metier.entite.Ressource;
import fr.iutmontpellier.tpoge.metier.manager.RessourceManager;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditionRessourceController {

    private int idRessource;

    @FXML
    private TextField nomRessourceField;

    @FXML
    private VBox container;

    @FXML
    public void initialize() {
        Platform.runLater(() -> {
            Ressource ressource = RessourceManager.getInstance().getRessource(idRessource);
            this.nomRessourceField.setText(ressource.getNom());
        });
    }

    public void setIdRessource(int idRessource) {
        this.idRessource = idRessource;
    }

    @FXML
    public void modifierRessource() {
        String nom = nomRessourceField.getText();
        if(!nom.equals("")) {
            RessourceManager.getInstance().updateRessource(idRessource, nom);
            Stage stage = (Stage) container.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    public void validerFormulaire(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER) {
            this.modifierRessource();
        }
    }
}
