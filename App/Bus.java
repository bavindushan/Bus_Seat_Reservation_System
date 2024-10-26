package App;

import java.io.Console;
import java.util.ArrayList;

import Files.FileHandling;
import StackDynamic.Stack;

public class Bus {
    
    private String busNumber;
    private String routeNumber;
    private String totalSeats;
    private String startPoint;
    private String endPoint;
    private String startTime;
    private String fare;
    private String filePathBus = "Files\\buses.txt";

    ArrayList<String> busDetails = new ArrayList<String>();
    FileHandling aFile = new FileHandling();

    Console console = System.console();

    public void createBus(){

        System.out.println("==== Create New Bus ====");
        System.out.println("Insert following details \n");
        busDetails.add(console.readLine("1. Bus Number: "));
        busDetails.add(console.readLine("2. Route Number: "));
        busDetails.add(console.readLine("3. Seat Count: "));
        busDetails.add(console.readLine("4. Start Location: "));
        busDetails.add(console.readLine("5. Destination: "));
        busDetails.add(console.readLine("6. Start Time: "));
        busDetails.add(console.readLine("7. Fare: "));

        String busRecord = "";
        int count = 0;
        for (String data : busDetails) {
            count++;
            busRecord += data;
            if (busDetails.size() != count){
                busRecord += ",";
            }
        }

        busDetails.clear();
        // System.out.println(busRecord);        
        
        if(!aFile.fileExist(filePathBus)){
            aFile.createFile(filePathBus);
        }

        aFile.appendToFile(filePathBus, busRecord);
        
    }

    public void searchAllBuses(){
        System.out.println(aFile.readFile(filePathBus));
    }

    public String searchBusByBusNumber(){
        busNumber = console.readLine("Insert bus number to search: ");
        return aFile.searchInFile(filePathBus, busNumber, 0);
    }

    public String searchBusByStartLocation(){
        busNumber = console.readLine("Insert start location to search: ");
        return aFile.searchInFile(filePathBus, busNumber, 3);
    }

    public void sortBusNewToOld(){
        Stack busStack = aFile.sortFileNewToOld(filePathBus);

        while (true) {
            if (busStack.peek() != "NotFound"){
                System.out.println(busStack.pop());
            } else {
                break;
            }
        }

    }

}


