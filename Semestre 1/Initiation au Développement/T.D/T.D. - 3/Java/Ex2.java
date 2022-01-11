public class Ex2 {
    public static void main(String[]args){
        int t;
        Ut.afficher("Entrez la taille du tableau :");t=Ut.saisirEntier();
        Ut.afficher(fmoyenne(saisirTabEntiers(t)));
    }

    public static void afficherTabEntiers (int[]tableau){
        int i;
        for (i=0;i<tableau.length;i++){
            Ut.afficher(tableau[i]);
        }
    }

    public static int[] saisirTabEntiers (int taille) {
        
        int [] tabentier = new int [taille];
        int i,x;
        x=0;
        for(i=0; i<taille; i++){
            Ut.afficher("Saisir le " + x + " entier du tableau : "); tabentier[i] = Ut.saisirEntier();
            if (tabentier[i] %2==0){
                tabentier[i]=tabentier[i]+1;
            }
            x++;
        }

        afficherTabEntiers(tabentier);
        
        return tabentier;
    }

    public static double fmoyenne (int [] tableau){
        int somme,j;
        double moyenne;
        somme=0;
        for (j=0;j<tableau.length;j++){
            somme=somme+tableau[j];
        }
        moyenne=somme/tableau.length;
        return moyenne;
    }
}   
