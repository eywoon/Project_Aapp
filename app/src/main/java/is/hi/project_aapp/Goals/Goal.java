package is.hi.project_aapp.Goals;

/**
 * Created by hrefnaolafsdottir on 09/04/16.
 */
public class Goal {
    private String goal;
    private int goalDay, goalMonth, goalYear;

    Goal(String goal, int goalDay, int goalMonth, int goalYear){
        this.goal = goal;
        this.goalDay = goalDay;
        this.goalMonth = goalMonth;
        this.goalYear = goalYear;
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
}
