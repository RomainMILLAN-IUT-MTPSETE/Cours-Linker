package fr.iutmontpellier.tpoge.application.ressource;

import fr.iutmontpellier.tpoge.metier.manager.RessourceManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NouvelleRessourceController {

    @FXML
    private TextField nomRessourceField;

    @FXML
    private VBox container;

    public void creerRessource() {
        String nom = nomRessourceField.getText();
        if(!nom.equals("")) {
            RessourceManager.getInstance().createRessource(nom);
            Stage stage = (Stage) container.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    public void validerFormulaire(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER) {
            this.creerRessource();
        }
    }
}
