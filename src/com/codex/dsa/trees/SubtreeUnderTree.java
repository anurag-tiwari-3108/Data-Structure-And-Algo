package com.codex.dsa.trees;

public class SubtreeUnderTree {

	private static boolean areIdentical(Node T1, Node T2) {
		if (T1 == null && T2 == null) {
			return true;
		}
		if (T1 == null || T2 == null) {
			return false;
		}
		return (T1.data == T2.data && areIdentical(T1.left, T2.left) && areIdentical(T1.right, T2.right));

	}

	public static boolean areSubtree(Node T, Node S) {

		/* base cases */
		if (S == null)
			return true;

		if (T == null)
			return false;

		if (areIdentical(T, S)) {
			return true;
		}

		return (areSubtree(T.left, S) || areSubtree(T.right, S));
	}

}
