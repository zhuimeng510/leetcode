package easy;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 题目描述
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are+,-,*,/. Each operand may be an integer or another expression.
Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

 */
public class EvaluateReversePolishNotation {

	public static int evalRPN(String[] tokens) {
        Integer res = 0;
        if (tokens!=null && tokens.length!=0) {
        	Deque<String> stack = new ArrayDeque<String>();
        	//遇到+ - * /则出栈两个数进行运算
        	String str1 = null;
        	String str2 = null;
			for (int i = 0; i < tokens.length; i++) {
				if (tokens[i].equals("+")){
					str1 = stack.pop();
					str2 = stack.pop();//出栈两个数
					res = Integer.parseInt(str2) + Integer.parseInt(str1);
					stack.push(res.toString());
				}else if (tokens[i].equals("-")) {
					str1 = stack.pop();
					str2 = stack.pop();//出栈两个数
					res = Integer.parseInt(str2) - Integer.parseInt(str1);
					stack.push(res.toString());
				}else if (tokens[i].equals("*")) {
					str1 = stack.pop();
					str2 = stack.pop();//出栈两个数
					res = Integer.parseInt(str2) * Integer.parseInt(str1);
					stack.push(res.toString());
				}else if (tokens[i].equals("/")) {
					str1 = stack.pop();
					str2 = stack.pop();//出栈两个数
					res = Integer.parseInt(str2) / Integer.parseInt(str1);
					stack.push(res.toString());
				}else {
					stack.push(tokens[i]);
				}
			}
			res = Integer.parseInt(stack.pop());
		}
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] tokens = {"4", "13", "5", "/", "+"};
		System.out.println(evalRPN(tokens));
		
	}

}
