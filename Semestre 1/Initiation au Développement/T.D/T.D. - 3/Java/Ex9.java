public class Ex9 {
    public static void main(String[] args){
        Ut.afficher("Saisir un périmetre n: "); int n = Ut.saisirEntier();
        Ut.afficher(triangle(n));
    }

    /**
     * Fonction pour calculer le nombre de triangles rectangles avec cotes entier en fonction d'un entier n, passer en paramètre.
     * @param perimeter
     * @return
     */
    public static int triangle(int perimeter) {
        int hypo = perimeter;
        int A = perimeter;
        int B = perimeter;
        int res = 0;

        while(hypo>0){
            while(A>0){
                while(B>0){
                    if(hypo*hypo == A*A + B*B && perimeter>hypo+A+B){
                        System.out.println(A + " " + B + " " + hypo + "\n");
                        res++;
                    }
                    B = B-1;
                }
                A = A-1;
                B = A;
            }
            hypo = hypo-1;
            A = hypo;
        }

        return res;
    }

}
