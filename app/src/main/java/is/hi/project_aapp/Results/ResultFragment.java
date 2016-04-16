package is.hi.project_aapp.Results;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import is.hi.project_aapp.R;
import is.hi.project_aapp.SingleFragmentActivity;
import is.hi.project_aapp.TaskManager.Counter;
import is.hi.project_aapp.TaskManager.TaskKeeper;

/**
 * Created by Eyrun on 12/04/16.
 */
public class ResultFragment extends Fragment {
    TaskKeeper mTaskKeeper;

   /* public ResultFragment() {
        mTaskKeeper = new TaskKeeper(getActivity().getApplicationContext());
    }
 */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);
        mTaskKeeper = new TaskKeeper(getActivity().getApplicationContext());
        getResults();

        return view;
    }

    public void getResults() {

        HashMap hmap = mTaskKeeper.deSerialiseHashMap();
       // mTaskKeeper.createHashMapFirstTime();

        mTaskKeeper.countTasksToday();





        if(hmap.isEmpty()) {
            System.out.println("FOKK FOKK FOKK FOKK FOKK FOKK FOKKk");
        }

        System.out.println("ÞETTA ER TIL ÉG LOFA " + hmap);
        Set set = hmap.entrySet();
        Iterator iterator = set.iterator();

        //plokka upplýsingar út úr mappinu
        while (iterator.hasNext()) {

            Map.Entry mentry = (Map.Entry) iterator.next();
            System.out.print("key: " + mentry.getKey() + " & Value: ");
            System.out.println(mentry.getValue());
            Counter c = (Counter) mentry.getValue();
            System.out.println(c.getLast7Days());
        }

    }



}
