package com.exercise.arrays;

import java.util.Arrays;

public class BestTimeBuySellStockII {


    public Integer getBestOutcome(Integer[] arr) {

        Integer bestResult = 0;

        boolean isBoughtStock = false;

        Integer priceAtStart = 0;
        for (int pCurr = 0, pNext = 1; pCurr < arr.length && pNext < arr.length; ++pCurr, ++pNext) {

            if (pNext == arr.length - 1) {
                if (isBoughtStock) {
                    isBoughtStock = false;
                    bestResult += arr[pCurr] - priceAtStart;
                }
                break;
            }

            if (isBoughtStock) {

                if (arr[pNext] < arr[pCurr]) {
                    isBoughtStock = false;
                    bestResult += arr[pCurr] - priceAtStart;
                }

            } else {

                if (arr[pNext] > arr[pCurr]) {
                    isBoughtStock = true;
                    priceAtStart = arr[pCurr];
                }

            }

        }
        return bestResult;

    }


    public static void main(String[] args) {
        BestTimeBuySellStockII timeBuySellStockII = new BestTimeBuySellStockII();
        Integer arr1[] = {7, 1, 5, 3, 6, 4};//7
        Integer arr2[] = {1, 2, 3, 4, 5};//4
        Integer arr3[] = {7, 6, 4, 3, 1};//0
        Integer bestOutcome1 = timeBuySellStockII.getBestOutcome(arr1);
        Integer bestOutcome2 = timeBuySellStockII.getBestOutcome(arr2);
        Integer bestOutcome3 = timeBuySellStockII.getBestOutcome(arr3);
        System.out.println("The return is = " + bestOutcome1);
        System.out.println("The return is = " + bestOutcome2);
        System.out.println("The return is = " + bestOutcome3);
    }


}
