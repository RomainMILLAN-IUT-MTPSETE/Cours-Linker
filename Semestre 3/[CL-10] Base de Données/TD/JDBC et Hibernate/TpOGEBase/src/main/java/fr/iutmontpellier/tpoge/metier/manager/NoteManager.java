package fr.iutmontpellier.tpoge.metier.manager;

import fr.iutmontpellier.tpoge.metier.entite.Note;

/**
 * Classe de service qui permet de gérer différentes notes affectés à des étudiants dans des ressources.
 * Singleton
 */
public class NoteManager {

    private final static NoteManager INSTANCE = new NoteManager();

    private NoteManager() {}

    public static NoteManager getInstance() {
        return INSTANCE;
    }

    /**
     * Instancie un objet {@link Note} puis le sauvegarde dans la source de données via le repository
     * L'étudiant et la ressource concernés seront récupérés via la source de données afin d'être affecté à l'instance
     * de {@link Note} créé.
     * @param idEtudiant : Identifiant de l'étudiant à qui la note est attribué
     * @param idRessource : Identifiant de la ressource en lien avec la note
     * @param note
     */
    public void addNoteToEtudiant(int idEtudiant, int idRessource, int note) {

    }

    /**
     * Récupère une instance de {@link Note} depuis la source de données, met à jour sa valeur de note puis
     * enregistre la mise à jour de l'entité via le repository
     * @param idNote : identifiant de la note à modifier
     * @param note : nouvelle valeur pour la note
     */
    public void updateNote(int idNote, int note) {

    }

    /**
     * Supprime une {@link Note} sur la source de données via le repository
     * @param idNote : identifiant de la note à supprimer
     */
    public void deleteNote(int idNote) {

    }

    /**
     * Récupère une instance d'une {@link Note} depuis la source de données via le repository
     * @param idNote : identifiant de la note à récupérer
     */
    public Note getNote(int idNote) {
        return null;
    }
}
