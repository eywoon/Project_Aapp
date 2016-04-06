package is.hi.project_aapp.Me;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import is.hi.project_aapp.R;
import is.hi.project_aapp.SQL.AAppDatabaseHelper;
import is.hi.project_aapp.Sponsor.SponsorActivity;

public class ChangeMeActivity extends AppCompatActivity {
    private DatePicker datePicker;
    private int soberday, sobermonth, soberyear;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_me);

        intent = getIntent();
        String firstName = intent.getStringExtra("firstname");
        String lastName = intent.getStringExtra("lastname");
        soberday = intent.getIntExtra("soberday", 0);
        sobermonth = intent.getIntExtra("sobermonth", 0);
        soberyear = intent.getIntExtra("soberyear", 0);

        EditText firstNameText = (EditText)findViewById(R.id.firstname);
        EditText lastNameText = (EditText)findViewById(R.id.lastnam);
        TextView dateView = (TextView) findViewById(R.id.dateview);

        firstNameText.setText(firstName);
        lastNameText.setText(lastName);
        dateView.setText(new StringBuilder().append(soberday).append("/").append(sobermonth).append("/").append(soberyear));

    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);

    }

    @Override
    protected Dialog onCreateDialog(int id) {

        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, soberyear, sobermonth-1, soberday);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {

            // arg1 = year
            // arg2 = month
            // arg3 = day
            soberyear = arg1;
            soberday = arg3;
            sobermonth = arg2+1;
            TextView dateView = (TextView) findViewById(R.id.dateview);
            dateView.setText(new StringBuilder().append(soberday).append("/").append(sobermonth).append("/").append(soberyear));
        }
    };

    public void onClickChangeMe(View view){

        new UpdateUserTask().execute(1);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            navigateUpTo(intent);
        }
        else{
            Toast toast = Toast.makeText(ChangeMeActivity.this,
                    "Búið að breyta", Toast.LENGTH_SHORT);
            toast.show();
        }
        /*Intent intent = new Intent(this, MeActivity.class);
        startActivity(intent);*/
    }

    //Inner class to update the user.
    private class UpdateUserTask extends AsyncTask<Integer, Void, Boolean> {
        ContentValues userValues;
        protected void onPreExecute() {
            EditText firstNameText = (EditText)findViewById(R.id.firstname);
            EditText lastNameText = (EditText)findViewById(R.id.lastnam);
            userValues = new ContentValues();
            userValues.put("FIRSTNAME", firstNameText.getText().toString());
            userValues.put("LASTNAME", lastNameText.getText().toString());
            userValues.put("SOBERYEAR", soberyear);
            userValues.put("SOBERMONTH", sobermonth);
            userValues.put("SOBERDAY", soberday);
        }
        protected Boolean doInBackground(Integer... drinks) {
            SQLiteOpenHelper appDatabaseHelper = new AAppDatabaseHelper(ChangeMeActivity.this);
            try {
                SQLiteDatabase db = appDatabaseHelper.getWritableDatabase();
                db.update("USER", userValues,
                        "_id = ?", new String[] {Integer.toString(1)});
                db.close();
                return true;
            } catch(SQLiteException e) {
                return false;
            }
        }
        protected void onPostExecute(Boolean success) {
            if (!success) {
                Toast toast = Toast.makeText(ChangeMeActivity.this,
                        "Database unavailable", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

}
