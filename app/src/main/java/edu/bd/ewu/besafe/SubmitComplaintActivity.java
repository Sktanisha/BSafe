package edu.bd.ewu.besafe;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class SubmitComplaintActivity extends Activity {

    public static int globalCounter = 0;
    private EditText etAddress, etProblemFaced;
    private RadioGroup radioGroupIssue, radioGroupUrgency;
    private final String selectedId = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.submit_complaints);


        radioGroupIssue = findViewById(R.id.radioGroupIssue);
        etAddress = findViewById(R.id.etAddress);
        etProblemFaced = findViewById(R.id.etProblemFaced);
        radioGroupUrgency = findViewById(R.id.radioGroupUrgency);
        RadioButton rb_harassment = findViewById(R.id.rb_harassment);
        RadioButton rb_security = findViewById(R.id.rb_security);
        RadioButton rb_corruption = findViewById(R.id.rb_corruption);
        RadioButton rb_drug = findViewById(R.id.rb_drug);
        RadioButton rb_others = findViewById(R.id.rb_others);
        RadioButton rb_anytime=findViewById(R.id.rb_anytime);
        RadioButton rb_emergency=findViewById(R.id.rb_emergency);
        RadioButton rb_weeks=findViewById(R.id.rb_weeks);
        TextView btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String error="";
                String et_Address= etAddress.getText().toString();
                if(et_Address.length()<2){
                    error = "Invalid Address\n";
                }
                String et_ProblemFaced=etProblemFaced.getText().toString();
                if(et_ProblemFaced.length()<5){
                    error += "Please fill up details information\n";
                }
                String type="";
                if(rb_corruption.isChecked()||rb_drug.isChecked()||rb_harassment.isChecked()||rb_others.isChecked()||rb_security.isChecked()){
                    type="selected\n";
                }
                /*if(rb_drug.isChecked()){
                    type="Invalid Drug trafficking\n";
                }
                if(rb_harassment.isChecked()){
                    type="Invalid women harassment\n";
                }
                if(rb_others.isChecked()){
                    type="Invalid others\n";
                }
*/
                if(error.length() ==0 && type.length() !=0){

                int selectedRadioIssueId = radioGroupIssue.getCheckedRadioButtonId();
                RadioButton radioIssueButton = (RadioButton) findViewById(selectedRadioIssueId);

                int selectedRadioUrgencyId = radioGroupUrgency.getCheckedRadioButtonId();
                RadioButton radioUrgencyButton = (RadioButton) findViewById(selectedRadioUrgencyId);


                System.out.println("issue: " + radioIssueButton.getText().toString());
                System.out.println("Address: " + etAddress.getText().toString());
                System.out.println("Problem faced: " + etProblemFaced.getText().toString());
                System.out.println("urgency: " + radioUrgencyButton.getText().toString());


                String issue_str = radioIssueButton.getText().toString();
                String address_str = etAddress.getText().toString();
                String problem_faced_str = etProblemFaced.getText().toString();
                String urgency = radioUrgencyButton.getText().toString();
                String review = "Not Reviewed Yet";

                String complaintId = address_str + System.currentTimeMillis();
                String eventValue = complaintId + "-----" + issue_str + "-----" + address_str + "-----" + problem_faced_str + "-----" + urgency + "-----" + review;
                System.out.println("complained id"+complaintId);


                ComplaintUtil.getInstance().setComplaintKeyValue(SubmitComplaintActivity.this, complaintId, eventValue);   // context can be activity or service. using only this as context will get the nearest
                UnreviewedComplaintUtil.getInstance().setComplaintKeyValue(SubmitComplaintActivity.this, complaintId, eventValue);   // context can be activity or service. using only this as context will get the nearest
                    showDialog("Do you want to submit?","Confirmation","Yes","No");


                    }

                else {
                    showDialog(error, "Please fill up the form carefully","Ok", "Back");
                }

            }
        });


        TextView btnHome = findViewById(R.id.btnHome);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(SubmitComplaintActivity.this, user_homepageActivity.class);
                startActivity(i);

            }
        });
    }
    private void showDialog (String message, String title, String bt1, String bt2){
        AlertDialog.Builder builder = new AlertDialog.Builder(SubmitComplaintActivity.this);

        builder.setMessage(message);
        builder.setTitle(title);

        builder.setCancelable(false)
                .setPositiveButton(bt1, (dialog, id) -> {
                    System.out.println("Yes,it is working");

                    dialog.cancel();


                })
                .setNegativeButton(bt2, (dialog, id) -> {
                    System.out.println("No,it is not working");
                    dialog.cancel();

                });
        //Creating dialogue box
        AlertDialog alert = builder.create();

        alert.show();
    }

        @Override
        protected void onStart () {
            super.onStart();
            System.out.println("@SubmitComplaintActivity- onStart");


        }


//    onResume(), onPause(), onStop(), onRestart(), onDestroy()

        @Override
        protected void onResume () {
            super.onResume();
            System.out.println("@SubmitComplaintActivity- onResume");
//           ComplaintUtil.getInstance().getValueByComplaintKey(SubmitComplaintActivity.this,"mirpur11662748791880");   // context can be activity or service. using only this as context will get the nearest
//            System.out.println(answer);


        }

        @Override
        protected void onPause () {
            super.onPause();
            System.out.println("@SubmitComplaintActivity- onPause");

        }

        @Override
        protected void onStop () {
            super.onStop();
            System.out.println("@SubmitComplaintActivity- onStop");

        }

        @Override
        protected void onRestart () {
            super.onRestart();
            System.out.println("@SubmitComplaintActivity- onRestart");


        }

        @Override
        protected void onDestroy () {
            super.onDestroy();
            System.out.println("@SubmitComplaintActivity- onDestroy");

        }


    }