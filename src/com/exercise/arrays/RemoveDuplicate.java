package com.exercise.arrays;

import java.util.Arrays;

public class RemoveDuplicate {

    public Integer getUniqueLength(Integer[] arr) {

        int pInsert = 0;

        //Array is already sorted so I can start always from [1]
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] > arr[pInsert]) {
                ++pInsert;//move to the next field to insert unique value
                arr[pInsert] = arr[i];//insert unique value
            }
        }

        return pInsert + 1;// pInsert is the last index of the removeDup array, so length is lastIndex + 1;

    }


    public static void main(String[] args) {
        RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        Integer arr1[] = {1, 1, 3, 4, 4, 6, 7, 7, 7};
        Integer uniqueLength = removeDuplicate.getUniqueLength(arr1);
        System.out.println("The return is = " + uniqueLength);
        System.out.println("The return is = " + Arrays.asList(arr1));
    }
}
