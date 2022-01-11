public class Casquette {
    private String couleur;
    private String matiere;
    private int taille;

    public Casquette(){
        this.couleur = "sans";
        this.matiere = "papier";
        this.taille = -1;
    }


    public Casquette(String couleur, String matiere, int taille) {
        this.couleur = couleur;
        this.matiere = matiere;
        this.taille = taille;
    }
    public Casquette(String couleur){
        this.couleur = couleur;
    }
    public Casquette(int taille){
        this.taille = taille;
    }

    public void afficher(){
        Ut.afficher(this.couleur + this.taille);
    }

    public String getCouleur() {
        return this.couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getMatiere() {
        return this.matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public int getTaille() {
        return this.taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }
    

}
