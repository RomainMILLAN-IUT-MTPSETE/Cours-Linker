public class TD1 {
    public static void main(String[] args){
        occurence();
    }

    public static void sommeNombres() {
        int a, b, somme;
        Ut.afficher("Saissiser un premier entier :");
        a = Ut.saisirEntier();
        Ut.afficher("Saissir le second entier :");
        b = Ut.saisirEntier();

        somme = a + b;
        Ut.afficherSL("La somme est :" + somme + " !");
    }
    public static void dixNombresSuivant() {
        int i, a;
        Ut.afficher("Saissiser un nombre entier :"); a = Ut.saisirEntier();
        for (i = 1; i <= 10; i++){
            a++; Ut.afficherSL(a);
        }
    }
    public static void moyenneAges() {
        int i, n, nbr, somme, moyenne;
        somme = 0;
        moyenne = 0;
        Ut.afficher("Saissir le nombre de personne :"); nbr = Ut.saisirEntier();
        for (i = 1; i <= nbr; i++) {
            Ut.afficher("Saissir l'âge de la " + i + "ème personne :"); n = Ut.saisirEntier();
            somme = somme+n;
        }
        moyenne = somme/nbr;
        Ut.afficherSL("La moyenne des ages est de : " + moyenne + "!");
    }
    public static void suiteUn(){
        int i, n, u;
        Ut.afficher("Saissir un nombre :"); n = Ut.saisirEntier();
        u = 1;
        i = 1;
        while (i <= n){
            i++;
            u = u+i;
        }
        Ut.afficherSL("Le dernier nombre est : " + u);
    }
    public static void suiteDeux(){ //Ui-1 + Ui-2
        int u, u1, u2, i, n;
        Ut.afficher("Saissir un nombre : "); n = Ut.saisirEntier();
        u1 = 1;
        u2 = 1;
        u = 0;
        for (i=2; i< n; i++){
            u = u1 + u2;
            u2 = u1;
            u1 = u;
        }
        Ut.afficherSL("Le dernier nombre est : " + u);
    }
    public static void division(){
        int i, n, p, q, r;
        q = 0;
        r = 0;
        Ut.afficher("Saissiser n :"); n = Ut.saisirEntier();
        Ut.afficher("Saissier p :"); p =Ut.saisirEntier();
        while(n >= p){
            q = q + 1;
            n = n - p;
        }
        r = n;
        Ut.afficherSL("Quotient : " + q + " | Reste : " + r);
    }
    public static void pi(){
        float e,a,b,c;
        e = -1;
        while (e <= 0){
            Ut.afficher("Saissir Epsilon : "); e = Ut.saisirEntier();
        }

        a = 3;
        b = 5;
        c = 1-(1/a)+(1/b);

        while (c >= e){
            a = a+4;
            b = b+4;
            c = c+(1/a)+(1/b);
        }
        Ut.afficherSL("La réponse est : " + c);
    }
    public static void occurence(){
        int n,x,i,f,e;

        Ut.afficher("Saisir un nombre d'entier : "); n = Ut.saisirEntier();
        int tabEnt[ ] = new int[n];
        i = 1;
        e = 0;
        while(i <= n){
            Ut.afficher("Saisir le " + i + "ème nombre : "); tabEnt[e] = Ut.saisirEntier();
            e++;
            i++;
        }

        i = 0;
        f = 0;
        Ut.afficher("Sélectionner un nombre : "); x = Ut.saisirEntier();
        while(i < tabEnt.length){
            if(tabEnt[i] == x){
                f = f + 1;
            }
            i++;
        }

        Ut.afficherSL("Il y a exactement " + f + " nombre d'occurence !");
    }
    public static void trie(){
        int n,i,e,w,x;

        Ut.afficher("Saisir un nombre d'entier : "); n = Ut.saisirEntier();
        int tab[ ] = new int[n];
        i = 1;
        e = 0;
        while(i <= n){
            Ut.afficher("Saissir le " + i + "ème nombre : "); tab[e] = Ut.saisirEntier();
            i++; e++;
        }
        i = 0; e = 0; 
    }
}