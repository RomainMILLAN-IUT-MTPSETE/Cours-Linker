import td8.EE;

public class Arene{
    private EE ensOrques;

    /**
     * Contructeur de la classe arene, il faut passer en parametre le nombre d'Orque qui vont se combattre dans l'arene.
     * @param nbo
     */
    public Arene(int nbo){
        this.ensOrques = new EE(nbo);
        for (int i=0; i<nbo; i++){
            Orque orque = new Orque(this);
            ensOrques.ajoutElt(orque.getId());
        }
        ensOrques.setCardinal(nbo);
    }

    public void Bataille(){
        while(ensOrques.getCardinal() > 1){
            int idO1 = ensOrques.retraitEltAleatoirement();
            int idO2 = ensOrques.retraitEltAleatoirement();

            Orque o1 = Orque.getOrqueByID(idO1);
            Orque o2 = Orque.getOrqueByID(idO2);

            int winner = o1.Combat(o2);

            ensOrques.ajoutElt(winner);
        }

        System.out.println("Le gagnant de l'arene est : " + ensOrques.getEnsTab()[0]);
    }
}
