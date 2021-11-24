public class dateCorrection {
    private int jour;
    private int mois;
    private int an;
    private static String[] moisLettres = { " janvier ", " fevrier ", " mars ", " avril ", "mai ", " juin ",
            " juillet ", " aout ", " septembre ", "octobre ", " novembre ", " decembre " };

    public void Date(int j, int m, int a) {
        this.jour = j;
        this.mois = m;
        this.an = a;
    }

    public void Date ( Date aCopier ) {
    // this ( aCopier .jour , aCopier .mois , aCopier .an); // Date (
    aCopier .jour , aCopier .mois , aCopier .an)
    this . jour = aCopier . jour ;
    this . mois = aCopier . mois ;
    this . an = aCopier . an ;
    }

    public String toString() {
        // Resultat : une chaine qui represente l’objet this .
        return this.jour + "␣" + moisLettres[this.mois - 1] + "␣" + this.an;
    }

    public void incrementer() {
        this.jour++;
        if (this.jour > nbJoursMois()) {
            this.jour = 1;
            this.mois++;
        }
        if (this.mois == 13) {
            this.mois = 1;
            this.an++;
        }
    }

    public int nbJoursMois() {
        if (mois == 4 || mois == 6 || mois == 9 || mois == 11) {
            return 30;
        } else if (mois == 2) {
            if (Ut.estBissextile(an))
                return 29;
            else
                return 28;
        } else {
            return 31;
        }
    }

    public Date lendemain() {
        Date newDate = new Date();
        newDate.incrementation();
        return newDate;
    }

    public boolean egale(Date d) {
        return this.an == d.an && this.mois == d.getMois() && this.jour == d.getJour();
    }

    public boolean anterieure(Date d) {
        return this.an < d.an || this.an == d.an && this.mois < d.getMois() || this.an == d.an && this.mois == d.getMois() && this.jour < d.getJour();
    }

    public boolean posterieure(Date d) {
        return !this.egale(d) && !this.anterieure(d);
    }

    public int ecart(Date d) {
        if (this.posterieure(d)) {
            return d.ecart(this);
        } else {
            int nb = 0;
            Date copieThis = new Date();
            while (!copieThis.egale(d)) {
                copieThis.incrementation();
                nb++;
            }
            return nb;
        }
    }
} // end class
