package emailapp;
import java.util.*;
public class EmailApp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //User info
        System.out.println("Enter first name: ");
        String f_name = s.next();
        System.out.println("Enter last name: ");
        String l_name = s.next();

        //Creating object for Email class
        Email em1 = new Email(f_name, l_name);
        int choice = -1;
        do{
            System.out.println("\n-----------------\nEnter your choice\n-----------------\n1.Show Info\n2.Change Password\n3.Change Mailbox Capacity\n4.Set Alternate Mail\n5.Store data in file\n6.Display data from file\n7.Exit");
            choice = s.nextInt();
            switch (choice) {
                case 1 -> em1.getInfo();
                case 2 -> em1.setPassword();
                case 3 -> em1.setMailCapacity();
                case 4 -> em1.alternateEmail();
                case 5 -> em1.storeFile();
                case 6 -> em1.readFile();
                case 7 -> System.out.println("Thank you for using application");
                default -> System.out.println("Invalid choice!\nEnter proper choice again");
            }
        }while(choice!=7);

    }
}
