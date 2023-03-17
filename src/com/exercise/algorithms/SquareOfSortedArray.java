package com.exercise.algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class SquareOfSortedArray {
    public static int[] sortedSquares(int[] nums) {

        int size = nums.length;
        int[] res = new int[size];

        int i = 0;
        ArrayList<Integer> negArr = new ArrayList<>();
        ArrayList<Integer> posArr = new ArrayList<>();
        while (i < size && nums[i] < 0) {
            negArr.add(nums[i] * nums[i]);
            i++;
        }

        while (i < size) {
            posArr.add(nums[i] * nums[i]);
            i++;
        }
        if (negArr.isEmpty()) {
            for (int j = 0; j < size; j++) {
                res[j] = posArr.get(j);
            }
        }
        if (posArr.isEmpty()) {
            for (int j = 0; j < size; j++) {
                res[size - 1 - j] = negArr.get(j);
            }
        }

        int pos = 0;
        int neg = 0;
        for (int j = 0; j < size; j++) {
            if (neg < negArr.size() && (pos >= posArr.size() || negArr.get(negArr.size() - 1 - neg) < posArr.get(pos))) {
                res[j] = negArr.get(negArr.size() - 1 - neg);
                neg++;
            } else {
                res[j] = posArr.get(pos);
                pos++;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{-4, -1, 0, 3, 10};
        int[] exp1 = new int[]{0, 1, 9, 16, 100};
        printTest(nums1, exp1);
        int[] nums2 = new int[]{-7, -3, 2, 3, 11};
        int[] exp2 = new int[]{4, 9, 9, 49, 121};
        printTest(nums2, exp2);
        int[] nums3 = new int[]{1};
        int[] exp3 = new int[]{1};
        printTest(nums3, exp3);
    }

    private static void printTest(int[] nums, int[] exp) {

        int[] res1 = sortedSquares(nums);
        System.out.println("test 1: " + Arrays.toString(exp) + " =?= " + Arrays.toString(res1));
    }


//            if (nums[0] >= 0) {
//        int[] res = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            res[i] = nums[i] * nums[i];
//        }
//    }
//        if (nums[nums.length - 1] < 0) {
//        int size = nums.length;
//        int[] res = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            res[size - 1 - i] = nums[i] * nums[i];
//        }
//    }


}
