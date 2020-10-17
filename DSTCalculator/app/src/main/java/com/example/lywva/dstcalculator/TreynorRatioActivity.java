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
public class TreynorRatioActivity extends AppCompatActivity {

    TextView TvTreynorRatio;
    EditText EtTreynorErp, EtTreynorRf, EtTreynorBetap;
    Button BtnTreynorCalc;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treynor_ratio);
        TvTreynorRatio = (TextView) findViewById(R.id.tv_treynor_ratio);
        EtTreynorErp = (EditText) findViewById(R.id.et_treynor_erp);
        EtTreynorRf = (EditText) findViewById(R.id.et_treynor_rf);
        EtTreynorBetap = (EditText) findViewById(R.id.et_treynor_betap);
        BtnTreynorCalc = (Button) findViewById(R.id.btn_treynor_calc);
        EtTreynorErp.setHint(Html.fromHtml("请输入E(R<sub>p</sub>):"));
        EtTreynorRf.setHint(Html.fromHtml("请输入r<sub>f</sub>"));
        EtTreynorBetap.setHint(Html.fromHtml("请输入β<sub>p</sub>"));
        BtnTreynorCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = EtTreynorErp.getText().toString();
                String text2 = EtTreynorRf.getText().toString();
                String text3 = EtTreynorBetap.getText().toString();
                if (text1.equals("") || text2.equals("") || text3.equals("")) {
                    Toast.makeText(TreynorRatioActivity.this, "need input", Toast.LENGTH_SHORT).show();
                } else {
                    TvTreynorRatio.setText("Treynor ratio = " + Finance.Treynor_ratio(text2, text1, text3));
                }
            }
        });
    }
}
