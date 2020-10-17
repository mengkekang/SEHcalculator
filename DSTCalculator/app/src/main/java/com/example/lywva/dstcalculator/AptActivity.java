package com.example.lywva.dstcalculator;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Vector;

/**
 * Created by lywva on 2020/10/17.
 */
public class AptActivity extends AppCompatActivity {

    TextView TvApt;
    EditText EtApt1, EtApt2;
    Button BtnAptCalc;
    int n = 0, i = 0;
    String r_f = "";
    java.util.Vector<String> beta, R_i;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apt);
        n = 0;
        i = 0;
        r_f = "";
        beta = new Vector<String>();
        R_i = new Vector<String>();
        TvApt = (TextView) findViewById(R.id.tv_apt);
        EtApt1 = (EditText) findViewById(R.id.et_apt1);
        EtApt2 = (EditText) findViewById(R.id.et_apt2);
        BtnAptCalc = (Button) findViewById(R.id.btn_apt_calc);
        EtApt2.setHint(Html.fromHtml("请输入r<sub>f</sub>:"));
        BtnAptCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(n == 0){
                    String text1 = EtApt1.getText().toString();
                    String text2 = EtApt2.getText().toString();
                    if(text1.equals("") || text2.equals("")){
                        Toast.makeText(AptActivity.this, "need input", Toast.LENGTH_SHORT).show();
                    }else{
                        n = Integer.parseInt(text1);
                        r_f = text2;
                        EtApt1.setText("");
                        EtApt2.setText("");
                        i++;
                        EtApt1.setHint(Html.fromHtml("请输入β<sub>"+String.valueOf(i)+"</sub>:"));
                        EtApt2.setHint(Html.fromHtml("请输入r<sub>"+String.valueOf(i)+"</sub>:"));
                        if(n == 1) BtnAptCalc.setText("计算");
                    }
                }else{
                    if(i < n-1){
                        String text1 = EtApt1.getText().toString();
                        String text2 = EtApt2.getText().toString();
                        if(text1.equals("") || text2.equals("")){
                            Toast.makeText(AptActivity.this, "need input", Toast.LENGTH_SHORT).show();
                        }else{
                            beta.add(text1);
                            R_i.add(text2);
                            EtApt1.setText("");
                            EtApt2.setText("");
                            i++;
                            EtApt1.setHint(Html.fromHtml("请输入β<sub>" + String.valueOf(i) + "</sub>:"));
                            EtApt2.setHint(Html.fromHtml("请输入r<sub>"+String.valueOf(i)+"</sub>:"));
                        }
                    }else if(i == n-1){
                        String text1 = EtApt1.getText().toString();
                        String text2 = EtApt2.getText().toString();
                        if(text1.equals("") || text2.equals("")){
                            Toast.makeText(AptActivity.this, "need input", Toast.LENGTH_SHORT).show();
                        }else{
                            beta.add(text1);
                            R_i.add(text2);
                            EtApt1.setText("");
                            EtApt2.setText("");
                            i++;
                            EtApt1.setHint(Html.fromHtml("请输入β<sub>" + String.valueOf(i) + "</sub>:"));
                            EtApt2.setHint(Html.fromHtml("请输入r<sub>"+String.valueOf(i)+"</sub>:"));
                            BtnAptCalc.setText("计算");
                        }
                    }else if(i == n){
                        String text1 = EtApt1.getText().toString();
                        String text2 = EtApt2.getText().toString();
                        if(text1.equals("") || text2.equals("")){
                            Toast.makeText(AptActivity.this, "need input", Toast.LENGTH_SHORT).show();
                        }else{
                            beta.add(text1);
                            R_i.add(text2);
                            EtApt1.setText("");
                            EtApt2.setText("");
                            TvApt.setText("R = " + Finance.APT(r_f, n, beta, R_i));
                            n = 0;
                            i = 0;
                            r_f = "";
                            beta.clear();
                            R_i.clear();
                            EtApt1.setHint("请输入n:");
                            EtApt2.setHint(Html.fromHtml("请输入r<sub>f</sub>:"));
                            BtnAptCalc.setText("录入");
                        }
                    }
                }
            }
        });
    }
}
