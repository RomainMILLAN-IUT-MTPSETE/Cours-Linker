
import java.util.Scanner; 
import java.lang.*;

public class Fraction {

    private int numerateur;

    private int denominateur; // Invariant : different de 0

    public Fraction (int num, int denom) {
	/*  Action : constructeur a partir de deux entiers.
	 *  Pre-requis : denom est different de 0 !
	 */
	this.numerateur = num;
	this.denominateur = denom;
    }

    public Fraction (Fraction frac) { // constructeur par recopie frac --> this
	this.numerateur = frac.numerateur;
	this.denominateur = frac.denominateur;
	// Rmq : peut s'écrire en faisant appel au constructeur precedent : this(frac.numerateur, frac.denominateur);
    }

    public Fraction (String strFrac) {
	/* Action : constructeur a partir d'une chaine de caracteres. 
	   Pre-requis : strFrac est une chaine de caracteres correspondant a une fraction, par exemple "13/26" 

	   Remarque pedagogique : parseInt est une methode de classe (Integer) ;
	   split est une methode d'instance (strFrac) 
	*/
	String str[];   // declaration d'un tableau de chaines de caracteres
        str = strFrac.split("/");  // Appel de la methode 'split' d'un objet de classe String : eclatement de strFrac en plusieurs sous-chaines separees par des '/' et rangees
	                           // dans str. Exemple : si strFrac=="13/26", alors str[0] vaut "13" et str[1] vaut "26". 
	this.numerateur = Integer.parseInt(str[0]);    // La methode de la classe Integer permet de traduire la chaine en argument en Integer... 
                                                       // Java sait automatiquement transformer (on dit "caster" ou "faire un cast" - anglicisme) une valeur Integer vers int.
	this.denominateur = Integer.parseInt(str[1]);
    }


    // public void affiche() {
    // !! Mieux vaut utiliser toString() ci-apres !!
    //	System.out.println("Fraction = " + this.numerateur + " / " + this.denominateur);
    // }

    public String toString() {
      return this.numerateur + "/" + this.denominateur; 
    }


    public int getNumerateur() {
        return this.numerateur;
    }

    public void setNumerateur(int numerateur) {
        this.numerateur = numerateur;
    }

    public int getDenominateur() {
        return this.denominateur;
    }

    public void setDenominateur(int denominateur) {
        this.denominateur = denominateur;
    }


    /* A COMPLETER A PARTIR D'ICI !! */

    // Dans terminal : [javac Fraction] ; javac MainFraction.java ;  java MainFraction
    /**
     * Fonction qui réduit une franction en modifiant le THIS.
     * @return
     */
    public String fractionReduiteModifThis(){
        int pgcd = Ut.pgcd(this.numerateur, this.denominateur);

        this.numerateur = this.numerateur/pgcd;
        this.denominateur = this.denominateur/pgcd;

        return this.numerateur + "/" + this.denominateur;
    }

    /**
     * Fonction qui réduit une fraction en ne modifiant pas le THIS.
     * @return
     */
    public Fraction fractionReduiteMNoModifThis(){
        int pgcd = Ut.pgcd(this.numerateur, this.denominateur);

        int numerateur = this.numerateur/pgcd;
        int denominateur = this.denominateur/pgcd;

        Fraction reduite;

        reduite = new Fraction(numerateur, denominateur);

        return reduite;
    }

    /**
     * Fonction qui mutliply et ajoute deux fraction.
     * @return
     */
    public String fractionMultiplyAndPlus(Fraction f){
        System.out.println("This Numerateur: " + this.numerateur + "    F Numerateur: " + f.getNumerateur());        
        System.out.println("This Denominateur: " + this.denominateur + "    F Denominateur: " + f.getDenominateur());

        int thisNum = (this.numerateur*f.getDenominateur());
        int fNum = (f.getNumerateur()*this.denominateur);
        int num = thisNum + fNum;
        int den = this.denominateur*f.getDenominateur();
        
        return this.numerateur*f.getNumerateur() + "/" + this.denominateur*f.getDenominateur() + "\n" + num+"/"+den;
    }

    /**
     * Fonction qui permet de mettre une fraction à la puissance.
     * @param n
     * @return
     */
    public String fractionPuissance(int n){
        return Math.pow(this.numerateur, n) + "/" + Math.pow(this.denominateur, n);
    }

    
}


