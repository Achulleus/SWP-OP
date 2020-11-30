package arethmetischereihe;

public class ArethmetischereiheAusfuehrung {
	public static void main(String[]args) {
		System.out.println(arethmetischereihe(5));
	}
	
	public static int arethmetischereihe (int n) {
		if(n == 0) {
			return 0;
		}else {
			 return arethmetischereihe(n-1)+n;
		}
	}
}
