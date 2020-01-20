package com.exercise.arrays;

import java.util.Arrays;

public class MoveZeros {


    public Integer[] move(Integer[] arr) {

        int zeroCount = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == 0) {
                ++zeroCount;
            }
        }


        for (int pZero = 0, pCurr = 0; pCurr < arr.length && pZero < arr.length;) {
            if (arr[pZero] != 0) {
                ++pZero;
            }

            if (pZero >= pCurr) {
                pCurr = pZero + 1;
            }

            while (pCurr < arr.length && arr[pCurr] == 0) {
                ++pCurr;
            }

            if (pCurr >= arr.length) {
                break;
            }

            arr[pZero] = arr[pCurr];
            arr[pCurr] = 0;
            ++pZero;
            ++pCurr;
        }

        return arr;
    }


    public static void main(String[] args) {
        MoveZeros moveZeros = new MoveZeros();
        Integer arr1[] = {1, 0, 2, 3};
        Integer arr2[] = {1, 2, 0, 0, 0, 3, 4};
        Integer arr3[] = {0};
        Integer[] arrNum1 = moveZeros.move(arr1);
        Integer[] arrNum2 = moveZeros.move(arr2);
        Integer[] arrNum3 = moveZeros.move(arr3);
        System.out.println("The return is = " + Arrays.asList(arrNum1));
        System.out.println("The return is = " + Arrays.asList(arrNum2));
        System.out.println("The return is = " + Arrays.asList(arrNum3));
    }

}
