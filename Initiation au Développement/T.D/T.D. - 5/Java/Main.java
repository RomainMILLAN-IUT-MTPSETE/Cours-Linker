public class Main {
    public static void main(String[] args){
        nombreLePlusFrequent(createTab());
    }

    /**
     * Fonction qui prend en parametre un tableau et qui l'affiche.
     * @param tab
     */
    public static void afficheTab(int[] tab){
        Ut.afficher("| ");
        for(int i=0; i<tab.length; i++){
            Ut.afficher("[" + tab[i] + "]");
        }
        Ut.afficherSL(" |");
    }

    public static int[] createTab(){
        Ut.afficher("Saisir la taille du tableau: "); int taille = Ut.saisirEntier();
        int[] tab = new int[taille];
        for(int i=0; i<taille; i++){
            Ut.afficher("Saisir le " + i + "eme nombre: ");
            tab[i] = Ut.saisirEntier();
        }

        return tab;
    }



    /**
     * Fonction pour afficher une table de multiplication d'un nombre.
     * @param n
     */
    public static void multiplication(int n){
        for (int i=0;i<10;i++){
            int x = i+1;
            int r = n*x;
            String spaces = "";
            String res = "";
            if(x < 10){
                spaces = "  * ";
            }else {
                spaces = " * ";
            }
            if(r < 10){
                res = " " + r;
            }else {
                res = "" + r;
            }
            Ut.afficherSL(x + spaces + n + " = " + res);
        }
    }

    //Chiffre ROMAIN

    /**
     * Fonction pour afficher le chiffre des unitées d'un chiffre romain.
     * @param nb
     */
    public static void chiffreUnite(int nb){
        if(nb >= 0 && nb <= 9){
            switch (nb){
                case 0:
                    System.out.println(" ");
                    break;
                case 1:
                    System.out.println("I");
                    break;
                case 2:
                    System.out.println("II");
                    break;
                case 3:
                    System.out.println("III");
                    break;
                case 4:
                    System.out.println("IV");
                    break;
                case 5:
                    System.out.println("V");
                    break;
                case 6:
                    System.out.println("VI");
                    break;
                case 7:
                    System.out.println("VII");
                    break;
                case 8:
                    System.out.println("VIII");
                    break;
                case 9:
                    System.out.println("IX");
                    break;
                default:
                    System.out.println("ERROR !");
                    break;
            }
        }
    }
    public static void chiffreUniteBis(int nb){
        if(nb >= 0 && nb <= 9){
            String[] tabRomain = new String[10];
            tabRomain[0] = "";
            tabRomain[1] = "I";
            tabRomain[2] = "II";
            tabRomain[3] = "III";
            tabRomain[4] = "IV";
            tabRomain[5] = "V";
            tabRomain[6] = "VI";
            tabRomain[7] = "VII";
            tabRomain[8] = "VIII";
            tabRomain[9] = "IX";
            System.out.print(tabRomain[nb]);
        }
    }

    /**
     * Fonction qui permet de connaitre le chiffre des dizaines en romain.
     * @param nb
     */
    public static void chiffreDizaines(int nb){
        if(nb >= 0 && nb <= 9){
            nb = nb*10;
            String[] dizaines = new String[10];
            dizaines[0] = "";
            dizaines[1] = "X";
            dizaines[2] = "XX";
            dizaines[3] = "XXX";
            dizaines[4] = "XL";
            dizaines[5] = "L";
            dizaines[6] = "LX";
            dizaines[7] = "LXX";
            dizaines[8] = "LXXX";
            dizaines[9] = "XC";
            System.out.print(dizaines[nb/10]);
        }
    }

    /**
     * Fonction qui permet de savoir les chiffres Centaines en romain.
     * @param nb
     */
    public static void chiffreCentaines(int nb){
        if(nb >= 0 && nb <= 9){
            nb = nb*100;
            String[] centaines = new String[10];
            centaines[0] = "";
            centaines[1] = "C";
            centaines[2] = "CC";
            centaines[3] = "CCC";
            centaines[4] = "CD";
            centaines[5] = "D";
            centaines[6] = "DC";
            centaines[7] = "DCC";
            centaines[8] = "DCCC";
            centaines[9] = "CM";
            System.out.print(centaines[nb/100]);
        }
    }

    /**
     * Fonction, qui permet de connaitre un chiffre en millier en romain.
     * @param nb
     */
    public static void chiffreMilliers(int nb){
        if(nb >= 0 && nb <= 3){
            nb = nb*1000;
            String[] milliers = new String[4];
            milliers[0] = "";
            milliers[1] = "M";
            milliers[2] = "MM";
            milliers[3] = "MMM";
            System.out.print(milliers[nb/1000]);
        }
    }

    /**
     * Fonction qui permet de d'afficher un chiffre en nombre romain.
     * @param nb
     */
    public static void afficherEnChiffresRomain(int nb){
        if(nb >= 0 && nb <= 3999){
            chiffreMilliers(nb/1000);
            nb = nb-((nb/1000)*1000);
            chiffreCentaines(nb/100);
            nb= nb-((nb/100)*100);
            chiffreDizaines(nb/10);
            nb = nb-((nb/10)*10);
            chiffreUnite(nb);
        }else {
            chiffreRomain();
        }
    }

    /**
     * Fontion qui permet de demander un nombre à convertir en nombre romain.
     */
    public static void chiffreRomain(){
        Ut.afficher("Saisir un nombre à convertir: "); int nb = Ut.saisirEntier();
        afficherEnChiffresRomain(nb);
    }


    //CARRE PARFAIT

    /**
     * Fonction qui permet de demander un nombre c en paramètre est de connaitre sa racine si ce nom est un carée parfait.
     * @param c
     * @return
     */
    public static int racineParfaite(int c){
        int resultat = 0;
        int n = (int) Math.sqrt(c);
        if(Math.pow(n, 2) == c){
            resultat = n;
        }else {
            resultat = -1;
        }
        return resultat;
    }

    /**
     * Fonction qui permet de déterminer si un nombre passer en paramètre est un Carre Parfait.
     * @param c
     * @return
     */
    public static boolean estCarreParfait(int c){
        boolean resultat = false;
        int n = (int) Math.sqrt(c);
        if(Math.pow(n, 2) == c){
            resultat = true;
        }

        return resultat;
    }

    public static boolean estTriangleRectanglePossible(int a, int b){
        boolean resultat = false;


        return resultat;
    }



    //Nombres d'amis

    public static void estAmis(int a, int b){
        System.out.println(calculSommeDiviser(a));
        System.out.println(calculSommeDiviser(b));

        if(a == calculSommeDiviser(b) && b == calculSommeDiviser(a)){
            Ut.afficher("Les nombres " + a + " " + b + ", sont des amis");
        }else {
            Ut.afficher("Les nombres " + a + " " + b + ", ne sont pas amis");
        }
    }
    public static int calculSommeDiviser(int nb){
        int resultat = 0;
        for(int i=1; i <= nb/2; i++){
            if(nb%i == 0){
                resultat = resultat + i;
            }
        }

        return resultat;
    }



    //COMPACTAGE


    /**
     * Fonction qui prend en parametre un tableau, et qui le range.
     * @param tab
     */
    public static void compactage(int[] tab){
        afficheTab(tab);

        for(int i=0; i<tab.length; i++){
            if(tab[i]==0){
                for(int j=i; j<tab.length; j++){
                    if(tab[j] != 0){
                        tab[i] = tab[j];
                        tab[j] = 0;
                        break;
                    }
                }
            }
        }

        afficheTab(tab);
    }

    /**
     * Fonction qui prend en parametre un tableau, qui supprime les doublons, et le range.
     * @param tab
     */
    public static void compactageSupp(int[] tab){
        afficheTab(tab);
        
        Ut.afficherSL("\nSuppression des doublons ...");
        for(int i=0; i<tab.length-1; i++){
            if(tab[i] !=0){
                for(int j=i+1; j<tab.length; j++){
                    if(tab[j] == tab[i]){
                        tab[j] = 0;
                    }
                }
            }
        }

        compactage(tab);
        Ut.afficher("\n\n");
    }




    //Plateau dans un vecteur

    /**
     * Fonction qui permet de crée un tableau de char.
     * @return
     */
    public static char[] createTabVecteur(){
        Ut.afficher("Saisir la taille du vecteur: "); int taille = Ut.saisirEntier();
        char[] tab = new char[taille];
        for(int i=0; i<taille; i++){
            Ut.afficher("Saisir le " + i + "eme char: ");
            tab[i] = Ut.saisirCaractere();
        }

        afficheTabVecteur(tab);
        return tab;
    }

    /**
     * Fonction qui permet d'afficher un tableau de char.
     * @param tab
     */
    public static void afficheTabVecteur(char[] tab){
        Ut.afficher("| ");
        for(int i=0; i<tab.length; i++){
            Ut.afficher("" + tab[i] + "");
        }
        Ut.afficherSL(" |");
    }

    /**
     * Fonction qui permet de déterminer quelle est le plus lon plateau de vecteur.
     * @param tab
     */
    public static void longPlateauVecteur(char[] tab){
        char moreLong = tab[0];
        int longer = 1;
        int calcul = 0;
        for(int i=0; i<tab.length; i++){
            calcul = 1;
            for(int j=i+1; j<tab.length; j++){
                if(tab[j] == tab[i]){
                    calcul += 1;
                }else {
                    break;
                }
            }

            if(calcul > longer){
                longer = calcul;
                moreLong = tab[i];
            }
        }

        Ut.afficher("Le caractère le plus long est: " + moreLong + ", avec " + longer + " caractères.");
    }



    //NOMBRE LE PLUS FREQUENT
    public static void nombreLePlusFrequent(int[] tab){
        afficheTab(tab);
        int moreLong = tab[0];
        int longerInt = 1;
        int calcul = 1;
        for(int i=0; i<tab.length; i++){
            calcul = 1;
            for(int j=i+1; j<tab.length; j++){
                if(tab[i] == tab[j]){
                    calcul += 1;
                }
            }

            if(calcul > longerInt){
                longerInt = calcul;
                moreLong = tab[i];
            }
        }

        Ut.afficher("\n\n");
        Ut.afficherSL("Le nombre le plus fréquent dans le tableau suivant: ");
        afficheTab(tab);
        Ut.afficher("est: " + moreLong + " avec: " + longerInt + " de fréquence.");
    }
}
