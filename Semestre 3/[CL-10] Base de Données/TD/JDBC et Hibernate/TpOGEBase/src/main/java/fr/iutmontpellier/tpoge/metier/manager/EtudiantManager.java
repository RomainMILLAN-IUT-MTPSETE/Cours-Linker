package fr.iutmontpellier.tpoge.metier.manager;

import com.gasquet.hrepositories.api.EntityRepository;
import com.gasquet.hrepositories.utils.RepositoryManager;
import fr.iutmontpellier.tpoge.metier.entite.Etudiant;
import fr.iutmontpellier.tpoge.metier.entite.Ressource;
import fr.iutmontpellier.tpoge.stockage.stub.StockageEtudiantDatabase;

import java.util.List;

/**
 * Classe de service qui permet de gérer différents étudiants
 * Singleton
 */
public class EtudiantManager {

    private EntityRepository<Etudiant> repository = RepositoryManager.getRepository(Etudiant.class);

    private final static EtudiantManager INSTANCE = new EtudiantManager();

    private EtudiantManager() {}

    public static EtudiantManager getInstance() {
        return INSTANCE;
    }

    /**
     * Instancie un objet {@link Etudiant} puis le sauvegarde dans la source de données via le repository
     * La ressource favorite est récupérée au niveau dz la source de données pour être affectée à l'étudiant
     * @param nom : Nom de l'étudiant
     * @param prenom : Prénom de l'étudiant
     * @param idRessource : identifiant de la {@link Ressource} favorite de l'étudiant
     */
    public void createEtudiant(String nom, String prenom, int idRessource) {
        repository.create(new Etudiant(nom, prenom, RessourceManager.getInstance().getRessource(idRessource)));
    }

    /**
     * Récupère une instance de {@link Etudiant} depuis la source de données, met à jour son nom, son prénom et
     * sa ressource favorite puis enregistre la mise à jour de l'entité via le repository.
     * La nouvelle ressource favorite est récupérée au niveau dz la source de données pour être affectée à l'étudiant
     * @param idEtudiant : identifiant de l'étudiant à mettre à jour
     * @param nom : nouveau nom de l'étudiant
     * @param prenom : nouveau prénom de l'étudiant
     * @param idRessource : identifiant de la nouvelle ressource favorite de l'étudiant
     */
    public void updateEtudiant(int idEtudiant, String nom, String prenom, int idRessource) {
        repository.findByID(idEtudiant).setNom(nom);
        repository.findByID(idEtudiant).setPrenom(prenom);
        repository.findByID(idEtudiant).setRessourceFavorite(RessourceManager.getInstance().getRessource(idRessource));
    }

    /**
     * Supprime un {@link Etudiant} sur la source de données via le repository
     * @param idEtudiant : identifiant de l'étudiant à supprimer
     */
    public void deleteEtudiant(int idEtudiant) {
        repository.deleteById(idEtudiant);
    }

    /**
     * Récupère une instance d'un {@link Etudiant} depuis la source de données via le repository
     * @param idEtudiant : identifiant de l'étudiant à récupérer
     * @return L'instance de {@link Etudiant} correspondant à l'identifiant
     */
    public Etudiant getEtudiant(int idEtudiant) {
        return repository.findByID(idEtudiant);
    }

    /**
     * Récupère une liste de tous les etudiants depuis la source de données via le repository
     * @return La liste de tous les etudiants.
     */
    public List<Etudiant> getEtudiants() {
        return repository.findAll();
    }
}
