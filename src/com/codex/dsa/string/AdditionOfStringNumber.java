package com.codex.dsa.string;

import java.util.ArrayList;
import java.util.List;

public class AdditionOfStringNumber {

	public static class TextInput {
		public void add(String str) {
		}

		public void add(Character c) {
			if (Character.isLetter(c)) {
//				System.out.println("Returning");
				return;
			}
			add(String.valueOf(c));
		}

	}

	public static class NumericInput extends TextInput {
		public static List<Integer> list = new ArrayList<Integer>();

		@Override
		public void add(String str) {
			String numberRefined = str.replaceAll("[^0-9]", "");
			if (numberRefined == null) {
				return;
			}

			if (numberRefined != null || !numberRefined.equalsIgnoreCase("")) {
//				System.out.println("check " + numberRefined);
				list.add(Integer.parseInt(str));
			}
		}

		public int getSumValue() {
			int sum = 0;
			for (int i = 0; i < list.size(); i++) {
				sum += list.get(i);
			}
			return sum;
		}

		public String getElementValue() {
			String element = "";
			for (int i = 0; i < list.size(); i++) {
				element = element + "" + "" + list.get(i);
			}
			return element;
		}
	}

	public static void main(String[] args) {
		TextInput input = new NumericInput();
		input.add('1');
		input.add('a');
		input.add('9');
		System.out.println("Sum of List is " + Integer.valueOf(((NumericInput) input).getSumValue()));
		System.out.println("Sum of List is " + Integer.valueOf(((NumericInput) input).getElementValue()));

	}
}
