public class Main {

    public static void main(String[] args){
        //Ut.afficher("Saisir le paramètre [rangee/serpentin/diagonale/spirale]: "); String param = Ut.saisirChaine();
        Ut.afficher("Saisir une dimension de matrice: "); int n = Ut.saisirEntier();
        carremagique(n);
    }

    /**
     * Permet de définir une matrice.
     * @return
     */
    public static int[][] defT2D(){
        Ut.afficher("Nombre de ligne: "); int l=Ut.saisirEntier();
        Ut.afficher("Nombre de colonne: "); int c=Ut.saisirEntier();
        int[][] mat;
        mat = new int[l][c];

        for(int i=0; i<mat.length; i++){
            for(int n=0; n<mat[i].length; n++){
                Ut.afficher("Saisir [Ligne: " + i + "], [Colonne: " + n +"]: "); mat[i][n]= Ut.saisirEntier();
            }
        }
        return mat;
    }

    /**
     * Permet d'additionner deux matrices entre elles.
     * @param mat1
     * @param mat2
     */
    public static void addTab2D(int[][] mat1, int[][] mat2){
        Mx.display(mat1);
        Mx.display(mat2);

        int res[][] = new int[mat1.length][mat1[0].length];
        for(int i=0; i<mat1.length; i++){
            for(int n=0; n < mat1[i].length; n++){
                res[i][n] = mat1[i][n] + mat2[i][n];
            }
        }

        Ut.afficher("\n");
        Mx.display(res);
    }

    /**
     * Permet de calculer les digonales d'une matrice.
     * @param mat
     */
    public static void addDiagoTab2D(int[][] mat) {
        Mx.display(mat);

        int res = 0;
        int n = 0;
        while (n < mat.length) {
            res = res + mat[n][n];
            Ut.afficherSL("Diagonale) n => " + n + " | value => " + mat[n][n] + " | res => " + res);
            n++;
        }
        n=mat.length-1;
        int i=0;
        while(n>=0 && i<=mat.length-1){
            res = res + mat[i][n];
            Ut.afficherSL("Reverse) n => " + n + " | value => " + mat[n][n] + " | res => " + res);
            n--;
            i++;
        }
        if(mat.length%2 == 1){
            res = res - mat[n/2][n/2];
        }

        Ut.afficher("Le résultat des diagonales est: " + res);
    }

    /**
     * Permet de créer un carée magique.
     * @param n
     * @return
     */
    public static int[][] carremagique(int n){
        if(n%2==0){
            return null;
        }else {
            int[][] mat = new int[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    mat[i][j] = 0;
                }
            }
            Mx.display(mat);
            mat[0][mat[0].length/2]=1;
            Mx.display(mat);

            int l=0;
            int c=mat[0].length/2;
            int la=0;
            int ca=mat[0].length/2;
            int number = 1;
            Ut.afficherSL(l + " " + c);
            for(int i=0; i<(mat.length*mat[0].length)-1; i++){
                number++;
                if(ca+1>=mat[0].length){
                    ca= 0;
                }else{
                    ca++;
                }

                if(la-1<0){
                    la = mat[0].length-1;
                }else {
                    la--;
                }


                if(mat[la][ca] == 0){
                    mat[la][ca] = number;
                    l = la;
                    c = ca;
                }else {
                    la = l+1;
                    ca = c;
                    mat[la][ca] = number;
                }
                Ut.afficherSL("Ligne: " + la + " | Colone: " + ca + " | Nombre: " + number + "\n");

                Mx.display(mat);
            }




            return null;
        }
    }


    public static void rangement(int n, String param){
        if(n > 0){
            if(param.equalsIgnoreCase("rangee")){
                int[][] mat = new int[n][n];
                int number = 1;

                for(int i=0; i<mat.length; i++){
                    for(int j=0; j<mat[0].length; j++){
                        Ut.afficherSL("Ligne: " + i + " | Colonne: " + j + " | Number: " + number);
                        mat[i][j] = number;
                        number++;
                    }
                }

                Mx.display(mat);

            }else if(param.equalsIgnoreCase("serpentin")){
                int[][] mat = new int[n][n];
                int number = 1;
                int i = 0;
                int j = 0;

                while(j<(mat.length*mat.length)){
                    if(i%2==0){
                        if(j+1>=mat[0].length){
                            j = j;
                            if(i+1>=mat.length){
                              break;
                            }else {
                                i--;
                            }
                        }else {
                            j++;
                        }
                        mat[i][j] = number;
                        number++;
                    }else {
                        j--;
                        number++;
                    }
                }

            }else if(param.equalsIgnoreCase("diagonale")){

            }else if(param.equalsIgnoreCase("spirale")){

            }else {
                Ut.afficher("ERROR: Merci de bien rentrée les paramètres !");
            }
        }else {
            Ut.afficher("ERROR: Merci de rentree une dimensions positive !");
        }
    }


}
