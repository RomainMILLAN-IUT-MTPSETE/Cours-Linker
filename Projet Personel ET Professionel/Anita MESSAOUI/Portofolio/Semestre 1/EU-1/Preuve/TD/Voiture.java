class Voiture{
    String nom;
    int vitesse;
    int position;
    int sens;

    public Voiture(String nom, int vitesse) {
        this.nom = nom;
        this.vitesse = vitesse;
        this.sens = sens;
    }
    public Voiture(){
        this.nom = "CHARRADE";
        this.vitesse = 1;
    }

    public String getNom() {
        return this.nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getVitesse() {
        return this.vitesse;
    }
    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public int getPosition() {
        return this.position;
    }
    public void setPosition(int position) {
        this.position = position;
    }

    public String toString(){
        return "Nom: " + this.nom + ", Vitesse: " + this.vitesse + ", Position: " + this.position + " Sens: " + this.sens;
    }
    public void toString2(){
        for(int o=0; o<this.position; o++){
            System.out.print("-");
        }
        char nom1 = this.nom.charAt(0);
        System.out.println(nom1);
    }
    public String leNom(){
        return this.nom;
    }
    public boolean depasse(int limite){
        boolean depasse = false;
        if(this.position >= limite){
            depasse = true;
        }

        return depasse;
    }
    public void avance(){
        this.position+=this.vitesse;
    }
    public void avanceAl(int max){
        this.position+=this.vitesse*Ut.randomMinMax(1, max);
    }
    public void auDepart(){
        this.position=0;
    }
    public void faitDemiTour(){
        this.sens = this.sens*(-1);
    }







    
    

}