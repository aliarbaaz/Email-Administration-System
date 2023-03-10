package emailapp;
import java.util.*;
import java.io.*;
public class Email {
    public Scanner s = new Scanner(System.in);
    //Setting variables as private to not give any access directly
    private String fname;
    private String lname;
    private String dept;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alter_email;
    //Constructor to receive first name, last name
    public Email(String fname, String lname){
        this.fname = fname;
        this.lname = lname;
        System.out.println("New Employee: " + this.fname + " " + this.lname);
        //Calling methods
        this.dept = this.setDept();//set Department
        this.password = this.generatePassword(8);//generate password
        this.email = this.generateEmail();//generate email





    }
    //Method to generate mail
    private String generateEmail(){
        return this.fname.toLowerCase() + "." + this.lname.toLowerCase() + "@" + this.dept.toLowerCase() + ".department.com";
    }
    //Asking for department
    private String setDept(){
        System.out.println("Department Codes\n1 for Information Technology \n2 for Computer Science \n3 for Data Science \n0 for None");
        boolean flag = false;
        do{
            System.out.println("Enter Department Code: ");
            int choice  = s.nextInt();
            switch (choice){
                case 1:
                    return "IT";
                case 2:
                    return "CSE";
                case 3:
                    return "DS";
                case 0:
                    return "None";
                default:
                    System.out.println("Invalid choice please choose it again");
            }
        }while(!flag);
        return null;
    }
    //Generating Random Password method
    private String generatePassword(int length){
        Random r = new Random();
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "012356789";
        String symbols = "!@#$%&?";
        String values = Capital_chars + Small_chars + numbers + symbols;
        String password = "";
        for(int i=0;i<length;i++){
            password = password + values.charAt(r.nextInt(values.length()));
        }
        return password;
    }
    //Change password method
    public void setPassword(){
        boolean flag = false;
        do{
            System.out.println("Do you want to change your password!(Y/N): ");
            char choice = s.next().charAt(0);
            if(choice=='Y' || choice=='y'){
                flag = true;
                System.out.println("Enter current password: ");
                String temp = s.next();
                if(temp.equals(this.password)){
                    System.out.println("Enter new password: ");
                    this.password = s.next();
                    System.out.println("Password changed successfully");
                }
                else{
                    System.out.println("Incorrect password");
                }
            }
            else if(choice=='N' || choice=='n'){
                flag = true;
                System.out.println("Password changed option cancelled");
            }
            else{
                System.out.println("Enter valid choice");
            }
        }while(!flag);
    }
    //Set mailbox capacity method
    public void setMailCapacity(){
        System.out.println("Current capacity = " + this.mailCapacity + "mb");
        System.out.println("Enter new mailbox capacity: ");
        this.mailCapacity = s.nextInt();
        System.out.println("Mailbox capacity is successfully changed");
    }
    //Set Alternate Mail
    public void alternateEmail(){
        System.out.println("Enter new alternate email: ");
        this.alter_email = s.next();
        System.out.println("Alternate email is set");
    }
    //Display user information method
    public void getInfo(){
        System.out.println("Name: " + this.fname + " " + this.lname);
        System.out.println("Department: " + this.dept);
        System.out.println("Email: " + this.email);
        System.out.println("Password: " + this.password);
        System.out.println("Mailbox capacity: " + this.mailCapacity + "mb");
        System.out.println("Alternate mail: " + this.alter_email);
    }
    //Store in File
    public void storeFile(){
        try{
            FileWriter in = new FileWriter("D:\\Java Project\\info.txt");
            in.write("First name: " + this.fname);
            in.append("\nLast name: " + this.lname);
            in.append("\nPassword: " + this.password);
            in.append("\nCapacity: " + this.mailCapacity);
            in.append("\nAlternative mail: " + this.alter_email);
            in.close();
            System.out.println("Data Stored..");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    //Reading File method
    public void readFile(){
        try{
            FileReader f1 = new FileReader("D:\\Java Project\\info.txt");
            int i;
            while((i=f1.read())!=-1){
                System.out.print((char)i);
            }
            f1.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
