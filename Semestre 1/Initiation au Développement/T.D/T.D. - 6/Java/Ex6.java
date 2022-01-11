public class Ex6 {
    public static void main(String[] args){
        Casquette k,s,nadal;
        k = new Casquette();
        s = new Casquette();
        k.afficher();
        s.afficher();
        Ut.afficher(k.getTaille());

        nadal = new Casquette("noir", "carton", 100);
        nadal.afficher();
        Ut.afficherSL(nadal.getTaille() + "\n" + nadal.getMatiere() + "\n" + nadal.getCouleur());
    }
}