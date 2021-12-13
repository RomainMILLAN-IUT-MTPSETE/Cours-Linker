import java.util.Random;

import java.util.Random;

public class Orque {
    private int id;
    private Arene arene;
    private int nbOrques = 0;
    private static int[] tabOrques = new int[1000];

    public Orque(Arene arene) {
        this.id = nbOrques;
        this.arene = arene;
    }

    public int Combat(Orque adversaire){
        Random rand = new Random();
        int res = rand.nextInt(2 - 1 + 1) + 1;
        int resultatCombat = -1;

        if(res == 1){
            resultatCombat = this.id;
        }else {
            resultatCombat = adversaire.id;
        }

        return resultatCombat;
    }


}
