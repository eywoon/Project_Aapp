package is.hi.project_aapp.Goals;

/**
 * Created by hrefnaolafsdottir on 09/04/16.
 */
public class Goals {
    private String goal;
    private int goalMonth, goalDay, goalYear;

    Goals(String goal, int goalMonth, int goalYear, int goalDay){
        this.goalDay = goalDay;
        this.goalYear = goalYear;
        this.goalMonth = goalMonth;
        this.goal = goal;
    }

    public int getGoalDay() {
        return goalDay;
    }

    public String getGoal() {
        return goal;
    }

    public int getGoalMonth() {
        return goalMonth;
    }

    public int getGoalYear() {
        return goalYear;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public void setGoalMonth(int goalMonth) {
        this.goalMonth = goalMonth;
    }

    public void setGoalDay(int goalDay) {
        this.goalDay = goalDay;
    }

    public void setGoalYear(int goalYear) {
        this.goalYear = goalYear;
    }
}
