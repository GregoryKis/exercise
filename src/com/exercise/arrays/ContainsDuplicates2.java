package com.exercise.arrays;

import java.util.Arrays;

public class ContainsDuplicates2 {

    public boolean isContainDuplicates(int[] nums, int k) {
        int[] nums2 = new int[nums.length];
        System.arraycopy(nums, 0, nums2, 0, nums.length);

        Arrays.sort(nums2);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] == nums2[i - 1]) {
                int t = nums2[i];
                int x = -1;
                int y = -1;
                for (int j = 0; j < nums.length && (x < 0 || y < 0); j++) {
                    if (nums[j] == t && x < 0) {
                        x = j;
                    } else if (nums[j] == t && y < 0) {
                        y = j;
                    }
                    if(y>0 && y-x>k){
                        System.out.println("!= :: x=" + x + ", y=" + y );
                        x=y;
                        y=-1;
                    }
                }
                if (y>=0 && x>=0 && y - x <= k) {
                    System.out.println("== :: x=" + x + ", y=" + y + ", " + nums[x] + "=" + nums[y]);
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        ContainsDuplicates2 containsDuplicates = new ContainsDuplicates2();
        int[] arr1 = {1, 2, 3, 1, 2, 3};
        int[] arr2 = {1, 0, 1, 1};
        boolean isContainDuplicates1 = containsDuplicates.isContainDuplicates(arr1, 2);
        boolean isContainDuplicates2 = containsDuplicates.isContainDuplicates(arr2, 1);

        System.out.println("The return is = " + isContainDuplicates1);
        System.out.println("The return is = " + isContainDuplicates2);
    }


}
