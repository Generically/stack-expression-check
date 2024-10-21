package stacktest;

import java.util.Stack;

public class Tester {

	
	// this code is basic so I wont bother with comments to explain, threw it together to do what I needed quickly for a University module
	// I didn't check particularly hard for bugs so use at your own risk I guess, seemed to work fine for what I needed though
	
	public static void main(String[] args) {
		String[] operations = {
				"oxoxox", 
				"oooxxx", 
				"oooooxxx", 
				"ooo00xoxxxxox",
		};
		
		String[] expressions = {"(1-5)/2-2", "(6-2)*5+3"};
			
		
		/*
		 * runTest(operations, expressions);
		 * runReversedExpressionTest(operations, expressions);
		 * 
		 * runThroughStack(operations, expressions);
		 * runThroughReversedExpressionStack(operations, expressions);
		 */
		
		
		
	}
	
	
	public static void runTest(String[] operations, String[] expression) {
		System.out.println("Output Format:\nOperations Performed before error/finished task\t|\tValid task or Error\t|\t Output from performing stack operations on expression or Error info\n");
		for(int j = 0; j < expression.length; j++) {
			System.out.println("\n\n\n"+expression[j]+"\n");
			for(int i = 0; i < operations.length; i++) {
				System.out.println("\t" + tester(operatorConverter(operations[i]), expression[j]));
			}
		}
		System.out.println("\n\nNote that just because stack operations are valid does not mean the expression formed will be valid");
	}
	
	
	public static void runReversedExpressionTest(String[] operations, String[] expression) {
		System.out.println("Output Format:\nOperations Performed before error/finished task\t|\tValid task or Error\t|\t Output from performing stack operations on expression or Error info\n");
		for(int j = 0; j < expression.length; j++) {
			System.out.println("\n\n\n"+expression[j]+ "\t->\t" + reversedString(expression[j]) + "\n");
			for(int i = 0; i < operations.length; i++) {
				System.out.println("\t" + tester(operatorConverter(operations[i]), reversedString(expression[j])));
			}
		}
		System.out.println("\n\nNote that just because stack operations are valid does not mean the expression formed will be valid");
	}
	
	public static void runThroughReversedExpressionStack(String[] operations, String[] expression) {
		for(int j = 0; j < expression.length; j++) {
			for(int i = 0; i < operations.length; i++) {
				System.out.println(expression[j]);
				System.out.println(walkThroughStack(operatorConverter(operations[i]), reversedString(expression[j])) + "\n");
			}
		}
	}
	
	
	public static void runThroughStack(String[] operations, String[] expression) {
		for(int j = 0; j < expression.length; j++) {
			for(int i = 0; i < operations.length; i++) {
				System.out.println(expression[j]);
				System.out.println(walkThroughStack(operatorConverter(operations[i]), expression[j]) + "\n");
			}
		}
	}
	
	
	public static int[] operatorConverter(String operatorString) {
		int operatorStringLength = operatorString.length();
		int[] operatorArray = new int[operatorStringLength];
		for(int i = 0; i < operatorStringLength; i++) {
			char currentChar = operatorString.charAt(i);
			
			if(currentChar == 'X' || currentChar == '1' || currentChar == 'x') {
				operatorArray[i] = 1;
				continue;
			}
			if(currentChar == 'O' || currentChar == '0' || currentChar == 'o') {
				operatorArray[i] = 0;
				continue;
			}
			System.out.println("\nERR Invalid char in operations string");
		}
		
		
		return operatorArray;
	}
	
	
	public static String reversedString(String str) {
		String reversedString = "";
		
		while (str != "") {
			reversedString += str.charAt(str.length()-1);
			str = str.substring(0, str.length()-1);
		}
		
		return reversedString;
	}
	
	
	public static String tester(int[] operators, String expression) {
		String output = "";
		Stack<Character> char_stack = new Stack<>();
		
		try {
			int length = operators.length;
			
			
			for (int i = 0; i < length; i++) {
				if(operators[i] == 0) {
					char_stack.push(expression.charAt(0));
					expression = expression.substring(1);
					System.out.print("O");
				}
				if(operators[i] == 1) {
					System.out.print("X");
					output += char_stack.pop();
				}
			}
			
			return "|\t Valid Stack Operation\t|\tStack operation output:\t" + output;
		}
		catch(java.util.EmptyStackException E) {
			System.out.print("\t|\t" + E + "\t|\t Operations list contains too many pops, i.e the stack becomes empty and you attempt to pop an item that doesnt exist (pop is X)");
			return "";
		}
		catch(java.lang.StringIndexOutOfBoundsException E) {
			System.out.print("\t\t|\t" + E + "\t|\t Operations list contains too many pushes i.e more pushes than there are characters in the expression (push is O)");
			return "";
		}
	}
	
	
	public static String walkThroughStack(int[] operators, String expression) {
		String output = "";
		Stack<Character> char_stack = new Stack<>();
		
		try {
			int length = operators.length;
			System.out.println(integerArrToStr(operators) + "\t" + expression);
			
			for (int i = 0; i < length; i++) {
				if(operators[i] == 0) {
					char_stack.push(expression.charAt(0));
					expression = expression.substring(1);
					System.out.print("O Push\t");
				}
				if(operators[i] == 1) {
					System.out.print("X Pop \t");
					output += char_stack.pop();
				}
				System.out.print("current Stack: "+ char_stack + "\t\tExpression:  " + output+"\n");
			}
			
			return "";
		}
		catch(Exception E) {
			System.out.print("ERR Invalid Input");
			return "";
		}
	}
	
	public static String integerArrToStr(int[] arr) {
		String str = "";
		for (int i = 0; i < arr.length; i++) {
			str+=(arr[i]);
		}
		
		return str;
	}

}
