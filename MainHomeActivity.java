package edu.bd.ewu.besafe;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainHomeActivity extends AppCompatActivity {

    public static int globalCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);


        TextView btnAdminLogin = findViewById(R.id.btnAdminLogin);

        btnAdminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainHomeActivity.globalCounter++;

                Intent i = new Intent(MainHomeActivity.this, AdminActivity.class);
                startActivity(i);

            }
        });


        TextView btnGiveComplain = findViewById(R.id.btnGiveComplain);

        btnGiveComplain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainHomeActivity.globalCounter++;

                Intent i = new Intent(MainHomeActivity.this, user_homepageActivity.class);
                startActivity(i);


            }
        });

        Button Exit = findViewById(R.id.btn_exit);

        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAndRemoveTask();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        MainHomeActivity.globalCounter++;

    }

    //    onResume(), onPause(), onStop(), onRestart(), onDestroy()

    @Override
    protected void onResume() {
        super.onResume();

        MainHomeActivity.globalCounter++;


    }

    @Override
    protected void onPause() {
        super.onPause();

        MainHomeActivity.globalCounter++;
    }

    @Override
    protected void onStop() {
        super.onStop();

        MainHomeActivity.globalCounter++;
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        MainHomeActivity.globalCounter++;


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        MainHomeActivity.globalCounter++;
    }




}