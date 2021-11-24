public class dateCorrection {
    private int jour;
    private int mois;
    private int an;
    private static String[] moisLettres = { " janvier ", " fevrier ", " mars ", " avril ", "mai ", " juin ", " juillet ", " aout ", " septembre ", "octobre ", " novembre ", " decembre " };

    public void dateCorrection(int j, int m, int a) {
        this.jour = j;
        this.mois = m;
        this.an = a;
    }
    public void dateCorrection (dateCorrection aCopier) {
    this . jour = aCopier.getJour() ;
    this . mois = aCopier.getMois() ;
    this . an = aCopier.getAn() ;
    }

    public String toString() {
        // Resultat : une chaine qui represente l’objet this .
        return this.jour + "␣" + moisLettres[this.mois - 1] + "␣" + this.an;
    }


    public int getJour() {
        return this.jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public int getMois() {
        return this.mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getAn() {
        return this.an;
    }

    public void setAn(int an) {
        this.an = an;
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

    public dateCorrection lendemain() {
        dateCorrection newDate = new dateCorrection();
        newDate.incrementer();
        return newDate;
    }

    public boolean egale(dateCorrection d) {
        return this.an == d.an && this.mois == d.getMois() && this.jour == d.getJour();
    }

    public boolean anterieure(dateCorrection d) {
        return this.an < d.an || this.an == d.an && this.mois < d.getMois() || this.an == d.an && this.mois == d.getMois() && this.jour < d.getJour();
    }

    public boolean posterieure(dateCorrection d) {
        return !this.egale(d) && !this.anterieure(d);
    }

    //d1.ecart(d2);
    public int ecart(dateCorrection d) {
        if (this.posterieure(d)) {
            return d.ecart(this);
            //d2.ecart(d1);
        } else {
            int nb = 0;
            dateCorrection copieThis = new dateCorrection();
            while (!copieThis.egale(d)) {
                copieThis.incrementer();
                nb++;
            }
            return nb;
        }
    }
}
