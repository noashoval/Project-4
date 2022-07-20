import java.util.ArrayList;

/**
 * Program name: Store
 *
 * Program Description: Creates the store class.  Allows user to create, edit and delete Calenders
 *
 * @author saajan shah, lab sec L01
 * @version July 17, 2022
 *
 */
//should this also extend user?
public class Store {
    String storeName;
    ArrayList<Calendar> calendarList = new ArrayList<>();

    public Store(String name) {
        this.storeName = name;
    }


    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setCalendarList(ArrayList<Calendar> calendarList) {
        this.calendarList = calendarList;
    }

    public String getStoreName() {
        return storeName;
    }

    public ArrayList<Calendar> getCalendarList() {
        return calendarList;
    }

    public void addCalendar(String calendarName, String description) {
        Calendar newCalendar = new Calendar(calendarName, description);
        calendarList.add(newCalendar);
    }

}
