package com.exercise.arrays;

import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArrays {


    public Integer[] getIntersection(Integer[] arr1, Integer[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        Integer[] result = new Integer[Math.max(arr1.length, arr2.length)];
        int pResult = 0;

        for (int pArr1 = 0, pArr2 = 0; pArr1 < arr1.length && pArr2 < arr2.length; ) {
            if (arr1[pArr1] == arr2[pArr2]) {
                result[pResult] = arr1[pArr1];
                ++pResult;
                if (arr1.length - pArr1 > arr2.length - pArr2) {
                    ++pArr1;
                } else {
                    ++pArr2;
                }

            } else if (arr1[pArr1] < arr2[pArr2]) {
                ++pArr1;
            } else if (arr1[pArr1] > arr2[pArr2]) {
                ++pArr2;
            }

        }

        return result;
    }


    public static void main(String[] args) {
        IntersectionOfTwoArrays intersectionArr = new IntersectionOfTwoArrays();
        List<Integer> testList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer arr2[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9};
        Integer ret[] = intersectionArr.getIntersection(arr1, arr2);
        System.out.println("The return is = " + Arrays.toString(ret));
    }

}
