public class TP1 {
    public static void main(String[] args){
        menu();
    }

    public static void suiteOrOrdre(){
        float n, i, u1, u2, u, uneg, v, p;

        n = 1;
        while(n <= 2){
            Ut.afficherSL("Saissir un nombre entier (> 2) : "); n = Ut.saisirEntier();
        }

        i = 2;
        u1 = 1; u2 = 1; u = 0;
        while(i <= n){
            Ut.afficherSL("-----");
            Ut.afficherSL("i : " + i);
            u = u1 + u2;
            uneg = u-u1;
            v = u/uneg;
            u2 = u1;
            u1 = u;
            Ut.afficherSL("U : " + u);
            Ut.afficherSL("Uneg : " + uneg);
            Ut.afficherSL("Vi : " + v);
            p = (v*v)-v-1;
            Ut.afficherSL("P(Vi) : " + p);
            Ut.afficherSL("-----");
            i++;
        }

    }
    public static void suiteOrEpsilon(){
        float f, e, i, dif, difabs, n, u1, u2, u, uneg, v, p;
        Ut.afficher("Saissir un nombre entier (>2) : "); e = Ut.saisirEntier();
        i = 3;
        dif = e + 1;
        difabs = Math.abs(dif);
        u1 = 1; u2 = 1; u = 0;
        System.out.println("OK 1");
        System.out.println(difabs + " " + e);
        while (e < difabs){
            System.out.println("OK 2");
            Ut.afficherSL("-----");
            Ut.afficherSL("i : " + i);
            u = u1 + u2;
            uneg = u-u1;
            v = u/uneg;
            u2 = u1;
            u1 = u;
            Ut.afficherSL("U : " + u);
            Ut.afficherSL("Uneg : " + uneg);
            Ut.afficherSL("Vi : " + v);
            p = (v*v)-v-1;
            Ut.afficherSL("P(Vi) : " + p);
            i++;

            dif = p-v;
            difabs = Math.abs(dif);
            Ut.afficherSL("Différence : " + dif);
            Ut.afficherSL("Différence Absolue : " + difabs); 
            Ut.afficherSL("-----");
        }
        System.out.println("OK F");
    }
    public static void menu(){
        int n;
        Ut.afficherSL("Bonjour et bienvenue sur le programme nomée TP1.java, voici la liste des choses que vous pouvez faire : ");
        Ut.afficherSL(" 1 - Utiliser le programme suiteOrOrdre()");
        Ut.afficherSL(" 2 - Utiliser le programme suiteOrEpsilon()");
        Ut.afficherSL(" 3 - Fermer le programme");
        n = Ut.saisirEntier();

        if(n == 1){
            suiteOrOrdre();
        }else if(n == 2){
            suiteOrEpsilon();
        }else if(n == 3){
            System.exit(0);
        }else {
            menu();
        }
    }
}