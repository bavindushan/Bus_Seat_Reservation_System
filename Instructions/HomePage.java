package Instructions;

public class HomePage {

    final static String ANSI_GREEN = "\u001B[32m";
    final static String ANSI_YELLOW = "\u001B[33m";
    final static String ANSI_RESET = "\u001B[0m";

    public static void display(){
        System.out.println("==========================================");
        System.out.println(ANSI_GREEN + "#         Bus Reservation System         #" + ANSI_RESET);
        System.out.println("==========================================");
        System.out.println("# Press 1 to Create New Bus              #");
        System.out.println("# Press 2 to Create New Customer         #");
        System.out.println("# Press 3 to Search All Busses           #");
        System.out.println("# Press 4 to Search Bus By Number        #");
        System.out.println("# Press 5 to Search Bus By Location      #");
        System.out.println("# Press 6 to Sort Customers New to Old   #");
        System.out.println("# Press 7 to Bus Reservation             #");
        System.out.println("# Press 8 to Search All Customers        #");
        System.out.println("# Press 9 to Customer Queue              #");
        System.out.println("# Press 10 to Customer by Age            #");
        System.out.println("# Press 0 to Exit                        #");
        System.out.println("#                                        #");
        System.out.println("==========================================");
    } 
}
