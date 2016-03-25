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
    //Database name
    private static final String DB_NAME = "aapp";
    //Database version
    private static final int DB_VERSION = 1;
    //Logcat tag
    private static final String TAG = "dbHelper";

    //Table names
    private static final String TABLE_USER = "USER";
    private static final String TABLE_SPONSOR = "SPONSOR";

    // Common column names
    private static final String KEY_ID = "_id";

    // USER Table - column names
    private static final String KEY_FIRSTNAME = "FIRSTNAME";
    private static final String KEY_LASTNAME = "LASTNAME";
    private static final String KEY_SOBERYEAR = "SOBERYEAR";
    private static final String KEY_SOBERDAY = "SOBERDAY";
    private static final String KEY_SOBERMONTH = "SOBERMONTH";

    // SPONSOR Table - column names
    private static final String KEY_NAME = "NAME";
    private static final String KEY_PHONENO = "PHONENO";


    // Table Create Statements
    //User table create statement
    private static final String CREATE_TABLE_USER = "CREATE TABLE "
            + TABLE_USER + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_FIRSTNAME
            + " TEXT, " + KEY_LASTNAME + " TEXT," + KEY_SOBERDAY
            + " INTEGER," + KEY_SOBERMONTH + " INTEGER," + KEY_SOBERYEAR+" INTEGER" + ");";

    // Sponsor table create statement
    private static final String CREATE_TABLE_SPONSOR = "CREATE TABLE " + TABLE_SPONSOR
            + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT,"
            + KEY_PHONENO + " INTEGER" + ");";






    public AAppDatabaseHelper(Context context){

        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        updateMyDatabase(db, 0, DB_VERSION);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV){
        updateMyDatabase(db, oldV, newV);
    }
    private void updateMyDatabase(SQLiteDatabase db, int oldV, int newV){
        if(oldV < 1){
            db.execSQL(CREATE_TABLE_SPONSOR);
            db.execSQL(CREATE_TABLE_USER);
            System.out.println(CREATE_TABLE_SPONSOR);
            System.out.println(CREATE_TABLE_USER);
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
