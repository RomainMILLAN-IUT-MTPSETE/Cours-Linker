
public class Liste {

    private Maillon tete; 

    /** Constructeur d'une liste vide
     */
	public Liste() {
		this.tete = null;
	}

	/** Constructeur d'une liste a un seul element
     */
    public Liste (int x) { 
    	Maillon teteMaillon = new Maillon(x);
		this.tete = teteMaillon;
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

	public int longueur(){
		int resultat = 1;
		Maillon courant = this.tete;

		while(courant.getSuiv() != null){
			resultat++;
			courant = courant.getSuiv();
		}

		return resultat;
	}

	public int somme(){
		int resultat = 0;
		Maillon courant = this.tete;

		while(courant.getSuiv() != null){
			resultat += courant.getVal();
			courant = courant.getSuiv();
		}

		return resultat;
	}

	public int dernierElt(){
		int resultat = 0;
		Maillon courant = this.tete;

		while(courant.getSuiv() != null){
			courant = courant.getSuiv();
		}

		resultat = courant.getVal();
		return resultat;
	}

	public boolean estSupK1(int k){
		return (longueur() >= k);
	}

	public boolean estSupK2 (int k){
		boolean resultat = false;
		int calcul = 1;
		Maillon courant = this.tete;

		while(courant.getSuiv() != null && resultat == false){
			calcul++;
			if(calcul >= k){
				resultat = true;
			}
			courant = courant.getSuiv();
		}

		return  resultat;
	}

	public boolean aLgPaire(){
		return (longueur()%2 == 0);
	}

	public int max(){
		int resultat = 0;
		Maillon courant = this.tete;

		while(courant.getSuiv() != null){
			if(courant.getVal() > resultat){
				resultat = courant.getVal();
			}

			courant = courant.getSuiv();
		}

		return resultat;
	}

	public int occurrences(int nb){
		int resultat = 0;
		Maillon courant = this.tete;

		while(courant.getSuiv() != null){
			if(courant.getVal() == nb){
				resultat++;
			}
			courant = courant.getSuiv();
		}

		return resultat;
	}

	public void ajoutFin(int n){
		Maillon dernier = new Maillon(n);
		Maillon courant = this.tete;

		while(courant.getSuiv() != null){
			courant = courant.getSuiv();
		}

		courant.setSuiv(dernier);
	}

	public void ajoutFinSiAbsent(int n){
		if(this.contient(n) == false){
			ajoutFin(n);
		}
	}

	public Liste extraireImpairsTete(){
		Liste listeThisImpair = new Liste();
		Maillon courant = this.tete;

		while(courant.getSuiv() != null){
			if(courant.getVal()%2!=0){
				listeThisImpair.ajoutTete(courant.getVal());
			}

			courant = courant.getSuiv();
		}

		return listeThisImpair;
	}

	public Liste extraireImpairsQueue(){
		Liste listeThisImpair = new Liste();
		Maillon courant = this.tete;

		while(courant.getSuiv() != null){
			if(courant.getVal()%2!=0){
				if(listeThisImpair.tete == null){
					listeThisImpair.ajoutTete(courant.getVal());
				}else {
					listeThisImpair.ajoutFin(courant.getVal());
				}

			}

			courant = courant.getSuiv();
		}

		return listeThisImpair;
	}

	public void supprOcc(int n){
		boolean resultat = false;

		if(this.tete.getVal() == n){
			this.tete.setSuiv(this.tete.getSuiv());
			resultat = true;
		}

		Maillon courant = this.tete.getSuiv();
		Maillon courantLast = this.tete;

		while(courant.getSuiv() != null && resultat == false){
			if(courant.getVal() == n && resultat == false){
				courant = courantLast.getSuiv();
				courantLast.setSuiv(courant.getSuiv());
				resultat = true;
			}
			courant = courant.getSuiv();
			courantLast = courantLast.getSuiv();
		}

		if(courant.getVal() == n && resultat == false){
			courantLast.setSuiv(null);
			resultat = true;
		}
	}



} // end class
