package is.hi.project_aapp.TaskManager;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import is.hi.project_aapp.R;


public class TaskActivity extends AppCompatActivity {

    private RecyclerView rw;
    private MyAdapter adapter;
    // veit ekki alveg hvernig þetta er notað
    private RecyclerView.LayoutManager mLayoutManager;
   // private  TaskKeeper tk;

    private String[] allTasks = new String[]{"vakna", "sofa", "borda", "tala", "syngja", "dansa", "flippa"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        // the recyclerView declared in content_task. It has the id:my_recycler_view
        rw =  (RecyclerView) findViewById(R.id.my_recycler_view);

        //set a linearLayout on the layout manager
        mLayoutManager = new LinearLayoutManager(this);
        //set the LinearLayout to the recycler view
        rw.setLayoutManager(mLayoutManager);

        // á þetta að vera hér?
        // er þetta betra fyrir neðan?
      //  tk = new TaskKeeper(getApplicationContext());

        //ef hashmappið er minna en 7?
        // ef þetta er tekið úr fer changeBooleanValue í villu, eins og lykilinn sé ekki til
       // tk.createHashMapFirstTime();
        //HashMap hmap = tk.deSerialiseHashMap();

        final ArrayList<String> values = new ArrayList<String>();

        // fyllir inn í arraylistann
        for(String i : allTasks) {
            values.add(i);
        }

        System.out.println("úr nýjasta " + values.get(2));

        adapter = new MyAdapter(values);
        rw.setAdapter(adapter);

        /*

        Drasl sem tengist listenernum

         */
        final GestureDetector mGestureDetector = new GestureDetector(TaskActivity.this, new GestureDetector.SimpleOnGestureListener() {

            @Override public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

        });



        rw.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
                                      
                                      @Override
                                      public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent e) {

                                          View child = recyclerView.findChildViewUnder(e.getX(),e.getY());
                                          int position = recyclerView.getChildPosition(child);
                                          System.out.println(position);

                                          if(child!=null && mGestureDetector.onTouchEvent(e)){
                                              System.out.println("ehehehe veitr ekkert hvað er í gangi :@");
                                              //temp heldur utan um það sem á svo að vera lykilinn
                                              String temp = values.get(position);
                                              setTaskKepper(true, temp);
                                              adapter.remove(position);
                                              //position -1 þýðir að ýtt er út fyrir listann
                                              //veit ekki hvað true og false eru að gera
                                              // skoða documentation fyrir onInterceptTouchEvent
                                              return true;
                                          }
                                          return false;
                                      }
                                      @Override
                                      public void onTouchEvent(RecyclerView rv, MotionEvent e) {

                                      }

                                      @Override
                                      public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
                                          //?? veit ekki neitt
                                      }
                                  }
        );
    }
    //Setja taskkeeper dótið af stað (reyna þetta til þess að ná því út úr langa onCreate fallinu
    public void setTaskKepper(boolean b, String s) {

        //s er lykillinn, b er counter valueið

        //getApplicationContext er til þess að senda Context context með
        //TaskKeeper tk = new TaskKeeper(getApplicationContext());

        //tk.serialiseHashMap(hmap);

        //hér ætti ég að deserialisa aftur þegar ég er búin að breyta gildi fyrir ákveðinn lykil í hashmappinu
        //  Counter c = new Counter();
        // c.addToDoneList(b);

       // tk.changeBooleanValue(b, s);

        // HashMap hmap = tk.deSerialiseHashMap();

    }

}
