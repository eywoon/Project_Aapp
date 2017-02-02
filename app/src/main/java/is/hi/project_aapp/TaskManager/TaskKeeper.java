package is.hi.project_aapp.TaskManager;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.renderscript.RenderScript;
import android.support.annotation.Nullable;
import android.view.Display;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import android.content.Context;

/**
 * Created by Eyrun on 28/02/16.
 */

public class TaskKeeper {

    private String[] allTasks = new String[]{"Ég vaknaði á réttum tíma", "Ég stundaði hugleiðslu", "Ég var kurteisi", "Ég vann húsverk", "Ég skrifaði í dagbókina", "Ég fór í bað", "Það var hreint í hjá mér", "Ég las AA bókina", "Ég stundaði áhugamál", "Ég var til fyrirmyndar", "Ég sofnaði fyrir miðnætti"};
    //instance variables
    //hmap has a String key and keeps track of the Counter objects
    HashMap<String, Counter> hmap = new HashMap<String, Counter>();

    //Context has to come from the activity
    private ArrayList<String> highPriorityTasks = new ArrayList<>();
    private ArrayList<String> mediumPriorityTasks = new ArrayList<>();
    private ArrayList<String> lowPriorityTasks = new ArrayList<>();
    Context context;
    Counter c;

    /*
     Context þarf að fylgja með frá activity-inu til þess að það sé hægt að seraliasa, s.s
     það þarf Context til þess að geta opnað og lokað FileInput/OutputStream
     */
    public TaskKeeper(Context context) {
        this.context = context;
        try {
            System.out.println("ég reyndi að opna hashmappið");
            hmap = deSerialiseHashMap();
        }
        catch (Exception exeption) {
            System.out.println("En það var ekkert hashmap til svo ég gerði það");
            createHashMapFirstTime();
        }
     //   if(hmap.isEmpty()) {
      //      createHashMapFirstTime();
     //   }
    }

    public String[] getAllTasks() {
        return allTasks;
    }

    /*

     */
    public void createHashMapFirstTime() {

        for(int i = 0; i < allTasks.length; i++) {
            hmap.put(allTasks[i], c = new Counter());
            int j = 0;
            ArrayList<Boolean> temp;;
            temp = c.getLast7Days();
            if(temp.isEmpty()) {
                while(j < 7) {
                    c.addToDoneList(false);
                    j++;
                }
            }
        }
        serialiseHashMap(hmap);
    }

    //TODO: þetta b versus bara true
    public void changeBooleanValue(String key, boolean b) {

        if(hmap.isEmpty()) {
            System.out.println("HashMap is empty :( ");
        }

        if(hmap.containsKey(key)) {
            System.out.println("_FDASFDASFKDASLFKLÆDASKGÆAFLKDHJGFLÆDAJSLGÆLFKAGDJSK");
            // sækir Counter fyrir lykilinn
            c = (Counter) hmap.get(key);
            // setur nýja gildið aftast (sem er í raun alltaf true, en laga það seinna
            c.addToDoneList(true);
            // vistum hashmappið
            serialiseHashMap(hmap);
            // þetta er bara til þess að skoða
           // c.setDoneToday(true);
         //   System.out.println(c.getDoneToday());
         //  deSerialiseHashMap();
        }
        else {
            System.out.println("hólí fokk það er einhver villa :O ");
        }
    }

    /**
     * Before:
     * After: hmap has been serialised
     **/
    public void serialiseHashMap(HashMap newMap) {

        FileOutputStream fileOut;
        String filename = "hashmap";

        try {
            /* For information: */
            //mode private = recreate the file even if it exists
            //mode append = if exists append to it, otherwise create it
            fileOut = context.openFileOutput(filename, Context.MODE_PRIVATE);

            //ObjectOutputStream: Getur serialisað object (og primitive types) í þetta skiptið er það í file-inn
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            // writeObject: Writes an object to the target stream.
            out.writeObject(newMap);
            //closes the stream
            out.close();
            //closes the FileOutPutStream
            fileOut.close();
            System.out.println("Serialized data is saved in" + filename);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * Before: map is an empty hashmap
     * After: ?? has been deserialised into map??
     **/
    public HashMap deSerialiseHashMap() {

        //map is empty
        HashMap<String, Counter> map = null;
        String filename = "hashmap";
        try {
            FileInputStream fis = context.openFileInput(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            // read the object and cast to a hashmap (the aldready defined map)
            map = (HashMap) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            //return map;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            //return map;
        }
        System.out.println("Deserialized HashMap..");
        // Display content using Iterator
        Set set = map.entrySet();
        Iterator iterator = set.iterator();

        //plokka upplýsingar út úr mappinu
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
         //   System.out.print("key: " + mentry.getKey() + " & Value: ");
          //  System.out.println(mentry.getValue());
            Counter c = (Counter) mentry.getValue();
          //  System.out.println(c.getLast7Days());
        }
      //  hmap = map;
        return map;
    }

  /* public HashMap getMap(){
        deSerialiseHashMap();
        return hmap;
    } */

    public int countTasksToday(int day) {
        //TODO: telja hversu margar tasks er búið að framkvæma í dag
        hmap = deSerialiseHashMap();

        Set set = hmap.entrySet();
        Iterator iterator = set.iterator();

        Boolean stats[] = new Boolean[allTasks.length];
        int noOfTasksDoneToday = 0;
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();

            Counter c = (Counter) mentry.getValue();
            boolean status = c.getLast7Days().get(day);
            if(status == true) {
                noOfTasksDoneToday++;
            }
        }

      // setBackGroundColour(noOfTasksDoneToday);
        System.out.println("Í dag er búið að gera " + noOfTasksDoneToday + " hluti");
        return noOfTasksDoneToday;
    }


    public void checkDaily() {
        //TODO: send a push notification every day at a certain time
    }

    public void checkEveryThreeDays() {
        //TODO: send a push notification every three days at a certain time
    }

    public void checkWeekly() {
        //TODO: send a push notification every week at a certain time and day
    }

    public void sendNotification(String s) {
        //TODO: send a the push notification with the relevant string (time is already determined in each individual check method
    }

    public String getBackgroundColour() {
        //TODO: colour is determined by the percentage of tasks finished that day
        return "colour";
    }

}