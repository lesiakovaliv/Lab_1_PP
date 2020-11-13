package com.kovalivlesia.lab1;

/**
 * A class that describes the interval between two numbers
 */
public class Interval {
    /**
     * The begin of the interval
     */
    private Integer start;
    /**
     * The end of the interval
     */
    private Integer end;

    public Interval(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    /**
     * The function outputs odd numbers in ascending order and even numbers in descending order
     */
    public void printOddAndEven() {
        for (int i = 0; i <= end - start; i++) {
            if ((start + i) % 2 == 1) {
                System.out.print((start + i) + "\t");
            }
        }
        System.out.println();
        for (int i = 0; i <= end - start; i++) {
            if ((end - i) % 2 == 0) {
                System.out.print((end - i) + "\t");
            }
        }
        System.out.println();
    }

    /**
     * The function displays the sum of odd and even numbers
     */
    public void printSum() {
        Integer sum1 = 0, sum2 = 0;
        for (int i = 0; i < end - start; i++) {
            if ((start + i) % 2 == 1) {
                sum1 += start + i;
            }
        }
        for (int i = 0; i < end - start; i++) {
            if ((end - i) % 2 == 0) {
                sum2 += end - i;
            }
        }
        System.out.println("Sum Odd = " + sum1);
        System.out.println("Sum Even = " + sum2);
    }

    /**
     * Displays Fibonacci series numbers of a given length
     * <p>
     * The first number is the largest odd, and the second largest even
     *
     * @param length row length
     */
    public void printFibonacci(Integer length) {
        Integer first = end % 2 == 0 ? end - 1 : end;
        Integer second = end % 2 == 0 ? end : end - 1;
        System.out.print(first + " " + second);
        for (int i = 2; i < length; i++) {
            Integer tmp = first + second;
            first = second;
            second = tmp;
            System.out.print(" " + tmp);
        }
        System.out.println();
    }

    /**
     * Displays the percentage of even and odd numbers in the Fibonacci series of a given length
     *
     * @param length row length
     */
    public void printFibonacciPercent(Integer length) {
        Integer first = end % 2 == 0 ? end - 1 : end;
        Integer second = end % 2 == 0 ? end : end - 1;
        Integer countEven = 1, countOdd = 1;
        for (int i = 2; i < length; i++) {
            Integer tmp = first + second;
            first = second;
            second = tmp;
            if (tmp % 2 == 0) {
                countEven++;
            } else {
                countOdd++;
            }
        }

        System.out.println("Percent of Even - " + 100.0 * countEven / length + "%");
        System.out.println("Percent of Odd - " + 100.0 * countOdd / length + "%");
    }
}