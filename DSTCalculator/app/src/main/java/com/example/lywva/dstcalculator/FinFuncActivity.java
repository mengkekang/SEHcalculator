package com.example.lywva.dstcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by lywva on 2020/10/16.
 */
public class FinFuncActivity extends AppCompatActivity {

    Button BtnCapm, BtnApt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finfunc);
        BtnCapm = (Button) findViewById(R.id.btn_capm);
        BtnCapm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(FinFuncActivity.this, CapmActivity.class);
                startActivity(intent);
            }
        });
        BtnApt = (Button) findViewById(R.id.btn_apt);
        BtnApt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(FinFuncActivity.this, AptActivity.class);
                startActivity(intent);
            }
        });
    }
}
