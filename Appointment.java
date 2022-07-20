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
    boolean approvedBooking; // number of approved bookings
    String startTime;
    String endTime;

    //CONSTRUCTOR\\
    public Appointment(String title, String startTime, String endTime) {
        this.title = title;
        this.maxAttend = 1;
        this.startTime = startTime;
        this.endTime = endTime;
        approvedBooking = false;
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

    public boolean getApprovedBooking() {
        return approvedBooking;
    }

    public void setApprovedBooking(boolean approvedBooking) {
        this.approvedBooking = approvedBooking;
    }

    @Override
    public String toString() {
        String approved; // number of approved bookings
        if(approvedBooking) {
            approved = "Yes";
        } else {
            approved = "No";
        }
        return String.format("--------------------------\n" +
                "Appointment Name: %s\n" +
                "Maximum Attendees: %d\n" +
                "Booking Approved: %s\n" +
                "Start Time: %s\n" +
                "End Time: %s", title, maxAttend, approved, startTime, endTime);
    }
}