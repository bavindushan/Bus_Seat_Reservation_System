package Files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import LinkedList.LinkedList;
import StackDynamic.Stack;


public class FileHandling {
    
    public boolean fileExist(String filePath){
        // Create file object
        File file = new File(filePath);

        return file.exists();
    }

    public void createFile(String filePath){

        // Create file object
        File file = new File(filePath);

        try {
            if(file.createNewFile()){
                System.out.println("File Created " + file.getName());
            } else {
                System.out.println("File already exists");
            }

        } catch (IOException e){
            System.out.println("Error occured");
            e.printStackTrace();
        }

    }

    public void appendToFile(String filePath, String textToAppend){
        // Create file object
        File file = new File(filePath);

        try {
            // Create FileWriter in append mode
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write to text file
            bufferedWriter.write(textToAppend);
            bufferedWriter.newLine();

            bufferedWriter.close();
            fileWriter.close();

            System.out.println("Record added successfully");
        } catch (IOException e){
            System.out.println("Error occured: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String readFile(String filePath){

        String returnString = "";

        // Create file object
        File file = new File(filePath);

        if (file.exists() && !file.isDirectory()){

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    returnString += line + "\n";
                }
            } catch (IOException e){
                System.out.println("Error occured");
                e.printStackTrace();
            }

        } else {
            System.out.println("File does not exists");
        }

        return returnString;
    }

    // Search Given Record
    public String searchInFile(String filePath, String searchValue, int searchIndex){

        String returnValue = "";

        // Create file object
        File file = new File(filePath);

        if (file.exists() && !file.isDirectory()){

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                boolean found = false; //
                while ((line = br.readLine()) != null) {
                    String[] busRecord = line.split(",");                                      
                    if(searchIndex == 0 && busRecord[searchIndex].equals(searchValue)){ //
                        returnValue = line;
                        found = true;
                        break;
                    } else if (searchIndex == 3 && busRecord[searchIndex].equals(searchValue)){
                        returnValue += line + "\n";
                        found = true;
                    }               
                }

                if (!found){ //
                    System.out.println("Bus not found");
                }

            } catch (IOException e){
                System.out.println("Error occured");
                e.printStackTrace();
            }

        } else {
            System.out.println("File does not exists");
        }

        return returnValue;
    }

    public Stack sortFileNewToOld(String filePath){

        Stack stack = new Stack();

        // Create file object
        File file = new File(filePath);

        if (file.exists() && !file.isDirectory()){

            try (BufferedReader br = new BufferedReader(new FileReader(file))) { //-->O(n)
                String line;
                while ((line = br.readLine()) != null) {
                    stack.push(line);//------->O(1)
                }
            } catch (IOException e){
                System.out.println("Error occured");
                e.printStackTrace();
            }

        } else {
            System.out.println("File does not exists");
        }

        return stack;
    }

    public LinkedList getCustomerList(String filePath){

        LinkedList list = new LinkedList();

        // Create file object
        File file = new File(filePath);

        if (file.exists() && !file.isDirectory()){

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    list.insertInLinkedList(line, 0);
                }
            } catch (IOException e){
                System.out.println("Error occured");
                e.printStackTrace();
            }

        } else {
            System.out.println("File does not exists");
        }

        return list;
    }

    public String searchInCusFile(String filePath, String searchValue, int searchIndex){

        String returnValue = "";

        // Create file object
        File file = new File(filePath);

        if (file.exists() && !file.isDirectory()){
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                boolean found = false; //
                while ((line = br.readLine()) != null) {
                    String[] cusRecord = line.split(",");                                     
                    if (searchIndex == 5 && cusRecord[searchIndex].equals(searchValue)){
                        returnValue += line + "\n";
                        found = true;
                    }               
                }

                if (!found){ //
                    System.out.println("Customer not found");
                }

            } catch (IOException e){
                System.out.println("Error occured");
                e.printStackTrace();
            }

        } else {
            System.out.println("File does not exists");
        }

        return returnValue;
    }

}
