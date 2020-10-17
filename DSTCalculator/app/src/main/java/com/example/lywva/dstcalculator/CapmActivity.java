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

/**
 * Created by lywva on 2020/10/16.
 */
public class CapmActivity extends AppCompatActivity {

    TextView TvCapm, TvCapmRf, TvCapmBeta, TvCapmRm;
    EditText EtCapmRf, EtCapmBeta, EtCapmRm;
    Button BtnCapmCalc;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capm);
        TvCapm = (TextView) findViewById(R.id.tv_capm);
        TvCapmRf = (TextView) findViewById(R.id.tv_capm_rf);
        TvCapmBeta = (TextView) findViewById(R.id.tv_capm_beta);
        TvCapmRm = (TextView) findViewById(R.id.tv_capm_rm);
        EtCapmRf = (EditText) findViewById(R.id.et_capm_rf);
        EtCapmBeta = (EditText) findViewById(R.id.et_capm_beta);
        EtCapmRm = (EditText) findViewById(R.id.et_capm_rm);
        BtnCapmCalc = (Button) findViewById(R.id.btn_capm_calc);
        TvCapmRf.setText(Html.fromHtml("r<sub>f</sub>:"));
        TvCapmBeta.setText("β:");
        TvCapmRm.setText(Html.fromHtml("R<sub>m</sub>:"));
        BtnCapmCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String r_f = EtCapmRf.getText().toString();
                String R_m = EtCapmRm.getText().toString();
                String beta = EtCapmBeta.getText().toString();
                if(r_f.equals("") || R_m.equals("") || beta.equals("")) {
                    Toast.makeText(CapmActivity.this, "need input", Toast.LENGTH_SHORT).show();
                }else {
                    TvCapm.setText(Html.fromHtml("R<sub>i</sub>")+" = "+Finance.CAPM(r_f, R_m, beta));
                }
            }
        });
    }
}
