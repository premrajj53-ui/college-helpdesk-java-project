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
                   Complaint c1 = new Complaint(compId,desc,"pending",stId,"");

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

                   System.out.println("Enter pin to login :");
                   int pass =sc. nextInt();if (pass==1234){
                   boolean adminLogin =true;
                   while (adminLogin) {
                       System.out.println("******************************");
                       System.out.println("Login successfull! as admin.");
                       System.out.println("******************************");

                       System.out.println("Prees 1 : to view all complaints and manage complaints");
                       System.out.println("prees 3 : to exit");
                       int adminChoice = sc.nextInt();
                       if (adminChoice ==1){
                           System.out.println("--- All complaints ---");
                           if (comlaintmap.isEmpty()){
                               System.out.println("No complaint has been raised yet!");

                           }else {
                           for (Complaint c: comlaintmap.values()) {
                               c.display();
                               sc.nextLine();

                           }
                               System.out.println("Enter complaint Id to update status(or 0 to go back)");
                           int checkId=-1;
                           checkId=sc.nextInt();
                           if (checkId==0){
                               System.out.println("Returning to dashboard...");
                               continue;
                           }
                           if (comlaintmap.containsKey(checkId)){

                               Complaint foundComplaint = comlaintmap.get(checkId);
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
                               continue;

                           }

                           }
                       }
                       else if (adminChoice == 2) {
                           adminLogin = false;
                           System.out.println("Logging out...");
                       }



                   }

               }

               else {
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
    }

}
