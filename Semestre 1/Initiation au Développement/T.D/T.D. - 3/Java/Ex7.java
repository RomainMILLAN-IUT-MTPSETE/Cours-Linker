public class Ex7{
    public static void main(String[] args){
        Ut.afficher("Saisir une hauteur : "); int h = Ut.saisirEntier();
        Ut.afficher("Saisir un caractère : "); char c = Ut.saisirCaractere();
        pyramideSimple(h, c);
    }

    public static void repeteCarac(int nb, char car){
        for (int i = 0; i < nb; i++){
            Ut.afficher(car);
        }
        Ut.afficher("\n");
    }

    public static void pyramideSimple(int h, char c){
        // h=5 et c=*
        int d = h-1; // 4
        int carac = 1; // 1
        while(d >= 0){
            for (int i = 0; i <= d; i++){
                Ut.afficher(" ");
            }
            for (int i = 0; i < carac; i++){
                Ut.afficher(c);
            }
            Ut.afficher("\n");
            d = d-1;
            carac = carac + 2;
        }
    }
}