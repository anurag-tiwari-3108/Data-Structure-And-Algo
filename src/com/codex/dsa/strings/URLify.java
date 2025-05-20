package com.codex.dsa.string;

public class URLify {

	public static void main(String [] args) {
		String raw_string = "Mr John Smith          ";
		int trueLenght = 13;
		System.out.println("URL : "+getURLValue(raw_string, trueLenght));
	}
	
	
	public static String getURLValue(String str, int trueLength) {
		StringBuilder result = new StringBuilder();
		for(int i =0; i < trueLength; i++) {
			char value = str.charAt(i);
			if(Character.isAlphabetic(value)) {
				result.append(value);
			}
			else
				result.append("%20");
		}				
		return result.toString();
	}
	
}
