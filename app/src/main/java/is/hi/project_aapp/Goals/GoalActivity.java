package is.hi.project_aapp.Goals;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
//import android.support.v4.app.Fragment;

import is.hi.project_aapp.SingleFragmentActivity;
import is.hi.project_aapp.TaskManager.TaskListFragment;

public class GoalActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        int goalId = (int) getIntent().getIntExtra("ID", 0);
        return GoalFragment.newInstance(goalId);
    }

    public static Intent newIntent(Context packageContext, int goalId){
        Intent intent = new Intent(packageContext, GoalActivity.class);
        intent.putExtra("ID", goalId);
        return intent;
    }



}
