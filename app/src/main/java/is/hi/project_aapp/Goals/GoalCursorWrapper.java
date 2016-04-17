package is.hi.project_aapp.Goals;

import android.database.Cursor;
import android.database.CursorWrapper;

/**
 * Created by hrefnaolafsdottir on 12/04/16.
 */
public class GoalCursorWrapper extends CursorWrapper{
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public GoalCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Goal getGoal(){
        int id = getInt(getColumnIndex("_id"));
        String title = getString(getColumnIndex("GOAL"));
        String description = getString(getColumnIndex("DESCRIPTION"));
        int goalDay = getInt(getColumnIndex("GOALDAY"));
        int goalMonth = getInt(getColumnIndex("GOALMONTH"));
        int goalYear = getInt(getColumnIndex("GOALYEAR"));
        int isDone = getInt(getColumnIndex("ISDONE"));

        Goal goal = new Goal(title, description, goalDay, goalMonth, goalYear, isDone, id );
        return goal;
    }
}
