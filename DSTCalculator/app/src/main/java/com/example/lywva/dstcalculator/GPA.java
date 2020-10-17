package com.example.lywva.dstcalculator;

/**
 * Created by lywva on 2020/10/17.
 */
import java.math.BigDecimal;
import java.util.Vector;

public class GPA {

    public static String gpa(int n, Vector<Integer> grade, Vector<BigDecimal> credit) {
        Vector<BigDecimal> p = new Vector<BigDecimal>();
        for(int i=0;i<n;i++) {
            p.add(point(grade.elementAt(i)));
        }
        BigDecimal S = new BigDecimal("0.0");
        for(int i=0;i<n;i++) {
            S = S.add(credit.elementAt(i));
        }

        BigDecimal r = new BigDecimal(0);
        BigDecimal c =  new BigDecimal(0);
        for(int i=0;i<n;i++) {
            c = credit.elementAt(i);
            c = c.divide(S, 2, BigDecimal.ROUND_HALF_DOWN);
            r = r.add(c.multiply(p.elementAt(i)));
        }

        return r.toString();
    }

    public static BigDecimal point(int grade) {

        if(grade < 60)
            return new BigDecimal("0.0");
        else if(grade == 60)
            return new BigDecimal("1.0");
        else if(grade <= 63)
            return new BigDecimal("1.3");
        else if(grade <= 67)
            return new BigDecimal("1.5");
        else if(grade <= 71)
            return new BigDecimal("2.0");
        else if(grade <= 74)
            return new BigDecimal("2.3");
        else if(grade <= 77)
            return new BigDecimal("2.7");
        else if(grade <= 81)
            return new BigDecimal("3.0");
        else if(grade <= 84)
            return new BigDecimal("3.3");
        else if(grade <= 89)
            return new BigDecimal("3.7");
        else
            return new BigDecimal("4.0");
    }

    /*public static void main(String[] args) {
        Vector<Integer> t = new Vector<Integer>();
        t.add(85);t.add(73);t.add(91);
        Vector<BigDecimal> m = new Vector<BigDecimal>();
        m.add(new BigDecimal(1.0));m.add(new BigDecimal(0.5));m.add(new BigDecimal(4.0));

        String rst = gpa(3,t,m);
        System.out.println(rst);
    }*/

}
