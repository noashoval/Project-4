/**
 * Program name: Appointment
 *
 * Program Description: Allows user to create, edit, and delete appointments.
 *
 * @author saajan shah, lab sec L01
 * @version July 17, 2022
 *
 */

public class Appointment {

    //PRIVATE FIELDS\\
    String title; // title of appointment
    int maxAttend; // Max number of attendees
    int approvedBooking; // number of approved bookings
    String startTime;
    String endTime;

    //CONSTRUCTOR\\
    public Appointment(String title, int maxAttend, String startTime, String endTime) {
        this.title = title;
        this.maxAttend = maxAttend;
        this.startTime = startTime;
        this.endTime = endTime;
        approvedBooking = 0;
    }

    //METHODS\\

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMaxAttend() {
        return maxAttend;
    }

    public void setMaxAttend(int maxAttend) {
        this.maxAttend = maxAttend;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getApprovedBooking() {
        return approvedBooking;
    }

    public void setApprovedBooking(int approvedBooking) {
        this.approvedBooking = approvedBooking;
    }

}
