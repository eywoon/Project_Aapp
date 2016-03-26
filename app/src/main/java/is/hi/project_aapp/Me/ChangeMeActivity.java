package is.hi.project_aapp.Me;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import is.hi.project_aapp.R;
import is.hi.project_aapp.SQL.AAppDatabaseHelper;
import is.hi.project_aapp.Sponsor.SponsorActivity;

public class ChangeMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_me);

        Intent intent = getIntent();
        String firstName = intent.getStringExtra("firstname");
        String lastName = intent.getStringExtra("lastname");
        EditText firstNameText = (EditText)findViewById(R.id.firstname);
        EditText lastNameText = (EditText)findViewById(R.id.lastnam);
        firstNameText.setText(firstName);
        lastNameText.setText(lastName);

    }

    public void onClickChangeMe(View view){

        new UpdateUserTask().execute(1);
        Intent intent = new Intent(this, MeActivity.class);
        startActivity(intent);
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
