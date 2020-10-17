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
public class InformationRatioActivity extends AppCompatActivity {

    TextView TvInformationRatio;
    EditText EtInformationErp, EtInformationErb, EtInformationsigmarpmrb;
    Button BtnInformationCalc;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_ratio);
        TvInformationRatio = (TextView) findViewById(R.id.tv_information_ratio);
        EtInformationErp = (EditText) findViewById(R.id.et_information_erp);
        EtInformationErb = (EditText) findViewById(R.id.et_information_erb);
        EtInformationsigmarpmrb = (EditText) findViewById(R.id.et_information_sigmarpmrb);
        BtnInformationCalc = (Button) findViewById(R.id.btn_information_calc);
        EtInformationErp.setHint(Html.fromHtml("请输入E(R<sub>p</sub>):"));
        EtInformationErb.setHint(Html.fromHtml("请输入E(R<sub>B</sub>):"));
        EtInformationsigmarpmrb.setHint(Html.fromHtml("请输入σ(R<sub>p</sub>-R<sub>B</sub>):"));
        BtnInformationCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = EtInformationErp.getText().toString();
                String text2 = EtInformationErb.getText().toString();
                String text3 = EtInformationsigmarpmrb.getText().toString();
                if (text1.equals("") || text2.equals("") || text3.equals("")) {
                    Toast.makeText(InformationRatioActivity.this, "need input", Toast.LENGTH_SHORT).show();
                } else {
                    TvInformationRatio.setText("Information ratio = " + Finance.Treynor_ratio(text2, text1, text3));
                }
            }
        });
    }
}
