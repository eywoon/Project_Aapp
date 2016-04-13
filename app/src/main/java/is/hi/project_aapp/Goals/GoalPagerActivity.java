/*package is.hi.project_aapp.Goals;



//import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

//import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;

import is.hi.project_aapp.R;

public class GoalPagerActivity extends FragmentActivity {
    private ViewPager mViewPager;
    private List<Goal> mGoals;

    public static Intent newIntent(Context packageContext, int goalId){
        Intent intent = new Intent(packageContext, GoalPagerActivity.class);
        intent.putExtra("ID", goalId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_pager);

        int goalId = (int) getIntent().getIntExtra("ID", 0);

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mGoals = GoalLab.get(this).getGoals();
        FragmentManager fragmentManager = getFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Goal goal = mGoals.get(position);
                return GoalFragment.newInstance(goal.getId());
            }

            @Override
            public int getCount() {
                return mGoals.size();
            }
        });
        for (int i = 0; i< mGoals.size(); i++){
            if(mGoals.get(i).getId() == goalId){
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
*/