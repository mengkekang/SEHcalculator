package com.example.lywva.dstcalculator;

/**
 * Created by lywva on 2020/10/12.
 */
import java.util.Stack;
import java.util.Vector;

public class Simple {
    public static double calculate(Vector<String> expression) {
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

        return numStack.pop();
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
        else if (op == '/')
            numStack.push(op2 / op1);
        else if (op == '*')
            numStack.push(op2 * op1);
        else if(op == 'm')
            numStack.push(Math.pow(op2, op1));
        else if(op == 's')
            numStack.push(Math.sin(op1));
        else if(op == 'c')
            numStack.push(Math.cos(op1));
        else if(op == 'l')
            numStack.push(Math.log(op1));
        else if(op == 'q')
            numStack.push(Math.sqrt(op1));
        else {

        }
    }

    /*public static void main(String[] args) {
        Vector<String> t = new Vector<String>();
        t.add("(");t.add("9");t.add("+");t.add("7");t.add(")");t.add("*");t.add("5");t.add("/");t.add("6");t.add("+");
        t.add("s");t.add("2");t.add("+");t.add("c");t.add("(");t.add("p");t.add("/");t.add("2");t.add(")");t.add("-");
        t.add("2");t.add("m");t.add("2");t.add("+");t.add("q");t.add("4");t.add("+");t.add("l");t.add("5");
        double rst = calculate(t);
        System.out.println(rst);
    }*/

}
