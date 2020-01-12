package com.exercise.arrays;

import java.util.Arrays;

public class ContainsDuplicates {

    public boolean isContainDuplicates(Integer[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i - 1] == arr[i]) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        ContainsDuplicates containsDuplicates = new ContainsDuplicates();
        Integer arr1[] = {7, 1, 5, 3, 3, 4};
        Integer arr2[] = {1};
        Integer arr3[] = {7, 7, 7, 1};
        boolean isContainDuplicates1 = containsDuplicates.isContainDuplicates(arr1);
        boolean isContainDuplicates2 = containsDuplicates.isContainDuplicates(arr2);
        boolean isContainDuplicates3 = containsDuplicates.isContainDuplicates(arr3);
        System.out.println("The return is = " + isContainDuplicates1);
        System.out.println("The return is = " + isContainDuplicates2);
        System.out.println("The return is = " + isContainDuplicates3);
    }


}
