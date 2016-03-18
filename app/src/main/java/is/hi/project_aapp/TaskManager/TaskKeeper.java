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
    // þurfa töskin kannski að vera skilgreins sem eitthva fyrst sem er svo sett inn í arraylistann
    // eins og kannski harðkóðað fylki sem er svo loopað í gegnum með put

    private String[] allTasks = new String[]{"vakna", "sofa", "borda", "tala", "syngja", "dansa", "flippa"};
    //instance variables
    //hmap has a String key and keeps track of the Counter objects
    HashMap<String, Counter> hmap = new HashMap<String, Counter>();
    //Context has to come from the activity
    Context context;
    private ArrayList<String> highPriorityTasks = new ArrayList<>();
    private ArrayList<String> mediumPriorityTasks = new ArrayList<>();
    private ArrayList<String> lowPriorityTasks = new ArrayList<>();


    public TaskKeeper(Context context) {

        Counter c = new Counter();

        for (int i = 0; i < 7; i++) {
            c.addToDoneList(true);
        }

        hmap.put("randomGæi", c);

    /*    for(int i = 0; i<= allTasks.length; i++) {
            hmap.put(allTasks[i], new Counter());
        } */


        this.context = context;
    }

    /**
     * Before:
     * After: hmap has been serialised
     **/
    public void serialiseHashMap() {

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
            out.writeObject(hmap);
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
    public void deSerialiseHashMap() {

        //map is empty
        HashMap<Integer, String> map = null;
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
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("Deserialized HashMap..");
        // Display content using Iterator
        Set set = map.entrySet();
        Iterator iterator = set.iterator();

        //plokka upplýsingar út úr mappinu
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            System.out.print("key: " + mentry.getKey() + " & Value: ");
            System.out.println(mentry.getValue());
            System.out.println("Valúið er: " + map.get(mentry.getValue()));
            Counter c = (Counter) mentry.getValue();
            System.out.println(c.getLast7Days());

        }
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
