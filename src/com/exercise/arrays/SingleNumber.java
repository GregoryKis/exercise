package com.exercise.arrays;

import java.util.*;

public class SingleNumber {

    public Integer getSingleNumber(List<Integer> list) {

        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < list.size(); ++i) {

            Integer num = list.get(i);

            if (numMap.containsKey(num)) {
                numMap.remove(num);
            } else {
                numMap.put(num, num);
            }
        }

        return (Integer) numMap.keySet().toArray()[0];
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        List<Integer> testList = Arrays.asList(1, 1, 2, 2, 3);
        Integer ret = singleNumber.getSingleNumber(testList);
        System.out.println("The return is = " + ret);
    }

}
