package is.hi.project_aapp.Goals;



import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import is.hi.project_aapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoalFragment extends Fragment {
    private Goal mGoal;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mIsDoneCheckBox;
    private static final String DIALOG_DATE = "DialogDate";
    private static final int REQUEST_DATE = 0;


    public GoalFragment() {
        // Required empty public constructor
    }

    @Override
    public void onPause(){
        super.onPause();

        GoalLab.get(getActivity()).updateGoal(mGoal);
    }
    public static GoalFragment newInstance(int goalId){
        Bundle args = new Bundle();
        args.putInt("ID", goalId);

        GoalFragment fragment = new GoalFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        int goalId = (int) getArguments().getInt("ID",0);
        mGoal = GoalLab.get(getActivity()).getGoal(goalId);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_goal, container, false);
        mTitleField = (EditText) v.findViewById(R.id.crime_title);
        mTitleField.setText(mGoal.getGoal());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mGoal.setGoal(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mDateButton = (Button) v.findViewById(R.id.crime_date);
        updateDate();

        mDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                FragmentManager manager = getActivity().getFragmentManager();
                DatePickerFragment dialog = DatePickerFragment.newInstance(mGoal.getGoalYear(), mGoal.getGoalMonth(), mGoal.getGoalDay());
                dialog.setTargetFragment(GoalFragment.this, REQUEST_DATE);
                dialog.show(manager, DIALOG_DATE);
            }
        });

        mIsDoneCheckBox = (CheckBox) v.findViewById(R.id.crime_solved);
        mIsDoneCheckBox.setChecked(mGoal.isDone());
        mIsDoneCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mGoal.setIsDone(isChecked);
            }
        });
        return v;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode != Activity.RESULT_OK){
            return;
        }
        if (requestCode == REQUEST_DATE){
            Date date = (Date) data.getSerializableExtra("date");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            mGoal.setGoalDay(day);
            mGoal.setGoalMonth(month);
            mGoal.setGoalYear(year);
            updateDate();


        }
    }

    private void updateDate(){
        mDateButton.setText(mGoal.getDate());
    }

}
