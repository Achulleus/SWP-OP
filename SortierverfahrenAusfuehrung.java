import java.util.Random;

public class SortierverfahrenAusfuehrung {
    private static int versuche = 5;
    private static int laenge = 50000;
    private static int[] arr = new int[laenge];

    private static long zeitInsertionsort;
    private static long zeitBubblesort;
    private static long zeitSelectionsort;
    private static long zeitQuicksort;

    private static int bubbleVergleich = 0;
    private static int bubbleTausch = 0;
    private static int insertionVergleich = 0;
    private static int insertionTausch = 0;
    private static int selectionVergleich = 0;
    private static int selectionTausch = 0;
    private static int quickVergleich = 0;
    private static int quickTausch = 0;

    private static String ersteZeit = "";
    private static String zweiteZeit = "";
    private static String dritteZeit = "";

    public static void main(String[] args) {

        for(int i = 0; i < versuche; i ++) {
            arrayZufallBefuellen();
            bubblesort(arr);

            arrayZufallBefuellen();
            insertionsort(arr);

            arrayZufallBefuellen();
            selectionsort(arr);

            arrayZufallBefuellen();
            quickSort(arr, 0, arr.length -1);
        }
        avgBerechnen();
        vergleich();

        ausgabe();
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

    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        quickTausch ++;
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[high];
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {
            quickVergleich ++;

            if (arr[j] < pivot)
            {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void quickSort(int[] arr, int low, int high)
    {
        final long timeStart = System.currentTimeMillis();
        if (low < high)
        {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
        final long timeEnd = System.currentTimeMillis();
        zeitQuicksort = zeitQuicksort + (timeEnd - timeStart);
    }

    public static void avgBerechnen() {
        zeitBubblesort = zeitBubblesort / versuche;
        zeitInsertionsort = zeitInsertionsort / versuche;
        zeitSelectionsort = zeitSelectionsort / versuche;
        zeitQuicksort = zeitQuicksort/  versuche;

        bubbleVergleich = bubbleVergleich / versuche;
        bubbleTausch = bubbleTausch / versuche;

        insertionVergleich = insertionVergleich / versuche;
        insertionTausch = insertionTausch / versuche;

        selectionVergleich = selectionVergleich / versuche;
        selectionTausch = selectionTausch / versuche;

        quickVergleich = quickVergleich / versuche;
        quickTausch = quickTausch / versuche;
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

        System.out.println("Quicksort:");
        System.out.println("Zeit: " + zeitQuicksort + " Vergleiche: " + quickVergleich + "Tauschungen: " +  quickTausch);

        System.out.println("Rangliste:");
        System.out.println("1. Quicksort");
        System.out.println("2. " + ersteZeit);
        System.out.println("3. " + zweiteZeit);
        System.out.println("4. " + dritteZeit);
    }
}
