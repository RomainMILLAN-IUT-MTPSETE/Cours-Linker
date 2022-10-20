public class Ex6 {
    public static void main(String[] args){
        Ut.afficher("Saisir un mot : ");char[] name = Ut.saisirCharArray();
        Ut.afficher(palindrome(name));
    }

    public static void afficheChar(char[] name){
        for (int o = 0; o<name.length; o++){
            Ut.afficherSL(o + " : " + name[o]);
        }
    }

    public static boolean palindrome(char[] name){
        afficheChar(name);
        int i = name.length;
        System.out.println(i);
        System.out.println(i/2);
        int p;
        for (int o = 0; o < i/2; o++){
            p = i-(o+1);
            System.out.print("o : " + o + " | i : " + i + " | p : " + p + " | char[o] : " + name[o] + " | char[p] " + name[p] + "\n");            
            
            if(name[o] == name[p]){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }
}