package SortMethods;

public class QuickSort {
    
    // * Helper Function for Partitioning
    // Return value from this function will be used as 
    // pivot number 
    public static int partition(int[] array, int start, int end){
        // Create the pivot number (right most number for simplicity)
        int pivot = end;

        int i = start - 1;
        for (int j=start; j <= end; j++){

            if (array[j] <= array[pivot]){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        
        return i;
    }


    // * Quick Sort Method
    public static void quickSort(int[] array, int start, int end){
        if (start < end) {
            // get the pivot number from partition method
            int pivot = partition(array, start, end);

            // call itself recursively with left sub array and right sub array
            quickSort(array, start, pivot-1);
            quickSort(array, pivot + 1, end);
        }
    }

    // Print Array
    // * Print Array Method
    public static void printArray(int[] arr){
        for (int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
