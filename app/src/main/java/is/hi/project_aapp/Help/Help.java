package is.hi.project_aapp.Help;

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
