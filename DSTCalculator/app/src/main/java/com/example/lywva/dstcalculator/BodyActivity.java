package com.example.lywva.dstcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by lywva on 2020/10/7.
 */
public class BodyActivity extends AppCompatActivity {

    Button BtnCalculator;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);
        BtnCalculator = (Button) findViewById(R.id.btn_calculator);
        BtnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(BodyActivity.this, CalculatorActivity.class);
                startActivity(intent);
            }
        });
    }
}
