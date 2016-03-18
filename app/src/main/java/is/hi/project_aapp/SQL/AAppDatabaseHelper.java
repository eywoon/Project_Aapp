package is.hi.project_aapp.SQL;

/**
 * Created by hrefnaolafsdottir on 10/03/16.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AAppDatabaseHelper extends SQLiteOpenHelper{
    private static final String DB_NAME = "aapp";
    private static final int DB_VERSION = 1;
    private static final String TAG = "dbHelper";

    public AAppDatabaseHelper(Context context){

        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        System.out.println( "onCreate: ÉG fór hingað");
        updateMyDatabase(db, 0, DB_VERSION);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV){
        updateMyDatabase(db, oldV, newV);
    }
    private void updateMyDatabase(SQLiteDatabase db, int oldV, int newV){
        if(oldV < 1){
            Log.d(TAG, "Bjó til db");
            db.execSQL("CREATE TABLE SPONSOR (_id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, PHONENO INTEGER);");
            insertSponsor(db, "Nafn", 000);
        }

    }

    private static void insertSponsor(SQLiteDatabase db, String name, int phoneNo){
        ContentValues sponsorValues = new ContentValues();
        sponsorValues.put("NAME", name);
        sponsorValues.put("PHONENO", phoneNo);
        db.insert("SPONSOR", null, sponsorValues);
    }
}
