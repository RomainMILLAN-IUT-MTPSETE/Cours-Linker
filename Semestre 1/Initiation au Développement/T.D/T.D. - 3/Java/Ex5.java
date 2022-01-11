public class Ex5 {
    public static void main(String[]args){
        Ut.afficher("Saisir un nombe : "); int n = Ut.saisirEntier();
        Ut.afficherSL(aChiffresTousDifferentsBis(n));
    }

    public static  int[] frequenceChiffres (int n){
        int[] frequence = new int[10];
        int i,r;
        i=0;

        while (n!=0){
            // 15121, r=1
            r = n%10;
            // 1 In frequence[1-1 = 0]
            frequence[r] = frequence[r] + 1;
            // i = i + 1
            i++;
            // 15121 => 1512
            n = n/10;
        }

        // Affichage des valeurs du tableau !
        i =0;
        for(i=0; i<=9; i++){
            Ut.afficherSL(i + " : " + frequence[i]);
        }
        
        return frequence;
    }

    public static boolean aChiffresTousDifferents(int n){

        int[] frequence = new int[10];
        int i,r;
        i = 0;

        while(n != 0){
            r = n%10;
            if(frequence[r] >= 1){
                return false;
            }else {
                frequence[r] = frequence[r] + 1;
            }
            i++;
            n = n/10;
        }

        return true;
        
    }

    public static boolean aChiffresTousDifferentsBis(int n){
        
        int tab[] = frequenceChiffres(n);
        for(int i=0; i<=9; i++){
            if(tab[i] > 1){
                return false;
            }
        }

        return true;
    }
}
