package edu.bd.ewu.besafe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class user_homepageActivity extends Activity {

     public static int globalCounter = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_homepage);



        Button btnSubmitComplaint = findViewById(R.id.btnSubmitComplaint);

        btnSubmitComplaint.setOnClickListener(v -> {

            Intent i = new Intent(user_homepageActivity.this, SubmitComplaintActivity.class);
            startActivity(i);
        });

        Button btnFeedback = findViewById(R.id.btnFeedback);

        btnFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(user_homepageActivity.this, Feedback.class);
                startActivity(i);
            }
        });


        Button btnCheckArea = findViewById(R.id.btnCheckArea);

        btnCheckArea.setOnClickListener(v -> {

            Intent i = new Intent(user_homepageActivity.this, Area_Checking.class);
            startActivity(i);
        });


        TextView btnExit = findViewById(R.id.btnExit);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(user_homepageActivity.this, MainHomeActivity.class);
                startActivity(i);

            }
        });



    }






    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("@user_homepageActivity- onStart");





    }


//    onResume(), onPause(), onStop(), onRestart(), onDestroy()

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("@user_homepageActivity- onResume");





    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("@user_homepageActivity- onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("@user_homepageActivity- onStop");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("@user_homepageActivity- onRestart");



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println(" @user_homepageActivity-onDestroy()");

    }

}
