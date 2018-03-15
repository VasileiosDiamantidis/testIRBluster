package com.example.vdiamant.testirbluster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class selectCompany extends AppCompatActivity {

    /**                            **
    *not in use.. it will be deleted*
    * *                            **/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_company);
        findViewById(R.id.btnSamsung).setOnClickListener(new myOpenMainActivityListener());
    }


    private class myOpenMainActivityListener implements View.OnClickListener {



        @Override
        public void onClick(final View view) {
            try {
                Intent k = new Intent(selectCompany.this, MainActivity.class);
                startActivity(k);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
