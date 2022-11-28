package fr.iutmontpellier.tpoge.metier.manager;

import fr.iutmontpellier.tpoge.metier.entite.Ressource;
import fr.iutmontpellier.tpoge.stockage.stub.StockageRessourceDatabase;

import java.util.List;

/**
 * Classe de service qui permet de gérer différentes ressources (matières)
 * Singleton
 */
public class RessourceManager {

    private StockageRessourceDatabase stockageRessourceDatabase = new StockageRessourceDatabase();

    private final static RessourceManager INSTANCE = new RessourceManager();

    private RessourceManager() {}

    public static RessourceManager getInstance() {
        return INSTANCE;
    }

    /**
     * Instancie un objet {@link Ressource} puis le sauvegarde dans la source de données via le repository
     * @param nom : Nom de la {@link Ressource} à créer
     */
    public void createRessource(String nom) {
        System.out.println(nom);
        stockageRessourceDatabase.create(new Ressource(nom));
    }

    /**
     * Récupère une instance de {@link Ressource} depuis la source de données, met à jour son nom puis enregistre la
     * mise à jour de l'entité via le repository
     * @param idRessource : identifiant de la {@link Ressource} à mettre à jour
     * @param nom : nouveau nom pour la {@link Ressource}
     */
    public void updateRessource(int idRessource, String nom) {
        Ressource r = this.getRessource(idRessource);
        r.setNom(nom);
        stockageRessourceDatabase.update(r);
    }

    /**
     * Supprime une {@link Ressource} sur la source de données via le repository
     * @param idRessource : identifiant de la {@link Ressource} à supprimer
     */
    public void deleteRessource(int idRessource) {
        stockageRessourceDatabase.deleteById(idRessource);
    }

    /**
     * Récupère une instance de {@link Ressource} depuis la source de données via le repository
     * @param idRessource : identifiant de la {@link Ressource} à récupérer
     * @return L'instance de {@link Ressource} correspondant à l'identifiant
     */
    public Ressource getRessource(int idRessource) {
        return stockageRessourceDatabase.getById(idRessource);
    }

    /**
     * Récupère une liste de toutes les {@link Ressource} depuis la source de données via le repository
     * @return La liste de toutes les {@link Ressource}
     */
    public List<Ressource> getRessources() {
        return stockageRessourceDatabase.getAll();
    }
}
