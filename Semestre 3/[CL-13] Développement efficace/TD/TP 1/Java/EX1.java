public class EX1 {

    public static void main(String[] args) {
        resoudre(6);
    }

    //EX1
    private static int factorielle(int n){
        if(n == 1){
            return 1;
        }else {
            int temp = (factorielle(n-1)*n);
            return temp;
        }
    }

    private static boolean pair(int n){
        if(n == 0){
            return true;
        }else if(n == 1){
            return false;
        }else {
            boolean res = pair(n-2);
            return res;
        }

    }

    private static int sommeImpairs(int n){
        if(n==1){
            return 1;
        }else {
            int temp = sommeImpairs(n-2);
            temp = temp+n;
            return temp;
        }
    }

    private static int puiss(int x, int n){
        if(n == 0){
            return 1;
        }else if(n == 1){
            return x;
        }else {
            int temp = puiss(x, n-1);
            temp = temp*x;
            return temp;
        }
    }

    //EX2
    private static int nbOccAux(int x, int []t, int i){
        int compteur = 0;

        if(i<t.length-1){
            if(t[i] == x){
                compteur = 1+nbOccAux(x, t, i+1);
            }else {
                compteur = nbOccAux(x, t, i+1);
            }
        }else {
            if(t[i] == x){
                compteur++;
            }
        }

        return compteur;
    }
    private static int nbOcc(int x, int []t){
        int nbOcc = 0;

        if(t.length > 0){
            nbOcc = nbOccAux(x, t, 0);
        }

        return nbOcc;
    }
    private static int nbOccAux2(int x, int []t, int i){
        if(i >= t.length){
            return 0;
        }else {
            if(t[i] == x){
                return 1+nbOccAux2(x, t, i+1);
            }else {
                return nbOccAux(x, t, i+1);
            }
        }
    }

    //EX6
    private static boolean estPalindrome(char []t){
        if(t.length == 0){
            return false;
        }else if(t.length == 1){
            return true;
        }else{
            return estPalindromeAux(0, t);
        }
    }
    private static boolean estPalindromeAux(int i, char []t){
        if(t.length < 2){
            return true;
        }else {
            if(i == t.length/2){
                return true;
            }
            if(t[i] == t[t.length-i-1]){
                return estPalindromeAux(i+1, t);
            }

            return false;
        }
    }

    //EX7
    private static boolean estCroissant(int []t){
        if(t.length == 0){
            return true;
        }else if(t.length == 1){
            return true;
        }else {
            return estCroissantAux(0, t);
        }
    }
    private static boolean estCroissantAux(int i, int []t){
        if(t.length<2){
            return false;
        }else {
            if(i<t.length-1){
                if(i!=0){
                    if(t[i]<t[i+1]){
                        return estCroissantAux(i+1, t);
                    }else {
                        return false;
                    }
                }else {
                    return estCroissantAux(i+1, t);
                }
            }else {
                if(t[i-1] < t[i]){
                    return true;
                }else {
                    return false;
                }
            }
        }
    }

    //EX8
    private static int f(int n){
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }else {
            return f(n-1) + f(n-2);
        }
    }
    //F = Suite de fibonnachi

    //EX9
    private static void resoudre(int n){
        resoudreAux(n,1,2 ,3);
    }
    private static void resoudreAux(int n, int i, int k, int j){
        if(n == 1){
            System.out.println(i + " => " + j);
        }else {
            resoudreAux(n-1,i,j,k);
            System.out.println(i + " => " + j);
            resoudreAux(n-1,k,i,j);
        }
    }


    //BONUS
    public static int PGCD(int a, int b){
        if(a==b){
            return a;
        }else {
            if(b<a){
                return PGCD(b, a-b);
            }else {
                return PGCD(a, b-a);
            }
        }
    }
}
