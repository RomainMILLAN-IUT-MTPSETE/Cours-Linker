public class MainEE {

    public static void main(String[] args){
        int[] tab = new int[10];
        tab[0] = 1;
        tab[1] = 2;
        tab[2] = 3;
        tab[3] = 4;
        tab[4] = 5;
        tab[5] = 3;
        tab[8] = 8;
        tab[9] = 0;
        int[] tab2 = new int[10];
        tab2[0] = 1;
        tab2[1] = 2;
        tab2[2] = 3;
        tab2[3] = 14;
        tab2[4] = 35;
        tab2[5] = 23;
        tab2[8] = 16;
        tab2[9] = 23;
        EE e1 = new EE(20, tab);
        EE e2 = new EE(20, tab2);
        System.out.println(e1.toString());
        System.out.println(e1.difference(e2));
    }
    
}
