package fr.iutmontpellier.tpoge.metier.entite;

public class Note {

    private int idNote;

    private Etudiant etudiant;

    private Ressource ressource;

    private int note;

    public int getIdNote() {
        return idNote;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Ressource getRessource() {
        return ressource;
    }

    public void setRessource(Ressource ressource) {
        this.ressource = ressource;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return String.format("%s : %s", this.ressource, this.note);
    }

    public Note() {

    }

    public Note(Etudiant etudiant, Ressource ressource, int note) {
        this.etudiant = etudiant;
        this.ressource = ressource;
        this.note = note;
    }
}
