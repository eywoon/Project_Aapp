package is.hi.project_aapp.Results;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Calendar;
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
    private TaskKeeper mTaskKeeper;
    private BarChart mChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_result, container, false);
        mTaskKeeper = new TaskKeeper(getActivity().getApplicationContext());

        BarChart chart = (BarChart) view.findViewById(R.id.chart);

        BarData data = new BarData(getXAxisValues(), getDataSet());
        chart.setData(data);
        chart.setDescription("");
        chart.animateXY(2000, 2000);
        chart.invalidate();


        getResults();


        return view;
    }

    public void getResults() {

        HashMap hmap = mTaskKeeper.deSerialiseHashMap();
        if(hmap.isEmpty()) {
            System.out.println("FOKK FOKK FOKK FOKK FOKK FOKK FOKKk");
        }
        else{ System.out.println("ÞETTA ER TIL ÉG LOFA " + hmap); }

        Set set = hmap.entrySet();
        Iterator iterator = set.iterator();

        //plokka upplýsingar út úr mappinu
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            System.out.print("key: " + mentry.getKey() + " & Value: ");
            System.out.println(mentry.getValue());
            Counter c = (Counter) mentry.getValue();
            System.out.println(c.getLast7Days());
            System.out.println(c.getLast7Days().get(5));
        }
    }

    public ArrayList<String> getXAxisValues() {

        LocalDate localDate6 = new LocalDate();

        int day6 = localDate6.getDayOfMonth();
        int month6 = localDate6.getMonthOfYear();

        LocalDate localDate5 = localDate6.minusDays(1);
        LocalDate localDate4 = localDate6.minusDays(2);
        LocalDate localDate3 = localDate6.minusDays(3);
        LocalDate localDate2 = localDate6.minusDays(4);
        LocalDate localDate1 = localDate6.minusDays(5);
        LocalDate localDate0 = localDate6.minusDays(6);


        int day5 = localDate5.getDayOfMonth();
        int month5 = localDate5.getMonthOfYear();

        int day4 = localDate4.getDayOfMonth();
        int month4 = localDate4.getMonthOfYear();

        int day3 = localDate3.getDayOfMonth();
        int month3 = localDate3.getMonthOfYear();

        int day2 = localDate2.getDayOfMonth();
        int month2 = localDate2.getMonthOfYear();

        int day1 = localDate1.getDayOfMonth();
        int month1 = localDate1.getMonthOfYear();

        int day0 = localDate0.getDayOfMonth();
        int month0 = localDate0.getMonthOfYear();

        //TODO að finna út dagsetningar með Calendar
        ArrayList<String> labels = new ArrayList<String>();
        labels.add(day0+"/"+month0);
        labels.add(day1+"/"+month1);
        labels.add(day2+"/"+month2);
        labels.add(day3+"/"+month3);
        labels.add(day4+"/"+month4);
        labels.add(day5+"/"+month5);
        labels.add(day6+"/"+month6);


       return labels;
    }


    public BarDataSet getDataSet() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(mTaskKeeper.countTasksToday(0), 0));
        entries.add(new BarEntry(mTaskKeeper.countTasksToday(1), 1));
        entries.add(new BarEntry(mTaskKeeper.countTasksToday(2), 2));
        entries.add(new BarEntry(mTaskKeeper.countTasksToday(3), 3));
        entries.add(new BarEntry(mTaskKeeper.countTasksToday(4), 4));
        entries.add(new BarEntry(mTaskKeeper.countTasksToday(5), 5));
        entries.add(new BarEntry(mTaskKeeper.countTasksToday(6), 5));

        BarDataSet dataSet = new BarDataSet(entries, "Fjöldi lokinna atriða");
        dataSet.setColor(Color.argb(255,215,58,49));

        return dataSet;
    }
}
