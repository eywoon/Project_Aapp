package is.hi.project_aapp.TaskManager;

/**
 * Created by Eyrun on 10/04/16.
 */
public class Task {

    private String task;
    private Boolean isDone;

    public Task(String task, Boolean isDone) {
        this.task = task;
        this.isDone = isDone;
    }


    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
