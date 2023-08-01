package co.yedam.collect;

import java.util.Stack;

public class StackExe {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("hong");
		stack.push("kim");
		stack.push("park");
		
//		System.out.println(stack.peek());
//		System.out.println(stack.peek());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());		
		}
	
		
	}

}
