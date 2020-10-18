package com.example.lywva.dstcalculator;

/**
 * Created by lywva on 2020/10/17.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Vector;

public class DST {

    public static Vector<String> cook(int f1, int f2, int f3, int f4, BufferedReader f, BufferedReader d)  throws IOException {

        Vector<Vector<String>> food = new Vector<Vector<String>>();
        Vector<Vector<String>> dishes = new Vector<Vector<String>>();

        food = getdata_food(f);
        dishes = getdata_dishes(d);

        //一些特殊的菜可以直接判断
        if(f1 == 30 || f2 == 30 || f3 == 30 || f4 == 30) {
            return dishes.elementAt(0);
        }
        if((f1 == 31 && f2 == 31 && f3 == 31) || (f1 == 31 && f2 == 31 && f4 == 31)
                || (f1 == 31 && f4 == 31 && f3 == 31) ||(f4 == 31 && f2 == 31 && f3 == 31)) {
            return dishes.elementAt(3);
        }
        //计算输入食材的数值
        Vector<Double> nums = new Vector<Double>();
        for(int i=0;i<6;i++) {
            double n = 0.0, n1 = 0.0, n2 = 0.0, n3 = 0.0, n4 = 0.0;
            n1 = Double.valueOf(food.elementAt(f1-1).elementAt(i+2));//食材1的第i个属性值
            n2 = Double.valueOf(food.elementAt(f2-1).elementAt(i+2));//食材2的第i个属性值
            n3 = Double.valueOf(food.elementAt(f3-1).elementAt(i+2));//食材3的第i个属性值
            n4 = Double.valueOf(food.elementAt(f4-1).elementAt(i+2));//食材4的第i个属性值
            n = n1 + n2 + n3 + n4;//输入食材的第i项属性值
            nums.add(n);
        }

        int len = dishes.size();
        Vector<Integer> ranks = new Vector<Integer>();

        //如果存在树枝，去除禁树枝的菜
        if(f1 == 29 || f2 == 29 || f3 == 29 || f4 == 29) {
            ranks.add(22);ranks.add(18);ranks.add(2);ranks.add(19);ranks.add(20);ranks.add(13);ranks.add(14);
            ranks.add(11);ranks.add(2);
        }
        //如果肉度大于0，去除禁肉的菜
        if(nums.elementAt(0) > 0.0) {
            ranks.add(15);
            if(!ranks.contains(19)) ranks.add(19);
            if(!ranks.contains(20)) ranks.add(20);ranks.add(4);ranks.add(21);
            if(!ranks.contains(10)) ranks.add(2);
        }
        //如果菜度大于0，去除禁菜的菜
        if(nums.elementAt(2) > 0.0) {
            if(!ranks.contains(19)) ranks.add(19);
            if(!ranks.contains(21))ranks.add(21);ranks.add(3);
        }
        //如果果度大于0，去除禁果的菜
        if(nums.elementAt(3) > 0.0) {
            if(!ranks.contains(2)) ranks.add(2);
        }

        for(int i=0;i<len;i++) {
            double n1 = 0.0, n2 = 0.0, n3 = 0.0, n4 = 0.0, n5 =0.0;
            n1 = Double.valueOf(dishes.elementAt(i).elementAt(2));//第i道菜的肉度需求
            n2 = Double.valueOf(dishes.elementAt(i).elementAt(3));//第i道菜的蛋度需求
            n3 = Double.valueOf(dishes.elementAt(i).elementAt(4));//第i道菜的菜度需求
            n4 = Double.valueOf(dishes.elementAt(i).elementAt(5));//第i道菜的果度需求
            n5 = Double.valueOf(dishes.elementAt(i).elementAt(6));//第i道菜的鱼度需求
            //判断输入食材是否满足这道菜的要求
            if(n1 > nums.elementAt(0) || n2 > nums.elementAt(1) || n3 > nums.elementAt(2) || n4 > nums.elementAt(3) || n5 > nums.elementAt(4)) {
                //如果不满足，记录菜的顺序
                if(!ranks.contains(i+1)) ranks.add(i+1);
            }
            //对一些有着特殊要求的菜进行处理
            int req = Integer.valueOf(dishes.elementAt(i).elementAt(7));
            if(req != 0) {
                if(f1 != req && f2!= req && f3!= req && f4!= req) {
                    if(!ranks.contains(i+1)) ranks.add(i+1);
                }
                else if(req == 2) {
                    int times = 0;
                    if(f1 == 2) times++;
                    if(f2 == 2) times++;
                    if(f3 == 2) times++;
                    if(f4 == 2) times++;
                    if(times < 2) if(!ranks.contains(i+1)) ranks.add(i+1);
                }
                else if(req == 29) {
                    int times = 0;
                    if(f1 == 29) times++;
                    if(f2 == 29) times++;
                    if(f3 == 29) times++;
                    if(f4 == 29) times++;
                    if(times >= 2 && (i == 11 || i == 5)) if(!ranks.contains(i+1)) ranks.add(i+1);
                }
            }
        }

        //对怪物度>=2的情况进行处理
        int mon = 0;
        if(f1 == 7 || f1 == 25) mon++;
        if(f2 == 7 || f2 == 25) mon++;
        if(f3 == 7 || f3 == 25) mon++;
        if(f4 == 7 || f4 == 25) mon++;
        if(mon >= 2) {
            for(int i=11;i<23;i++) {
                if(!ranks.contains(i)) ranks.add(i);
            }
        }else if(!ranks.contains(10)) ranks.add(10);

        //剔除不符合要求的菜
        Vector<Vector<String>> dishes_last = new Vector<Vector<String>>();
        for(int i=0;i<len;i++) {

            Vector<String> dish = new Vector<String>();
            dish = dishes.elementAt(i);
            if(!ranks.contains(i+1)) {
                dishes_last.add(dish);
            }

        }

        return dishes_last.elementAt(0);
    }

    public static Vector<Vector<String>> getdata_food(BufferedReader f) throws IOException {

        Vector<Vector<String>> rst = new Vector<Vector<String>>();
        String line = null;

        while((line = f.readLine()) != null) {
            String[] food = line.split(",");
            Vector<String> e = new Vector<String>();
            for(int i=0;i<food.length;i++) {
                e.add(food[i]);
            }
            rst.add(e);
        }

        return rst;
    }

    public static Vector<Vector<String>> getdata_dishes(BufferedReader d) throws IOException {

        Vector<Vector<String>> rst = new Vector<Vector<String>>();
        String line = null;

        while((line = d.readLine()) != null) {
            String[] dishes = line.split(",");
            Vector<String> e = new Vector<String>();
            for(int i=0;i<dishes.length;i++) {
                e.add(dishes[i]);
            }
            rst.add(e);
        }

        return rst;
    }

}