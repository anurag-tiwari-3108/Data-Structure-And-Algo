package com.codex.dsa.array;

import java.util.ArrayList;
import java.util.List;

public class Partition {

	public List<List<String>> partition(String s) {

		List<List<String>> res = new ArrayList<>();
		List<String> path = new ArrayList<>();
		func(0, s, path, res);
		return res;

	}

	private void func(int index, String s, List<String> path, List<List<String>> res) {
		if (index == s.length()) {
			res.add(new ArrayList<>(path));
			return;
		}
		for (int end = index; end < s.length(); ++end) {
			if (isPalindrome(s, index, end)) {
				path.add(s.substring(index, end + 1));
				func(end + 1, s, path, res);
				path.remove(path.size() - 1);
			}
		}
	}

	boolean isPalindrome(String s, int start, int end) {
		while (start <= end) {
			if (s.charAt(start++) != s.charAt(end--))
				return false;
		}
		return true;
	}

}
