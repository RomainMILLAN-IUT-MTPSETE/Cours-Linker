class Course {
    Voiture voit1;
    Voiture voit2;
    int longueur;


    public Course(Voiture voit1, Voiture voit2, int longueur) {
        this.voit1 = voit1;
        this.voit2 = voit2;
        this.longueur = longueur;
    }

    public String toString(){
        return "Voiture 1 => " + voit1.toString() + " | Voiture 2 => " + voit2.toString() + " | Longueur => " + this.longueur; 
    }
    public Voiture deroulement(){
        

        return voit1;
    }
}
