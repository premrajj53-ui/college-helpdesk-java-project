import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;
        HashMap <Integer,Complaint> comlaintmap = new HashMap<>();
        int compId = 1;
       while (isRunning) {
           System.out.println(":---Help-Desk---:");
           System.out.println("Login as :");
           System.out.println("1.Student");
           System.out.println("2.Admin");
           System.out.println("3.Exit");
           System.out.println("Enter your choice: 1 , 2 ,3 :");
           int choice = sc.nextInt();
           switch (choice) {
               case 1:
                   System.out.println("\n---Student portal---");
                   System.out.print("Enter Student Id :");
                   int stId = sc.nextInt();
                   sc.nextLine();
                   System.out.println("Describe your issue : ");
                   String desc = sc.nextLine();
                   Complaint c1 = new Complaint(compId,desc,"pending",stId);

               comlaintmap.put(compId,c1);
                   System.out.println("\n------------------------------------");
                   System.out.println("Complaint raised successfully!");
                   System.out.println("------------------------------------");

                   System.out.println("Complaint Id :" + compId);
                   System.out.println("Complaint :" + desc);
                   System.out.println("Student Id :" + stId);
                   System.out.println("------------------------------------");
                   System.out.println("Press Enter to return to the main menu...");
                   sc.nextLine();


                   break;
               case 2:
                   System.out.println("---Admin portal---");
                   break;
               case 3:
                   System.out.printf("Exiting....");
                   isRunning = false;
                   break;
               default:
                   System.out.println("invalid choise. Enter : 1 , 2 or 3");
           }
       }
    }

}
