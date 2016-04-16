package is.hi.project_aapp.TaskManager;


import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import is.hi.project_aapp.SingleFragmentActivity;

public class TaskListActivity extends SingleFragmentActivity {
    @Override
    protected TaskListFragment createFragment(){
        return new TaskListFragment();
    }
}
