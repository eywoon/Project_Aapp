package is.hi.project_aapp.Sponsor;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import is.hi.project_aapp.R;
import is.hi.project_aapp.SQL.AAppDatabaseHelper;

public class ChangeSponsorActivity extends AppCompatActivity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_sponsor);
        intent = getIntent();
        String name = intent.getStringExtra("name");
        int phoneno = intent.getIntExtra("phoneno", 0);
        EditText nameText = (EditText)findViewById(R.id.name);
        EditText phonenoText = (EditText)findViewById(R.id.phoneno);
        nameText.setText(name);
        phonenoText.setText(Integer.toString(phoneno));

    }

    public void onClickChangeSponsor(View view){

        new UpdateSponsorTask().execute(1);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            navigateUpTo(intent);
        }
        else{
            Toast toast = Toast.makeText(ChangeSponsorActivity.this,
                    "Búið að breyta", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    //Inner class to update the sponsor.
    private class UpdateSponsorTask extends AsyncTask<Integer, Void, Boolean> {
        ContentValues sponsorValues;
        protected void onPreExecute() {
            EditText name = (EditText)findViewById(R.id.name);
            EditText phoneno = (EditText)findViewById(R.id.phoneno);
            sponsorValues = new ContentValues();
            sponsorValues.put("NAME", name.getText().toString());
            sponsorValues.put("PHONENO", Integer.parseInt(phoneno.getText().toString()));
        }
        protected Boolean doInBackground(Integer... drinks) {
            int drinkNo = drinks[0];
            SQLiteOpenHelper starbuzzDatabaseHelper = new AAppDatabaseHelper(ChangeSponsorActivity.this);
            try {
                SQLiteDatabase db = starbuzzDatabaseHelper.getWritableDatabase();
                db.update("SPONSOR", sponsorValues,
                        "_id = ?", new String[] {Integer.toString(1)});
                db.close();
                return true;
            } catch(SQLiteException e) {
                return false;
            }
        }
        protected void onPostExecute(Boolean success) {
            if (!success) {
                Toast toast = Toast.makeText(ChangeSponsorActivity.this,
                        "Database unavailable", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

}
