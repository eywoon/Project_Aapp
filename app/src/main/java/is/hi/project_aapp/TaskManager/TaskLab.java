package is.hi.project_aapp.TaskManager;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Eyrun on 10/04/16.
 * This is a singleton class
 */
public class TaskLab {
    private static TaskLab sTaskLab;
    private List<Task> tasks;
//    private String[] allTasks;
    private String[] allTasks = new String[]{"vakna", "sofa", "borda", "tala", "syngja", "dansa", "flippa"};
  //  private TaskKeeper mTaskKeeper;
    private HashMap hmap;


    public static TaskLab get(Context context) {
        if(sTaskLab == null) {
            sTaskLab = new TaskLab(context);
        }
        return sTaskLab;
    }



    public TaskLab(Context context) {
        tasks = new ArrayList<>();


        // þetta er til þess að fá listann af tasks, s.s. strengina
        // svo hann sé ekki geymdur út um allt
      //  mTaskKeeper = new TaskKeeper(context);
      //  allTasks = mTaskKeeper.getAllTasks();

        //ef hashmappið er minna en 7?
        // ef þetta er tekið úr fer changeBooleanValue í villu, eins og lykilinn sé ekki til
     //   mTaskKeeper.createHashMapFirstTime();
        // ef mappið er deserialisað hér, þá er það ekki tómt
       // hmap = mTaskKeeper.deSerialiseHashMap();

       // System.out.println(hmap);
      // fyllir inn í arraylistann
       for(String i : allTasks) {
          Task task = new Task(i, true);
          tasks.add(task);
       }
    }

    public List<Task> getTasks(){
        return tasks;
    }


  /*  public void setTaskKeeper(String s, boolean b) {
        mTaskKeeper.changeBooleanValue(b, s);
    } */

    // kannski þarf id dótið??

}
