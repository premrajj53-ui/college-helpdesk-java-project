import java.util.HashMap;
import java.util.Scanner;

public class Studentportal {

     public static int openPortal(Scanner sc,
                              HashMap<Integer, Complaint> complaintMap,HashMap<String,String> studentInfo, int compId){
         boolean isRunning=true;
         while (isRunning) {
             System.out.println("Prees 1 to raise complaint");
             System.out.println("Prees 2 to view complaint status");
             System.out.println("Prees 3 to exit");
             int choise = sc.nextInt();
             sc.nextLine();
             switch (choise) {
                 case 1:
                     System.out.println("\n---Student portal---");
                     System.out.print("Enter Student Id :");
                     String stId = sc.nextLine().trim();

                     if (studentInfo.containsKey(stId)) {
                         System.out.println("Describe your issue : ");
                         String desc = sc.nextLine();
                         Complaint c1 = new Complaint(compId, desc, "", stId, "");

                         complaintMap.put(compId, c1);
                         System.out.println("\n------------------------------------");
                         System.out.println("Complaint raised successfully!");
                         System.out.println("------------------------------------");
                         System.out.println("Complaint Id :" + compId);
                         System.out.println("Complaint :" + desc);
                         System.out.println("Student Id :" + stId);
                         System.out.println("------------------------------------");
                         System.out.println("Press Enter to return to the main menu...");
                         compId++;
                         sc.nextLine();
                     }
                     else {
                         System.out.println("student not valid");
                     }
                     break;
                 case 2:
                     System.out.println("view complaint");
                     break;
                 case 3:
                     System.out.println("Exiting....");
                     isRunning=false;
                     break;
                 default:
                     System.out.println("select valid option!");
                     break;
             }
         }





        return compId++;
    }
}
