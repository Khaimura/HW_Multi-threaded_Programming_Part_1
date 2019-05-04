package com.Khaimura;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Factorial task1 = new Factorial(100);
        Factorial task2 = new Factorial(100);
        Factorial task3 = new Factorial(100);
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);
       // thread1.start();
       // thread2.start();
        thread3.start();
        Thread thr = Thread.currentThread();
        int pracesor = Runtime.getRuntime().availableProcessors();
        System.out.println(pracesor);

        int[] array = new int[5];
        Random rn = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rn.nextInt(5);
        }
        long d = System.currentTimeMillis();
        int sum=0;
        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }
        System.out.println("array"+Arrays.toString(array));
        System.out.println("suma"+sum);
        System.out.println(thr.getName() + " STOP");

    }
}