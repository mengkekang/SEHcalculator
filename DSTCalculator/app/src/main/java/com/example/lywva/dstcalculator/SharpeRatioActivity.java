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
public class SharpeRatioActivity extends AppCompatActivity {

    TextView TvSharpeRatio;
    EditText EtSharpeErp, EtSharpeRf, EtSharpeSigmap;
    Button BtnSharpeCalc;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharpe_ratio);
        TvSharpeRatio = (TextView) findViewById(R.id.tv_sharpe_ratio);
        EtSharpeErp = (EditText) findViewById(R.id.et_sharpe_erp);
        EtSharpeRf = (EditText) findViewById(R.id.et_sharpe_rf);
        EtSharpeSigmap = (EditText) findViewById(R.id.et_sharpe_sigmap);
        BtnSharpeCalc = (Button) findViewById(R.id.btn_sharpe_calc);
        EtSharpeErp.setHint(Html.fromHtml("请输入E(R<sub>p</sub>):"));
        EtSharpeRf.setHint(Html.fromHtml("请输入r<sub>f</sub>"));
        EtSharpeSigmap.setHint(Html.fromHtml("请输入σ<sub>p</sub>"));
        BtnSharpeCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = EtSharpeErp.getText().toString();
                String text2 = EtSharpeRf.getText().toString();
                String text3 = EtSharpeSigmap.getText().toString();
                if(text1.equals("") || text2.equals("") || text3.equals("")){
                    Toast.makeText(SharpeRatioActivity.this, "need input", Toast.LENGTH_SHORT).show();
                }else{
                    TvSharpeRatio.setText("Sharpe ratio = " + Finance.Sharpe_ratio(text2, text1, text3));
                }
            }
        });
    }
}
