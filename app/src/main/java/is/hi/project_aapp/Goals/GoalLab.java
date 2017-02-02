package is.hi.project_aapp.Goals;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import is.hi.project_aapp.Me.User;
import is.hi.project_aapp.R;
import is.hi.project_aapp.SQL.AAppDatabaseHelper;

/**
 * Created by Eyrun on 11/04/16.
 */
public class GoalLab {
    private static GoalLab sGoalLab;
    private SQLiteDatabase mDatabase;
    private Context mContext;

    public static GoalLab get(Context context) {
        if(sGoalLab == null) {
            sGoalLab = new GoalLab(context);
        }
        return sGoalLab;
    }

    public GoalLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new AAppDatabaseHelper(mContext).getWritableDatabase();





    }

    public List<Goal> getGoals() {
        List<Goal> goals = new ArrayList<>();
        GoalCursorWrapper cursor = queryGoals(null,null);

        try{
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                goals.add(cursor.getGoal());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }

        return goals;
    }

    public Goal getGoal(int id){
        GoalCursorWrapper cursor = queryGoals(
                "_id = ?",
                new String[]{String.valueOf(id)}
        );
        try{
            if(cursor.getCount() == 0){
                return null;
            }
            cursor.moveToFirst();
            return cursor.getGoal();
        }finally {
            cursor.close();
        }
    }

    private static ContentValues getContentValues(Goal goal){
        ContentValues values = new ContentValues();
        //values.put("_id", goal.getId());
        values.put("GOAL", goal.getGoal());
        values.put("DESCRIPTION", goal.getDescription());
        values.put("ISDONE", goal.isDone());
        values.put("GOALYEAR", goal.getGoalYear());
        values.put("GOALDAY", goal.getGoalDay());
        values.put("GOALMONTH", goal.getGoalMonth());
        return values;
    }

    public void addGoal(Goal g){
        ContentValues values = getContentValues(g);
        mDatabase.insert("GOAL", null, values);
    }
    public void updateGoal(Goal goal){
        String goalId = goal.getId()+"";
        ContentValues values = getContentValues(goal);
        mDatabase.update("GOAL", values, "_id = ?", new String[]{goalId});
    }

    private  GoalCursorWrapper queryGoals(String whereClause, String[] whereArgs){
        Cursor cursor = mDatabase.query(
                "GOAL",
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );
        return new GoalCursorWrapper(cursor);
    }
}
