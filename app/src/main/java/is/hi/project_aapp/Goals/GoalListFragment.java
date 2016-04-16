package is.hi.project_aapp.Goals;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import is.hi.project_aapp.R;

/**
 * Created by Eyrun on 11/04/16.
 */
public class GoalListFragment extends Fragment {
    private RecyclerView mGoalRecyclerView;
    private GoalAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);

        mGoalRecyclerView = (RecyclerView) view.findViewById(R.id.task_recycler_view);
        mGoalRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;
    }

    public void updateUI() {
        GoalLab goalLab = GoalLab.get(getActivity());
        List<Goal> goals = goalLab.getGoals();

        mAdapter = new GoalAdapter(goals);
        mGoalRecyclerView.setAdapter(mAdapter);
    }


    private class GoalHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private Goal mGoal;
        private TextView mTitleTextView;
        private TextView mDateTextView;
        private CheckBox mSolvedCheckBox;

        public GoalHolder(View itemView) {
            super(itemView);

            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_goal_title_text_view);
            mDateTextView = (TextView) itemView.findViewById(R.id.list_item_goal_date_text_view);
            mSolvedCheckBox = (CheckBox) itemView.findViewById(R.id.list_item_goal_solved_checkBox);
            itemView.setOnClickListener(this);
            //setja hlustara á hin textview-in
        }

        public void bindGoal(Goal goal) {
            mGoal = goal;
            mTitleTextView.setText(mGoal.getGoal());
           // mDateTextView.setText(mGoal.getGoalDay());
            mSolvedCheckBox.setChecked(true);
        }


        @Override
        public void onClick(View v) {
            //geyma
            int pos = getAdapterPosition();
        }
    }


    private class GoalAdapter extends RecyclerView.Adapter<GoalHolder> {
        private List<Goal> mGoals;

        public GoalAdapter(List<Goal> goals) {mGoals = goals;}

        @Override
        public GoalHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_goal, null);

            return new GoalHolder(view);
        }

        @Override
        public void onBindViewHolder(GoalHolder holder, int position) {
            Goal goal = mGoals.get(position);
            holder.bindGoal(goal);
        }

        @Override
        public int getItemCount() {
            return mGoals.size();
        }



    }




}
