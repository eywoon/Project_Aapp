package is.hi.project_aapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.joda.time.*;


import is.hi.project_aapp.Emotions.Emotions;
import is.hi.project_aapp.Goals.GoalListActivity;
import is.hi.project_aapp.Help.Help;
import is.hi.project_aapp.Me.MeActivity;
import is.hi.project_aapp.Results.ResultActivity;
import is.hi.project_aapp.SQL.AAppDatabaseHelper;
import is.hi.project_aapp.Settings.Settings;
import is.hi.project_aapp.Steps.StepsActivity;

import is.hi.project_aapp.Sponsor.SponsorActivity;
import is.hi.project_aapp.TaskManager.TaskListActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onResume()
    {
        super.onResume();
        updateView();
    }

    public void updateView(){
        //Create a cursor
        try {
            SQLiteOpenHelper aappDatabaseHelper = new AAppDatabaseHelper(this);
            SQLiteDatabase db = aappDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("USER",
                    new String[]{"FIRSTNAME", "SOBERYEAR", "SOBERMONTH", "SOBERDAY"},
                    null, null, null, null, null);
            if(cursor.moveToFirst()){
                //Get the drink details from the cursor
                String firstNameText = cursor.getString(0);
                int soberYearText = cursor.getInt(1);
                int soberMonthText = cursor.getInt(2);
                int soberDayText = cursor.getInt(3);


                LocalDate dateToday = LocalDate.now();

                LocalDate dateThen = new LocalDate(soberYearText, soberMonthText, soberDayText);

                PeriodType periodType = PeriodType.standard().withWeeksRemoved();
                Period period = new Period(dateThen, dateToday).normalizedStandard(periodType);
                String soberDate = "";

                if(period.getYears() > 0){
                    soberDate =  period.getYears()+" ár ";
                }

                if (period.getMonths() > 1){
                    soberDate = soberDate+period.getMonths() + " mánuði ";
                }
                if (period.getMonths() == 1){
                    soberDate = soberDate+period.getMonths() + " mánuð ";
                }

                if (period.getDays() == 1||period.getDays() == 21||period.getDays() == 31){
                    soberDate = soberDate+period.getDays() + " dag";
                }
                if (period.getDays() > 1 && period.getDays() != 21 && period.getDays() != 31){
                    soberDate = soberDate+period.getDays() + " daga";
                }

                TextView name = (TextView) findViewById(R.id.name);
                name.setText(firstNameText);
                TextView soberDateView = (TextView)findViewById(R.id.dagar);
                soberDateView.setText(soberDate);
            }
            cursor.close();
            db.close();
        }
        catch (SQLiteException e){
            Toast toast = Toast.makeText(this, "VESEN", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void on12stepsClick (View view){
        Intent intent = new Intent(this, StepsActivity.class);
        startActivity(intent);
    }


    public void onResultsClick(View view){
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }

    public void onSponsorClick(View view){
        Intent intent = new Intent(this, SponsorActivity.class);
        startActivity(intent);
    }


    public void onSettingsClick(View view){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    public void onTasksClick(View view){
        Intent intent = new Intent(this, TaskListActivity.class);
        startActivity(intent);
    }

    public void onHelpClick(View view){
        Intent intent = new Intent(this, Help.class);
        startActivity(intent);
    }

   public void onGoalsClick(View view){
        Intent intent = new Intent(this, GoalListActivity.class);
        startActivity(intent);
    }

    public void onEmotionsClick(View view){
        Intent intent = new Intent(this, Emotions.class);
        startActivity(intent);
    }

    public void onMeClick(View view){
        Intent intent = new Intent(this, MeActivity.class);
        startActivity(intent);

    }

}


