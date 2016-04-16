package is.hi.project_aapp.TaskManager;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Eyrun on 28/02/16.
 * <p>
 * This class takes care of keeping the count for if, for the past seven days
 * a task has been done or not. It keeps an ArrayList of seven booleans.
 * <p>
 * <p>
 * Counter needs to implement Serializable in order for the object to be able to be serialise.
 * Hashmap already implements Serializable, further read: https://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html
 */
public class Counter implements Serializable {

    /*
    ============ JÆJA KRAKKAR!!!
    Athugið að í augnablikinu er ég ljótur hlutur :'(

     */


    //instance variables
    private boolean doneToday = false;
    //last7Days keeps a list of seven booleans that can be done or not done
    private ArrayList<Boolean> last7Days = new ArrayList<Boolean>();


    // right now this is just a piece of bull
    public Counter() {
    }

    public boolean getDoneToday() {

        return doneToday;
    }

    public void setDoneToday(boolean b) {
        this.doneToday = b;

        //addToDoneList(doneToday);

    }



    /*
     * @param ArrayList - the total amount of seats to book
     * @return last7Days
     */
    public ArrayList<Boolean> getLast7Days() {
        return last7Days;
    }

    /*
     * @param ArrayList - the total amount of seats to book
     *
     * addToDoneList adds the latest boolean for that task to the back
     * of the list. Then it removes the last boolean from the list, thus making sure there are never
     * more than seven booleans in the list
     */
    public void addToDoneList(boolean b) {
        //TODO villumelda þetta og koma í veg fyrir svindl
        last7Days.add(b);
        while (last7Days.size() > 7) {
            last7Days.remove(0);
        }
        setDoneToday(true);
    }


    //TODO það vantar að passa að doneToday breytist alltaf á miðnætti, líklegast aðferð hér
    public void reset() {
        // kallað á úr taskkeeper, fyrir hvern key í hashmappinu
        doneToday = false;
    }

}
