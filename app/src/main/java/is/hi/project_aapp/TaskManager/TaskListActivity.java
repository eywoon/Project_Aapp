package is.hi.project_aapp.TaskManager;

import is.hi.project_aapp.SingleFragmentActivity;

public class TaskListActivity extends SingleFragmentActivity {
    @Override
    protected TaskListFragment createFragment(){
        return new TaskListFragment();
    }
}
