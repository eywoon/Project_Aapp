package is.hi.project_aapp.Goals;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.app.Fragment;

import java.util.Date;
import java.util.GregorianCalendar;

import is.hi.project_aapp.R;

/**
 * Created by hrefnaolafsdottir on 13/04/16.
 */
public class DatePickerFragment  extends DialogFragment{
    private DatePicker mDatePicker;

    public static DatePickerFragment newInstance(int year, int month, int day){
        Bundle args = new Bundle();
        args.putInt("year", year);
        args.putInt("month", month);
        args.putInt("day", day);

        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_date, null);
        int year = getArguments().getInt("year");
        int month = getArguments().getInt("month");
        int day = getArguments().getInt("day");

        mDatePicker = (DatePicker) v.findViewById(R.id.dialog_date_datePicker);
        mDatePicker.init(year, month, day, null);
        return new AlertDialog.Builder(getActivity()).setView(v).setTitle(R.string.date_button_set).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int year = mDatePicker.getYear();
                int month = mDatePicker.getMonth();
                int day = mDatePicker.getDayOfMonth();
                Date date = new GregorianCalendar(year,month,day).getTime();
                sendResult(Activity.RESULT_OK, date);
            }
        }).create();
    }
    private void sendResult(int resultCode, Date date){
        if(getTargetFragment() == null){
            return;
        }

        Intent intent = new Intent();
        intent.putExtra("date", date);
        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
    }
}
