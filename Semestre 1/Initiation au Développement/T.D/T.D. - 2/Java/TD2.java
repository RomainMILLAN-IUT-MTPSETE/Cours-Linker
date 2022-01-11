import java.util.ArrayList;
import java.util.HashMap;

public class TD2 {
    public static void main(String[] args){
        ex1112();
    }

    public static void ex12(){
        int j,m,a,somme,i,ms;

        Ut.afficher("Saissir un jour : "); j = Ut.saisirEntier();
        Ut.afficher("Saissir un mois : "); m = Ut.saisirEntier();
        Ut.afficher("Saissir une année : "); a = Ut.saisirEntier();

        i=1;
        ms = 1;
        somme = 0;
        for(i=1; i < m; i++){
            if(a > 0){
                //Mois 31
                if (ms == 1 || ms == 3 || ms == 5 || ms == 7 || ms == 8 || ms == 10 || ms == 12){
                    somme = somme + 31;
                    ms++;
                }/*Mois 30*/else if(ms == 4 || ms == 6 || ms == 9 || ms == 11){
                    somme = somme + 30;
                    ms++;
                }/*Fevrier*/else if (ms == 2){
                    if(a % 4 == 0 && a % 100 != 0 || a % 400 == 0){
                        somme = somme + 29;
                        ms++;
                    }else {
                        somme = somme + 28;
                        ms++;
                    }
                }else {
                    Ut.afficherSL("ERREUR : Merci de saisir un bon mois !");
                    i = m + 1;
                    somme = 0;
                    ms = 0;
                }
            }
        }
        somme = somme + j;
        Ut.afficherSL("La somme est égale à : " + somme);
    }

    public static void ex121(){
        int j,m,a,somme,i,monthActuall;
        HashMap<Integer, Integer> daysMonths = new HashMap<Integer, Integer>();

        Ut.afficher("Saissir un jour : "); j = Ut.saisirEntier();
        Ut.afficher("Saissir un mois : "); m = Ut.saisirEntier();
        Ut.afficher("Saissir une année : "); a = Ut.saisirEntier();
        Ut.afficherSL("     ");
        Ut.afficherSL("-----");
        Ut.afficherSL("     ");
        somme = 0;
        monthActuall = 1;
        if(a % 4 == 0 && a % 100 != 0 || a % 400 == 0){
            daysMonths.put(2, 29);
            Ut.afficherSL("Année Bissextile");
        }else {
            daysMonths.put(2, 28);
            Ut.afficherSL("Année non-Bissextile");
        }
        daysMonths.put(1, 31);
        daysMonths.put(3, 31);
        daysMonths.put(4, 30);
        daysMonths.put(5, 31);
        daysMonths.put(6, 30);
        daysMonths.put(7, 31);
        daysMonths.put(8, 31);
        daysMonths.put(9, 30);
        daysMonths.put(10, 31);
        daysMonths.put(11, 30);
        daysMonths.put(12, 31);
        

        for (i = 1; i < m; i = i + 1){
            somme = somme + daysMonths.get(monthActuall);
            Ut.afficherSL("Somme: " + somme + " | Mois: " + monthActuall + " |  Jours: " + daysMonths.get(monthActuall));
            monthActuall++;
        }
        Ut.afficherSL("     ");
        Ut.afficherSL("-----");
        Ut.afficherSL("     ");
        somme = somme + j;
        Ut.afficherSL("La somme est égale à : " + somme);
    }

    public static void ex1112(){
        HashMap<Integer,Integer> JoursMois = new HashMap<Integer, Integer>();
        ArrayList<Integer> JourMoi = new ArrayList<>();
        int i,j,m,a,nbj;

        Ut.afficher("Jour ?"); j = Ut.saisirEntier();
        Ut.afficher("Mois ?"); m = Ut.saisirEntier();
        Ut.afficher("Année ?"); a = Ut.saisirEntier();
        if(a % 4 == 0 && a % 100 != 0 || a % 400 == 0){
            JourMoi.add(e)
        }else {
            JoursMois.put(1, 28);
        }

        for(i = 0; i <= 6; i = i + 2){
            JoursMois.put(i, 31);
        }
        for(i = 7; i <= 11; i = i + 2){
            JoursMois.put(i, 32);
        }
        JoursMois.put(3, 30);
        JoursMois.put(5, 30);
        JoursMois.put(8, 30);
        JoursMois.put(10, 30);

        if(a > 0 && m >= 1 && m <= 12 && j >= 1 && JoursMois.get(m-1) >= j){
            nbj = j;
            for(i = 0; i < m-2; i++){
                nbj = nbj + JoursMois.get(i);
            }
            Ut.afficher(nbj);
        }else {
            Ut.afficher("FAUX");
        }
    }
}