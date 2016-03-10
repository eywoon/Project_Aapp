package is.hi.project_aapp.SQL;

/**
 * Created by hrefnaolafsdottir on 10/03/16.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class AAppDatabaseHelper extends SQLiteOpenHelper{
    private static final String DB_NAME = "aapp";
    private static final int DB_VERSION = 1;

    AAppDatabaseHelper(Context context){
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
            db.execSQL("CREATE TABLE SPONSOR ("
            + "NAME TEXT"
            + "PHONENO INTEGER);");
        }
    }
}
