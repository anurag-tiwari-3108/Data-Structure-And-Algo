package com.codex.dsa.divideandconquer;
/**
 * Here we need to write a code to search for the first 1 occurrence in an array
 * of millions of data. We first search the middle element if it is having the
 * value as 1 then search in left part otherwise in right side
 *
 * @author anutiwar
 *
 */
public class SearchNumberInMilionsOfData {

    public static void main(String[] args) {
        // Example: sorted array of 0s and 1s
        int[] arr = new int[] {0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
        int index = findFirstOne(arr);
        System.out.println("First occurrence of 1 is at index: " + index);
    }

    // Binary search for first occurrence of 1 in a sorted array of 0s and 1s
    public static int findFirstOne(int[] arr) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == 1) {
                result = mid;
                right = mid - 1; // look for earlier 1
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
