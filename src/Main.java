import java.util.Scanner;

public class Main {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;
       while (isRunning) {
           System.out.println(":---Help-Desk---:");
           System.out.println("Login as :");
           System.out.println("1.Student");
           System.out.println("2.Admin");
           System.out.println("3.Exit");
           System.out.println("Enter your choise: 1 , 2 ,3 :");
           int choise = sc.nextInt();
           switch (choise) {
               case 1:
                   System.out.printf("\n---Student portal---");

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
