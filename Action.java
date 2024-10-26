import java.util.Scanner;
import App.Bus;
import App.Customer;
import DynamicQueue.QueueOperations;
import Instructions.HomePage;

public class Action {  
    
    final String ANSI_GREEN = "\u001B[32m";
    final String ANSI_YELLOW = "\u001B[33m";
    final String ANSI_RESET = "\u001B[0m";

    public void runProgram(){

        Scanner scn = new Scanner(System.in);
        int userAction;
        Bus bus = new Bus();
        Customer cus = new Customer();        
        QueueOperations qo = new QueueOperations();

        //
        HomePage.display();

        do {
            System.out.print(ANSI_YELLOW + "Select your Input: " + ANSI_RESET);
            userAction = scn.nextInt();
            
            switch (userAction) {
                case 1:                    
                    bus.createBus();
                    break;
                case 2: 
                    cus.createCustomer();
                    break;
                case 3:
                    bus.searchAllBuses();
                    break;
                case 4: 
                    System.out.println(bus.searchBusByBusNumber());
                    break;
                case 5: 
                    System.out.println(bus.searchBusByStartLocation());
                    break;
                case 6:
                    cus.sortCustomerNewToOld();
                    break;
                case 7: 
                    qo.runProgram("bus");
                    break;
                case 8:
                    cus.searchAllCustomers();
                    break;
                case 9:
                    qo.runProgram("customer");
                    break;
                case 10:
                    cus.sortCustomerByAge();
                    break;
                default:
                    break;
                    
            }


        } while (userAction != 0);

        scn.close();

    }
}
