class Date {
    private int jour;
    private int mois;
    private int annee;

    public Date() {
        this.jour = 01;
        this.mois = 12;
        this.annee = 1999;
    }
    public Date(int jour, int mois, int annee) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
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

    public int getAnnee() {
        return this.annee;
    }
    public void setAnnee(int annee) {
        this.annee = annee;
    }
    
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


    public String afficheDate(){
        switch(mois){
            case 1:
                return this.jour + " Janvier " + this.annee;
            case 2:
                return this.jour + " Fevrier " + this.annee;
            case 3:
                return this.jour + " Mars " + this.annee;
            case 4:
                return this.jour + " Avril " + this.annee;
            case 5:
                return this.jour + " Mai " + this.annee;
            case 6:
                return this.jour + " Juin " + this.annee;
            case 7:
                return this.jour + " Juillet " + this.annee;
            case 8:
                return this.jour + " Aout " + this.annee;
            case 9:
                return this.jour + " Septembre " + this.annee;
            case 10:
                return this.jour + " Octobre " + this.annee;
            case 11:
                return this.jour + " Novembre " + this.annee;
            case 12:
                return this.jour + " Décembre " + this.annee;
            default:
                return null;
        }
    }


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


    
}    
