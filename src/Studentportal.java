import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Studentportal {

     public static int openPortal(Scanner sc,
                              HashMap<Integer, Complaint> complaintMap,HashMap<String,String> studentInfo, int compId){
         boolean isRunning=true;
         while (isRunning) {
             System.out.println("Prees 1 to raise complaint");
             System.out.println("Prees 2 to view complaint status");
             System.out.println("Prees 3 to exit");
             try {
                 int choise = sc.nextInt();
                 sc.nextLine();
                 switch (choise) {
                     case 1:
                         System.out.println("\n---Student portal---");
                         System.out.print("Enter Student Id :");
                         String stId = sc.nextLine().trim();

                         if (studentInfo.containsKey(stId)) {
                             System.out.println("welcome" + " " + studentInfo.get(stId));
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
                         } else {
                             System.out.println("student not valid");
                         }
                         break;
                     case 2:
                         System.out.print("Enter your Complaint ID to check status: ");
                         try{
                             int searchId = sc.nextInt();
                             sc.nextLine();


                             if (complaintMap.containsKey(searchId)) {
                                 Complaint found = complaintMap.get(searchId);

                                 System.out.print("Enter your Student ID for verification: ");
                                 String verifyStId = sc.nextLine().trim();

                                 if (found.studentId.equals(verifyStId)) {
                                     System.out.println("\n--- Complaint Status ---");
                                     System.out.println("ID: " + searchId);
                                     System.out.println("Status: " + found.status);
                                     System.out.println("Admin Note: " + (found.adminNote.isEmpty() ? "No response yet." : found.adminNote));
                                     System.out.println("------------------------");
                                 } else {
                                     System.out.println("Access Denied: Student ID does not match this Complaint ID.");
                                 }
                             } else {
                                 System.out.println("Error: Complaint ID #" + searchId + " not found.");
                             }
                             System.out.println("Press Enter to continue...");
                             sc.nextLine();

                             break;
                         }
                         catch (InputMismatchException e){
                             System.out.println("invalid input ! enter complaint id in numbers");
                             sc.nextLine();
                         }

                     case 3:
                         System.out.println("Exiting....");
                         isRunning = false;
                         break;
                     default:
                         System.out.println("select valid option!");
                         break;
                 }
             }
             catch (InputMismatchException e){
                 System.out.println("select valid option!");

                 sc.nextLine();

             }

         }





        return compId++;
    }
}
