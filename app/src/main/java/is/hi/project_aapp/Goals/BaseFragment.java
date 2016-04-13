package is.hi.project_aapp.Goals;

import android.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

public class BaseFragment extends Fragment {

    protected ActionBar getActionBar() {
        return ((ActionBarActivity) getActivity()).getSupportActionBar();
    }

}
