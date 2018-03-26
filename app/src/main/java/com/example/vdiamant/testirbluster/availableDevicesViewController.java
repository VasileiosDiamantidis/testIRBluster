package com.example.vdiamant.testirbluster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class availableDevicesViewController extends AppCompatActivity {

    /*
        This class handles activity_available_devices.
        Only thing it does is to transist to the device that the user choose (Air condition / TV)

    */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_devices);
        findViewById(R.id.adTVbtn).setOnClickListener(new myTmpListener());
        findViewById(R.id.airConditionImageBTN).setOnClickListener(new mySecondListener());
    }



    private void openTVController(){

    }

    private class myTmpListener implements View.OnClickListener {

        @Override
        public void onClick(final View view) {
            try {
                Intent k = new Intent(availableDevicesViewController.this, presentModels.class);
                startActivity(k);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }


    private class mySecondListener implements View.OnClickListener {

        @Override
        public void onClick(final View view) {
            try {
                Intent k = new Intent(availableDevicesViewController.this, AirConditionViewController.class);
                startActivity(k);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }


}
