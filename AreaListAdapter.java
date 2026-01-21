package edu.bd.ewu.besafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AreaListAdapter extends ArrayAdapter<Complaint_List> {

    private  LayoutInflater inflater;    // inflater used to access the views of a layout
    private int resourceId;


    public AreaListAdapter(@NonNull Context context, int resource, @NonNull List<Complaint_List> items) {
        super(context, resource, items);
        this.resourceId = resource;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    // getView is a member function of ArrayAdapter. gets called as many times as the number of rows in items

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {     // gets called for every row

        View rowView = inflater.inflate(resourceId, parent, false);  // firstly, we access the empty template(access layout-work of inflater)
        TextView address = rowView.findViewById(R.id.area_information);

        Complaint_List c = this.getItem(position);

        address.setText(c.address);
        return rowView;

    }
}