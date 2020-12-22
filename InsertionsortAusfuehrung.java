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
		binaerInsertionSort(arr);
		ausgabeSortiert();
		
		arrayAbsteigendBefuellen();
		bubblesort(arr);
		binaerInsertionSort(arr);
		ausgabeUnsortiert();
		
		arrayZufallBefuellen();
		bubblesort(arr);
		binaerInsertionSort(arr);
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
	
	public static void binaerInsertionSort(int[] nums) {
		final long timeStart = System.currentTimeMillis();
	    int length = nums.length;

	    for (int i = 1; i < length; ++i) {
	        int key = nums[i];
	        int insertedPosition = findePosition(nums, 0, i - 1, key);

	        for (int j = i - 1; j >= insertedPosition; --j) {
	            nums[j + 1] = nums[j];
	        }

	        nums[insertedPosition] = key;
	    }
	    final long timeEnd = System.currentTimeMillis();
		zeitInsertionsort = timeEnd-timeStart;
	}

	public static int findePosition(int[] nums, int start, int ende, int key) {
	    while (start <= ende) {
	        int mid = start + (ende - start) / 2;

	        if (key < nums[mid]) {
	            ende = mid - 1;
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
