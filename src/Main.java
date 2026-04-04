import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);

        boolean isRunning = true;
        HashMap <Integer,Complaint> comlaintMap = new HashMap<>();
        HashMap <String,String>studentsInfoMap = new HashMap<>();
        Fileswork.studentsInfo(studentsInfoMap);

        int compId = 1;
       while (isRunning) {
           System.out.println(":---Help-Desk---:");
           System.out.println("Login as :");
           System.out.println("1.Student");
           System.out.println("2.Admin");
           System.out.println("3.Exit");
           try {
               System.out.print("Enter your choice: 1 , 2 ,3 :");

               int choice = sc.nextInt();
               sc.nextLine();

               switch (choice) {
                   case 1:
                   compId=   Studentportal.openPortal(sc,comlaintMap ,studentsInfoMap,compId);


                       break;
                   case 2:
                       System.out.println("---Admin portal---");

                       System.out.println("Enter pin to login :");
                       String pass = sc.nextLine();
                       String savedPass = "1234";
                       if (pass.equals(savedPass) ) {
                           boolean adminLogin = true;
                           while (adminLogin) {
                               System.out.println("******************************");
                               System.out.println("Login successfull! as admin.");
                               System.out.println("******************************");
                                try{ System.out.println("Prees 1 : to view all complaints and manage complaints");
                                    System.out.println("prees 2 : to exit");
                                    int adminChoice = sc.nextInt();
                                    if (adminChoice == 1) {
                                        System.out.println("--- All complaints ---");
                                        if (comlaintMap.isEmpty()) {
                                            System.out.println("No complaint has been raised yet!");

                                        } else {
                                            for (Complaint c : comlaintMap.values()) {
                                                c.display();
                                                System.out.println("-----------------------");
                                                sc.nextLine();
                                            }
                                            try{System.out.println("Enter complaint Id to update status(or 0 to go back)");
                                                int checkId = -1;
                                                checkId = sc.nextInt();
                                                sc.nextLine();
                                                if (checkId == 0) {
                                                    System.out.println("Returning to dashboard...");
                                                    continue;
                                                }
                                                if (comlaintMap.containsKey(checkId)) {

                                                    Complaint foundComplaint = comlaintMap.get(checkId);
                                                    System.out.println("current status:" + foundComplaint.status);

                                                    System.out.println("Enter new status (e.g., Resolved, In Progress or Rejected) :");
                                                    String newStatus = sc.nextLine();
                                                    foundComplaint.status = newStatus;



                                                    System.out.print("Add a note explaining why (or press Enter to skip): ");
                                                    String newNote = sc.nextLine();
                                                    if (!newNote.isEmpty()) {
                                                        foundComplaint.adminNote = newNote;
                                                    }

                                                    System.out.println(" Ticket #" + checkId + " successfully updated!");
                                                    System.out.println("Press Enter to return to the main menu...");
                                                    sc.nextLine();
                                                    continue;


                                                }
                                            }
                                            catch (InputMismatchException e){
                                                System.out.println(" Please enter a valid NUMBER ID!");
                                                sc.nextLine();
                                            }


                                        }
                                    } else if (adminChoice == 2) {
                                        adminLogin = false;
                                        System.out.println("Logging out...");
                                    }
                                }
                                catch (InputMismatchException e){
                                    System.out.println("Invalid input! Please enter 1 or 2.");
                                    sc.nextLine();
                                }


                           }

                       } else {
                           System.out.println(" Access Denied: Incorrect password.");

                       }
                       break;
                   case 3:
                       System.out.print("Exiting....");
                       isRunning = false;
                       break;
                   default:
                       System.out.println("invalid choise. Enter : 1 , 2 or 3");

               }
           }
           catch (InputMismatchException e){
               System.out.println("Enter valid number (1,2 or 3)");
               sc.nextLine();
           }
       }
    }


}
