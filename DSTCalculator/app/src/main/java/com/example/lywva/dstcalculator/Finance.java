package com.example.lywva.dstcalculator;

/**
 * Created by lywva on 2020/10/16.
 */
import java.math.BigDecimal;
import java.util.Vector;

public class Finance {
    public static String CAPM(String r_f, String R_m, String beta) {

        BigDecimal rf = new BigDecimal(r_f);
        BigDecimal Rm = new BigDecimal(R_m);
        BigDecimal b = new BigDecimal(beta);

        String rst;
        rst = (rf.add((b.multiply((Rm.subtract(rf))))).toString());
        return rst;
    }

    public static String APT(String r_f, int n, Vector<String> beta, Vector<String> R_i) {

        BigDecimal rf = new BigDecimal(r_f);
        Vector<BigDecimal> b = new Vector<BigDecimal>();
        Vector<BigDecimal> R = new Vector<BigDecimal>();
        for(int i=0;i<n;i++) {
            b.add(new BigDecimal(beta.elementAt(i)));
            R.add(new BigDecimal(R_i.elementAt(i)));
        }

        BigDecimal e = new BigDecimal("0.0");
        BigDecimal rst = rf;
        for(int i=0;i<n;i++) {
            BigDecimal bi = b.elementAt(i);
            BigDecimal ri = R.elementAt(i);
            e = bi.multiply(ri.subtract(rf));
            rst = rst.add(e);
        }

        return rst.toString();
    }

    public static String Sharpe_ratio(String r_f, String R_p, String v_p) {

        BigDecimal rf = new BigDecimal(r_f);
        BigDecimal Rp = new BigDecimal(R_p);
        BigDecimal v = new BigDecimal(v_p);

        String rst;
        rst = (((Rp.subtract(rf)).divide(v)).toString());
        return rst;
    }

    public static String Treynor_ratio(String r_f, String R_p, String beta_p) {

        BigDecimal rf = new BigDecimal(r_f);
        BigDecimal Rp = new BigDecimal(R_p);
        BigDecimal bp = new BigDecimal(beta_p);

        String rst;
        rst = (((Rp.subtract(rf)).divide(bp)).toString());
        return rst;
    }

    public static String Information_ratio(String R_B, String R_p, String v_bp) {

        BigDecimal RB = new BigDecimal(R_B);
        BigDecimal Rp = new BigDecimal(R_p);
        BigDecimal v = new BigDecimal(v_bp);

        String rst;
        rst = (((Rp.subtract(RB)).divide(v)).toString());
        return rst;
    }

    public static String Jensen_measure(String R_m, String R_p, String beta_p, String r_f) {

        BigDecimal rf = new BigDecimal(r_f);
        BigDecimal Rm = new BigDecimal(R_m);
        BigDecimal b = new BigDecimal(beta_p);
        BigDecimal Rp = new BigDecimal(R_p);

        String rst;
        rst = ((Rp.subtract(rf.add((b.multiply((Rm.subtract(rf))))))).toString());
        return rst;
    }

    public static void main(String[] args) {

        System.out.println(CAPM("0.05", "0.1", "0.8"));
        System.out.println(Sharpe_ratio("0.05", "0.05", "0.05"));
        Vector<String> t1 = new Vector<String>();
        Vector<String> t2 = new Vector<String>();
        t1.add("0.8");t1.add("0.5");
        t2.add("0.1");t2.add("0.06");
        System.out.println(APT("0.05", 2, t1, t2));

    }
}
