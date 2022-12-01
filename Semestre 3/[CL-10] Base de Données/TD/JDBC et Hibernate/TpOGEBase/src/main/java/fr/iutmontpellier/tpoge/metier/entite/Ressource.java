package fr.iutmontpellier.tpoge.metier.entite;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@DynamicUpdate
@Entity
@Table(name = "RessourcesOGE")
public class Ressource {

    @Id
    @GenericGenerator(name = "ressourceAuto", strategy = "increment")
    @GeneratedValue(generator = "ressourceAuto")
    private int idRessource;

    @Column
    private String nom;

    public Ressource(String nom) {
        this.nom = nom;
    }

    public Ressource() { }

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
