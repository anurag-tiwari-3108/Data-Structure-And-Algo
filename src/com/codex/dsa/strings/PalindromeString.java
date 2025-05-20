/**
 * 
 */
package com.codex.dsa.string;

public class PalindromeString {
	public static void main(String[] args) {
		String value = "0P";
		System.out.println("VALUE IS "+value);
		System.out.println(isPalindrome(value));
	}

	public static boolean isPalindrome(String str) {
		str= str.toLowerCase();
		int i =0;
		int j = str.length()-1;
		while(i<j) {
			if(!Character.isAlphabetic(str.charAt(i)) ) {
				i++;			
				continue;
			}
			if(!Character.isAlphabetic(str.charAt(j))) {
				j--;
				continue;
			}
			
			if(str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
