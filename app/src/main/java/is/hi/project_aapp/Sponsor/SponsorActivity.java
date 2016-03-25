package is.hi.project_aapp.Sponsor;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
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
import is.hi.project_aapp.Sponsor.Sponsor;


public class SponsorActivity extends AppCompatActivity {
    private static final String TAG = "sponsorA";
    private Sponsor sponsor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsor);




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

                sponsor = new Sponsor(nameText, phoneNoText);
                //Populate the drink name
                TextView name = (TextView)findViewById(R.id.name);
                name.setText(nameText);
                TextView phoneNo = (TextView)findViewById(R.id.phoneno);
                phoneNo.setText(Integer.toString(phoneNoText));
            }
            cursor.close();
            db.close();
        }
        catch (SQLiteException e){
            Toast toast = Toast.makeText(this, "VESEN", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void onCallSponsor(View view){
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:"+sponsor.getPhoneNo()));
        startActivity(callIntent);
    }

    public void onChangeSponsor(View view){
        Intent intent = new Intent(this, ChangeSponsorActivity.class);
        intent.putExtra("name", sponsor.getName());
        intent.putExtra("phoneno", sponsor.getPhoneNo());
        startActivity(intent);
    }

}
