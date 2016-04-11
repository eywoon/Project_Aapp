package is.hi.project_aapp.Settings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import is.hi.project_aapp.R;
import is.hi.project_aapp.TaskManager.TaskKeeper;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("fhdsajfkdskjfdaslkfjslka");
        TaskKeeper tk = new TaskKeeper(getApplicationContext());
        tk.createHashMapFirstTime();
        tk.deSerialiseHashMap();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }
}
