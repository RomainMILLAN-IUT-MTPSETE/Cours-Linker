package fr.iutmontpellier.tpoge.metier.entite;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EtudiantsOGE")
public class Etudiant {

    @Id
    @GenericGenerator(name = "etudiantAuto", strategy = "increment")
    @GeneratedValue(generator = "etudiantAuto")
    private int idEtudiant;

    @Column
    private String nom;

    @Column
    private String prenom;

    @ManyToOne
    @JoinColumn (name = "idRessource")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Ressource ressourceFavorite;

    @OneToMany(mappedBy="idNote", fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private List<Note> notes = new ArrayList<>();

    public Etudiant(String nom, String prenom, Ressource ressourceFavorite) {
        this.nom = nom;
        this.prenom = prenom;
        this.ressourceFavorite = ressourceFavorite;
    }

    public Etudiant() {

    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Ressource getRessourceFavorite() {
        return ressourceFavorite;
    }

    public void setRessourceFavorite(Ressource ressourceFavorite) {
        this.ressourceFavorite = ressourceFavorite;
    }

    @Override
    public String toString() {
        return String.format("%s %s, ressource favorite : %s", this.prenom, this.nom, this.ressourceFavorite);
    }

    public List<Note> getNotes() {
        return notes;
    }
}
