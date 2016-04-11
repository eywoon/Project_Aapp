package is.hi.project_aapp.TaskManager;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import is.hi.project_aapp.SingleFragmentActivity;

public class TaskListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(){
        return new TaskListFragment();
    }
}
