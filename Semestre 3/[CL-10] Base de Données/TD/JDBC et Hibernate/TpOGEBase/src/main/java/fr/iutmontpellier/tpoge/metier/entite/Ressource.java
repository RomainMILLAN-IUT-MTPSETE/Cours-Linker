package fr.iutmontpellier.tpoge.metier.entite;

public class Ressource {

    private int idRessource;

    private String nom;

    public Ressource(String nom) {
        this.nom = nom;
    }

    public Ressource() {

    }

    public int getIdRessource() {
        return idRessource;
    }

    public void setIdRessource(int idRessource) {
        this.idRessource = idRessource;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return this.nom;
    }
}
