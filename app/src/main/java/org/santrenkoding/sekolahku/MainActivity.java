package org.santrenkoding.sekolahku;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    //Set waktu lama splashscreen
    private static int splashInterval = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // TODO Auto-generated method stub

                Intent i = new Intent(MainActivity.this, DataSiswaActivity.class);
                startActivity(i); // menghubungkan activity splashscren ke main activity dengan intent
                finish();

                //jeda selesai Splashscreen
//                this.finish();
            }

//            private void finish() {
//                // TODO Auto-generated method stub
//
//            }
        }, splashInterval);

    }

    ;

}

