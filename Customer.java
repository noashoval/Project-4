import java.util.ArrayList;

public class Customer extends User {
    private ArrayList<Appointment> approvedApt = new ArrayList<>(); // Array list of approved appointments

    public Customer(String userName, String password, String firstName, String lastName, String email) {
        super(userName, password, firstName, lastName, email);
    }

    public void viewCalendars(Calendar calendar) {
        ArrayList<Appointment> appointments = new ArrayList<>();
        System.out.println(calendar.getCalendarName());
        System.out.println(calendar.getDescription());
        appointments = calendar.getAppointments();
        for (int i = 0; i < appointments.size(); i++) {
            System.out.println(appointments.get(i));
        }
    }

    public void makeAptRequest(String title, Calendar calendar, String name) throws AppointmentNotFoundException {
        Appointment appointmentRequest =  calendar.searchByTitle(title, calendar.getAppointments());
        appointmentRequest.setName(name);
        if (appointmentRequest == null) {
            throw new AppointmentNotFoundException("Appointment not found");
        } else {
            calendar.makeAptRequest(appointmentRequest);
        }

    }

    public void cancelAptRequest(String title, Calendar calendar) throws AppointmentNotFoundException {
        Appointment appointmentRequest =  calendar.searchByTitle(title, calendar.getAppointments());
        if (appointmentRequest == null) {
            throw new AppointmentNotFoundException("Appointment not found");
        } else {
            calendar.removeAptRequest(appointmentRequest);
        }
    }

    public void viewApprovedApt() {
        System.out.println("Approved Appointments");
        for (int i = 0; i < approvedApt.size(); i++) {
            System.out.println(approvedApt.get(i));
        }
    }

    public void rescheduleApt(String aptTitle, Calendar calendar) throws AppointmentNotFoundException {
        Appointment apt = searchByTitle(aptTitle, approvedApt);
        if (apt == null) {
            throw new AppointmentNotFoundException("Appointment not found");
        } else {
            approvedApt.remove(apt);
            for (int i = 0; i < calendar.appointments.size(); i++) {
                if(calendar.appointments.get(i).getTitle().equalsIgnoreCase(apt.title)) {
                    calendar.appointments.get(i).setApprovedBooking(false);
                }
            }
            calendar.makeAptRequest(apt);
        }
    }

    public ArrayList<Appointment> getApprovedApt() {
        return approvedApt;
    }


    public void setApprovedApt(ArrayList<Appointment> approvedApt) {
        this.approvedApt = approvedApt;
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

}
