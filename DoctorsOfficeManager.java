import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DoctorsOfficeManager {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean logLoop;
        boolean existUser;
        String usernameInput = null;
        int userType;
        String passwordInput;
        ArrayList<Seller> sellersList = new ArrayList<>();
        ArrayList<Customer> customersList = new ArrayList<>();
        boolean invalid = true;
        boolean valid = false;

        System.out.println("Welcome, please choose an option:");
        int loginAnswer;
        do {
            System.out.println("1. log in as a new user\n2. log in as an existing user");
            loginAnswer = scan.nextInt();
            scan.nextLine();
            switch (loginAnswer) {
                case 1 -> {
                    System.out.println("Please Enter Your First Name");
                    String firstName = scan.nextLine();
                    System.out.println("Please Enter Your Last Name");
                    String lastName = scan.nextLine();
                    System.out.println("Please Enter Your Email");
                    String email = scan.nextLine();
                    System.out.println("Please Enter Your Password");
                    String password = scan.nextLine();
                    invalid = true;
                    do {
                        System.out.println("Are you signing in as 1. Doctor or 2. Patient?");
                        userType = scan.nextInt();
                        scan.nextLine();
                        switch (userType) {
                            case 1 -> {
                                String userName = "Seller";
                                Seller sell = new Seller(userName, password, firstName, lastName, email);
                                sellersList.add(sell);
                                invalid = false;
                            }
                            case 2 -> {
                                String userName = "Customer";
                                Customer customer = new Customer(userName, password, firstName, lastName, email);
                                customersList.add(customer);
                                invalid = false;
                            }
                            default -> System.out.println("Invalid User type please.");
                        }
                    } while (invalid);
                    System.out.println("Account Created");
                    valid = false;
                }
                case 2 -> {
                    invalid = true;
                    do {
                        System.out.println("Are you signing in as 1. Doctor or 2. Patient?");
                        userType = scan.nextInt();
                        scan.nextLine();
                        switch (userType) {
                            case 1 -> {
                                System.out.println("Enter your firstName");
                                String FirstNameInput = scan.nextLine();
                                for (int i = 0; i < sellersList.size(); i++) {
                                    if (sellersList.get(i).getFirstName().equalsIgnoreCase(FirstNameInput)) {
                                        System.out.println("Enter your password");
                                        passwordInput = scan.nextLine();
                                        if (sellersList.get(i).getPassword().equals(passwordInput.trim())) {
                                            System.out.println("You have been successfully logged in!");
                                            invalid = true;
                                            do {
                                                int input;
                                                System.out.println("1. Create Store\n2. View Existing Store\n3. " +
                                                        "Edit Account\n4. Delete Account 5. Exit");
                                                input = scan.nextInt();
                                                scan.nextLine();
                                                switch (input) {
                                                    case 1 -> {
                                                        System.out.println("Please enter a Store Name");
                                                        Store store = new Store(scan.nextLine());
                                                        sellersList.get(i).addStore(store);
                                                        System.out.println("Store created!");
                                                    }
                                                    case 2 -> {
                                                        System.out.println("Enter store name");
                                                        String storeName = scan.nextLine();
                                                        for (int j = 0; j < sellersList.get(i).getStores().
                                                                size(); j++) {
                                                            if(storeName.equalsIgnoreCase(sellersList.get(i).
                                                                    getStores().get(j).storeName)) {
                                                                System.out.println("Store Found");
                                                                invalid = true;
                                                                do {
                                                                    System.out.println("1. Create Calendar\n 2. " +
                                                                            "View Calendar\n 3. Exit");
                                                                    input = scan.nextInt();
                                                                    scan.nextLine();
                                                                    switch (input) {
                                                                        case 1 -> {
                                                                            System.out.println("Enter Calendar Name");
                                                                            String calendarName = scan.nextLine();
                                                                            System.out.println("Enter Calendar " +
                                                                                    "Description");
                                                                            String description = scan.nextLine();
                                                                            Calendar calendar = new Calendar(
                                                                                    calendarName, description);
                                                                            sellersList.get(i).getStores().get(j).
                                                                                    getCalendarList().add(calendar);
                                                                            System.out.println("Calendar Created");
                                                                        }
                                                                        case 2 -> {
                                                                            System.out.println("Enter Calendar Name");
                                                                            String calendarName = scan.nextLine();
                                                                            for(int k = 0; k < sellersList.get(i).getStores().get(j).getCalendarList().size(); k++) {
                                                                                if(calendarName.equalsIgnoreCase(sellersList.get(i).getStores().get(j).getCalendarList().get(k).getCalendarName())) {
                                                                                    System.out.println("Calendar Found");
                                                                                    do {
                                                                                        System.out.println("1. Create Appointment window\n" +
                                                                                                "2. Edit Appointment window\n" +
                                                                                                "3. Delete appointment Window\n" +
                                                                                                "4. View Calendar\n" +
                                                                                                "5. Appointment requests\n" +
                                                                                                "6.Exit");
                                                                                        input = scan.nextInt();
                                                                                        scan.nextLine();
                                                                                        switch (input){
                                                                                            case 1 -> {
                                                                                                System.out.println("Enter Appointment Name");
                                                                                                String appointmentName = scan.nextLine();
                                                                                                System.out.println("Enter Start Time");
                                                                                                String startTime = scan.nextLine();
                                                                                                System.out.println("Enter End Time");
                                                                                                String endTime = scan.nextLine();
                                                                                                Appointment appointment = new Appointment(appointmentName, startTime, endTime);
                                                                                                sellersList.get(i).getStores().get(j).getCalendarList().get(k).appointments.add(appointment);
                                                                                                System.out.println("Appointment Created");
                                                                                            }
                                                                                            case 2 -> {
                                                                                                System.out.println("Enter Original Appointment Name");
                                                                                                String originAppointmentName = scan.nextLine();
                                                                                                System.out.println("Enter New Appointment Name");
                                                                                                String appointmentName = scan.nextLine();
                                                                                                System.out.println("Enter Start Time");
                                                                                                String startTime = scan.nextLine();
                                                                                                System.out.println("Enter End Time");
                                                                                                String endTime = scan.nextLine();
                                                                                                (sellersList.get(i).getStores().get(j).getCalendarList().get(k).searchByTitle(originAppointmentName, sellersList.get(i).getStores().get(j).getCalendarList().get(k).appointments)).setTitle(appointmentName);
                                                                                                System.out.println("Title Set");
                                                                                                (sellersList.get(i).getStores().get(j).getCalendarList().get(k).searchByTitle(originAppointmentName, sellersList.get(i).getStores().get(j).getCalendarList().get(k).appointments)).setStartTime(startTime);
                                                                                                System.out.println("Start Time Set");
                                                                                                (sellersList.get(i).getStores().get(j).getCalendarList().get(k).searchByTitle(originAppointmentName, sellersList.get(i).getStores().get(j).getCalendarList().get(k).appointments)).setEndTime(endTime);
                                                                                                System.out.println("End Time Set");
                                                                                            }
                                                                                            case 3 -> {
                                                                                                System.out.println("Enter Appointment Name");
                                                                                                String appointmentName = scan.nextLine();
                                                                                                sellersList.get(i).getStores().get(j).getCalendarList().get(k).removeAppointment(sellersList.get(i).getStores().get(j).getCalendarList().get(k).searchByTitle(appointmentName, sellersList.get(i).getStores().get(j).getCalendarList().get(k).appointments));
                                                                                            }
                                                                                            case 4 -> {
                                                                                                sellersList.get(i).getStores().get(j).getCalendarList().get(k).viewCalendar();
                                                                                            }
                                                                                            case 5 -> {
                                                                                                System.out.println("Approval Appointments");
                                                                                                String a;
                                                                                                for(int q = 0; q < sellersList.get(i).getStores().size(); q++) {

                                                                                                    for(int w = 0; w < sellersList.get(i).getStores().get(q).calendarList.size(); w++) {

                                                                                                        for(int e = 0; e < sellersList.get(i).getStores().get(q).calendarList.get(w).apptRequests.size(); e++) {
                                                                                                            System.out.println(sellersList.get(i).getStores().get(q).calendarList.get(w).apptRequests.get(e));
                                                                                                            System.out.println("Approve request?(Enter Yes/No)");
                                                                                                            a = scan.nextLine();
                                                                                                            if(a.equalsIgnoreCase("yes")) {
                                                                                                                sellersList.get(i).approveApptRequest(sellersList.get(i).getStores().get(q).calendarList.get(w).apptRequests.get(e), q, w);
                                                                                                            } else if (a.equalsIgnoreCase("no")) {
                                                                                                                sellersList.get(i).denyApptRequest(sellersList.get(i).getStores().get(q).calendarList.get(w).apptRequests.get(e), q, w);
                                                                                                            } else {
                                                                                                                System.out.println("ERROR");
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            case 6 -> {
                                                                                                invalid = false;
                                                                                            }
                                                                                            default -> System.out.println("Invalid input");
                                                                                        }
                                                                                    } while (invalid);
                                                                                    invalid = true;
                                                                                }
                                                                            }
                                                                        } case 3 -> {
                                                                            invalid = false;
                                                                        }
                                                                        default -> System.out.println("Invalid input");
                                                                    }
                                                                } while (invalid);
                                                                invalid = true;
                                                            }
                                                        }
                                                    }
                                                    case 3 -> {
                                                        do {
                                                            System.out.println("1. Change Email\n 2. Change Password");
                                                            input = scan.nextInt();
                                                            scan.nextLine();
                                                        } while(invalid);
                                                    }
                                                    case 4 -> {
                                                        sellersList.remove(i);
                                                        System.out.println("Account Deleted");
                                                    } case 5 -> {
                                                        invalid = false;
                                                    }
                                                    default -> System.out.println("Please Select a valid choice");
                                                }
                                            } while(invalid);
                                            invalid = true;
                                        } else {
                                            System.out.println("That is an incorrect password");
                                            logLoop = true;
                                            break;
                                        }
                                    }
                                }
                                invalid = false;
                            }
                            case 2 -> {
                                String userName = "Customer";
                                System.out.println("Enter your firstName");
                                String FirstNameInput = scan.nextLine();
                                for (int i = 0; i < customersList.size(); i++) {
                                    if (customersList.get(i).getFirstName().equalsIgnoreCase(FirstNameInput)) {
                                        System.out.println("Enter your password");
                                        passwordInput = scan.nextLine();
                                        if (customersList.get(i).getPassword().equals(passwordInput.trim())) {
                                            System.out.println("You have been successfully logged in!");
                                            invalid = true;
                                            do {
                                                int input;
                                                System.out.println("1. List Stores by Seller\n 2. View Store\n3. List Approved Appointments\n" +
                                                        "4. Edit Account 5. Delete Account 6. Exit");
                                                input = scan.nextInt();
                                                scan.nextLine();
                                                switch (input) {
                                                    case 1 -> {

                                                    }
                                                    case 2 -> {

                                                    }
                                                    case 3 -> {

                                                    }
                                                    case 4 -> {

                                                    }
                                                    case 5 -> {

                                                    }
                                                    case 6 -> {
                                                        invalid = false;
                                                    }
                                                    default -> System.out.println("Please Select a valid choice");
                                                }
                                            } while(invalid);

                                        } else {
                                            System.out.println("That is an incorrect password");
                                            logLoop = true;
                                            break;
                                        }
                                    }
                                }
                                invalid = false;
                            }
                            default -> System.out.println("Invalid User type please.");
                        }
                    } while (invalid);


                    valid = true;
                }
                default -> {
                    System.out.println("Invalid option, please choose an option:");
                    System.out.println();
                    System.out.println("1. log in as a new user\n2. log in as an existing user");
                    loginAnswer = scan.nextInt();
                    valid = false;
                }
            }
        } while (!valid);
    }
    /*public static ArrayList<User> readUserFile(String filename) {
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
    }*/
}
