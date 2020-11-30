package potenzrekursion;

public class PotenzrekursionAusfuehrung {
	public static void main(String[]args) {
		System.out.println(potenz(5,4));
	}
	
	public static int potenz (int b, int p) {
		if(p == 1) {
			return b;
		}else{
			return b *potenz (b, p-1);
		}
	}
}
