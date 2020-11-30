package endrekursion;

public class enrekursionAusfuehrung {

	public static void main(String[] args) {
		
	}
	
	public static int aretmetischereihe (int n) {
		if(n == 0) {
			return 0;
		}else {
			 return aretmetischereihe(n-1)+n;
		}
	}
	
	public static int fibonacciRekursiv(int n) {
		if(n < 2){
			return 1;
		}else {
			return fibonacciRekursiv(fibonacciRekursiv(n-1) + fibonacciRekursiv(n-2));
		}
	}
	
	public static int g_fibonacci(int n, int fk1, int fk2) {
		if (n<=1) {
			return fk1+fk2;
		}else {
		return g_fibonacci(n-1, fk2+fk1, fk1);
		}
	}
	
	public static int fibonacci(int n) {
		return g_fibonacci(n-1,1,0);
	}

}
