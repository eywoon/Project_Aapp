package is.hi.project_aapp.Help;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import is.hi.project_aapp.R;

import is.hi.project_aapp.SingleFragmentActivity;
import is.hi.project_aapp.TaskManager.TaskListFragment;

public class Help extends SingleFragmentActivity {
    @Override
    protected TaskListFragment createFragment(){
       /* TaskKeeper tk = new TaskKeeper(getApplicationContext());
        tk.createHashMapFirstTime(); */
        return new TaskListFragment();
    }
}
