package is.hi.project_aapp.Goals;

/**
 * Created by hrefnaolafsdottir on 09/04/16.
 */
public class Goal {
    private int id;
    private String goal, description;
    private int goalDay, goalMonth, goalYear;
    private boolean isDone;

    Goal(){

    }
    Goal(String goal, String description ,int goalDay, int goalMonth, int goalYear, int isDone, int id){
        this.goal = goal;
        this.description = description;
        this.goalDay = goalDay;
        this.goalMonth = goalMonth;
        this.goalYear = goalYear;
        this.isDone = isDone != 0;
        this.id = id;
    }

    public int getGoalDay() {
        return goalDay;
    }

    public int getGoalMonth() {
        return goalMonth;
    }

    public int getGoalYear() {
        return goalYear;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public void setGoalDay(int goalDay) {
        this.goalDay = goalDay;
    }

    public void setGoalMonth(int goalMonth) {
        this.goalMonth = goalMonth;
    }

    public void setGoalYear(int goalYear) {
        this.goalYear = goalYear;
    }
    public String getDate(){
        String temp = goalDay+"/"+goalMonth+"/"+goalYear;
        return temp;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
