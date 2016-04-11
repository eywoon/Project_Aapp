package is.hi.project_aapp.Goals;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eyrun on 11/04/16.
 */
public class GoalLab {
    private static GoalLab sGoalLab;
    private List<Goal> goals;

    public static GoalLab get(Context context) {
        if(sGoalLab == null) {
            sGoalLab = new GoalLab(context);
        }
        return sGoalLab;
    }

    public GoalLab(Context context) {
        goals = new ArrayList<>();
        Goal goal = new Goal("flippa", 14, 03, 2015);
        Goal goal2 = new Goal("danse", 12, 03, 2014);

        //TODO:setja inn í arraylistann með cursor gögnunum
        goals.add(goal);
        goals.add(goal2);

    }

    public List<Goal> getGoals() { return goals;}
}
