package is.hi.project_aapp.Results;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

import is.hi.project_aapp.Goals.GoalListFragment;
import is.hi.project_aapp.R;
import is.hi.project_aapp.SingleFragmentActivity;

public class ResultActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ResultFragment();
    }

}
