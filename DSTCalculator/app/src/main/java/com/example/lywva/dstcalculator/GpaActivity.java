package com.example.lywva.dstcalculator;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.Vector;

/**
 * Created by lywva on 2020/10/17.
 */
public class GpaActivity extends AppCompatActivity {

    TextView TvGpa;
    EditText EtGpaGrade, EtGpaCredit;
    Button BtnGpaCalc;
    int n = 0, i = 0;
    Vector<Integer> grade;
    Vector<BigDecimal> credit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa);
        n = 0;
        i = 0;
        grade = new Vector<>();
        credit = new Vector<>();
        TvGpa = (TextView) findViewById(R.id.tv_gpa);
        EtGpaGrade = (EditText) findViewById(R.id.et_gpa_grade);
        EtGpaCredit = (EditText) findViewById(R.id.et_gpa_credit);
        BtnGpaCalc = (Button) findViewById(R.id.btn_gpa_calc);
        BtnGpaCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(n == 0){
                    String text1 = EtGpaGrade.getText().toString();
                    if(text1.equals("")){
                        Toast.makeText(GpaActivity.this, "need input", Toast.LENGTH_SHORT).show();
                    }else{
                        n = Integer.parseInt(text1);
                        EtGpaGrade.setText("");
                        EtGpaCredit.setText("");
                        i++;
                        EtGpaGrade.setHint("请输入第" + String.valueOf(i) + "门学科成绩");
                        EtGpaCredit.setHint("请输入第" + String.valueOf(i) + "门学科学分");
                        if(n == 1) BtnGpaCalc.setText("计算");
                    }
                }else{
                    if(i < n-1){
                        String text1 = EtGpaGrade.getText().toString();
                        String text2 = EtGpaCredit.getText().toString();
                        if(text1.equals("") || text2.equals("")){
                            Toast.makeText(GpaActivity.this, "need input", Toast.LENGTH_SHORT).show();
                        }else{
                            grade.add(Integer.valueOf(text1));
                            credit.add(new BigDecimal(text2));
                            EtGpaGrade.setText("");
                            EtGpaCredit.setText("");
                            i++;
                            EtGpaGrade.setHint("请输入第" + String.valueOf(i) + "门学科成绩");
                            EtGpaCredit.setHint("请输入第" + String.valueOf(i) + "门学科学分");
                        }
                    }else if(i == n-1){
                        String text1 = EtGpaGrade.getText().toString();
                        String text2 = EtGpaCredit.getText().toString();
                        if(text1.equals("") || text2.equals("")){
                            Toast.makeText(GpaActivity.this, "need input", Toast.LENGTH_SHORT).show();
                        }else {
                            grade.add(Integer.valueOf(text1));
                            credit.add(new BigDecimal(text2));
                            EtGpaGrade.setText("");
                            EtGpaCredit.setText("");
                            i++;
                            EtGpaGrade.setHint("请输入第" + String.valueOf(i) + "门学科成绩");
                            EtGpaCredit.setHint("请输入第" + String.valueOf(i) + "门学科学分");
                            BtnGpaCalc.setText("计算");
                        }
                    }else if(i == n) {
                        String text1 = EtGpaGrade.getText().toString();
                        String text2 = EtGpaCredit.getText().toString();
                        if (text1.equals("") || text2.equals("")) {
                            Toast.makeText(GpaActivity.this, "need input", Toast.LENGTH_SHORT).show();
                        } else {
                            grade.add(Integer.valueOf(text1));
                            credit.add(new BigDecimal(text2));
                            EtGpaGrade.setText("");
                            EtGpaCredit.setText("");
                            TvGpa.setText("GPA = " + GPA.gpa(n, grade, credit));
                            i = 0;
                            n = 0;
                            grade.clear();
                            credit.clear();
                            EtGpaGrade.setHint("请输入科目数:");
                            EtGpaCredit.setHint("");
                            BtnGpaCalc.setText("录入");
                        }
                    }
                }
            }
        });
    }
}
