package is.hi.project_aapp.Goals;


import android.app.Fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import is.hi.project_aapp.SingleFragmentActivity;
import is.hi.project_aapp.TaskManager.TaskListFragment;

public class GoalListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new GoalListFragment();
    }

    public void onAddGoal (View view){
        System.out.println("ÉG ER TAKKI I GOALLIST");
        Toast toast = Toast.makeText(GoalListActivity.this,
                "Búið að breyta", Toast.LENGTH_SHORT);
        toast.show();

        Intent intent = NewGoalActivity.newIntent(this, 1);
        startActivity(intent);
    }

}
