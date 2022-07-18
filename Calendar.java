import java.util.ArrayList;

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

    public void createAppointment(String title, int maxAttend, String startTime, String endTime) {
        Appointment newAppointment = new Appointment(title, maxAttend, startTime, endTime);
        appointments.add(newAppointment);
    }





}
