package encapsulation;

import java.util.Stack;

public class RPNCalc {
	private Stack<Double> stack = new Stack<Double>();
	
	public void push(double d) {
		this.stack.push(d);
	}
	
	public double pop() {
		return this.stack.pop();
	}
	
	public double peek(int i) {
		if (i < this.stack.size()) {
			return this.stack.get(i);
		} 
		
		return Double.NaN;
	}
	
	public int getSize() {
		return this.stack.size();
	}
	
	public void performOperation(char c) {
		double d1 = this.pop();
		double d2 = this.pop();
		
		if (c == '+') {
			this.push(d1+d2);
		}
		else if (c == '-') {
			this.push(d1-d2);
		}
		else if (c == '*') {
			this.push(d1*d2);
		}
		else if (c == '/') {
			this.push(d1/d2);
		}
	}
	
	public static void main(String[] args) {
		RPNCalc rpn = new RPNCalc();
		rpn.push(5.0);
		rpn.push(7.0);
		rpn.performOperation('*');
		System.out.println(rpn.getSize());
		System.out.println(rpn.peek(0));
		
		
	}
}
