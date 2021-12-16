import Java.EE;

public class Arene{
    private EE ensOrques;

    public Arene(int nbo){
        this.ensOrques = new EE(nbo);
        for (int i=0; i<nbo; i++){
            System.out.print("ID: " + i);
            Orque orque = new Orque(this);
            ensOrques.ajoutElt(orque.getId());
        }
        ensOrques.setCardinal(nbo);
        System.out.println("Cardinal : " + ensOrques.getCardinal());
    }

    public void Bataille(){
        while(ensOrques.getCardinal() > 1){
            int random = Ut.randomMinMax(0, ensOrques.getCardinal()-1);
            Orque orque1 = Orque.getOrqueByID(random);
            random = Ut.randomMinMax(0, ensOrques.getCardinal()-1);
            Orque orque2 = Orque.getOrqueByID(random);

            while(orque1==orque2){
                orque2 = Orque.getOrqueByID(Ut.randomMinMax(0, ensOrques.getCardinal()-1));
            }

            int id_winner = orque1.Combat(orque2);
            ensOrques.retraitElt(id_winner);
        }
    }
}
