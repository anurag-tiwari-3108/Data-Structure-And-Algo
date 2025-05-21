package com.codex.dsa.arrays;

import java.util.Arrays;

// kadane's algo 

public class ContinuousSubarrayMaximumSum {
    public static void main(String[] args) {
        int[] ar = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println("Max Difference in array is ::  " + Arrays.toString(maxSum(ar)));
    }

    private static int[] maxSum(int[] ar) {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;
        int start = 0;
        int end = 0;
        int beg = 0;
        for (int i = 0; i < ar.length; i++) {
            max_ending_here = max_ending_here + ar[i];
            if (max_ending_here < ar[i]) {
                max_ending_here = ar[i];
                beg = i;
            }
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                start = beg;
                end = i;
            }
        }
        return Arrays.copyOfRange(ar, start, end + 1);
    }
}
