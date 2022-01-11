public class Ex10 {

    public static void main(String[] args){
        Ut.afficher("Saissir le nombre d'étape: "); int step = Ut.saisirEntier();
        Ut.afficher("Saissir le nombre: "); int n = Ut.saisirEntier();
        syracusiens(step, n);
    }

    public static void syracusiens(int etapes, int nombre){
        boolean verification = false;
        int i = 0;
        int n = nombre;
        while(i<=etapes && verification == false){
            if(n%2==0){
                //PAIR
                n/=2;
            }else {
                //IMPAIR
                n = (3*n + 1);
            }

            if(n == 1){
                verification = true;
                Ut.afficher("Le nombre " + n + " est un nombre syracusien sur " + (i+1) + " étapes.");
            }

            i++;
        }
    }

}
