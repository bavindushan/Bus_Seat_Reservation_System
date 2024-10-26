package SortMethods;

public class InsertionSort {
    
    // Insertion Sort Method
    public static void insertionSort(int[] arr){

        for (int i=1; i < arr.length ; i++) {

            // create a themporary variable with the value of arr[i]
            int temp = arr[i]; 
            int j = i;

            while (j > 0 && arr[j-1] > temp){ // if the previous element is greater than next element
                arr[j] = arr[j-1];
                j--;
            }    
            
            // while (j > 0){ // if the previous element is greater than next element
            //     if (arr[j-1] > temp){
            //         arr[j] = arr[j-1];
            //         j--;
            //     } else {
            //         break;
            //     }
            // }    
            arr[j] = temp; // if the previous element is NOT greater than next element
        }   
    }


    // Function to print array
    public static void printArray(int[] arr){
        for (int i=0; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
