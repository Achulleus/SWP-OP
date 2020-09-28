package binaersuche;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinaersucheAusfuehrung {
	
	private static int x = 100;
	private static int gesZahl;
	private static int suchMeth;
	private static int stelle;
	private static boolean gefunden = false;
	private static int [] arr = new int [x];
	static Random wuerfel = new Random ();

	public static void main(String[] args) {
		befuellen();
		sortieren();
		eingabe();
		if(suchMeth == 0) sequentiellSuche();
		if(suchMeth == 1) binaerSuche();
		ausgabe();
	}
	
	public static void befuellen(){
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 1 + wuerfel.nextInt(100);
		}
	}
	
	public static void sortieren() {
		Arrays.sort(arr);
	}
	
	public static void eingabe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welche Zahl wollen Sie suchen?");
		gesZahl = sc.nextInt();
		do {
			System.out.println("Wie wollen Sie suchen? 0 für sequentiel; 1 für binaer");
			suchMeth = sc.nextInt();
		}while(suchMeth != 0 || suchMeth != 1);	
	}
	
	public static void sequentiellSuche() {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == gesZahl) {
				gefunden = true;
				stelle = i;
				return;
			}
		}
		gefunden = false;
		return;
	}
	
	public static void binaerSuche() {
		int anfang = 0;
		int ende = arr.length -1;
		while(anfang <= ende) {	
			int mitte = anfang + ((ende - anfang)/2);
			if(arr[mitte] == gesZahl) {
				gefunden = true;
				stelle = mitte;
				return;
			}
			if(gesZahl < arr[mitte]) {
				ende = mitte;
			} 
			if(gesZahl > arr[mitte]) {
				anfang = mitte;
			}
		}
		gefunden = false;
		return;
	}
	
	public static void ausgabe() {
		if(gefunden == true) System.out.println("Zahl gefunden: "+ gesZahl +" an der "+ stelle +" Stelle.");
		if(gefunden == false) System.out.println(gesZahl +" ist nicht im Array enthalten.");
	}
}
