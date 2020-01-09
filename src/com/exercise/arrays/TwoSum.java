package com.exercise.arrays;

import java.util.Arrays;
import java.util.List;

public class TwoSum {

    public Integer[] getMembersOfSum(Integer[] arr, Integer sum) {
        Arrays.sort(arr);

        Integer[] res = new Integer[2];

        Integer testSum = 0;

        // I can do this only because it is guaranteed that there is a solution
        // and I cant use the same array member twice - so there are at least 2 members in the array
        for(int pStart = 0, pEnd = arr.length - 1; pStart < pEnd;){

            testSum = arr[pStart] + arr[pEnd];

            if (testSum < sum){
                ++pStart;
            }else if(testSum>sum){
                --pEnd;
            }else {
                res[0] = arr[pStart];
                res[1] = arr[pEnd];
                break;
            }
        }

        return res;

    }


    public static void main(String[] args) {
        TwoSum sumMembers = new TwoSum();
        Integer arr1[] = {1, 2, 3, 4, 5, 50, 7, 8, 9};
        Integer ret[] = sumMembers.getMembersOfSum(arr1, 51);
        System.out.println("The return is = " + Arrays.toString(ret));
    }

}
