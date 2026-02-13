package edu.bd.ewu.besafe;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ParticularAreaProblem extends Activity {

    //private EditText issue, description, urgent, review;
    private String selected_address;
    //    private RadioGroup radioEventGroup;
    private String selectedId = "";

    private ListView area_List;   // for complaint_list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_checking);
         area_List = findViewById(R.id.area_lists);

        Button back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });


        Intent i = getIntent();

        if(i.hasExtra("address")) {

            selected_address = i.getStringExtra("address");
            System.out.println(selected_address);

        }
        else{
        }


    }

    @Override
    protected void onStart() {
        super.onStart();

    }

//    onResume(), onPause(), onStop(), onRestart(), onDestroy()

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Complaint_List> items = new ArrayList<>();

        UnreviewedComplaintTable db = new UnreviewedComplaintTable(this);
        Cursor rows = db.execute("SELECT * FROM unreviewed_complaint_value_pairs");


        while(rows.moveToNext()){
            String complaint = rows.getString(0);     // returns the first column out of the 2 columns
            String value = rows.getString(1);

            String[] subStrings = value.split("-----");

            String complaint_id = subStrings[0];
            String issue = subStrings[1];
            String address = subStrings[2];
            String problem_faced = subStrings[3];
            String urgency = subStrings[4];
            String review = subStrings[5];

            if (address.equals(selected_address)){

                items.add(new Complaint_List(complaint_id, issue, address, problem_faced, urgency));
                System.out.println(selected_address);
            }

        }

        AreaDescriptionListAdapter ala = new AreaDescriptionListAdapter(this, R.layout.activity_area_row, items);
        area_List.setAdapter(ala);    // sets rows in the layout: listAreas


    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


}