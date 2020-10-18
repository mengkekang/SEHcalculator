package com.example.lywva.dstcalculator;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.Vector;

/**
 * Created by lywva on 2020/10/18.
 */
public class SoulActivity extends AppCompatActivity {

    private ListView LvSoul;
    private SoulAdapter soulAdapter;
    ImageView IvSoul1, IvSoul2, IvSoul3, IvSoul4;
    TextView TvSoul;
    BufferedReader f = null;
    BufferedReader d = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soul);
        TvSoul = (TextView) findViewById(R.id.tv_soul);
        IvSoul1 = (ImageView) findViewById(R.id.iv_soul1);
        IvSoul2 = (ImageView) findViewById(R.id.iv_soul2);
        IvSoul3 = (ImageView) findViewById(R.id.iv_soul3);
        IvSoul4 = (ImageView) findViewById(R.id.iv_soul4);
        final int[] n = {0};
        final Vector<Integer> iv = new Vector<>();
        for(int i = 0; i<4; i++) iv.add(Integer.valueOf(0));
        //导入数据
        InputStream inputStreamF = getResources().openRawResource(R.raw.dst_food);
        InputStream inputStreamD = getResources().openRawResource(R.raw.dst_dishes);
        f = new BufferedReader(new InputStreamReader(inputStreamF));
        Vector<Vector<String>> food = new Vector<Vector<String>>();
        try {
            food = getdata_food(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LvSoul = (ListView) findViewById(R.id.lv_soul);
        soulAdapter = new SoulAdapter(SoulActivity.this, food);
        LvSoul.setAdapter(soulAdapter);
        IvSoul1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(n[0] >= 0){
                    iv.remove(0);
                    n[0]--;
                    iv.add(Integer.valueOf(0));
                    setImage(iv);
                }
                TvSoul.setText("");
            }
        });
        IvSoul2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(n[0] >= 0){
                    iv.remove(1);
                    n[0]--;
                    iv.add(Integer.valueOf(0));
                    setImage(iv);
                }
                TvSoul.setText("");
            }
        });
        IvSoul3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(n[0] >= 0){
                    iv.remove(2);
                    n[0]--;
                    iv.add(Integer.valueOf(0));
                    setImage(iv);
                }
                TvSoul.setText("");
            }
        });
        IvSoul4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(n[0] >= 0){
                    iv.remove(3);
                    n[0]--;
                    iv.add(Integer.valueOf(0));
                    setImage(iv);
                }
                TvSoul.setText("");
            }
        });
        LvSoul.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(n[0] < 4){
                    iv.set(n[0], position+1);
                    setImage(iv);
                    n[0]++;
                    if(n[0] == 4){
                        try {
                            InputStream inputStreamF = getResources().openRawResource(R.raw.dst_food);
                            InputStream inputStreamD = getResources().openRawResource(R.raw.dst_dishes);
                            f = new BufferedReader(new InputStreamReader(inputStreamF));
                            d = new BufferedReader(new InputStreamReader(inputStreamD));
                            Vector<String> result = DST.cook(iv.get(0).intValue(), iv.get(1).intValue(), iv.get(2).intValue(), iv.get(3).intValue(), f, d);
                            TvSoul.setText("菜肴 = " + result.get(1) + ", 血量 " + result.get(8) + ", 饱食 " + result.get(9) + ", 精神 " + result.get(10));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public static Vector<Vector<String>> getdata_food(BufferedReader f) throws IOException {

        Vector<Vector<String>> rst = new Vector<Vector<String>>();
        String line = null;
        Log.d("main", "start");
        while((line = f.readLine()) != null) {
            Log.d("main", "one line");
            String[] food = line.split(",");
            Vector<String> e = new Vector<String>();
            for(int i=0;i<food.length;i++) {
                e.add(food[i]);
            }
            rst.add(e);
        }

        return rst;
    }

    public void setImage(Vector<Integer> iv){
        if(iv.get(0) == 0){
            IvSoul1.setImageDrawable(null);
            IvSoul1.refreshDrawableState();
            IvSoul1.setBackgroundColor(Color.GRAY);
        }else{
            Glide.with(SoulActivity.this).load(getDrawableId("food"+iv.get(0))).into(IvSoul1);
        }
        if(iv.get(1) == 0){
            IvSoul2.setImageDrawable(null);
            IvSoul2.refreshDrawableState();
            IvSoul2.setBackgroundColor(Color.GRAY);
        }else{
            Glide.with(SoulActivity.this).load(getDrawableId("food"+iv.get(1))).into(IvSoul2);
        }
        if(iv.get(2) == 0){
            IvSoul3.setImageDrawable(null);
            IvSoul3.refreshDrawableState();
            IvSoul3.setBackgroundColor(Color.GRAY);
        }else{
            Glide.with(SoulActivity.this).load(getDrawableId("food"+iv.get(2))).into(IvSoul3);
        }
        if(iv.get(3) == 0){
            IvSoul4.setImageDrawable(null);
            IvSoul4.refreshDrawableState();
            IvSoul4.setBackgroundColor(Color.GRAY);
        }else{
            Glide.with(SoulActivity.this).load(getDrawableId("food"+iv.get(3))).into(IvSoul4);
        }
    }

    public static int getDrawableId(String var) {
        try {
            Field field = R.drawable.class.getField(var);
            return field.getInt(new R.drawable());
        } catch (Exception e) {
            return 0;
        }
    }
}