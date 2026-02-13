package edu.bd.ewu.besafe;



import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Area_Checking extends Activity {

    public static int globalCounter = 0;
    private ListView area_List;   // for area lists
    private ArrayList<Complaint_List> items = new ArrayList<>();
    private AreaListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_checking);
        area_List = findViewById(R.id.area_lists);

        area_List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Complaint_List selectedComplaint = items.get(position);

                Intent i = new Intent(Area_Checking.this, ParticularAreaProblem.class);
                i.putExtra("address", selectedComplaint.address);
                System.out.println("area checking address is"+selectedComplaint.address);
                startActivity(i);
            }

        });

        Button back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Area_Checking.this, user_homepageActivity.class);
                startActivity(i);


            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

    }


//    onResume(), onPause(), onStop(), onRestart(), onDestroy()

    @Override
    protected void onResume() {
        super.onResume();

        items.clear();

//        ArrayList<Complaint> items = new ArrayList<>();

        UnreviewedComplaintTable db = new UnreviewedComplaintTable(this);
        Cursor rows = db.execute("SELECT * FROM unreviewed_complaint_value_pairs");

//        String all_areas[]=new String[];

        String all_areas = "";
//        String[] all_areas_sep;

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

            String[] all_areas_sep;

            if(all_areas.length() ==0){
                all_areas = address+ "###";
                items.add(new Complaint_List(complaint_id, issue, address, problem_faced, urgency));
            }

            if(all_areas.length() !=0){
                all_areas_sep = all_areas.split("###");

                int flag = 0;
                for(int i =0; i<all_areas_sep.length; i++){
                    if(all_areas_sep[i].equals(address)){
                        flag = 1;
                        break;
                    }
                }
                if(flag==0){
                    all_areas = all_areas+address+"###";
                    items.add(new Complaint_List(complaint_id, issue, address, problem_faced, urgency));
                }
            }

        }

        AreaListAdapter ala = new AreaListAdapter(this, R.layout.activity_row_all_area, items);
        area_List.setAdapter(ala);    // sets rows in the layout: complaint_list

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
