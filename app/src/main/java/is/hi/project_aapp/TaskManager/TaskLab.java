package is.hi.project_aapp.TaskManager;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Eyrun on 10/04/16.
 * This is a singleton class
 * Creates the data for the adapter
 */
public class TaskLab {
    private static TaskLab sTaskLab;
    private List<Task> tasks;
    private String[] allTasks;
    private TaskKeeper mTaskKeeper;

    public static TaskLab get(Context context) {
        if(sTaskLab == null) {
            sTaskLab = new TaskLab(context);
        }
        return sTaskLab;
    }

    public TaskLab(Context context) {
        tasks = new ArrayList<>();
        mTaskKeeper = new TaskKeeper(context);
        allTasks = mTaskKeeper.getAllTasks();

       for(String i : allTasks) {
          Task task = new Task(i, true);
          tasks.add(task);
       }
    }

    public List<Task> getTasks(){
        return tasks;
    }
}
