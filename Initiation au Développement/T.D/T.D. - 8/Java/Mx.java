package Java;

public class Mx {


    /* 
       Mx.sum(int[][] A, int[][] B --> 
       Renvoie la somme de deux matrices (ne marche que si elles ont les
       memes dimonsions)

       Mx.create(int a, int b) -->
       Renvoie une matrice contenant que des 0, avec a lignes et b colonnes

       Mx.edit() -->
       Demande les dimensions de la matrice puis demande chaque coefficient
       (valeur contenue dans la case du tableau)
       (  On peut directement rentrer les dimensions avec
       Mx.edit(int a, int b)   )
       Renvoie la matrice correspondante

       Mx.dislpay(int[][] M) -->
       Renvoie un affichage clair de la matrice M

       Mx.product(int[][] A, int[][]B) -->
       Renvoie la matrice qui correspond a la multiplication de la matrice A
       et de la matrice B

       Mx.product(int[][] M, int k) -->
       Renvoie la multiplication de la matrice M par un entier k

       Mx.max(int[][] M) ou Mx.min(int[][] M)-->
       Renvoie le coefficient maximal ou minimal de la matrice

       Mx.rotate(int[][] M,int n) -->
       Renvoie une rotation de la matrice de n degres
       (  /!\ le nbr de degres doit etre un multiple de 90 comme 0, 90, 180 ou
       encore 270)

       Mx.pow(int[][] M, int n) --> 
       Renvoie la matrice M elevee a la puissance n

       Mx.tr(int[][] M) -->
       Renvoie la trace de la matrice M

    */

    public static void main(String[] args){
        display(create(3,2));
    }


    public static int[][] create(int lignes, int colonnes){
        /* permet de creer une matrice en rentrant ses coefficients 1 a 1 */
        int[][] matrice = new int[lignes][colonnes];
	for (int i=0; i<matrice.length; i++){
	    for (int j=0; j<matrice[0].length; j++){
		displayModif(matrice,i,j);
		matrice[i][j] = T.inputInt();
	    }
	}
        return (matrice);
    }


    public static int[][] create(int taille) {
        int[][] matrice = new int[taille][taille];
        return (matrice);
    }

    public static int[][] create(int lignes, int colonnes, int valeurRemplissage){
        /* creer une matrice dont chaque case contiendra la valeur
           indiquee en parametre */
        int[][] matrice = create(lignes,colonnes);
        for (int i = 0; i<lignes; i++){
            for (int j = 0; j<colonnes; j++){
                matrice[i][j] = valeurRemplissage;
            }
        }
        return(matrice);
    }

    public static int[][] identity(int[] taille){
	return(identity(taille[0],taille[1]));
    }

    public static int[][] identity(int a, int b){
        int[][] matrice = new int[a][b];
        for (int i=0; i<b; i++){
	    matrice[i][i] = 1;
	}
        return(matrice);
    }

    public static int[][] identity(int a){
        return(identity(a,a));
    }

    public static void displayModif(int[][] matrice, int iMod, int jMod){
        /* affiche les valeurs de la matrice sous forme de tableau jusqu'a
	 un '?' qui correspond au coefficient en cours de modification */
	int m = maxCaracteres(matrice);
        int hauteurMatrice = matrice.length;
        int largeurMatrice = matrice[0].length;

	T.display(" ");
        for (int j=0; j<(matrice[0].length*m + 2*matrice[0].length); j++){
		T.display("-");
	    }
        for (int i=0; i<hauteurMatrice; i++){
            T.display("\n|");
            for (int j=0; j<largeurMatrice; j++){
		for (int k=0; k<(m - nbCarac(matrice[i][j])); k++){
			T.display(" ");
		}
		if (i==iMod && j==jMod){
		    if (j==0){
			T.display(" ?");
		    }else{
			T.display("  ?");
		    }
		}
		else{
		    if (j==0){
			T.display(" "+matrice[i][j]);
		    }else{
			T.display("  "+matrice[i][j]);
		    }
		}
	    } 
            T.display(" |");
        }
	T.display("\n ");
	for (int k=0; k<(matrice[0].length*m + 2*matrice[0].length); k++){
	    T.display("-");
	}
	T.lineBreak();
    }

    public static void display(int[][] matrice){
        /* affiche les valeurs de la matrice sous forme de tableau */
	    int m = maxCaracteres(matrice);
        int hauteurMatrice = matrice.length;
        int largeurMatrice = matrice[0].length;

	    System.out.print(" ");
        for (int j=0; j<(matrice[0].length*m + 2*matrice[0].length); j++){
	        System.out.print("-");
	    }
        for (int i=0; i<hauteurMatrice; i++){
            System.out.print("\n|");
            for (int j=0; j<largeurMatrice; j++){
		for (int k=0; k<(m - nbCarac(matrice[i][j])); k++){
		        System.out.print(" ");
		}
		if (j==0){
		    System.out.print(" "+matrice[i][j]);
		}else{
		    System.out.print("  "+matrice[i][j]);
		}
            }
            System.out.print(" |");
        }
	System.out.print("\n ");
	for (int k=0; k<(matrice[0].length*m + 2*matrice[0].length); k++){
		System.out.print("-");
	}
	System.out.print("\n");
    }

    public static int[] size(int[][] matrice){
        /* renvoie un tableau de 2 entiers contenant à l'indice 0
           le nombr de lignes et à l'indice 1 le nbr de colonnes */
        int[] taille = new int[2];
        taille[0] = matrice.length;
        taille[1] = matrice[0].length;
        return(taille);
    }

    public static int[][] sum(int[][] matriceA, int[][] matriceB){
        /* renvoie la somme des 2 matrices en paramètre */
        int hauteurMatrice = matriceA.length;
        int largeurMatrice = matriceA[0].length;

        for (int i=0; i<hauteurMatrice; i++) {
            for (int j = 0; j < largeurMatrice; j++) {
                matriceA[i][j] = matriceA[i][j] + matriceB[i][j];
            }
        }
        return(matriceA);
    }

    public static int[][] difference(int[][] A, int[][] B){
        return (sum(A,product(B,-1)));
    }

    public static int[][] product(int[][] matrice, int k){
        int hauteurMatrice = matrice.length;
        int largeurMatrice = matrice[0].length;

        for (int i=0; i<hauteurMatrice; i++) {
            for (int j = 0; j < largeurMatrice; j++) {
                matrice[i][j] = (matrice[i][j])*k;
            }
        }
        return (matrice);
    }

    public static int[][] product(int[][] A, int[][] B){
        int[] tA = size(A); int[] tB = size(B); int coef;

        int[][] C = create(tA[0]);
        for (int i=0; i<tA[0]; i++){
            for (int j=0; j<tA[0]; j++){
                C[i][j] = 0;
                for (int i1=0; i1<tB[0]; i1++){
                    C[i][j] = C[i][j] + A[i][i1]*B[i1][j];
                }

            }
        }
        return (C);
    }

    public static int[][] pow(int[][] A, int b) {
        if (b == 0){
            return(identity(size(A)));
        }
        else{
            return(product(A,pow(A,b - 1)));
        }
    }

    public static int tr(int[][] A){
	//calcul la trace d'une matrice
        int result = 0;
        for (int i=0; i<A.length; i++){
            result += A[i][i];
        }
        return(result);
    }

    public static int[][] rotate(int[][] M, int n){
	// effectue une rotation de matrice n degres
	// dans le sens direct
	int nbLignes = size(M)[0];
	int nbColonnes = size(M)[1];
	int[][] Mbis = create(nbColonnes,nbLignes);
	
	switch (n%360){
	case 0:
	    return(M);
	case 90:
	    for (int i=0; i<nbLignes; i++){
		for (int j=0; j<nbColonnes; j++){
		    Mbis[T.abs(nbColonnes - 1 - j)][i] = M[i][j];
		}
	    }
	    return(Mbis);
	case 180:
	    Mbis = create(nbLignes,nbColonnes);
	    for (int i=0; i<nbLignes; i++){
		for (int j=0; j<nbColonnes; j++){
		    Mbis[i][j] = M[nbLignes - 1 - i][nbColonnes - 1 - j];
		}
	    }
	    return(Mbis);
	case 270:
	    for (int i=0; i<nbLignes; i++){
		for (int j=0; j<nbColonnes; j++){
		    Mbis[j][T.abs(nbLignes - 1 - i)] = M[i][j];
		}
	    }
	    return(Mbis);

	default:
	    T.display("Rotation is impossibe");
	    return(M);
	}
    }

    public static int[][] rotate(int[][] M){
	return(rotate(M,90));
    }


    public static int max(int[][] M){
	int max = M[0][0];
	for (int i=0; i<M.length; i++){
	    for (int j=0; j<M[0].length; j++){
		if (M[i][j] > max){
		    max = M[i][j];
		}
	    }
	}
	return(max);
    }

    public static int min(int[][] M){
	int max = M[0][0];
	for (int i=0; i<M.length; i++){
	    for (int j=0; j<M[0].length; j++){
		if (M[i][j] < max){
		    max = M[i][j];
		}
	    }
	}
	return(max);
    }


    //attention fonctions a part

    public static int nbCarac(int n){
	if (n >= 0){
	    if (n < 10){
		return(1);
	    }else{
		return(1 + nbCarac(n/10));
	    }
	}else{
	    return(1 + nbCarac(T.abs(n)));
	}
    }

    public static int maxCaracteres(int[][] M){
	return( T.max( nbCarac(max(M)),nbCarac(min(M)) ) );
    }
		       
	    
}
