package Dz5;

import java.util.Arrays;

public class Dz5 {

    static class ArrayThread extends Thread    {
        private float[] arrayTh;

        ArrayThread(float[] arrTh) {
            this.arrayTh = arrTh;
        }

        @Override
        public void run() {
            for (int i = 0; i < arrayTh.length; i++) {
                arrayTh[i] = (float)(arrayTh[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }
    }

    public static void main(String[] args) {
        int size = 10000000;
        int h = size / 2;

        float[] arr = new float[size];
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];

        //Инициализация массива
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        a = System.currentTimeMillis() - a;

        System.out.println("Время вычисления = " + a);

        //Инициализация массива
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        a = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        ArrayThread arrayTh1 = new ArrayThread(arr1);
        ArrayThread arrayTh2 = new ArrayThread(arr2);

        arrayTh1.start();
        arrayTh2.start();

        try {
            arrayTh1.join();
            arrayTh2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);

        a = System.currentTimeMillis() - a;
        System.out.println("Время вычисления в 2 потока = " + a);

    }
}


