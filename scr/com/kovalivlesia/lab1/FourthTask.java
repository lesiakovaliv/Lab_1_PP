package com.kovalivlesia.lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FourthTask {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Input first: ");
        Integer first = Integer.parseInt(bufferedReader.readLine());
        System.out.print("Input last: ");
        Integer last = Integer.parseInt(bufferedReader.readLine());
        Interval interval = new Interval(first, last);
        interval.printOddAndEven();
        interval.printSum();
        System.out.print("Input length of Fibonacci row: ");
        Integer length = Integer.parseInt(bufferedReader.readLine());
        interval.printFibonacci(length);
        interval.printFibonacciPercent(length);
    }
}