import java.util.Scanner;

public class T {

    public static void main(String[] args){
    }

    
    public static int inputInt(){
        Scanner a = new Scanner(System.in);
        int b = a.nextInt();
        return(b);
    }

    public static String inputString(){
        Scanner a = new Scanner(System.in);
        String b = a.nextLine();
        return(b);
    }

    public static double inputDouble(){
        Scanner a = new Scanner(System.in);
        Double b = a.nextDouble();
        return(b);
    }
    
    public static void lineBreak(){
        System.out.print("\n");
    }

    public static void lineBreak(int a){
        if (a <= 1){
            lineBreak();
        }
        else{
            lineBreak();
            lineBreak(a - 1);
        }
    }

    public static void display(int n){
        System.out.print(n);
    }

    public static void display(double x){
	System.out.print(x);
    }

    public static void display(String w){
	System.out.print(w);
    }

    public static void display(int[] M){
	System.out.print("\n| ");
	for (int i=0; i<M.length - 1; i++){
	    System.out.print(M[i]+"  ");
	}
	System.out.print(M[(M.length - 1)]+" |\n");
    }

    public static void dispMany(int n, char c){
	for (int i=0; i<n; i++){
	    System.out.print(c);
	}
    }

    public static int pow(int a){
	return(a*a);
    }

    public static int pow(int a, int b){
        if (b == 0){
            return(1);
        }
        else{
            return(a*pow(a, b - 1));
        }
    }

    public static boolean impair(int n){
	return(n%2 == 1);
    }

    public static boolean pair(int n){
	return(n%2 == 0);
    }

    public static int rest(int a, int b){
        if (b > a){
            return(a);
        }
        else{
            return(rest(a - b, b));
        }
    }

    public static int quotient(int a, int b){
        if (b > a){
            return(1);
        }
        else{
            return(1 + quotient(a - b, b));
        }
    }

    public static int factAux(int k, int accu){
	if (accu == 0){
	    return(k);
	}else{
	    return(factAux(k*accu,accu-1));
	    }  
    }

    public static int factUntil(int a,int b){
	if (a == b){
	    return(a);
	}else{
	    return(a*factUntil(a - 1,b));
	}
    }

    public static int fact(int k){
        return(factAux(1,k));
    }

    public static int combin(int k, int n){
	if (k > n){
	    return(0);
	}else{
	    return( factUntil(n,n - k + 1 )/fact(k) );
	}
    }


    public static int abs(int n){
	if (n >= 0){ return(n);	}else{ return(-n); }
    }

    public static double abs(double x){
	if (x>=0){ return x; }else{ return(-x); }
    }

    public static int max(int a, int b){
	if (a < b){
	    return(b);
	}else{
	    return(a);
	}
    }

    public static int sqrt(int n){
	int low = 0, high = n; int mid;
	while (low != high){
	    mid = (low + high)/2;
	    if (mid*mid == n){
		return mid;
	    }
	    if (mid*mid > n){
		high = mid;
	    }else{
		low = mid;
	    }
	}
	return low;
    }

    public static double sqrt(double n){
	double low = 0, high = n, mid = (low + high)/2;
	for (int i=0; i<1000; i++){
	    if (mid*mid >= n){
		high = mid;
	    }else{
		low = mid;
	    }
	    mid = (low + high)/2;
	}
	return mid;
    }

    public static void display(char[][] tab){
	System.out.print(" ");
	for (int i=0; i<tab[0].length; i++){
	    System.out.print("-");
	}
        lineBreak();
	for (int j=0; j<tab.length; j++){
	    System.out.print("| ");
	    for (int k=0; k<tab[0].length; k++){
		System.out.print(tab[j][k]+" ");
	    }
	}
    }
	

}
