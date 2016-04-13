package is.hi.project_aapp.Goals;

import android.app.Fragment;

import is.hi.project_aapp.SingleFragmentActivity;
import is.hi.project_aapp.TaskManager.TaskListFragment;

public class GoalListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new GoalListFragment();
    }


}
