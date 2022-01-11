class Date {
    private int jour;
    private int mois;
    private int annee;

    /**
     * Contructeur par défaut de Date
     */
    public Date() {
        this.jour = 01;
        this.mois = 12;
        this.annee = 1999;
    }
    /**
     * Contructeur de Date
     * @param jour
     * @param mois
     * @param annee
     */
    public Date(int jour, int mois, int annee) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }
    public Date(Date aCopier){
        this.jour = aCopier.jour;
        this.mois = aCopier.mois;
        this.annee = aCopier.annee;
    }
    public String [] moisLettres = {"Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Aout", "Septembre", "Octobre", "Novembre", "Decembre"};
    public int an;

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

    public int getAnnee() {
        return this.annee;
    }
    public void setAnnee(int annee) {
        this.annee = annee;
    }
    
    /**
     * La fonction 'incrementation', permet d'incrementer de 1, la date actuelle.
     */
    public void incrementation(){
        switch(this.mois){
            case 1:
                if(this.jour >= 31){
                    this.jour = 1;
                }else {
                    this.jour++;
                }
                break;
            case 2:
                if(this.jour >=28){
                    this.jour = 1;
                }else {
                    this.jour++;
                }
                break;
            case 3:
                if(this.jour >= 31){
                    this.jour = 1;
                }else {
                    this.jour++;
                }
                break;
            case 4:
                if(this.jour >= 30){
                    this.jour = 1;
                }else {
                    this.jour++;
                }
                break;
            case 5:
                if(this.jour >= 31){
                    this.jour = 1;
                }else {
                    this.jour++;
                }
                break;
            case 6:
                if(this.jour >= 30){
                    this.jour = 1;
                }else {
                    this.jour++;
                }
                break;
            case 7:
                if(this.jour >= 31){
                    this.jour = 1;
                }else {
                    this.jour++;
                }
                break;
            case 8:
                if(this.jour >= 31){
                    this.jour = 1;
                }else {
                    this.jour++;
                }
                break;
            case 9:
                if(this.jour >= 30){
                    this.jour = 1;
                }else {
                    this.jour++;
                }
                break;
            case 10:
                if(this.jour >= 31){
                    this.jour = 1;
                }else {
                    this.jour++;
                }
                break;
            case 11:
                if(this.jour >= 30){
                    this.jour = 1;
                }else {
                    this.jour++;
                }
                break;
            case 12:
                if(this.jour >= 31){
                    this.jour = 1;
                }else {
                    this.jour++;
                }
                break;
            default:
                break;
        }
    }

    /**
     * La fonction 'dateAfter', permet de connaitre la date du lendemain de la date mise en parametre.
     */
    public void dateAfter(){
        int jourAfter = this.jour;
        int mois = this.mois;
        int annee = this.annee;
        switch(this.mois){
            case 1:
                if(this.jour >= 31){
                    jourAfter = 1;
                    mois++;
                }else {
                    jourAfter++;
                }
                break;
            case 2:
                if(this.jour >=28){
                    jourAfter = 1;
                    mois++;
                }else {
                    jourAfter++;
                }
                break;
            case 3:
                if(this.jour >= 31){
                    jourAfter = 1;
                    mois++;
                }else {
                    jourAfter++;
                }
                break;
            case 4:
                if(this.jour >= 30){
                    jourAfter = 1;
                    mois++;
                }else {
                    jourAfter++;
                }
                break;
            case 5:
                if(this.jour >= 31){
                    jourAfter = 1;
                    mois++;
                }else {
                    jourAfter++;
                }
                break;
            case 6:
                if(this.jour >= 30){
                    jourAfter = 1;
                    mois++;
                }else {
                    jourAfter++;
                }
                break;
            case 7:
                if(this.jour >= 31){
                    jourAfter = 1;
                    mois++;
                }else {
                    jourAfter++;
                }
                break;
            case 8:
                if(this.jour >= 31){
                    jourAfter = 1;
                    mois++;
                }else {
                    jourAfter++;
                }
                break;
            case 9:
                if(this.jour >= 30){
                    jourAfter = 1;
                    mois++;
                }else {
                    jourAfter++;
                }
                break;
            case 10:
                if(this.jour >= 31){
                    jourAfter = 1;
                    mois++;
                }else {
                    jourAfter++;
                }
                break;
            case 11:
                if(this.jour >= 30){
                    jourAfter = 1;
                    mois++;
                }else {
                    jourAfter++;
                }
                break;
            case 12:
                if(this.jour >= 31){
                    jourAfter = 1;
                    mois = 1;
                    annee++;
                }else {
                    jourAfter++;
                }
                break;
            default:
                break;
        }

        Ut.afficher(jourAfter + "/" + mois + "/" + annee);
    }

    /**
     * La fonction 'afficheDate', permet d'afficher une date en lettre.
     * @return
     */
    public String afficheDate(){
        return this.jour + moisLettres[this.mois-1] + this.annee;
    }


    /**
     * La fonction 'secodneDate', permet de savoir par rapport à une deuxième date, si elle est antérieur, postérieur, ...
     * @param d2
     * @return
     */
    public String secondeDate(Date d2){
        if(this.jour == d2.getJour() && this.mois == d2.getMois() && this.annee == d2.getAnnee()){
            return "Les deux jours sont égaux";
        }else if(this.jour > d2.jour && this.mois >= d2.getMois() && this.annee >= d2.getAnnee()){
            return "Le jour '" +  this.jour+"/"+this.mois+"/"+this.annee + "', est plus postérieure à '"+ d2.getJour()+"/"+d2.getMois()+"/"+d2.getAnnee() +"'";
        }else if(this.jour < d2.jour && this.mois <= d2.getMois() && this.annee <= d2.getAnnee()){
            return "Le jour '" +  this.jour+"/"+this.mois+"/"+this.annee + "', est antérieur à '"+ d2.getJour()+"/"+d2.getMois()+"/"+d2.getAnnee() +"'";
        }else {
            return null;
        }
    }
    public int ecart(dateCorrection dateCorrection) {
        return 0;
    }
    public boolean egale(Date d) {
        return false;
    }
    public boolean egale(Date d) {
        return false;
    }


    
}