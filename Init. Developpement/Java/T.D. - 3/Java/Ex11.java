public class Ex11 {

    public static void main(String[] args){
        Ut.afficher("Saisir le nombre: "); int n = Ut.saisirEntier();
        Ut.afficher("Saisir le dénom: "); int denom = Ut.saisirEntier();
        Ut.afficher(eAux(n, denom));
    }

    public static double eAux(int n, double denom){
        if(n == 0){
            return(1+1/(1-1/denom));
        }else {
            return(eAux(n-2, 2+1/((n+1) - 1/denom)));
        }
    }

}
