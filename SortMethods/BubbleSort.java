package SortMethods;

public class BubbleSort {
    
    // * Bubble Sort Method
    public static void bubbleSort(int arr[]){

        int n = arr.length; // variable to hold array size (length)

        // Loop through entire array for each round
        for (int i=0; i < n-1 ;i++){
            // another loop inside first loop for comparing pairs
            for (int j=0; j < n-i-1 ;j++){

                // Compare pairs
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            } 
        }
    }


    // * methhod to display sorted array
    public void printArray(int arr[]){

        for (int i=0; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
