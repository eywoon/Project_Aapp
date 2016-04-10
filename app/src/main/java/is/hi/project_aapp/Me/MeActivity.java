package is.hi.project_aapp.Me;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import is.hi.project_aapp.R;
import is.hi.project_aapp.SQL.AAppDatabaseHelper;

public class MeActivity extends AppCompatActivity {
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
    }
    public void updateView(){
        //Create a cursor
        try {
            SQLiteOpenHelper aappDatabaseHelper = new AAppDatabaseHelper(this);
            SQLiteDatabase db = aappDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("USER",
                    new String[]{"FIRSTNAME", "LASTNAME", "SOBERYEAR", "SOBERMONTH", "SOBERDAY"},
                    null, null, null, null, null);
            if(cursor.moveToFirst()){
                //Get the drink details from the cursor
                String firstNameText = cursor.getString(0);
                String lastNameText = cursor.getString(1);
                int soberYearText = cursor.getInt(2);
                int soberMonthText = cursor.getInt(3);
                int soberDayText = cursor.getInt(4);
                System.out.println(soberMonthText);

                user = new User(firstNameText, lastNameText, soberDayText, soberMonthText, soberYearText);

                String soberdate = soberDayText + "-"+ soberMonthText + "-"+soberYearText;

                String nameText = firstNameText + " "+ lastNameText;
                //Populate the drink name
                TextView name = (TextView)findViewById(R.id.name);
                name.setText(nameText);
                TextView soberDate = (TextView)findViewById(R.id.soberdate);
                soberDate.setText(soberdate);
            }
            cursor.close();
            db.close();
        }
        catch (SQLiteException e){
            Toast toast = Toast.makeText(this, "VESEN", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    public void onChangeUser (View view){
        Intent intent = new Intent(this, ChangeMeActivity.class);
        intent.putExtra("firstname", user.getFirstName());
        intent.putExtra("lastname", user.getLastName());
        intent.putExtra("soberyear", user.getSoberYear());
        intent.putExtra("sobermonth", user.getSoberMonth());
        intent.putExtra("soberday", user.getSoberDay());
        startActivity(intent);

    }
    protected void onResume()
    {
        super.onResume();
        updateView();
    }

}
