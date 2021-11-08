public class Ex8 {

    public static void main(String[] args){
        Ut.afficher("Saisir un entier: "); int a = Ut.saisirEntier();
        // Ut.afficher("Saisir un autre entier: "); int b = Ut.saisirEntier();
        pyramide(a);
    }

    /**
     * Fonction pour afficher les unitées des nombres entres les deux entier en paramètre en fontion croissant.
     * @param nb1
     * @param nb2
     */
    public static void afficheNombresCroissants(int nb1, int nb2){
        if(nb1 <= nb2){
            int nb = nb1;
            while(nb <= nb2){
                Ut.afficher(nb%10);
                nb++;
            }
        }else {
            Ut.afficher("ERROR, a > b !");
        }
    }

    /**
     * Fonction pour afficher les unitées des nombres entres les deux entier en paramètre en fontion décroissant.
     * @param nb1
     * @param nb2
     */
    public static void afficheNombresDecroissants(int nb1, int nb2){
        if(nb1 <= nb2){
            int nb = nb2;
            while(nb >= nb1){
                Ut.afficher(nb%10);
                nb--;
            }
        }else {
            Ut.afficher("ERROR a > b !");
        }
    }

    /**
     * Fonction pour créer une pyramide difficile.
     * @param n
     */
    public static void pyramide(int n){
        int dep = n-1;
        int c = 1;
        int nbr = 1;
        int margin = 0;
        int x;
        System.out.println(dep);
        for(int i = 0; i < n; i++){
            for(int o = 0; o<dep; o++){
                Ut.afficher(" ");
            }
            x = margin;
            for(int o = 0; o < margin; o++){
                Ut.afficher((c-x)%10);
                x = x - 1;
            }
            Ut.afficher(c);
            x = x + 1;
            for(int o = 0; o < margin; o++){
                Ut.afficher((c-x)%10);
                x = x + 1;
            }
            Ut.afficher("\n");
            margin++;
            c = c+2;
            dep--;
        }
    }
}
