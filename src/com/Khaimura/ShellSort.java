package com.Khaimura;

import java.util.Arrays;
import java.util.Random;

public class ShellSort {

        /* function to sort arr using shellSort */
        int [] sort(int arr[])
        {
            int n = arr.length;

            // Start with a big gap, then reduce the gap
            for (int gap = n/2; gap > 0; gap /= 2)
            {
              //  System.out.println(gap);
                // Do a gapped insertion sort for this gap size.
                // The first gap elements a[0..gap-1] are already
                // in gapped order keep adding one more element
                // until the entire array is gap sorted
                for (int i = gap; i < n; i += 1)
                {
                    // add a[i] to the elements that have been gap
                    // sorted save a[i] in temp and make a hole at
                    // position i
                    int temp = arr[i];
                 //   System.out.println("temp " + temp);

                    // shift earlier gap-sorted elements up until
                    // the correct location for a[i] is found
                    int j;
                    for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                        arr[j] = arr[j - gap];

                    // put temp (the original a[i]) in its correct
                    // location
                    arr[j] = temp;
                }
            }
            return arr;
        }

        public int[] parallelSort(int[] array) {
        int k = 2;
        int count = array.length/k;
        int temp1[] =  new int [count];
        int temp2[] =  new int [array.length-count];
            System.arraycopy(array, 0, temp1, 0, count);
            System.arraycopy(array, count, temp2, 0, array.length-count);
            new SortThread(temp1).run();
            new SortThread(temp2).run();

//        int[][] temp = new int[k][array.length-count];
//        for (int i = 0; i < k; i++) {
//            System.arraycopy(array, count* i, temp[i], 0, array.length-count);
//            new SortThread(temp[i]).run();
//        }
        return mergeSort(temp1,temp2);

    }

    public int[] mergeSort(int[] a, int[] b){
        int[] array = new int[a.length+b.length];
        int aCount = 0;
        int bCount = 0;
        for (int i = 0; i < array.length; i++) {
            if(a[aCount]>b[bCount]){
                array[i] = b[bCount++];
                if(bCount==b.length){
                    break;
                }
            } else {
                array[i] = a[aCount++];
                if(aCount==a.length){
                    break;
                }
            }
        }
        if(aCount==a.length){
            for (int i = aCount+bCount;i<array.length;i++){
                array[i]=b[bCount++];
            }
        } else {
            for (int i = aCount+bCount;i<array.length;i++){
                array[i]=a[aCount++];
            }
        }
        return array;
    }

        public static void main(String args[])
        {
            int[] arr = new int[100000000];
            int[] sorted = new int [arr.length];
            Random rn = new Random();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = rn.nextInt(100);
            }
            //int arr[] = {12, 54, 34, 3, 1, 14, 17, 5, 9, 55, 6, 37, 14, 8};

            ShellSort ob = new ShellSort();
            long start = System.currentTimeMillis();
            sorted = ob.parallelSort(arr);
            long end = System.currentTimeMillis();
            System.out.println("Multithreaded Shell sorting.\nTime: " + (end - start) + "ms. Array length is " + arr.length);

            long start2 = System.currentTimeMillis();
            arr = ob.sort(arr);
            long end2 = System.currentTimeMillis();
            System.out.println("simple Shell sorting.\nTime: " + (end2 - start2) + "ms. Array length is " + arr.length);


        }


}
