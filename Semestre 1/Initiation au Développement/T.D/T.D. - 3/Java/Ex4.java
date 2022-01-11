public class Ex4 {
    public static void main (String[]args){
        int nb;
        nb=2;
        Ut.afficher(nbChiffres(nb));
        Ut.afficher(bChiffreDuCarre(nb));
    }
    public static int nbChiffres (int n){
        int l;l=0;

        while (n!=0){
            n=n/10;
            l=l+1;
        }
        
        return l;
    }
    public static int bChiffreDuCarre (int n){

        n=n*n;

        n=nbChiffres(n);
        
        return n;
    }
}
