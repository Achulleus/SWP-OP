package vergleichSorts;

import java.util.Random;

public class VergleichSortsAusfuehrung {
	
	private static int versuche = 50000;
	private static int laenge = 1000;
	private static int[] arr = new int[laenge];
	
	private static long zeitInsertionsort;
	private static long zeitBubblesort;
	private static long zeitSelectionsort;
	
	private static int bubbleVergleich = 0;
	private static int bubbleTausch = 0;
	private static int insertionVergleich = 0;
	private static int insertionTausch = 0;
	private static int selectionVergleich = 0;
	private static int selectionTausch = 0;
	
	private static String ersteZeit = "";
	private static String zweiteZeit = "";
	private static String dritteZeit = "";

	public static void main(String[] args) {
		
		for(int i = 0; i < versuche; i ++) {
			arrayZufallBefuellen();
			
			bubblesort(arr);
			insertionsort(arr);
			selectionsort(arr);
			
			avgBerechnen();
			vergleich();
			
			ausgabe();
		}
		
		
	}
	
	public static void arrayZufallBefuellen() {
		Random wuerfel = new Random();
		
		for(int i = 0; i<arr.length; i++) {
			arr[i] = wuerfel.nextInt(laenge);
		}
	}
	
	public static void bubblesort(int[] arr) {
		final long timeStart = System.currentTimeMillis();
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr.length-1; j++) {
				bubbleVergleich ++;
				if(arr[j] > arr[j+1]) {
					bubbleTausch ++;
					int y = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = y;
				}
			}
		}
		final long timeEnd = System.currentTimeMillis();
		zeitBubblesort = zeitBubblesort + (timeEnd-timeStart);
	}
	
	 public static void insertionsort(int arr[]){
		 final long timeStart = System.currentTimeMillis();
		 int n = arr.length;
	     for (int i = 1; i < n; ++i) {
	    	 int key = arr[i];
	         int j = i - 1;

	         while (j >= 0 && arr[j] > key) {
	        	 insertionVergleich ++;
	        	 arr[j + 1] = arr[j];
	             j = j - 1;
	         }
	         insertionTausch ++;
	         arr[j + 1] = key;
	     }
	     final long timeEnd = System.currentTimeMillis();
	     zeitInsertionsort = zeitInsertionsort + (timeEnd-timeStart);
	 }
	 
	 public static void selectionsort(int[] arr){ 
		 final long timeStart = System.currentTimeMillis();
		 for (int i = 0; i < arr.length - 1; i++){  
			 int index = i;  
	         for (int j = i + 1; j < arr.length; j++){  
	        	 selectionVergleich ++;
	        	 if (arr[j] < arr[index]){
	        		 selectionTausch ++;
	        		 index = j;
	             }  
	         }  
	         int smallerNumber = arr[index];   
	         arr[index] = arr[i];  
	         arr[i] = smallerNumber;  
	     }  
		 final long timeEnd = System.currentTimeMillis();
		 zeitSelectionsort = zeitSelectionsort + (timeEnd - timeStart);
	 }  
	
	public static void avgBerechnen() {
		zeitBubblesort = zeitBubblesort / versuche;
		zeitInsertionsort = zeitInsertionsort / versuche;
		zeitSelectionsort = zeitSelectionsort / versuche;
		
		bubbleVergleich = bubbleVergleich / versuche;
		bubbleTausch = bubbleTausch / versuche;
		insertionVergleich = insertionVergleich / versuche;
		insertionTausch = insertionTausch / versuche;
		selectionVergleich = selectionVergleich / versuche;
		selectionTausch = selectionTausch / versuche;
	}
	
	public static void vergleich() {
		
		if(zeitBubblesort < zeitInsertionsort) {
			if(zeitBubblesort < zeitSelectionsort) {
				ersteZeit = "Bubblesort";
				if(zeitSelectionsort <= zeitInsertionsort) {
					zweiteZeit = "Selectionsort";
					dritteZeit = "Insertionsort";
				}else {
					zweiteZeit = "Insertionsort";
					dritteZeit = "Selectionsort";
				}
			}
			if(zeitBubblesort >= zeitSelectionsort) {
				if(zeitSelectionsort <= zeitInsertionsort) {
					ersteZeit = "Selectionsort";
					if(zeitInsertionsort < zeitBubblesort) {
						zweiteZeit = "Insertionsort";
						dritteZeit = "Bubblesort";
					}else {
						zweiteZeit = "Bubblesort";
						dritteZeit = "Inserionsort";
					}
				}
			}
		}
		
		if(zeitBubblesort >= zeitInsertionsort) {
			if(zeitInsertionsort <= zeitSelectionsort) {
				ersteZeit = "Insertionsort";
				if(zeitSelectionsort < zeitBubblesort) {
					zweiteZeit = "Selectionsort";
					dritteZeit = "Bubblesort";
				}else {
					zweiteZeit = "Bubblesort";
					dritteZeit = "Selectionsort";
				}
			}
		}
	}
	
	public static void ausgabe() {
		System.out.println("Selectionsort:");
		System.out.println("Zeit: " + zeitSelectionsort + " Vergleiche: " + selectionVergleich + "Tauschungen: " +  selectionTausch);
		
		System.out.println("Insertionsort:");
		System.out.println("Zeit: " + zeitInsertionsort + " Vergleiche: " + insertionVergleich + "Tauschungen: " +  insertionTausch);
		
		System.out.println("Bubblesort:");
		System.out.println("Zeit: " + zeitBubblesort + " Vergleiche: " + bubbleVergleich + "Tauschungen: " +  bubbleTausch);
		
		System.out.println("Rangliste:");
		System.out.println("1. " + ersteZeit);
		System.out.println("2. " + zweiteZeit);
		System.out.println("3. " + dritteZeit);
	}

}
