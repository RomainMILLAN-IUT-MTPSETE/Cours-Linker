public class Ex3 {
    public static void main(String[]args){
        int e,f,g;
        e=9;
        f=7;
        g=33;
        f= max2(e, f);
        Ut.afficher(max2(f,g));
    }
    public static int max2 (int a, int b){
        int c;
        c=0;
        if (a<=b){
            c= b;
        }
        if (b<a){
            c= a;
        }
        return c;
    }
}
