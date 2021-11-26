class Course {
    Voiture voit1;
    Voiture voit2;
    int longueur;


    public Course(Voiture voit1, Voiture voit2, int longueur) {
        this.voit1 = voit1;
        this.voit2 = voit2;
        this.longueur = longueur;
    }

    public String toString(){
        return "Voiture 1 => " + voit1.toString() + " | Voiture 2 => " + voit2.toString() + " | Longueur => " + this.longueur; 
    }

    public Voiture courseAller(){
        Voiture resultat = null;
        this.voit1.auDepart();
        this.voit2.auDepart();

        while(!this.voit1.depasse(this.longueur) || !this.voit2.depasse(this.longueur)){
            int vitesseC = Ut.randomMinMax(1, 4);
            Ut.clearConsole();
            for(int j=0; j<this.longueur; j++){
                System.out.print("_");
            }
            System.out.println("\n\n");
            //Voiture 1
            this.voit1.avanceAl(vitesseC);
            voit1.toString2();
            if(!(this.voit1.depasse(this.longueur))){
                this.voit2.avanceAl(vitesseC);
                voit2.toString2();
                System.out.println("\n");
                for(int j=0; j<this.longueur; j++){
                    System.out.print("_");
                }
                Ut.pause(200);
            }else {
                voit2.toString2();
                System.out.println("\n");
                for(int j=0; j<this.longueur; j++){
                    System.out.print("_");
                }
                Ut.pause(200);
                resultat = voit1;
                break;
            }
        }
        if(this.voit2.depasse(this.longueur)) {
            resultat = voit2;
        }
        System.out.println("\n");
        return resultat;
    }

    
    public Voiture deroulementRetour(){

        Voiture v;
        int arriver_v1 = this.longueur;
        int arriver_v2 = this.longueur;

        int a = Ut.randomMinMax(1,2);


        while (!(this.voit1.depasse(arriver_v1)|| this.voit2.depasse(arriver_v2))){
            Ut.clearConsole();
            this.voit1.toString2();System.out.print("\n");this.voit2.toString2();
            Ut.pause(500);

            a = Ut.randomMinMax(1,2);
            if (a == 1){
            this.voit1.avance();
            if (this.voit1.depasse(arriver_v1)){
                this.voit1.faitDemiTour();
                this.voit1.setPosition(arriver_v1);
                arriver_v1 = 0;
            }
            }else {
                this.voit2.avance();
                if (this.voit2.depasse(arriver_v2)){
                    this.voit2.faitDemiTour();
                    this.voit2.setPosition(arriver_v2);
                    arriver_v2 = 0;

                }

            }



            Ut.clearConsole();
            this.voit1.toString2();System.out.print("\n");this.voit2.toString2();
        }

        if (this.voit1.getPosition() < this.voit2.getPosition()){
            v = this.voit1;
        }else{v = this.voit2;}

        return v;

    }
}
