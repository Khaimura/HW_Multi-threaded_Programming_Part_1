package com.Khaimura;

import java.math.BigInteger;

public class Factorial implements Runnable {
    private int number;

    public Factorial(int number) {
        this.number = number;
    }

    public Factorial() {
    }

    public BigInteger calculateFactorial(int n) {
        BigInteger factor = new BigInteger("1");

        for(int i = 1; i <= n; ++i) {
            factor = factor.multiply(new BigInteger(Integer.toString(i)));
        }

        return factor;
    }

    public void run() {
        Thread thr = Thread.currentThread();

        for(int i = 1; i <= this.number; ++i) {
            if (thr.isInterrupted()) {
                System.out.println(thr.getName() + "interapt");
                return;
            }

            System.out.println(thr.getName() + "  " + i + "! =" + this.calculateFactorial(i));
        }

    }
}