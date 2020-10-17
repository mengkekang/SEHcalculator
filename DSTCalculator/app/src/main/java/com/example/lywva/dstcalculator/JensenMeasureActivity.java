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
 * Created by lywva on 2020/10/17.
 */
public class JensenMeasureActivity extends AppCompatActivity {

    TextView TvJensenRatio;
    EditText EtJensenBetap, EtJensenErm, EtJensenErp, EtJensenRf;
    Button BtnJensenCalc;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jensen_measure);
        TvJensenRatio = (TextView) findViewById(R.id.tv_jensen_measure);
        EtJensenBetap = (EditText) findViewById(R.id.et_jensen_betap);
        EtJensenErm = (EditText) findViewById(R.id.et_jensen_erm);
        EtJensenErp = (EditText) findViewById(R.id.et_jensen_erp);
        EtJensenRf = (EditText) findViewById(R.id.et_jensen_rf);
        BtnJensenCalc = (Button) findViewById(R.id.btn_jensen_calc);
        EtJensenBetap.setHint(Html.fromHtml("请输入β<sub>p</sub>:"));
        EtJensenErm.setHint(Html.fromHtml("请输入E(R<sub>m</sub>):"));
        EtJensenErp.setHint(Html.fromHtml("请输入E(R<sub>p</sub>):"));
        EtJensenRf.setHint(Html.fromHtml("请输入r<sub>f</sub>:"));
        BtnJensenCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = EtJensenBetap.getText().toString();
                String text2 = EtJensenErm.getText().toString();
                String text3 = EtJensenErp.getText().toString();
                String text4 = EtJensenRf.getText().toString();
                if(text1.equals("") || text2.equals("") || text3.equals("") || text4.equals("")){
                    Toast.makeText(JensenMeasureActivity.this, "need input", Toast.LENGTH_SHORT).show();
                }else{
                    TvJensenRatio.setText(Html.fromHtml("α<sub>p</sub> = " + Finance.Jensen_measure(text2, text3, text1, text4)));
                }
            }
        });
    }
}
