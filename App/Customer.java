package App;

import java.io.Console;
import java.util.ArrayList;

import Files.FileHandling;
import LinkedList.LinkedList;
import LinkedList.Node;
import SortMethods.*;
import StackDynamic.Stack;

public class Customer {

    private String customerNumber;
    private String name;
    private String mobile;
    private String email;
    private String city;
    private String age;
    private String filePathCustomer = "Files/customers.txt";

    ArrayList<String> customerDetails = new ArrayList<String>();
    FileHandling aFile = new FileHandling();

    Console console = System.console();

    public void createCustomer() {

        System.out.println("==== Create New Customer ====");
        System.out.println("Insert following details \n");
        customerDetails.add(console.readLine("1. Customer Number: "));
        customerDetails.add(console.readLine("2. Name: "));
        customerDetails.add(console.readLine("3. Mobile: "));
        customerDetails.add(console.readLine("4. Email: "));
        customerDetails.add(console.readLine("5. City: "));
        customerDetails.add(console.readLine("6. Age: "));

        String customerRecord = "";
        int count = 0;
        for (String data : customerDetails) {
            count++;
            customerRecord += data;
            if (customerDetails.size() != count) {
                customerRecord += ",";
            }
        }

        customerDetails.clear();
        // System.out.println(busRecord);

        if (!aFile.fileExist(filePathCustomer)) {
            aFile.createFile(filePathCustomer);
        }

        aFile.appendToFile(filePathCustomer, customerRecord);

    }

    public void searchAllCustomers() {
        System.out.println(aFile.readFile(filePathCustomer));
    }

    public String searchCustomerByCustomerNumber() {
        customerNumber = console.readLine("Insert customer number to search: ");
        return aFile.searchInFile(filePathCustomer, customerNumber, 0);
    }

    public void sortCustomerByAge() {
        LinkedList customerList = aFile.getCustomerList(filePathCustomer);

        int[] arr = new int[customerList.size];

        if (customerList.head != null) {
            Node tempNode = customerList.head;
            for (int i=0; i < customerList.size; i++){
                String[] temp = tempNode.value.split(",");
                arr[i] = Integer.parseInt(temp[5]);  
                // System.out.println(arr[i]);              
                tempNode = tempNode.next;
            }
        }

        BubbleSort.bubbleSort(arr);     // Bubble Sort
        // InsertionSort.insertionSort(arr); // Insertion Sort
        QuickSort.quickSort(arr, 0, arr.length-1);
        

        for (int i=0;i < arr.length;i++){
            // System.out.println(Integer.toString(arr[i]));
            System.out.print(aFile.searchInCusFile(filePathCustomer, Integer.toString(arr[i]), 5));
        }
        

        // while (true) {
        // if (custoStack.peek() != "NotFound"){
        // String temp[] = custoStack.pop().split(",");
        // } else {
        // break;
        // }
        // }

    }

    public void sortCustomerNewToOld(){
        Stack customerStack = aFile.sortFileNewToOld(filePathCustomer);

        while (true) {
            if (customerStack.peek() != "NotFound"){//----->O(1) 
                System.out.println(customerStack.pop());//---->O(1) 
            } else {
                break;
            }
        }
    }
}



