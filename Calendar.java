import java.util.ArrayList;
////create an arraylist viewApptRequests
//first there is a request arraylist
//you view the array list then you can call approve/deny methods
//then once you remove or deny the appt request you can call create appt and add it to appt rrraylist

/**
 * Program name: Calendar
 *
 * Program Description: Creates the Calendar class.  Allows user to create, edit and delete appointments
 *
 * @author saajan shah, lab sec L01
 * @version July 17, 2022
 *
 */
public class Calendar {

    //PRIVATE FIELDS\\
    String calendarName;
    String description;
    ArrayList<Appointment> appointments = new ArrayList<>();

    ArrayList<Appointment> apptRequests = new ArrayList<>();

    //CONSTRUCTOR\\
    public Calendar(String calendarName, String description) {
        this.calendarName = calendarName;
        this.description = description;
    }

    //METHODS\\

    public String getCalendarName() {
        return calendarName;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }


    public void setApptRequests(ArrayList<Appointment> apptRequests) {
        this.apptRequests = apptRequests;
    }

    public void createAppointment(String title, String startTime, String endTime) {
        Appointment newAppointment = new Appointment(title, startTime, endTime);
        appointments.add(newAppointment);
    }

    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    public void approveRequest(String title1, String startTime1, String endTime1) {
            Appointment apptRequest = new Appointment(title1, startTime1, endTime1);
            apptRequest.setApprovedBooking(true);
            apptRequests.remove(apptRequest);
            createAppointment(title1, startTime1, endTime1);
    }
    //if denied, just remove from apptRequests array list, don't add appt to appts Arraylist
    public void denyRequest(String title, String startTime, String endTime) {
        Appointment apptRequest = new Appointment(title, startTime, endTime);
        apptRequest.setApprovedBooking(false);
        apptRequests.remove(apptRequest);
    }

    public void makeAptRequest(Appointment appointment) {
        apptRequests.add(appointment);
    }
    public void removeAptRequest(Appointment appointment) {
        apptRequests.remove(appointment);
    }

    public Appointment searchByTitle(String placeholder, ArrayList<Appointment> appointmentList) {
        ArrayList<Appointment> apt = appointmentList;
        String search = placeholder;
        for(int i = 0; i < apt.size(); i++) {
            if(search.equalsIgnoreCase(apt.get(i).getTitle())) {
                return apt.get(i);
            }
        }
        return null;
    }


    public void viewCalendar() {
        System.out.println(calendarName);
        System.out.println(description);
        for(int i = 0; i < appointments.size(); i++) {
            System.out.println(appointments.get(i));
        }
    }



}
