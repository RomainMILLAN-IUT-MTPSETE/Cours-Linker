import td8.EE;

public class Orque {
    private int id;
    private int pdv;
    private int poids;
    private int agressivite;
    private EE arme;
    private Arene arene;
    private static int nbOrques = 0;
    private static Orque[] tabOrques = new Orque[1000];

    /**
     * Constructeur de la classe Orque
     * @param arene
     */
    public Orque(Arene arene) {
        this.id = nbOrques;
        this.tabOrques[this.id] = this;
        this.arene = arene;
        this.pdv = 100;
        nbOrques++;
    }    

    public String toString(){
        String res ="";
        for(int i=0; i<nbOrques; i++){
            res += "{id: " + i + " | Arene:" + this.getOrqueByID(i).arene + "}";
        }

        return null;
    }

    /**
     * Getter d'ID d'orque
     * @return
     */
    public int getId(){
        return this.id;
    }

    /**
     * On retourne un orque en fonction de son ID
     * @param id
     * @return
     */
    public static Orque getOrqueByID(int id){
        return tabOrques[id];
    }

    /**
     * On fait un combat d'orque et retourne un gagnant
     * @param adversaire
     * @return
     */
    public int Combat(Orque adversaire){
        int random = Java.Ut.randomMinMax(0, 1);
        int resultatCombat = -1;

        if(random == 1){
            resultatCombat = this.id;
        }else {
            resultatCombat = adversaire.getId();
        }
        System.out.println("Le gagnent est : " + resultatCombat);
        return resultatCombat;
    }
    


}
