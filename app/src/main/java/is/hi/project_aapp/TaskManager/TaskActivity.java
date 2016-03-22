package is.hi.project_aapp.TaskManager;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.HashMap;

import is.hi.project_aapp.R;
import is.hi.project_aapp.TaskManager.Counter;


public class TaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasks);


    }


    public void onButton(View view) {
        System.out.println("prent prent");
        TaskKeeper tk = new TaskKeeper(getApplicationContext());

        HashMap hmap = tk.deSerialiseHashMap();
        // tk.deSerialiseHashMap();
//lalal
        Counter c = new Counter();
        c = (Counter) hmap.get("randomGæi");
        c.addToDoneList(false);


        //gera
        tk.serialiseHashMap(hmap);


        //HashMap hmap = tk.deSerialiseHashMap();
    }

}
