package com.example.lywva.dstcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by lywva on 2020/10/17.
 */
public class FinExpActivity extends AppCompatActivity {

    Button BtnSharpe, BtnTreynor, BtnInfo, BtnJen;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finexp);
        BtnSharpe = (Button) findViewById(R.id.btn_sharpe_ratio);
        BtnTreynor = (Button) findViewById(R.id.btn_treynor_ratio);
        BtnInfo = (Button) findViewById(R.id.btn_information_ratio);
        BtnJen = (Button) findViewById(R.id.btn_jensen_measure);
        BtnSharpe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(FinExpActivity.this, SharpeRatioActivity.class);
                startActivity(intent);
            }
        });
        BtnTreynor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(FinExpActivity.this, TreynorRatioActivity.class);
                startActivity(intent);
            }
        });
        BtnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(FinExpActivity.this, InformationRatioActivity.class);
                startActivity(intent);
            }
        });
        BtnJen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(FinExpActivity.this, JensenMeasureActivity.class);
                startActivity(intent);
            }
        });
    }
}
