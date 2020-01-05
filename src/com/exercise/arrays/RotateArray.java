package com.exercise.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateArray {

    public Integer[] rotateRightByN(Integer[] arr, int n) {

        int shiftRightBy = n % arr.length;

        List<Integer> mem = new ArrayList<>(shiftRightBy);

        for (int i = arr.length - shiftRightBy; i < arr.length; ++i) {
            mem.add(arr[i]);
        }

        for (int i = arr.length - shiftRightBy - 1; i >= 0; --i) {
            arr[i + shiftRightBy] = arr[i];
        }

        for (int i = 0; i < shiftRightBy; ++i) {
            arr[i] = mem.get(i);
        }

        return arr;
    }


    public static void main(String[] args) {
        RotateArray rotate = new RotateArray();
        List<Integer> testList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer ret[] = rotate.rotateRightByN(arr, 14);
        System.out.println("The return is = " + Arrays.toString(ret));
    }

}
