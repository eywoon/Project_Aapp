package is.hi.project_aapp.Sponsor;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import is.hi.project_aapp.R;
import is.hi.project_aapp.SQL.AAppDatabaseHelper;


public class SponsorActivity extends AppCompatActivity {
    private static final String TAG = "sponsorA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
        System.out.println("HALLALALASDFJASLDIFHALSIDHFASLDFÆASDFJOÆ");
        //Create a cursor
        try {
            SQLiteOpenHelper aappDatabaseHelper = new AAppDatabaseHelper(this);
            SQLiteDatabase db = aappDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("SPONSOR",
                    new String[]{"NAME", "PHONENO"},
                    null, null, null, null, null);
            if(cursor.moveToFirst()){
                //Get the drink details from the cursor
                String nameText = cursor.getString(0);
                int phoneNoText = cursor.getInt(1);

                //Populate the drink name
                TextView name = (TextView)findViewById(R.id.name);
                name.setText(nameText);
                TextView phoneNo = (TextView)findViewById(R.id.phoneno);
                phoneNo.setText(String.valueOf(phoneNoText));
            }
            cursor.close();
            db.close();
        }
        catch (SQLiteException e){
            Toast toast = Toast.makeText(this, "VESEN", Toast.LENGTH_SHORT);
            toast.show();
        }
    }


}
