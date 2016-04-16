package is.hi.project_aapp.TaskManager;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;

import is.hi.project_aapp.R;

/**
 * Created by Eyrun on 10/04/16.
 */
public class TaskListFragment extends Fragment {
    private RecyclerView mTaskRecyclerView;
    private TaskAdapter mAdapter;
    private Context mContext;
    private TaskKeeper mTaskKeeper;

    //= new TaskKeeper(mContext);

    //?? veit ekki með þetta
  //  private TaskLab mTaskLab;




    public void setContext(Context context) {
        mContext =  context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mTaskKeeper =  new TaskKeeper(getActivity().getApplicationContext());
       // mTaskKeeper.createHashMapFirstTime();
        mTaskKeeper.deSerialiseHashMap();

        View view = inflater.inflate(R.layout.fragment_task_list, container, false);

        mTaskRecyclerView = (RecyclerView) view.findViewById(R.id.task_recycler_view);
        mTaskRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;

    }

    public void updateUI() {
        TaskLab taskLab = TaskLab.get(getActivity());
        List<Task> tasks = taskLab.getTasks();

        mAdapter = new TaskAdapter(tasks);
        mTaskRecyclerView.setAdapter(mAdapter);

    }

    // inner ViewHolder class
    //viewholder heldur utan um hvert atriði í listanum (held ég)
    private class TaskHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        private Task mTask;
        private TextView mTitleTextView;
        private HashMap hmap;

        public TaskHolder(View itemView) {
            super(itemView);

            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_task_title_text_view);
            itemView.setOnClickListener(this);
        }

        public void bindTask(Task task) {
            mTask = task;
            mTitleTextView.setText(mTask.getTask());
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            mAdapter.remove(pos);
            mTaskKeeper.changeBooleanValue(mTask.getTask(), true);
            Toast.makeText(getActivity(), mTask.getTask() +  " clicked!" , Toast.LENGTH_SHORT).show();
        }
    }

    private class TaskAdapter extends RecyclerView.Adapter<TaskHolder> {
        private List<Task> mTasks;

        public TaskAdapter(List<Task> tasks) {
            mTasks = tasks;
        }

        @Override
        public TaskHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_task, null);
            return new TaskHolder(view);
        }

        @Override
        public void onBindViewHolder(TaskHolder holder, int position) {
            Task task = mTasks.get(position);
            holder.bindTask(task);
        }

        @Override
        public int getItemCount() {
            return mTasks.size();
        }

        // taka stak út úr listanum
        public void remove(int position) {
            mTasks.remove(position);
            notifyItemRemoved(position);
        }
    }
}
