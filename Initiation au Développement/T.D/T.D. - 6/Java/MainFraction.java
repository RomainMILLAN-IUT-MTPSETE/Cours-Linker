
import java.util.Scanner; 
import java.lang.*;

class MainFraction { // Classe de test de Fraction et contenant la fonction principale

    public static void main(String args[]){
	
	Fraction f1, f2, f3, f4; // declaration de 4 variables/instances de type/classe Fraction

	f1 = new Fraction(-4,5); // fabrication d'une instance de la classe Fraction à l'aide du constructeur a deux arguments entiers

	f2 = new Fraction(13,26); // fabrication d'une instance de la classe Fraction à l'aide du constructeur a deux arguments entiers

	f3 = new Fraction("24/36"); // fabrication d'une instance de la classe Fraction à partir d'une chaîne de caractères

	f4 = new Fraction(f2); // fabrication d'une instance de la classe Fraction par recopie de l'instance f2

	System.out.print ("f1 = "); System.out.println (f1.toString());
	System.out.println ("f2 = " + f2.toString()); 
	System.out.println ("f3 = " + f3.toString());
	System.out.println ("f4 = " + f4); // f4 n'etant pas de type String, f4.toString() est invoquee automatiquement : le resultat est concatene a la chaine precedente ("f4 = ")

	/* A COMPLETER A PARTIR D'ICI !! */

	System.out.println(f1.fractionReduite());
    }
}

