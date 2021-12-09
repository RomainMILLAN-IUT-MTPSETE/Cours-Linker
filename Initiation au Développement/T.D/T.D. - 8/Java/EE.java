public class EE {

    private int [] ensTab;
    private int cardinal;

    public EE(int max){
        this.ensTab=new int [max];
        this.cardinal=0;
    }

    public EE(int max, int[]t){
        this.ensTab=new int[max];
        for(int i=0; i<t.length; i++){
            this.ensTab[i]=t[i];
        }
        this.cardinal=t.length;
    }

    public EE(EE autreEnsemble){
        this(autreEnsemble.cardinal, autreEnsemble.ensTab);
    }

    public String toString(){
        String res = "{";
        for(int i=0; i<this.cardinal-1;i++){
            res = res + this.ensTab[i] + ",";
        }
        res += this.ensTab[this.cardinal-1] + "}";
        return res;
    }

    public int getCardinal(){
        return this.cardinal;
    }

    public int contientPratique(int elementR){
        int res=-1;
        boolean trouve=false;
        int i=0;
        while(!trouve && i<this.cardinal){
            if(this.ensTab[i]==elementR){
                trouve=true;
                res=i;
            }
            i++;
        }
        return res;
    }

    public boolean contient(int element){
        boolean res=false;
        if(contientPratique(element) !=-1){
            res=true;
        }
        return res;
    }

    public void ajoutPratique(int e){
        for(int i=0; i<this.cardinal-1; i++){
            if(this.ensTab[i]==e){
                Ut.afficher("L'entier fait déjà partie de l'ensemble");
            }
        }
        System.out.println(this.ensTab.length + " " + this.cardinal);
        if(this.ensTab.length==this.cardinal){
            Ut.afficher("L'ensemble est déjà plein");
        }else {
            this.ensTab[this.cardinal] = e;
            System.out.println("L'entier " + e + " à était ajouté à "  + this.cardinal);
            this.cardinal++;
        }
    }

    public int retraitPratique(int i){
        int res = -1;
        if(0<i && i<this.cardinal){
            res = this.ensTab[i];
            this.ensTab[i]=this.ensTab[this.ensTab.length];
            this.cardinal = this.cardinal -1;
        }
        return res;
    }

    public boolean estVide(){
        boolean res = false;
        if(this.ensTab.length==0){
            res = true;
        }
        return res;
    }

    public boolean deborde(){
        boolean res = false;
        if(this.ensTab.length==this.cardinal){
            res = true;
        }
        return res;
    }

    public boolean retraitElt(int i){
        boolean res = false;
        for(int j=0; j<this.ensTab.length; j++){
            if(i==this.ensTab[j]){
                this.ensTab[j]=this.ensTab[this.ensTab.length];
                this.cardinal=this.cardinal-1;
                res = true;
            }
            else{
                res = false;
            }
        }
        return res;
    }

    public int ajoutElt(int i){
        int res;
        if(this.deborde()){
            res = -1;
        }
        for(int j=0; j<this.cardinal-1; j++){
            if(this.ensTab[j]==i){
                res = 0;
            }
        }
        this.ensTab[this.cardinal]=i;
        this.cardinal++;
        res = 1;
        return res;
    }

    public boolean estInclut(EE e){

        boolean res = true;
        for(int i=0; i<this.cardinal; i++){
            if(!e.contient(this.ensTab[i])){
                res = false;
            }
        }

        return res;

    }

    public boolean estEgal(EE e){
        boolean res = true;
        if(this.cardinal!=e.getCardinal()){
            res = false;
        }else{
            for(int i=0; i<this.cardinal; i++){
                if(this.ensTab[i] != e.ensTab[i]){
                    res = false;
                }
            }
        }


        return res;
    }

    public boolean estDisjoint(EE e){
        boolean res = true;
        for(int i=0; i<this.cardinal; i++){
            for(int j=0; j<e.getCardinal(); j++){
                if(this.ensTab[i] == e.ensTab[j]){
                    res = false;
                }
            }
        }

        return res;
    }

    public String intersection(EE e){
        String intersection = "{";

        int i=0;
        while(i<this.cardinal){
            for(int j=0; j<e.getCardinal(); j++){
                if(this.ensTab[i] == e.ensTab[j]){
                    intersection += this.ensTab[i] + ",";
                    i++;
                }
            }
        }
        intersection += "} ";

        return intersection;
    }

    public String difference(EE b){
        //Faire un A-B
        String res = "{ ";

        for(int i=0; i<this.ensTab.length; i++){
            boolean resultB = true;
            for(int j=0; j<b.ensTab.length; j++){
                if(this.ensTab[i] == b.ensTab[j]){
                    resultB = false;
                }
            }

            if(resultB == true){
                res += this.ensTab[i] + ",";
            }
        }

        res += " }";


        return res;
    }

    


}