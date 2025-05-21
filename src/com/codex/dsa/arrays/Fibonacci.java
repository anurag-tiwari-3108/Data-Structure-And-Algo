package com.codex.dsa.arrays;

public class Fibonacci {

	public static void main(String [] args) {
		System.out.println("Fibo of 10 is "+printFibonacci(10));
	}
	
	private static int printFibonacci(int n) {
		if(n <= 1) {
			return n;
		}
		return printFibonacci(n-1) + printFibonacci(n-2) ;
	}
}
