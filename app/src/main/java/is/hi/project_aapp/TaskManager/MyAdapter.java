package is.hi.project_aapp.TaskManager;

/**
 * Created by Eyrun on 26/03/16.
 */
import java.util.ArrayList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import is.hi.project_aapp.R;


/**
 * Created by Eyrun on 25/03/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private ArrayList<String> values;

    // inner ViewHolder class
    // þessi klasi stillir text viewið
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        //  public TextView txtFooter;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            //       txtFooter = (TextView) v.findViewById(R.id.secondLine);
        }
    }

    // bæta við í adapterinn
    public void add(int position, String item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    // taka stak út úr listanum
    public void remove(int position) {
        values.remove(position);
        //tékka á þessari aðferð
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset, this case an Arraylist of strings)
    public MyAdapter(ArrayList<String> myDataset) {
        values = myDataset;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder,final int position) {
        // - get element from your dataset at this position

        //gæti verið að það þurfi hér að ná position út úr arraylistanum
        String k = values.get(position);

        //   System.out.println(k);

        // - replace the contents of the view with that element

        final String name = values.get(position);
        holder.txtHeader.setText(name);
        holder.txtHeader.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(position);
            }
        });

        //    holder.txtFooter.setText("Footer: " + name);

    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}
