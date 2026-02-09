package edu.bd.ewu.besafe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Feedback extends Activity {

    public static int globalCounter = 0;
    private EditText comment_us;
    private RadioGroup feedback;
    private String selectedId = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        System.out.println(Feedback.globalCounter+" @Feedback-oCreate()");

        feedback = findViewById(R.id.feedback);
        comment_us = findViewById(R.id.comment_us);

        Button submit  = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //System.out.println(user_homepageActivity.globalCounter+ "@Feedback-Submit Button was pressed");

                int selectedRadioFeedbackId = feedback.getCheckedRadioButtonId();
                RadioButton feedback = findViewById(selectedRadioFeedbackId);


                System.out.println("fdbk: "+feedback.getText().toString());
                System.out.println("comment: "+comment_us.getText().toString());

                String fdbk = feedback.getText().toString();
                String comment = comment_us.getText().toString();


                String feedbackId = comment + System.currentTimeMillis();
                String Value = feedbackId + "-----"+ fdbk+ "-----" + comment ;

                UserFeedbackUtil.getInstance().setKeyValue(Feedback.this, feedbackId, Value);   // context can be activity or service. using only this as context will get the nearest

                Intent i = new Intent(Feedback.this, user_homepageActivity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Your Feedback is sent successfully",Toast.LENGTH_SHORT).show();


            }
        });


        Button home  = findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(user_homepageActivity.globalCounter+ "@Feedback-Home Button was pressed");

                Intent i = new Intent(Feedback.this, user_homepageActivity.class);
                startActivity(i);

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();


    }


    @Override
    protected void onResume() {
        super.onResume();


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