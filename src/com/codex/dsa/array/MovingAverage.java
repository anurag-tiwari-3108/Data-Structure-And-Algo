package com.codex.dsa.array;

// https://evelynn.gitbooks.io/google-interview/content/moving_average_from_data_stream.html

public class MovingAverage {
    private int [] window;
    private int n, insert;
    private long sum;

    /** Initialise your data structure here. */
    
    public MovingAverage(int size) {
        window = new int[size];
        insert = 0;
        sum = 0;
    }

    public double next(int val) {
        if (n < window.length)  n++;
        sum = sum- window[insert];
        sum = sum+ val;
        window[insert] = val;
        insert = (insert + 1) % window.length;

        return (double)sum / n;
    }
}