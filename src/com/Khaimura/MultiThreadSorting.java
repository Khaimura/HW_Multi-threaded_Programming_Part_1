package com.Khaimura;

    public class MultiThreadSorting extends Thread {
        private int arr[];
        int strt; int st; int sum;
        public MultiThreadSorting(int arr[], int strt, int st, int sum){
            this.arr = arr;
            this.strt = strt;
            this.st = st;
            this.sum = sum;
        }

        @Override
        public void run() {
            synchronized (arr){
                for(int i = arr[strt]; i<=arr[st]; i++){
                    sum +=arr[i];
                    set(sum);
                }
            }

        }
        public int get(){
            return sum;
        }
        public void set(int x){
            sum = x;
        }
    }

