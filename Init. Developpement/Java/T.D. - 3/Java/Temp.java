public class Temp {

    public static void main(String[] args){
        Ut.afficher("Saisir une température : "); int temp = Ut.saisirEntier();
        Ut.afficherSL(temp(temp));
    }

    public static String temp(int temp){
        String resultat;
        if(temp < 10){
            resultat = "Froid";
        }else if(temp > 28) {
            resultat = "Chaud";
        }else {
            resultat = "Il fait bon";
        }

        return resultat;
    }
    
}
