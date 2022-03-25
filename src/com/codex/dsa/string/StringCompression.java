package com.codex.dsa.string;

import java.util.Stack;

//"2[abc]3[cd]ef";  "2[abc]3[cd]ef"; "abc3[cd]xyz"; "3[a2[c]]";

public class StringCompression {
	public static void main(String[] args) {
		String val = "aabccccaaa";
		System.out.println("Encoded String of " + val + " is " + encodeString(val));
		String val2 = "2[abc]3[cd]ef";
		System.out.println("Decoded String of " + val2 + " is " + decodeString(val2));
	}

	public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        
        char[] values = s.toCharArray();
        for(char value: values){
            if(value == ']'){
                String decode = "";
                while(stack.peek() != '['){
                    decode += stack.pop();
                }
                
                // pop off the '['
                stack.pop();
                
                // get the number
                int num = 0;
                int exponent = 0;
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    num += (stack.pop() - '0') * Math.pow(10, exponent++);
                }
                
                while(num-- != 0){
                    for(int i = decode.length() - 1; i >= 0; i--){
                        //System.out.println(decode.charAt(i));
                        stack.push(decode.charAt(i));
                    }
                }
                
            }
            
            else { 
            	stack.push(value);
            	System.out.println("stack :: "+stack);
            }
        }
        
        String result = "";
        while(!stack.empty()){
            result = stack.pop() + result;
        }
        
        return result;
        
	}

	public static String encodeString(String value) {
		StringBuilder result = new StringBuilder();
		int countConsecutive = 0;
		for (int i = 0; i < value.length(); i++) {
			char currentChar = value.charAt(i);
			countConsecutive++;
			if (i + 1 >= value.length() || currentChar != value.charAt(i + 1)) {
				result.append(currentChar);
				result.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return result.length() < value.length() ? result.toString() : value;
	}
}
