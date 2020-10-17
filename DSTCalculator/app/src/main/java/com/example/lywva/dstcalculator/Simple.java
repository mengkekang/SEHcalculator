package com.example.lywva.dstcalculator;

/**
 * Created by lywva on 2020/10/12.
 */
import java.util.Stack;
import java.util.Vector;

public class Simple {
    public static String calculate(Vector<String> expression) {
        Stack<Double> numStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        for (int i = 0; i < expression.size(); i++) {
            if (expression.get(i).charAt(0) == '+' || expression.get(i).charAt(0) == '-') {
                while (!operatorStack.empty() && (operatorStack.peek() + "").matches("\\+{0,1}-{0,1}\\*{0,1}/{0,1}c{0,1}s{0,1}t{0,1}l{0,1}q{0,1}m{0,1}"))
                    operate(numStack, operatorStack);

                operatorStack.push(expression.get(i).charAt(0));
            }
            else if (expression.get(i).charAt(0) == '*' || expression.get(i).charAt(0) == '/') {
                while (!operatorStack.empty() && (operatorStack.peek() + "").matches("\\*{0,1}/{0,1}c{0,1}s{0,1}l{0,1}q{0,1}m{0,1}"))
                    operate(numStack, operatorStack);

                operatorStack.push(expression.get(i).charAt(0));
            }
            else if(expression.get(i).charAt(0) == 'm') {
                while(!operatorStack.empty() && (operatorStack.peek() == 'm'))
                    operate(numStack, operatorStack);

                operatorStack.push(expression.get(i).charAt(0));
            }
            else if(expression.get(i).matches("c{0,1}s{0,1}l{0,1}q{0,1}")) {
                operatorStack.push(expression.get(i).charAt(0));
            }
            else if (expression.get(i).charAt(0) == '(')
                operatorStack.push(expression.get(i).charAt(0));
            else if (expression.get(i).charAt(0) == ')') {
                while (operatorStack.peek() != '(')
                    operate(numStack, operatorStack);

                operatorStack.pop();
            }
            else {
                if (expression.get(i).charAt(0) == 'p')
                    numStack.push(Math.PI);
                else numStack.push(Double.valueOf(expression.get(i)));
            }
        }

        while (!operatorStack.empty())

            operate(numStack, operatorStack);

        double rst ;
        rst = numStack.pop();
        if(rst >= 1.2E16) return String.valueOf((1.0/0.0));
        double ze = Math.cos(Math.PI/2);
        if(rst == ze) {
            rst = 0;
        }
        rst = rst * 1000000.0;
        rst = Math.round(rst);
        rst = rst / 1000000.0;
        String r = String.valueOf(rst);

        if (r.length() >= 9){
            return  r.substring(0, 8);
        }
        return  r;
    }

    public static void operate(Stack<Double> numStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        double op1 = 0, op2 = 0;
        if(op == '+' || op == '-' || op == '*' || op == '/' || op == 'm' ) {
            op1 = numStack.pop();
            op2 = numStack.pop();
        }
        else if((op + "").matches("c{0,1}s{0,1}l{0,1}q{0,1}")) {
            op1 = numStack.pop();
        }

        if (op == '+')
            numStack.push(op2 + op1);
        else if (op == '-')
            numStack.push(op2 - op1);
        else if (op == '/') {
            if(op1 != 0) numStack.push((op2*10000.0) / (op1*10000.0));
            else numStack.push(op2/op1);
        }
        else if (op == '*')
            numStack.push((op2*10000.0) * (op1*10000.0) / 100000000.0);
        else if(op == 'm')
            numStack.push(Math.pow(op2, op1));
        else if(op == 's')
            numStack.push(Math.sin(op1));
        else if(op == 'c')
            numStack.push(Math.cos(op1));
        else if(op == 'l')
            numStack.push(Math.log(op1));
        else if(op == 'q')
            numStack.push(Math.sqrt((op1*10000))/100);
        else {

        }
    }

    /*public static void main(String[] args) {
        Vector<String> t = new Vector<String>();
        t.add("1");t.add("/");t.add("0");
        String rst = calculate(t);
        System.out.println(rst);
    }*/

}