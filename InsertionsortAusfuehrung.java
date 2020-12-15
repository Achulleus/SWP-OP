package insertionsort;

import java.util.Random;

public class InsertionsortAusfuehrung {
	
	private static int[] arr = new int[1000];
	private static long zeitInsertionsort;
	private static long zeitBubblesort;
	private static int stelle;
	
	public static void main(String[] args) {
		arrayAufsteigendBefuellen();
		bubblesort(arr);
		binaryInsertionSort(arr);
		ausgabeSortiert();
		
		arrayAbsteigendBefuellen();
		bubblesort(arr);
		binaryInsertionSort(arr);
		ausgabeUnsortiert();
		
		arrayZufallBefuellen();
		bubblesort(arr);
		binaryInsertionSort(arr);
		ausgabeZufall();
	}
	
	public static void arrayAufsteigendBefuellen() {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
	}
	
	public static void arrayAbsteigendBefuellen() {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (arr.length-1) -i;
		}
	}
	
	public static void arrayZufallBefuellen() {
		Random wuerfel = new Random();
		
		for(int i = 0; i<arr.length; i++) {
			arr[i] = wuerfel.nextInt(1000);
		}
	}
	
	/*public static void insertionsort() {
		final long timeStart = System.currentTimeMillis();
		 for (int i=1; i<arr.length; i++)
	        {
	            int j=i;
	            int t=arr[j];
	            arr[binaerSuche(arr[0] ,j, t-1)] = t;
	        }
		 final long timeEnd = System.currentTimeMillis();
		 zeitInsertionsort = timeEnd - timeStart;
	}*/
	
	public static void bubblesort(int[] arr) {
		final long timeStart = System.currentTimeMillis();
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr.length-1; j++) {
				if(arr[j] > arr[j+1]) {
					int y = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = y;
				}
			}
		}
		final long timeEnd = System.currentTimeMillis();
		zeitBubblesort = timeEnd-timeStart;
	}
	
	/*public static int binaerSuche(int anfang, int ende, int gesZahl) {
		while(anfang <= ende) {	
			int mitte = anfang + ((ende - anfang)/2);
			if(arr[mitte] == gesZahl) {
				stelle = mitte;
				return stelle;
			}
			if(gesZahl < arr[mitte]) {
				ende = mitte;
			} 
			if(gesZahl > arr[mitte]) {
				anfang = mitte;
			}
		}
		return 0;
	}*/
	
	public static void binaryInsertionSort(int[] nums) {
		final long timeStart = System.currentTimeMillis();
	    int length = nums.length;

	    for (int i = 1; i < length; ++i) {
	        int key = nums[i];
	        int insertedPosition = findPosition(nums, 0, i - 1, key);

	        for (int j = i - 1; j >= insertedPosition; --j) {
	            nums[j + 1] = nums[j];
	        }

	        nums[insertedPosition] = key;
	    }
	    final long timeEnd = System.currentTimeMillis();
		zeitBubblesort = timeEnd-timeStart;
	}

	public static int findPosition(int[] nums, int start, int end, int key) {
	    while (start <= end) {
	        int mid = start + (end - start) / 2;

	        if (key < nums[mid]) {
	            end = mid - 1;
	        } else {
	            start = mid + 1;
	        }
	    }
	    return start;
	}
	
	public static void ausgabeSortiert() {
		System.out.println("Sortiert: ");
		System.out.println("Zeit Insertionsort: "+ zeitInsertionsort);
		System.out.println("Zeit Bubblesort: "+ zeitBubblesort);
		System.out.println();
	}
	
	public static void ausgabeUnsortiert() {
		System.out.println("Unsortiert: ");
		System.out.println("Zeit Insertionsort: "+ zeitInsertionsort);
		System.out.println("Zeit Bubblesort: "+ zeitBubblesort);
		System.out.println();
	}
	
	public static void ausgabeZufall() {
		System.out.println("Zufall: ");
		System.out.println("Zeit Insertionsort: "+ zeitInsertionsort);
		System.out.println("Zeit Bubblesort: "+ zeitBubblesort);
		System.out.println();
	}
}
