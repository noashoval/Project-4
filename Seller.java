//Sellers will be able to create stores to sell their products and maintain relationships with customers.
//Sellers will be able to create as many stores as they like.
//Sellers can create, edit, and delete calendars with individual appointment windows.
//Sellers can approve or decline customer appointment requests.
//Sellers can view a list of currently approved appointments by store.
//Sellers can search for a specific customer and move their appointment to a different time at the same store.

//every calendar by week/day
//in every calendar have a number of appts
//max attendees of 1



//every seller can create a store
//every store can have multiple calendars
//calendars have appointments

import java.util.ArrayList;
import java.util.Calendar;

public class Seller extends User {
    //private fields
    private ArrayList<Store> stores;
    private boolean acceptRequest;

    //constructor
    public Seller (String userName, String password, String firstName, String lastName, String email) {
        super(userName, password, firstName, lastName, email);
        this.stores = stores;
    }
    //getStores method
    public ArrayList<Store> getStores() {
        return stores;
    }
    //add store method
    public void addStore(Store store) {
        stores.add(store);
    }
    //edit store method
    public void modifyStore(Store store, String newName, ArrayList<Calendar> newCalendar) {
        store.setStoreName(newName);
       // store.setCalendarList(newCalendar);
        //new store object??

    }

    //remove store method
    public void removeStore(Store store) {
        stores.remove(store);
    }

    //add calendar
    public void addCalendar(Store store, String newCalendarName, String newDescription) {
        store.addCalendar(newCalendarName, newDescription);
    }

    //edit calendar
    public void modifyCalendar(Store store, Calendar calendar, String newCalName, String newCalDescription) {
        store.getCalendarList();
        if (store.getCalendarList().contains(calendar)) {
            store.getCalendarList().remove(calendar);
            store.addCalendar(newCalName, newCalDescription);
        } else {
            System.out.println("calendar you are trying to modify does not exist");
        }
    }

    //delete calendar
    public void removeCalendar(Store store, Calendar calendar) {
        if (store.getCalendarList().contains(calendar)) {
            store.getCalendarList().remove(calendar);
        }
    }

    //accept/ decline requests
    public void viewApptRequests(Store store) {
        for (int i = 0; i < store.getCalendarList().size(); i++) {
           for(int j = 0; j < store.getCalendarList().get(i).apptRequests.size(); j ++) {
               System.out.println(store.getCalendarList().get(i).apptRequests.get(j));
           }
        }
        }


    public void approveApptRequest(Appointment appointment, int storeIndex, int calendarIndex) {
        stores.get(storeIndex).getCalendarList().get(calendarIndex).removeAptRequest(appointment);
        int size = stores.get(storeIndex).getCalendarList().get(calendarIndex).appointments.size();
        for(int i = 0; i < size; i++) {
            if(appointment.getTitle().equalsIgnoreCase(stores.get(storeIndex).getCalendarList().get(calendarIndex).appointments.get(i).title)){
                stores.get(storeIndex).getCalendarList().get(calendarIndex).appointments.get(i).setApprovedBooking(true);
            }
        }
    }

    public void denyApptRequest(Appointment appointment, int storeIndex, int calendarIndex) {
        stores.get(storeIndex).getCalendarList().get(calendarIndex).removeAptRequest(appointment);
        int size = stores.get(storeIndex).getCalendarList().get(calendarIndex).appointments.size();
        for(int i = 0; i < size; i++) {
            if(appointment.getTitle().equalsIgnoreCase(stores.get(storeIndex).getCalendarList().get(calendarIndex).appointments.get(i).title)){
                stores.get(storeIndex).getCalendarList().get(calendarIndex).appointments.get(i).setApprovedBooking(false);
            }
        }
    }



}
