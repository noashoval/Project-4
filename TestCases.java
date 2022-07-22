import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.io.*;

import static org.junit.Assert.*;

public class TestCases {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestCases.class);
        System.out.printf("Test Count: %d.\n", result.getRunCount());
        if (result.wasSuccessful()) {
            System.out.printf("Excellent - all local tests ran successfully.\n");
        } else {
            System.out.printf("Tests failed: %d.\n", result.getFailureCount());
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        }
    }
    private final PrintStream originalOutput = System.out;
    private final InputStream originalSysin = System.in;

    @SuppressWarnings("FieldCanBeLocal")
    private ByteArrayInputStream testIn;

    @SuppressWarnings("FieldCanBeLocal")
    private ByteArrayOutputStream testOut;

    @Before
    public void outputStart() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @After
    public void restoreInputAndOutput() {
        System.setIn(originalSysin);
        System.setOut(originalOutput);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @SuppressWarnings("SameParameterValue")
    private void receiveInput(String str) {
        testIn = new ByteArrayInputStream(str.getBytes());
        System.setIn(testIn);
    }

    //Tests store creation
    @Test(timeout = 5000)
    public void AccountCreationTest() throws AppointmentNotFoundException {
        // Set the input
        // Separate each input with a newline (\n).
        String input = "1" + System.lineSeparator() +
                "FirstName" + System.lineSeparator() +
                "LastName" + System.lineSeparator() +
                "Email" + System.lineSeparator() +
                "password" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "3" + System.lineSeparator();

        // Pair the input with the expected result
        String expected = "Welcome, please choose an option:" + System.lineSeparator() +
                "1. log in as a new user\n2. log in as an existing user\n3.End Application(For testing)" + System.lineSeparator() +
                "Please Enter Your First Name" + System.lineSeparator() +
                "Please Enter Your Last Name" + System.lineSeparator() +
                "Please Enter Your Email" + System.lineSeparator() +
                "Please Enter Your Password" + System.lineSeparator() +
                "Are you signing in as 1. Doctor or 2. Patient?" + System.lineSeparator() +
                "Account Created" + System.lineSeparator() +
                "1. log in as a new user\n2. log in as an existing user\n3.End Application(For testing)" + System.lineSeparator();

        // Runs the program with the input values
        // Replace TestProgram with the name of the class with the main method
        receiveInput(input);
        DoctorsOfficeManager.main(new String[0]);

        // Retrieves the output from the program
        String output = getOutput();

        // Trims the output and verifies it is correct.
        expected = expected.replaceAll("\r\n", "\n");
        output = output.replaceAll("\r\n", "\n");
        assertEquals("Ensure Account is created",
                expected.trim(), output.trim());


    }

    //Tests accound login and store creation
    @Test(timeout = 5000)
    public void logInRequestAndStoreCreationTest() throws AppointmentNotFoundException {
        // Set the input
        // Separate each input with a newline (\n).
        String input = "1" + System.lineSeparator() +
                "FirstName" + System.lineSeparator() +
                "LastName" + System.lineSeparator() +
                "Email" + System.lineSeparator() +
                "password" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "FirstName" + System.lineSeparator() +
                "password" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "storeName" + System.lineSeparator() +
                "5" + System.lineSeparator() +
                "3" + System.lineSeparator();

        // Pair the input with the expected result
        String expected = "Welcome, please choose an option:" + System.lineSeparator() +
                "1. log in as a new user\n2. log in as an existing user\n3.End Application(For testing)" + System.lineSeparator() +
                "Please Enter Your First Name" + System.lineSeparator() +
                "Please Enter Your Last Name" + System.lineSeparator() +
                "Please Enter Your Email" + System.lineSeparator() +
                "Please Enter Your Password" + System.lineSeparator() +
                "Are you signing in as 1. Doctor or 2. Patient?" + System.lineSeparator() +
                "Account Created" + System.lineSeparator() +
                "1. log in as a new user\n2. log in as an existing user\n3.End Application(For testing)" + System.lineSeparator() +
                "Are you signing in as 1. Doctor or 2. Patient?" + System.lineSeparator() +
                "Enter your firstName" + System.lineSeparator() +
                "Enter your password" + System.lineSeparator() +
                "You have been successfully logged in!" + System.lineSeparator() +
                "1.Create Store\n2.View Existing Store\n3.Edit Account\n4.Delete Account\n5.Logout" + System.lineSeparator() +
                "Please enter a Store Name" + System.lineSeparator() +
                "Store created!" + System.lineSeparator() +
                "1.Create Store\n2.View Existing Store\n3.Edit Account\n4.Delete Account\n5.Logout" + System.lineSeparator() +
                "1. log in as a new user\n2. log in as an existing user\n3.End Application(For testing)";

        // Runs the program with the input values
        // Replace TestProgram with the name of the class with the main method
        receiveInput(input);
        DoctorsOfficeManager.main(new String[0]);

        // Retrieves the output from the program
        String output = getOutput();

        // Trims the output and verifies it is correct.
        expected = expected.replaceAll("\r\n", "\n");
        output = output.replaceAll("\r\n", "\n");
        assertEquals("Ensure Log in and Store creation run correctly",
                expected.trim(), output.trim());


    }

    //Test determines if the edit store option and create Calendar option works
    @Test(timeout = 5000)
    public void editStoreAndCreateCalendarTest() throws AppointmentNotFoundException {
        // Set the input
        // Separate each input with a newline (\n).
        String input = "1" + System.lineSeparator() +
                "FirstName" + System.lineSeparator() +
                "LastName" + System.lineSeparator() +
                "Email" + System.lineSeparator() +
                "password" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "FirstName" + System.lineSeparator() +
                "password" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "storeName" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "storeName" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "calendarName" + System.lineSeparator() +
                "calendarDescription" + System.lineSeparator() +
                "4" + System.lineSeparator() +
                "5" + System.lineSeparator() +
                "3" + System.lineSeparator();

        // Pair the input with the expected result
        String expected = "Welcome, please choose an option:" + System.lineSeparator() +
                "1. log in as a new user\n2. log in as an existing user\n3.End Application(For testing)" + System.lineSeparator() +
                "Please Enter Your First Name" + System.lineSeparator() +
                "Please Enter Your Last Name" + System.lineSeparator() +
                "Please Enter Your Email" + System.lineSeparator() +
                "Please Enter Your Password" + System.lineSeparator() +
                "Are you signing in as 1. Doctor or 2. Patient?" + System.lineSeparator() +
                "Account Created" + System.lineSeparator() +
                "1. log in as a new user\n2. log in as an existing user\n3.End Application(For testing)" + System.lineSeparator() +
                "Are you signing in as 1. Doctor or 2. Patient?" + System.lineSeparator() +
                "Enter your firstName" + System.lineSeparator() +
                "Enter your password" + System.lineSeparator() +
                "You have been successfully logged in!" + System.lineSeparator() +
                "1.Create Store\n2.View Existing Store\n3.Edit Account\n4.Delete Account\n5.Logout" + System.lineSeparator() +
                "Please enter a Store Name" + System.lineSeparator() +
                "Store created!" + System.lineSeparator() +
                "1.Create Store\n2.View Existing Store\n3.Edit Account\n4.Delete Account\n5.Logout" + System.lineSeparator() +
                "Enter store name" + System.lineSeparator() +
                "Store Found" + System.lineSeparator() +
                "1.Create Calendar\n2.View Calendar\n3. Delete Calendar\n4.Exit" + System.lineSeparator() +
                "Enter Calendar Name" + System.lineSeparator() +
                "Enter Calendar Description" + System.lineSeparator() +
                "Calendar Created" + System.lineSeparator() +
                "1.Create Calendar\n2.View Calendar\n3. Delete Calendar\n4.Exit" + System.lineSeparator() +
                "1.Create Store\n2.View Existing Store\n3.Edit Account\n4.Delete Account\n5.Logout" + System.lineSeparator() +
                "1. log in as a new user\n2. log in as an existing user\n3.End Application(For testing)";

        // Runs the program with the input values
        // Replace TestProgram with the name of the class with the main method
        receiveInput(input);
        DoctorsOfficeManager.main(new String[0]);

        // Retrieves the output from the program
        String output = getOutput();

        // Trims the output and verifies it is correct.
        expected = expected.replaceAll("\r\n", "\n");
        output = output.replaceAll("\r\n", "\n");
        assertEquals("Ensure Edit Store and Calendar Creation work Properly",
                expected.trim(), output.trim());
    }

    //Test determines if the edit calendar and all the appointment options work
    @Test(timeout = 5000)
    public void editCalendarAndAppointmentTest() throws AppointmentNotFoundException {
        // Set the input
        // Separate each input with a newline (\n).
        String input = "1" + System.lineSeparator() +
                "FirstName" + System.lineSeparator() +
                "LastName" + System.lineSeparator() +
                "Email" + System.lineSeparator() +
                "password" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "FirstName" + System.lineSeparator() +
                "password" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "storeName" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "storeName" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "calendarName" + System.lineSeparator() +
                "calendarDescription" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "calendarName" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "appName1" + System.lineSeparator() +
                "1:00" + System.lineSeparator() +
                "2:00" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "appName2" + System.lineSeparator() +
                "3:00" + System.lineSeparator() +
                "5:00" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "appName1" + System.lineSeparator() +
                "appNameChange" + System.lineSeparator() +
                "6:00" + System.lineSeparator() +
                "8:00" + System.lineSeparator() +
                "3" + System.lineSeparator() +
                "appName2" + System.lineSeparator() +
                "6" + System.lineSeparator() +
                "4" + System.lineSeparator() +
                "5" + System.lineSeparator() +
                "3" + System.lineSeparator();

        // Pair the input with the expected result
        String expected = "Welcome, please choose an option:" + System.lineSeparator() +
                "1. log in as a new user\n2. log in as an existing user\n3.End Application(For testing)" + System.lineSeparator() +
                "Please Enter Your First Name" + System.lineSeparator() +
                "Please Enter Your Last Name" + System.lineSeparator() +
                "Please Enter Your Email" + System.lineSeparator() +
                "Please Enter Your Password" + System.lineSeparator() +
                "Are you signing in as 1. Doctor or 2. Patient?" + System.lineSeparator() +
                "Account Created" + System.lineSeparator() +
                "1. log in as a new user\n2. log in as an existing user\n3.End Application(For testing)" + System.lineSeparator() +
                "Are you signing in as 1. Doctor or 2. Patient?" + System.lineSeparator() +
                "Enter your firstName" + System.lineSeparator() +
                "Enter your password" + System.lineSeparator() +
                "You have been successfully logged in!" + System.lineSeparator() +
                "1.Create Store\n2.View Existing Store\n3.Edit Account\n4.Delete Account\n5.Logout" + System.lineSeparator() +
                "Please enter a Store Name" + System.lineSeparator() +
                "Store created!" + System.lineSeparator() +
                "1.Create Store\n2.View Existing Store\n3.Edit Account\n4.Delete Account\n5.Logout" + System.lineSeparator() +
                "Enter store name" + System.lineSeparator() +
                "Store Found" + System.lineSeparator() +
                "1.Create Calendar\n2.View Calendar\n3. Delete Calendar\n4.Exit" + System.lineSeparator() +
                "Enter Calendar Name" + System.lineSeparator() +
                "Enter Calendar Description" + System.lineSeparator() +
                "Calendar Created" + System.lineSeparator() +
                "1.Create Calendar\n2.View Calendar\n3. Delete Calendar\n4.Exit" + System.lineSeparator() +
                "Enter Calendar Name" + System.lineSeparator() +
                "Calendar Found" + System.lineSeparator() +
                "1.Create Appointment window\n2.Edit Appointment window\n3.Delete appointment Window" +
                "\n4.View Calendar\n5.Appointment requests\n6.Exit" + System.lineSeparator() +
                "Enter Appointment Name" + System.lineSeparator() +
                "Enter Start Time" + System.lineSeparator() +
                "Enter End Time" + System.lineSeparator() +
                "Appointment Created" + System.lineSeparator() +
                "1.Create Appointment window\n2.Edit Appointment window\n3.Delete appointment Window" +
                "\n4.View Calendar\n5.Appointment requests\n6.Exit" + System.lineSeparator() +
                "Enter Appointment Name" + System.lineSeparator() +
                "Enter Start Time" + System.lineSeparator() +
                "Enter End Time" + System.lineSeparator() +
                "Appointment Created" + System.lineSeparator() +
                "1.Create Appointment window\n2.Edit Appointment window\n3.Delete appointment Window" +
                "\n4.View Calendar\n5.Appointment requests\n6.Exit" + System.lineSeparator() +
                "Enter Original Appointment Name" + System.lineSeparator() +
                "Enter New Appointment Name" + System.lineSeparator() +
                "Enter Start Time" + System.lineSeparator() +
                "Enter End Time" + System.lineSeparator() +
                "Title Set" + System.lineSeparator() +
                "Start Time Set" + System.lineSeparator() +
                "End Time Set" + System.lineSeparator() +
                "1.Create Appointment window\n2.Edit Appointment window\n3.Delete appointment Window" +
                "\n4.View Calendar\n5.Appointment requests\n6.Exit" + System.lineSeparator() +
                "Enter Appointment Name" + System.lineSeparator() +
                "Appointment Deleted" + System.lineSeparator() +
                "1.Create Appointment window\n2.Edit Appointment window\n3.Delete appointment Window" +
                "\n4.View Calendar\n5.Appointment requests\n6.Exit" + System.lineSeparator() +
                "1.Create Calendar\n2.View Calendar\n3. Delete Calendar\n4.Exit" + System.lineSeparator() +
                "1.Create Store\n2.View Existing Store\n3.Edit Account\n4.Delete Account\n5.Logout" + System.lineSeparator() +
                "1. log in as a new user\n2. log in as an existing user\n3.End Application(For testing)";

        // Runs the program with the input values
        // Replace TestProgram with the name of the class with the main method
        receiveInput(input);
        DoctorsOfficeManager.main(new String[0]);

        // Retrieves the output from the program
        String output = getOutput();

        // Trims the output and verifies it is correct.
        expected = expected.replaceAll("\r\n", "\n");
        output = output.replaceAll("\r\n", "\n");
        assertEquals("Ensure Edit Store and Calendar Creation work Properly",
                expected.trim(), output.trim());
    }

    //Tests Customer creation and Log in
    @Test(timeout = 5000)
    public void logInRequestCustomer() throws AppointmentNotFoundException {
        // Set the input
        // Separate each input with a newline (\n).
        String input = "1" + System.lineSeparator() +
                "FirstName" + System.lineSeparator() +
                "LastName" + System.lineSeparator() +
                "Email" + System.lineSeparator() +
                "password" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "FirstName" + System.lineSeparator() +
                "password" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "storeName" + System.lineSeparator() +
                "5" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "FirstName" + System.lineSeparator() +
                "LastName" + System.lineSeparator() +
                "Email" + System.lineSeparator() +
                "password" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "FirstName" + System.lineSeparator() +
                "password" + System.lineSeparator() +
                "6" + System.lineSeparator() +
                "3" + System.lineSeparator();

        // Pair the input with the expected result
        String expected = "Welcome, please choose an option:" + System.lineSeparator() +
                "1. log in as a new user\n2. log in as an existing user\n3.End Application(For testing)" + System.lineSeparator() +
                "Please Enter Your First Name" + System.lineSeparator() +
                "Please Enter Your Last Name" + System.lineSeparator() +
                "Please Enter Your Email" + System.lineSeparator() +
                "Please Enter Your Password" + System.lineSeparator() +
                "Are you signing in as 1. Doctor or 2. Patient?" + System.lineSeparator() +
                "Account Created" + System.lineSeparator() +
                "1. log in as a new user\n2. log in as an existing user\n3.End Application(For testing)" + System.lineSeparator() +
                "Are you signing in as 1. Doctor or 2. Patient?" + System.lineSeparator() +
                "Enter your firstName" + System.lineSeparator() +
                "Enter your password" + System.lineSeparator() +
                "You have been successfully logged in!" + System.lineSeparator() +
                "1.Create Store\n2.View Existing Store\n3.Edit Account\n4.Delete Account\n5.Logout" + System.lineSeparator() +
                "Please enter a Store Name" + System.lineSeparator() +
                "Store created!" + System.lineSeparator() +
                "1.Create Store\n2.View Existing Store\n3.Edit Account\n4.Delete Account\n5.Logout" + System.lineSeparator() +
                "1. log in as a new user\n2. log in as an existing user\n3.End Application(For testing)" + System.lineSeparator() +
                "Please Enter Your First Name" + System.lineSeparator() +
                "Please Enter Your Last Name" + System.lineSeparator() +
                "Please Enter Your Email" + System.lineSeparator() +
                "Please Enter Your Password" + System.lineSeparator() +
                "Are you signing in as 1. Doctor or 2. Patient?" + System.lineSeparator() +
                "Account Created" + System.lineSeparator() +
                "1. log in as a new user\n2. log in as an existing user\n3.End Application(For testing)" + System.lineSeparator() +
                "Are you signing in as 1. Doctor or 2. Patient?" + System.lineSeparator() +
                "Enter your firstName" + System.lineSeparator() +
                "Enter your password" + System.lineSeparator() +
                "You have been successfully logged in!" + System.lineSeparator() +
                "1. List Stores by Seller\n 2. View Store\n3. List Approved Appointments\n4. Edit Account 5. Delete Account 6. Exit" + System.lineSeparator() +
                "1. log in as a new user\n2. log in as an existing user\n3.End Application(For testing)";

        // Runs the program with the input values
        // Replace TestProgram with the name of the class with the main method
        receiveInput(input);
        DoctorsOfficeManager.main(new String[0]);

        // Retrieves the output from the program
        String output = getOutput();

        // Trims the output and verifies it is correct.
        expected = expected.replaceAll("\r\n", "\n");
        output = output.replaceAll("\r\n", "\n");
        assertEquals("Ensure Log in and Store creation run correctly",
                expected.trim(), output.trim());


    }


    @Test(timeout = 5000)
    public void customerMakeAppointmentRequest() throws AppointmentNotFoundException {
        // Set the input
        // Separate each input with a newline (\n).
        String input = "1" + System.lineSeparator() +
                "Name" + System.lineSeparator() +
                "LastName" + System.lineSeparator() +
                "Email" + System.lineSeparator() +
                "password" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "Name" + System.lineSeparator() +
                "password" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "storeName" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "storeName" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "calendarName" + System.lineSeparator() +
                "calendarDescription" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "calendarName" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "appName1" + System.lineSeparator() +
                "1:00" + System.lineSeparator() +
                "2:00" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "appName2" + System.lineSeparator() +
                "3:00" + System.lineSeparator() +
                "5:00" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "appName1" + System.lineSeparator() +
                "appNameChange" + System.lineSeparator() +
                "6:00" + System.lineSeparator() +
                "8:00" + System.lineSeparator() +
                "3" + System.lineSeparator() +
                "appName2" + System.lineSeparator() +
                "6" + System.lineSeparator() +
                "4" + System.lineSeparator() +
                "5" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "FirstName" + System.lineSeparator() +
                "LastName" + System.lineSeparator() +
                "Email" + System.lineSeparator() +
                "pass" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "FirstName" + System.lineSeparator() +
                "pass" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "storeName" + System.lineSeparator() +
                "Name" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "calendarName" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "appNameChange" + System.lineSeparator() +
                "5" + System.lineSeparator() +
                "3" + System.lineSeparator() +
                "6" + System.lineSeparator() +
                "3" + System.lineSeparator();

        // Pair the input with the expected result
        String expected = "Welcome, please choose an option:" + System.lineSeparator() +
                "1. log in as a new user\n2. log in as an existing user\n3.End Application(For testing)" + System.lineSeparator() +
                "Please Enter Your First Name" + System.lineSeparator() +
                "Please Enter Your Last Name" + System.lineSeparator() +
                "Please Enter Your Email" + System.lineSeparator() +
                "Please Enter Your Password" + System.lineSeparator() +
                "Are you signing in as 1. Doctor or 2. Patient?" + System.lineSeparator() +
                "Account Created" + System.lineSeparator() +
                "1. log in as a new user\n2. log in as an existing user\n3.End Application(For testing)" + System.lineSeparator() +
                "Are you signing in as 1. Doctor or 2. Patient?" + System.lineSeparator() +
                "Enter your firstName" + System.lineSeparator() +
                "Enter your password" + System.lineSeparator() +
                "You have been successfully logged in!" + System.lineSeparator() +
                "1.Create Store\n2.View Existing Store\n3.Edit Account\n4.Delete Account\n5.Logout" + System.lineSeparator() +
                "Please enter a Store Name" + System.lineSeparator() +
                "Store created!" + System.lineSeparator() +
                "1.Create Store\n2.View Existing Store\n3.Edit Account\n4.Delete Account\n5.Logout" + System.lineSeparator() +
                "Enter store name" + System.lineSeparator() +
                "Store Found" + System.lineSeparator() +
                "1.Create Calendar\n2.View Calendar\n3. Delete Calendar\n4.Exit" + System.lineSeparator() +
                "Enter Calendar Name" + System.lineSeparator() +
                "Enter Calendar Description" + System.lineSeparator() +
                "Calendar Created" + System.lineSeparator() +
                "1.Create Calendar\n2.View Calendar\n3. Delete Calendar\n4.Exit" + System.lineSeparator() +
                "Enter Calendar Name" + System.lineSeparator() +
                "Calendar Found" + System.lineSeparator() +
                "1.Create Appointment window\n2.Edit Appointment window\n3.Delete appointment Window" +
                "\n4.View Calendar\n5.Appointment requests\n6.Exit" + System.lineSeparator() +
                "Enter Appointment Name" + System.lineSeparator() +
                "Enter Start Time" + System.lineSeparator() +
                "Enter End Time" + System.lineSeparator() +
                "Appointment Created" + System.lineSeparator() +
                "1.Create Appointment window\n2.Edit Appointment window\n3.Delete appointment Window" +
                "\n4.View Calendar\n5.Appointment requests\n6.Exit" + System.lineSeparator() +
                "Enter Appointment Name" + System.lineSeparator() +
                "Enter Start Time" + System.lineSeparator() +
                "Enter End Time" + System.lineSeparator() +
                "Appointment Created" + System.lineSeparator() +
                "1.Create Appointment window\n2.Edit Appointment window\n3.Delete appointment Window" +
                "\n4.View Calendar\n5.Appointment requests\n6.Exit" + System.lineSeparator() +
                "Enter Original Appointment Name" + System.lineSeparator() +
                "Enter New Appointment Name" + System.lineSeparator() +
                "Enter Start Time" + System.lineSeparator() +
                "Enter End Time" + System.lineSeparator() +
                "Title Set" + System.lineSeparator() +
                "Start Time Set" + System.lineSeparator() +
                "End Time Set" + System.lineSeparator() +
                "1.Create Appointment window\n2.Edit Appointment window\n3.Delete appointment Window" +
                "\n4.View Calendar\n5.Appointment requests\n6.Exit" + System.lineSeparator() +
                "Enter Appointment Name" + System.lineSeparator() +
                "Appointment Deleted" + System.lineSeparator() +
                "1.Create Appointment window\n2.Edit Appointment window\n3.Delete appointment Window" +
                "\n4.View Calendar\n5.Appointment requests\n6.Exit" + System.lineSeparator() +
                "1.Create Calendar\n2.View Calendar\n3. Delete Calendar\n4.Exit" + System.lineSeparator() +
                "1.Create Store\n2.View Existing Store\n3.Edit Account\n4.Delete Account\n5.Logout" + System.lineSeparator() +
                "1. log in as a new user\n2. log in as an existing user\n3.End Application(For testing)" + System.lineSeparator() +
                "Please Enter Your First Name" + System.lineSeparator() +
                "Please Enter Your Last Name" + System.lineSeparator() +
                "Please Enter Your Email" + System.lineSeparator() +
                "Please Enter Your Password" + System.lineSeparator() +
                "Are you signing in as 1. Doctor or 2. Patient?" + System.lineSeparator() +
                "Account Created" + System.lineSeparator() +
                "1. log in as a new user\n2. log in as an existing user\n3.End Application(For testing)" + System.lineSeparator() +
                "Are you signing in as 1. Doctor or 2. Patient?" + System.lineSeparator() +
                "Enter your firstName" + System.lineSeparator() +
                "Enter your password" + System.lineSeparator() +
                "You have been successfully logged in!" + System.lineSeparator() +
                "1. List Stores by Seller\n2.View Store\n3. List Approved Appointments\n4. Edit Account 5. Delete Account\n6. Exit" + System.lineSeparator() +
                "Enter store name" + System.lineSeparator() +
                "Enter seller name" + System.lineSeparator() +
                "1. View Calendars\n2. Enter Calendar\n3. Exit" + System.lineSeparator() +
                "Enter Calendar Name" + System.lineSeparator() +
                "Calendar Found" + System.lineSeparator() +
                "1. List Appointments\n2. Make Appointment Request\n3. Reschedule Appointment\n4. Cancel Appointment\n5. Exit" + System.lineSeparator() +
                "Enter Appointment Title:" + System.lineSeparator() +
                "1. List Appointments\n2. Make Appointment Request\n3. Reschedule Appointment\n4. Cancel Appointment\n5. Exit" + System.lineSeparator() +
                "1. View Calendars\n2. Enter Calendar\n3. Exit" + System.lineSeparator() +
                "1. List Stores by Seller\n2.View Store\n3. List Approved Appointments\n4. Edit Account 5. Delete Account\n6. Exit" + System.lineSeparator() +
                "1. log in as a new user\n2. log in as an existing user\n3.End Application(For testing)";


        // Runs the program with the input values
        // Replace TestProgram with the name of the class with the main method
        receiveInput(input);
        DoctorsOfficeManager.main(new String[0]);

        // Retrieves the output from the program
        String output = getOutput();

        // Trims the output and verifies it is correct.
        expected = expected.replaceAll("\r\n", "\n");
        output = output.replaceAll("\r\n", "\n");
        assertEquals("Ensure Edit Store and Calendar Creation work Properly",
                expected.trim(), output.trim());
    }


    //Checks Reschedule
    @Test(timeout = 5000)
    public void customerAppointmentReschedule() throws AppointmentNotFoundException {
        // Set the input
        // Separate each input with a newline (\n).
        String input = "1" + System.lineSeparator() +
                "Name" + System.lineSeparator() +
                "LastName" + System.lineSeparator() +
                "Email" + System.lineSeparator() +
                "password" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "Name" + System.lineSeparator() +
                "password" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "storeName" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "storeName" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "calendarName" + System.lineSeparator() +
                "calendarDescription" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "calendarName" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "appName1" + System.lineSeparator() +
                "1:00" + System.lineSeparator() +
                "2:00" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "appName2" + System.lineSeparator() +
                "3:00" + System.lineSeparator() +
                "5:00" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "appName1" + System.lineSeparator() +
                "appNameChange" + System.lineSeparator() +
                "6:00" + System.lineSeparator() +
                "8:00" + System.lineSeparator() +
                "3" + System.lineSeparator() +
                "appName2" + System.lineSeparator() +
                "6" + System.lineSeparator() +
                "4" + System.lineSeparator() +
                "5" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "FirstName" + System.lineSeparator() +
                "LastName" + System.lineSeparator() +
                "Email" + System.lineSeparator() +
                "pass" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "FirstName" + System.lineSeparator() +
                "pass" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "storeName" + System.lineSeparator() +
                "Name" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "calendarName" + System.lineSeparator() +
                "3" + System.lineSeparator() +
                "appNameChange" + System.lineSeparator() +
                "5" + System.lineSeparator() +
                "3" + System.lineSeparator() +
                "6" + System.lineSeparator() +
                "3" + System.lineSeparator();

        // Pair the input with the expected result
        String expected = "Welcome, please choose an option:" + System.lineSeparator() +
                "1. log in as a new user\n2. log in as an existing user\n3.End Application(For testing)" + System.lineSeparator() +
                "Please Enter Your First Name" + System.lineSeparator() +
                "Please Enter Your Last Name" + System.lineSeparator() +
                "Please Enter Your Email" + System.lineSeparator() +
                "Please Enter Your Password" + System.lineSeparator() +
                "Are you signing in as 1. Doctor or 2. Patient?" + System.lineSeparator() +
                "Account Created" + System.lineSeparator() +
                "1. log in as a new user\n2. log in as an existing user\n3.End Application(For testing)" + System.lineSeparator() +
                "Are you signing in as 1. Doctor or 2. Patient?" + System.lineSeparator() +
                "Enter your firstName" + System.lineSeparator() +
                "Enter your password" + System.lineSeparator() +
                "You have been successfully logged in!" + System.lineSeparator() +
                "1.Create Store\n2.View Existing Store\n3.Edit Account\n4.Delete Account\n5.Logout" + System.lineSeparator() +
                "Please enter a Store Name" + System.lineSeparator() +
                "Store created!" + System.lineSeparator() +
                "1.Create Store\n2.View Existing Store\n3.Edit Account\n4.Delete Account\n5.Logout" + System.lineSeparator() +
                "Enter store name" + System.lineSeparator() +
                "Store Found" + System.lineSeparator() +
                "1.Create Calendar\n2.View Calendar\n3. Delete Calendar\n4.Exit" + System.lineSeparator() +
                "Enter Calendar Name" + System.lineSeparator() +
                "Enter Calendar Description" + System.lineSeparator() +
                "Calendar Created" + System.lineSeparator() +
                "1.Create Calendar\n2.View Calendar\n3. Delete Calendar\n4.Exit" + System.lineSeparator() +
                "Enter Calendar Name" + System.lineSeparator() +
                "Calendar Found" + System.lineSeparator() +
                "1.Create Appointment window\n2.Edit Appointment window\n3.Delete appointment Window" +
                "\n4.View Calendar\n5.Appointment requests\n6.Exit" + System.lineSeparator() +
                "Enter Appointment Name" + System.lineSeparator() +
                "Enter Start Time" + System.lineSeparator() +
                "Enter End Time" + System.lineSeparator() +
                "Appointment Created" + System.lineSeparator() +
                "1.Create Appointment window\n2.Edit Appointment window\n3.Delete appointment Window" +
                "\n4.View Calendar\n5.Appointment requests\n6.Exit" + System.lineSeparator() +
                "Enter Appointment Name" + System.lineSeparator() +
                "Enter Start Time" + System.lineSeparator() +
                "Enter End Time" + System.lineSeparator() +
                "Appointment Created" + System.lineSeparator() +
                "1.Create Appointment window\n2.Edit Appointment window\n3.Delete appointment Window" +
                "\n4.View Calendar\n5.Appointment requests\n6.Exit" + System.lineSeparator() +
                "Enter Original Appointment Name" + System.lineSeparator() +
                "Enter New Appointment Name" + System.lineSeparator() +
                "Enter Start Time" + System.lineSeparator() +
                "Enter End Time" + System.lineSeparator() +
                "Title Set" + System.lineSeparator() +
                "Start Time Set" + System.lineSeparator() +
                "End Time Set" + System.lineSeparator() +
                "1.Create Appointment window\n2.Edit Appointment window\n3.Delete appointment Window" +
                "\n4.View Calendar\n5.Appointment requests\n6.Exit" + System.lineSeparator() +
                "Enter Appointment Name" + System.lineSeparator() +
                "Appointment Deleted" + System.lineSeparator() +
                "1.Create Appointment window\n2.Edit Appointment window\n3.Delete appointment Window" +
                "\n4.View Calendar\n5.Appointment requests\n6.Exit" + System.lineSeparator() +
                "1.Create Calendar\n2.View Calendar\n3. Delete Calendar\n4.Exit" + System.lineSeparator() +
                "1.Create Store\n2.View Existing Store\n3.Edit Account\n4.Delete Account\n5.Logout" + System.lineSeparator() +
                "1. log in as a new user\n2. log in as an existing user\n3.End Application(For testing)" + System.lineSeparator() +
                "Please Enter Your First Name" + System.lineSeparator() +
                "Please Enter Your Last Name" + System.lineSeparator() +
                "Please Enter Your Email" + System.lineSeparator() +
                "Please Enter Your Password" + System.lineSeparator() +
                "Are you signing in as 1. Doctor or 2. Patient?" + System.lineSeparator() +
                "Account Created" + System.lineSeparator() +
                "1. log in as a new user\n2. log in as an existing user\n3.End Application(For testing)" + System.lineSeparator() +
                "Are you signing in as 1. Doctor or 2. Patient?" + System.lineSeparator() +
                "Enter your firstName" + System.lineSeparator() +
                "Enter your password" + System.lineSeparator() +
                "You have been successfully logged in!" + System.lineSeparator() +
                "1. List Stores by Seller\n2.View Store\n3. List Approved Appointments\n4. Edit Account 5. Delete Account\n6. Exit" + System.lineSeparator() +
                "Enter store name" + System.lineSeparator() +
                "Enter seller name" + System.lineSeparator() +
                "1. View Calendars\n2. Enter Calendar\n3. Exit" + System.lineSeparator() +
                "Enter Calendar Name" + System.lineSeparator() +
                "Calendar Found" + System.lineSeparator() +
                "1. List Appointments\n2. Make Appointment Request\n3. Reschedule Appointment\n4. Cancel Appointment\n5. Exit" + System.lineSeparator() +
                "Enter Appointment Title:" + System.lineSeparator() +
                "1. List Appointments\n2. Make Appointment Request\n3. Reschedule Appointment\n4. Cancel Appointment\n5. Exit" + System.lineSeparator() +
                "1. View Calendars\n2. Enter Calendar\n3. Exit" + System.lineSeparator() +
                "1. List Stores by Seller\n2.View Store\n3. List Approved Appointments\n4. Edit Account 5. Delete Account\n6. Exit" + System.lineSeparator() +
                "1. log in as a new user\n2. log in as an existing user\n3.End Application(For testing)";


        // Runs the program with the input values
        // Replace TestProgram with the name of the class with the main method
        receiveInput(input);
        DoctorsOfficeManager.main(new String[0]);

        // Retrieves the output from the program
        String output = getOutput();

        // Trims the output and verifies it is correct.
        expected = expected.replaceAll("\r\n", "\n");
        output = output.replaceAll("\r\n", "\n");
        assertEquals("Ensure Edit Store and Calendar Creation work Properly",
                expected.trim(), output.trim());
    }

}
