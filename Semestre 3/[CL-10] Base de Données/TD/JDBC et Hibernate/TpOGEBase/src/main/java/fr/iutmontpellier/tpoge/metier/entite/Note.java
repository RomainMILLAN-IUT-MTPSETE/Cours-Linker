package fr.iutmontpellier.tpoge.metier.entite;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@DynamicUpdate
@Entity
@Table(name = "NotesOGE")
public class Note {

    @Id
    @GenericGenerator(name = "noteAuto", strategy = "increment")
    @GeneratedValue(generator = "noteAuto")
    private int idNote;

    @OneToOne
    @JoinColumn(name = "idEtudiant")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Etudiant etudiant;

    @OneToOne
    @JoinColumn(name = "idRessource")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Ressource ressource;

    @Column
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
