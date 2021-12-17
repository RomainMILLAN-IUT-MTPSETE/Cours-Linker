
public class Maillon {

    private int valeur; 
    private Maillon suivant;

    /** Constructeur vide */
    public Maillon () { 
	suivant = null; 
    }

    /** Constructeur avec la valeur */
    public Maillon (int n) { 
	valeur = n;
	suivant = null; 
    }

    public int getVal() {
	return this.valeur;
    }

    public void setVal(int v) {
	this.valeur = v;
    }

    public Maillon getSuiv () {
	return this.suivant;
    }

    public void setSuiv (Maillon m) {
	this.suivant = m;
    }

    public String toString () {
	return Integer.toString(this.valeur);
    }

    /* -------------------------------------------------- */

}
