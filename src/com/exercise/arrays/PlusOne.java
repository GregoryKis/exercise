package com.exercise.arrays;

import java.util.Arrays;

public class PlusOne {


    public Integer[] increment(Integer[] arr) {

        ++arr[arr.length-1];
        return arr;
    }


    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        Integer arr1[] = {1,2,3};
        Integer arr2[] = {4,3,2,1};
        Integer arr3[] = {0};
        Integer[] arrNum1 = plusOne.increment(arr1);
        Integer[] arrNum2 = plusOne.increment(arr2);
        Integer[] arrNum3 = plusOne.increment(arr3);
        System.out.println("The return is = " + Arrays.asList(arrNum1));
        System.out.println("The return is = " + Arrays.asList(arrNum2));
        System.out.println("The return is = " + Arrays.asList(arrNum3));
    }


}
