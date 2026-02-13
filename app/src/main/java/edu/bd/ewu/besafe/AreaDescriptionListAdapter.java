package edu.bd.ewu.besafe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AreaDescriptionListAdapter extends ArrayAdapter<Complaint_List> {

    private  LayoutInflater inflater;    // inflater used to access the views of a layout
    private int resourceId;




    public AreaDescriptionListAdapter(@NonNull Context context, int resource, @NonNull List<Complaint_List> items) {
        super(context, resource, items);
        this.resourceId = resource;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }


    // getView is a member function of ArrayAdapter. gets called as many times as the number of rows in items


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {     // gets called for every row
//        return super.getView(position, convertView, parent);


        @SuppressLint("ViewHolder") View rowView = inflater.inflate(resourceId, parent, false);  // firstly, we access the empty template(access layout-work of inflater)
        TextView issue = rowView.findViewById(R.id.issue);
        TextView problemDescription = rowView.findViewById(R.id.description);   // now access the elments inside that layout
        TextView address = rowView.findViewById(R.id.address);
        TextView urgency = rowView.findViewById(R.id.urgent);



        Complaint_List c = this.getItem(position);
        System.out.println("the issue is: "+c.issue);
        issue.setText(c.issue);
        //System.out.println("here the issuueeee isssssssssss"+issue.getText().toString());
        problemDescription.setText(c.problem_faced);
        address.setText(c.address);
        urgency.setText(c.urgency);


        return rowView;

    }
}