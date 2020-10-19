package simple_calculate;

import java.util.Stack;
import java.util.Vector;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class simple {
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
		
		BigDecimal rst_round = new BigDecimal(rst);
		rst_round= rst_round.setScale(2, RoundingMode.HALF_UP);
		return rst_round.toString();
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
		
		BigDecimal o1 = new BigDecimal(op1);
		BigDecimal o2 = new BigDecimal(op2);
		
		if (op == '+')
			numStack.push(o1.add(o2).doubleValue());
		else if (op == '-')
			numStack.push(o2.subtract(o1).doubleValue());
		else if (op == '/') {
			if(op1 != 0) numStack.push(o2.divide(o1).doubleValue());
			else numStack.push(op2/op1);
		}
		else if (op == '*')
			numStack.push(o1.multiply(o2).doubleValue());
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
	
	public static void main(String[] args) {
		Vector<String> t = new Vector<String>();
		//t.add("s");t.add("(");t.add("p");t.add("/");t.add("2");t.add(")");t.add("/");
		//t.add("c");t.add("(");t.add("p");t.add("/");t.add("2");t.add(")");
		t.add("0.3");t.add("*");t.add("3");
		String rst = calculate(t);
		System.out.println(rst);
	}
	
}
