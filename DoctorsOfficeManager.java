import java.util.Scanner;

public class DoctorsOfficeManager {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome, please choose an option:");
        System.out.println("1. log in as a new user\n2. log in as an existing user");
        int loginAnswer = scan.nextInt();
        do {
            switch (loginAnswer) {
                case 1:
                    //user login logic here
                    //sout("create username");
                    //if username exists sout("error this username is already taken! choose another one)
                    //sout("create password");
                    //don't need to check if password exists
                    //enter user type (either doctor or patient)
                    //user created!
                    break;
                case 2:
                    //user login logic here
                    // sout("enter username");
                    //sout("enter password");
                    //either account found! or account not found try to log in to existing user again? or new

                    break;
                default:
                    System.out.println("Invalid option, please choose an option:");
                    System.out.println();
                    System.out.println("1. log in as a new user\n2. log in as an existing user");
                    loginAnswer = scan.nextInt();
                    break;
            }
        } while (loginAnswer > 0 && loginAnswer <= 2);
    }
}
