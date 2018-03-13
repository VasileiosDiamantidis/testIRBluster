package com.example.vdiamant.testirbluster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Arrays;

public class availableDevices extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_devices);
        findViewById(R.id.adTVbtn).setOnClickListener(new myListener());
    }



    private void openTVController(){

    }

    private class myListener implements View.OnClickListener {



        @Override
        public void onClick(final View view) {
            try {
                Intent k = new Intent(availableDevices.this, MainActivity.class);
                startActivity(k);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }


}
