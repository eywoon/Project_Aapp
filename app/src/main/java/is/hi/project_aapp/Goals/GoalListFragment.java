package is.hi.project_aapp.Goals;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import is.hi.project_aapp.R;

/**
 * Created by Eyrun on 11/04/16.
 */
public class GoalListFragment extends Fragment implements View.OnClickListener {
    private RecyclerView mGoalRecyclerView;
    private GoalAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //View takkaView = inflater.inflate(R.layout.takki, container, true);
       // takkaView.setOnClickListener(this);

        //container.addView(takkaView);
        View view = inflater.inflate(R.layout.fragment_goal_list, container, false);

        mGoalRecyclerView = (RecyclerView) view.findViewById(R.id.goal_recycler_view);
        mGoalRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));




        updateUI();
        return view;

    }


    @Override
    public void onResume(){
        super.onResume();
        updateUI();
    }

    public void updateUI() {
        GoalLab goalLab = GoalLab.get(getActivity());
        List<Goal> goals = goalLab.getGoals();

        if(mAdapter == null){
            mAdapter = new GoalAdapter(goals);
            mGoalRecyclerView.setAdapter(mAdapter);
        } else{
            mAdapter.setGoals(goals);
            mAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onClick(View v) {
        System.out.println("IMPLEMENTS");
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
            mDateTextView.setText(mGoal.getDate());
            mSolvedCheckBox.setChecked(goal.isDone());
        }


        @Override
        public void onClick(View v) {
            Intent intent = GoalActivity.newIntent(getActivity(), mGoal.getId());
            startActivity(intent);
        }
    }






    private class GoalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<Goal> mGoals;



        public GoalAdapter(List<Goal> goals) {mGoals = goals;}

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {



            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_goal, null);




            return new GoalHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

                    GoalHolder vh = (GoalHolder) holder;

                    Goal goal = mGoals.get(position);
                    vh.bindGoal(goal);


        }

        @Override
        public int getItemCount() {


            // Add extra view to show the footer view

            return mGoals.size();
        }


        @Override
        public int getItemViewType(int position) {


            return super.getItemViewType(position);
        }
        public void setGoals(List<Goal> goals){
            mGoals = goals;
        }



    }




}
