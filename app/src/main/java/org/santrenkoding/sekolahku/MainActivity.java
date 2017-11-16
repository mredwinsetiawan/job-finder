package org.santrenkoding.sekolahku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //tindakan jika menu Data siswa yang diklik
    public void searchPoint(View view) {
        Intent linktoPoint = new Intent(MainActivity.this,
                DataSiswaActivity.class);
        startActivity(linktoPoint);
    }
}
