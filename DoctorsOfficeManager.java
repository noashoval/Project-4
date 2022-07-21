import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DoctorsOfficeManager {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome, please choose an option:");
        System.out.println("1. log in as a new user\n2. log in as an existing user");
        int loginAnswer = scan.nextInt();
        boolean logLoop;
        boolean existUser = false;
        String usernameInput;
        String passwordInput;
        String firstName;
        String lastname;
        String email;
        ArrayList<User> usersList = readUserFile("userFile.txt");
        User loggedUser = new User("username", "password", "first", "last", "email");
        do {
            switch (loginAnswer) {
                case 1:
                    System.out.println("Enter your username");
                    usernameInput = scan.nextLine();
                    if (usernameInput.trim().contains(" ")) {
                        System.out.println("Enter a username with no spaces");
                    } else if (!usernameInput.trim().contains(" ")) {
                        if (usersList.size() > 0) {
                            for (int i = 0; 1 < usersList.size(); i++) {
                                if (usersList.get(i).getUserName().equalsIgnoreCase(usernameInput.trim())) {
                                    System.out.println("This is now your username");
                                    existUser = false;
                                    break;
                                } else {
                                    existUser = true;
                                }
                            }
                        } else {
                            existUser = true;
                        }
                    }
                    if (existUser) {
                        boolean passwordCreated;
                        do {
                            passwordCreated = false;
                            System.out.println("Enter a password");
                            passwordInput = scan.nextLine();

                            System.out.println("Please enter your first name.");
                            firstName = scan.nextLine().trim();
                            firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);

                            System.out.println("Please enter your last name.");
                            lastname = scan.nextLine().trim();
                            lastname = lastname.substring(0, 1).toUpperCase() + lastname.substring(1);

                            System.out.println("Please enter your email");
                            email = scan.nextLine().trim();


                            User user = new User(usernameInput, passwordInput, firstName, lastname, email);
                            boolean loop;
                            do {
                                loop = false;
                                System.out.println("What type of account do you want?");
                                System.out.println("Are you a seller or customer?");
                                System.out.println("1.Seller" + '\n' + "2.Customer");
                                String accountType = scan.nextLine();

                                if (accountType.equals("1")) {
                                    loggedUser = new Seller(usernameInput, passwordInput, firstName, lastname, email);
                                    usersList.add(loggedUser);
                                } else if (accountType.equals("2")) {
                                    loggedUser = new Customer(usernameInput, passwordInput, firstName, lastname, email);
                                    usersList.add(loggedUser);
                                } else {
                                    System.out.println("That is an invalid option");
                                    loop = true;
                                }


                            } while (loop);
                        } while (passwordCreated);
                    }
                    //user login logic here
                    //sout("create username");
                    //if username exists sout("error this username is already taken! choose another one)
                    //sout("create password");
                    //don't need to check if password exists
                    //enter user type (either doctor or patient)
                    //user created!

                    break;
                case 2:
                    //logging in
                    System.out.println("Enter your username");
                    usernameInput = scan.nextLine();
                    for (int i = 0; i < usersList.size(); i++) {
                        if (usersList.get(i).getUserName().equalsIgnoreCase(usernameInput.trim())) {
                            System.out.println("Enter your password");
                            passwordInput = scan.nextLine();

                            if (usersList.get(i).getPassword().equals(passwordInput.trim())) {
                                System.out.println("You have been successfully logged in!");
                                loggedUser = usersList.get(i);
                                break;
                            } else {
                                System.out.println("That is an incorrect password");
                                logLoop = true;
                                break;
                            }
                        }
                    }



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
    public static ArrayList<User> readUserFile(String filename) {
        ArrayList<User> userArrayList = new ArrayList<>();

        try {
            FileInputStream file = new FileInputStream(new File(filename));
            ObjectInputStream objectInput = new ObjectInputStream(file);
            userArrayList = (ArrayList<User>) objectInput.readObject();
            objectInput.close();
            file.close();
        } catch (FileNotFoundException e ) {
            System.out.println("The user file was not found.");
            return new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return userArrayList;
    }
}
