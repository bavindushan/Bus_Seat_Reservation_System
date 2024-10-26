package DynamicQueue;

import java.util.Scanner;

import App.Bus;
import App.Customer;
import Instructions.HomePage;

public class QueueOperations {  
    
    final String ANSI_GREEN = "\u001B[32m";
    final String ANSI_YELLOW = "\u001B[33m";
    final String ANSI_RESET = "\u001B[0m";
    QueueDynamic qd;

    Bus bus = new Bus();
    Customer cus = new Customer();

    public void runProgram(String type){

        Scanner scn = new Scanner(System.in);
        int userAction;

        System.out.println("==========================================");
        System.out.println(ANSI_GREEN + "#"+ type.toUpperCase() +" Operations#" + ANSI_RESET);
        System.out.println("==========================================");
        System.out.println("# Press 1 to Create Queue                #");
        System.out.println("# Press 2 to Check if the queue is empty #");
        System.out.println("# Press 3 to Add "+type+" to the queue     #");
        System.out.println("# Press 4 to Remove "+type+" from queue    #");
        System.out.println("# Press 5 to see next available "+type+ "  #");
        System.out.println("# Press 6 to Delete queue                #");
        System.out.println("# Press 7 to View all "+type+"s in queue   #");
        System.out.println("# Press 0 to Go back                     #");
        System.out.println("#                                        #");
        System.out.println("==========================================");


        do {
            System.out.print(ANSI_YELLOW + "Select your Input: " + ANSI_RESET);
            userAction = scn.nextInt();
            
            switch (userAction) {
                case 1:
                    qd = new QueueDynamic();
                    break;
                case 2: 
                    if (this.qd == null)
                        System.out.println(ANSI_GREEN + "Queue is not created" + ANSI_RESET);
                    else if (qd.isEmpty())
                        System.out.println(ANSI_GREEN + "Queue is empty" + ANSI_RESET);
                    else
                        System.out.println(ANSI_GREEN + "Queue is not empty" + ANSI_RESET);
                    break;
                case 3:
                    if (this.qd == null)
                        System.out.println(ANSI_GREEN + "Queue is not created" + ANSI_RESET);
                    else {
                        // System.out.print(ANSI_YELLOW + "Input "+type+" number: " + ANSI_RESET);
                        String value = "";
                        if (type == "bus"){
                            value = bus.searchBusByBusNumber();
                        } else if (type == "customer"){
                            value = cus.searchCustomerByCustomerNumber();
                        }                        
                        qd.enQueue(value);
                    }
                    break;
                case 4: 
                    if (this.qd == null)
                        System.out.println(ANSI_GREEN + "Queue is not created" + ANSI_RESET);
                    else {
                        String returnVal = qd.deQueue();
                        if (returnVal != "EMPTY") {
                            System.out.println(ANSI_GREEN + returnVal + "is removed" + ANSI_RESET);
                        } else {
                            System.out.println(ANSI_GREEN + "Queue is empty" + ANSI_RESET);
                        }                        
                    }
                    break;
                case 5: 
                    if (this.qd == null)
                        System.out.println(ANSI_GREEN + "Queue is not created" + ANSI_RESET);
                    else if (qd.peek() != "EMPTY")
                        System.out.println(ANSI_GREEN + "First element is " + qd.peek() + ANSI_RESET);
                    else        
                        System.out.println(ANSI_GREEN + "Queue is empty" + ANSI_RESET);
                    break;
                case 6:
                    if (this.qd == null)
                        System.out.println(ANSI_GREEN + "Queue is not created" + ANSI_RESET);
                    else
                        qd.deleteQueue();
                    break;
                case 7: 
                    if (this.qd == null)
                        System.out.println(ANSI_GREEN + "Queue is not created" + ANSI_RESET);
                    else
                        qd.viewAllElements();
                    break;
                default:
                if(userAction == 0) HomePage.display();
                    break;
                    
            }


        } while (userAction != 0);

        // scn.close();

    }
}
