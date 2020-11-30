package bubblesort;

import java.util.Random;
import java.util.Scanner;

public class BubblesortAusfuehrung {
	
	private static int[] arr = new int[10000];
	private static int tauschoperationen = 0;
	private static long zeit;
	
	public static void main(String[] args) {
		start();
	}
	
	public static void start() {
		arrayBefuellen();
	}
	
	public static void eingabe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Wollen Sie auf- oder absteigend sortieren?[au/ab] ");
		String line = sc.next();
		if(line.equalsIgnoreCase("au")) sortierenAufsteigend();
		if(line.equalsIgnoreCase("ab")) sortierenAbsteigend();
	}
	
	public static void arrayBefuellen() {
		Random wuerfel = new Random();
		
		for(int i = 0; i<arr.length; i++) {
			arr[i] = wuerfel.nextInt(100);
		}
		eingabe();
	}
	
	public static void sortierenAufsteigend() {
		final long timeStart = System.currentTimeMillis();
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr.length-1; j++) {
				if(arr[j] > arr[j+1]) {
					int y = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = y;
					tauschoperationen++;
				}
			}
		}
		final long timeEnd = System.currentTimeMillis();
		zeit = timeEnd-timeStart;
		ausgabe();
	}
	
	public static void sortierenAbsteigend() {
		final long timeStart = System.currentTimeMillis();
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr.length-1; j++) {
				if(arr[j] < arr[j+1]) {
					int y = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = y;
					tauschoperationen++;
				}
			}
		}
		final long timeEnd = System.currentTimeMillis();
		zeit = timeEnd - timeStart;
		ausgabe();
	}
	
	public static void ausgabe() {
		System.out.println("Es wurden "+ tauschoperationen +" Tauschoperationen durchgeführt.");
		System.out.println("Die Sortierung hat "+ zeit +" Millisekunden gedauert.");
		for (int i = 0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}