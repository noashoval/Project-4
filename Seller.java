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

public class Seller extends User {
    //private fields
    private ArrayList<Store> stores;
    private boolean acceptRequest;

    //constructor
    public Seller (String userName, String email, String password, ArrayList<Store> stores) {
        super(userName, email, password);
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
        store.setCalendarList(newCalendar);
        //new store object??

    }

    //remove store method
    public void removeStore(Store store) {
        stores.remove(store);
    }

    //add calendar
    public void addCalendar(Calendar calendar) {
        addCalendar(calendar);
    }

    //edit calendar
    public void modifyCalendar(Calendar calendar, String newCalName, String newCalDescription) {
        calendar.setCalendarName(newCalName);
        calendar.setDescription(newCalDescription);
    }

    //delete calendar
    public void removeCalendar(Calendar calendar) {

    }

    //accept/ decline requests
    public void viewApptRequests(Appointment appointment) {


    }


}
