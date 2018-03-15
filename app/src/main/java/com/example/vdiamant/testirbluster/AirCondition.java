package com.example.vdiamant.testirbluster;

import android.hardware.ConsumerIrManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Model.CAirCondition;

public class AirCondition extends AppCompatActivity {

    /*
        This is the class that handles activity_air_condition.
        The codes are for Carrier Air condition and they don't work at company
    */


    //These commands are from the site https://irdb.globalcache.com/Home/Database
    //They are for Carrier Air Condtitions

    String cmdPowerON = "0000 006D 0022 0002 0155 00AB 0016 0015 0016 0015 0016 0015 0016 0015 0016 0040 0016 0015 0016 0040 0016 0015 0016 0040 0016 0040 0016 0040 0016 0040 0016 0015 0016 0040 0016 0015 0016 0040 0016 0015 0016 0040 0016 0040 0016 0040 0016 0040 0016 0040 0016 0015 0016 0015 0016 0040 0016 0015 0016 0015 0016 0015 0016 0015 0016 0015 0016 0040 0016 0040 0016 05D5 0155 0055 0016 0E55";
    String cmdPowerOFF = "0000 006D 0022 0002 0155 00AB 0016 0015 0016 0015 0016 0015 0016 0015 0016 0040 0016 0015 0016 0040 0016 0015 0016 0040 0016 0040 0016 0040 0016 0040 0016 0015 0016 0040 0016 0015 0016 0040 0016 0040 0016 0040 0016 0040 0016 0040 0016 0040 0016 0040 0016 0015 0016 0015 0016 0015 0016 0015 0016 0015 0016 0015 0016 0015 0016 0015 0016 0040 0016 0040 0016 05D5 0155 0055 0016 0E55";
    ConsumerIrManager irManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_condition);
        irManager =  (ConsumerIrManager) getSystemService(CONSUMER_IR_SERVICE);
        findViewById(R.id.btnAirConditionPower).setOnClickListener(new ClickListener(hex2ir(cmdPowerON)));
        findViewById(R.id.powerOffAirCondition).setOnClickListener(new ClickListener(hex2ir(cmdPowerOFF)));
    }







    private class ClickListener implements View.OnClickListener {
        private final AirCondition.IRCommand cmd;

        public ClickListener(final AirCondition.IRCommand cmd) {
            this.cmd = cmd;
        }


        @Override
        public void onClick(final View view) {
            android.util.Log.d("Remote", "frequency: " + cmd.freq);
            android.util.Log.d("Remote", "pattern: " + Arrays.toString(cmd.pattern));
            irManager.transmit(cmd.freq, cmd.pattern);
        }
    }


    private AirCondition.IRCommand hex2ir(final String irData) {
        List<String> list = new ArrayList<String>(Arrays.asList(irData.split(" ")));
        list.remove(0); // dummy
        int frequency = Integer.parseInt(list.remove(0), 16); // frequency
        list.remove(0); // seq1
        list.remove(0); // seq2

        frequency = (int) (1000000 / (frequency * 0.241246));
        int pulses = 1000000 / frequency;
        int count;

        int[] pattern = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            count = Integer.parseInt(list.get(i), 16);
            pattern[i] = count * pulses;
        }

        return new AirCondition.IRCommand(frequency, pattern);
    }


    private class IRCommand {
        private final int freq;
        private final int[] pattern;

        private IRCommand(int freq, int[] pattern) {
            this.freq = freq;
            this.pattern = pattern;
        }
    }

}
