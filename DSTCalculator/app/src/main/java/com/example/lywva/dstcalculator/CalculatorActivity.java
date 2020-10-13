package com.example.lywva.dstcalculator;

import android.nfc.Tag;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Vector;

import com.example.lywva.dstcalculator.Simple;

import static com.example.lywva.dstcalculator.R.id.btn_5;
import static com.example.lywva.dstcalculator.R.id.btn_8;

/**
 * Created by lywva on 2020/10/7.
 */
public class CalculatorActivity extends AppCompatActivity {

    Button BtnPow, BtnSqr, BtnSin, BtnCos, BtnBack, BtnLeftBrac, BtnRightBrac, BtnPlus, Btn1, Btn2, Btn3, BtnMinus, Btn4, Btn5, Btn6, BtnMult, Btn7, Btn8, Btn9, BtnDiv, BtnZeroZero, Btn0, BtnDot, BtnEqual;
    TextView TvCalculator;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        BtnPow = (Button) findViewById(R.id.btn_pow);
        BtnSqr = (Button) findViewById(R.id.btn_sqr);
        BtnSin = (Button) findViewById(R.id.btn_sin);
        BtnCos = (Button) findViewById(R.id.btn_cos);
        BtnBack = (Button) findViewById(R.id.btn_back);
        BtnLeftBrac = (Button) findViewById(R.id.btn_leftbrac);
        BtnRightBrac = (Button) findViewById(R.id.btn_rightbrac);
        BtnPlus = (Button) findViewById(R.id.btn_plus);
        Btn1 = (Button) findViewById(R.id.btn_1);
        Btn2 = (Button) findViewById(R.id.btn_2);
        Btn3 = (Button) findViewById(R.id.btn_3);
        BtnMinus = (Button) findViewById(R.id.btn_minus);
        Btn4 = (Button) findViewById(R.id.btn_4);
        Btn5 = (Button) findViewById(R.id.btn_5);
        Btn6 = (Button) findViewById(R.id.btn_6);
        BtnMult = (Button) findViewById(R.id.btn_mult);
        Btn7 = (Button) findViewById(R.id.btn_7);
        Btn8 = (Button) findViewById(R.id.btn_8);
        Btn9 = (Button) findViewById(R.id.btn_9);
        BtnDiv = (Button) findViewById(R.id.btn_div);
        BtnZeroZero = (Button) findViewById(R.id.btn_zerozero);
        Btn0 = (Button) findViewById(R.id.btn_0);
        BtnDot = (Button) findViewById(R.id.btn_dot);
        BtnEqual = (Button) findViewById(R.id.btn_equal);
        TvCalculator = (TextView) findViewById(R.id.tv_calculator);

        final StringBuffer result = new StringBuffer();
        final StringBuffer temp = new StringBuffer();

        BtnPow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("^(");
                temp.append("m(");
                if(result.length() > 10){
                    TvCalculator.setText(result.getChars(););
                }
                TvCalculator.setText(result);
            }
        });
        BtnSqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("√(");
                temp.append("q(");
                TvCalculator.setText(result);
            }
        });
        BtnSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("sin(");
                temp.append("s(");
                TvCalculator.setText(result);
            }
        });
        BtnCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("cos(");
                temp.append("c(");
                TvCalculator.setText(result);
            }
        });
        BtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(temp.length() != 1 && temp.length() != 0)
                {
                    if(temp.charAt(temp.length()-1) == 's' || temp.charAt(temp.length()-1) == 'c')
                    {
                        result.delete(result.length()-3, result.length());
                    }else {
                        result.deleteCharAt(result.length() - 1);
                        temp.deleteCharAt(temp.length() - 1);
                    }
                }else if(temp.length() == 1)
                {
                    result.delete(0, result.length());
                    temp.delete(0, temp.length());
                }
                TvCalculator.setText(result);
            }
        });
        BtnLeftBrac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("(");
                temp.append("(");
                TvCalculator.setText(result);
            }
        });
        BtnRightBrac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append(")");
                temp.append(")");
                TvCalculator.setText(result);
            }
        });
        BtnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("+");
                temp.append("+");
                TvCalculator.setText(result);
            }
        });
        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("1");
                temp.append("1");
                TvCalculator.setText(result);
            }
        });
        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("2");
                temp.append("2");
                TvCalculator.setText(result);
            }
        });
        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("3");
                temp.append("3");
                TvCalculator.setText(result);
            }
        });
        BtnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("-");
                temp.append("-");
                TvCalculator.setText(result);
            }
        });
        Btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("4");
                temp.append("4");
                TvCalculator.setText(result);
            }
        });
        Btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("5");
                temp.append("5");
                TvCalculator.setText(result);
            }
        });
        Btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("6");
                temp.append("6");
                TvCalculator.setText(result);
            }
        });
        BtnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("×");
                temp.append("*");
                TvCalculator.setText(result);
            }
        });
        Btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("7");
                temp.append("7");
                TvCalculator.setText(result);
            }
        });
        Btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("8");
                temp.append("8");
                TvCalculator.setText(result);
            }
        });
        Btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("9");
                temp.append("9");
                TvCalculator.setText(result);
            }
        });
        BtnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("÷");
                temp.append("/");
                TvCalculator.setText(result);
            }
        });
        BtnZeroZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("π");
                temp.append("p");
                TvCalculator.setText(result);
            }
        });
        Btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("0");
                temp.append("0");
                TvCalculator.setText(result);
            }
        });
        BtnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append(".");
                temp.append(".");
                TvCalculator.setText(result);
            }
        });
        BtnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vector<String> expression = new Vector<String>();
                StringBuffer buf = new StringBuffer();
                for(int i = 0; i < temp.length(); i++)
                {
                    if(buf.length() != 0 && (temp.charAt(i) == 'm' || temp.charAt(i) == 'q' || temp.charAt(i) == 's' || temp.charAt(i) == 'c' || temp.charAt(i) == '(' || temp.charAt(i) == ')' || temp.charAt(i) == '+' || temp.charAt(i) == '-' || temp.charAt(i) == '*' || temp.charAt(i) == '/' || temp.charAt(i) == 'p'))
                    {
                        expression.add(buf.toString());
                        buf.delete(0, buf.length());
                        expression.add(String.valueOf(temp.charAt(i)));
                    }else if(buf.length() == 0 && (temp.charAt(i) == 'm' || temp.charAt(i) == 'q' || temp.charAt(i) == 's' || temp.charAt(i) == 'c' || temp.charAt(i) == '(' || temp.charAt(i) == ')' || temp.charAt(i) == '+' || temp.charAt(i) == '-' || temp.charAt(i) == '*' || temp.charAt(i) == '/' || temp.charAt(i) == 'p')){
                        expression.add(String.valueOf(temp.charAt(i)));
                    }else{
                        buf.append(temp.charAt(i));
                    }
                }
                if(buf.length() != 0) expression.add(buf.toString());
                if(result.length() != 0) result.delete(0, result.length());
                final String TAG = "MainActivity";
                Log.d(TAG, expression.toString());
                result.append(Simple.calculate(expression));
                TvCalculator.setText(result);
                result.delete(0, result.length());
                temp.delete(0, temp.length());
            }
        });
    }
}
