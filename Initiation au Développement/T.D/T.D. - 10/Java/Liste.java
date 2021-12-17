
public class Liste {

    private Maillon tete; 

    /** Constructeur d'une liste vide
     */
    public Liste () { 
	/* TO DO */ 
    }

    /** Constructeur d'une liste a un seul element
     */
    public Liste (int x) { 
    	/* TO DO */
    }
    
  /** @param tabListe est un tableau contenant les elements de la liste
     * Pre-requis : aucun
     */
    public Liste (int[] tabListe) {
	this(); // Liste()
	if (tabListe.length > 0) {
	    this.tete = new Maillon (tabListe[0]);
	    Maillon curThis = this.tete;
	    for (int i = 1 ; i < tabListe.length ; i++) {
		curThis.setSuiv (new Maillon(tabListe[i])); // creation et accrochage du maillon suivant
		curThis = curThis.getSuiv();
	    }
	}
    }

   /**
     * Prerequis: aucun
     * construit une liste completement disjointe de la liste l 
     */
    public Liste (Liste l) { // constructeur par recopie profonde
	this(); 
	if (! l.estVide()) {

	    this.tete = new Maillon (l.tete.getVal());
	    Maillon curThis = this.tete;
	    Maillon curL = l.tete.getSuiv();

	    while (curL != null) {
		curThis.setSuiv (new Maillon(curL.getVal())); // creation et accrochage du maillon suivant
		curThis = curThis.getSuiv();
		curL = curL.getSuiv();
	    }
	}
    }

    public boolean estVide() {
	return (this.tete == null) ;
    }

    public void ajoutTete (int x) {
	Maillon m = new Maillon(x);
	m.setSuiv(this.tete);
	this.tete=m;
    }

    public boolean contient (int x) {
	Maillon courant = this.tete;
	while (courant != null && courant.getVal() != x) {
	    courant = courant.getSuiv(); 
	}
	return courant != null;
    }

    public String toString() {
	String s = "(";
	Maillon courant = this.tete;
	while (courant != null) {
	    s = s + (courant.getVal()) + ((courant.getSuiv() != null)?", ":"");
	    courant = courant.getSuiv();
	}
	return s + ")";
    }

} // end class
