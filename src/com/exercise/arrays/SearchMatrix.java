package com.exercise.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (target < matrix[0][0])
            return false;

        for (int rowNum = 0; rowNum < matrix.length; rowNum++) {

            if (target >= matrix[rowNum][0] && target <= matrix[rowNum][matrix[rowNum].length - 1]) {
                for (int i = 0; i < matrix[rowNum].length; i++) {
                    if (target == matrix[rowNum][i])
                        return true;
                }
                return false;
            }
        }

        return false;
    }

    private boolean isTargetInRow(int[] row, int target) {

        for (int i = 0; i < row.length; i++) {
            if (target == row[i])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
        int arr1[][] = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60},
        };

        int[] resGood = new int[]{1, 7, 10, 20, 23, 60};
        for (int i = 0; i < resGood.length; i++) {
            boolean isFound = searchMatrix.searchMatrix(arr1, resGood[i]);
            System.out.println("The return is = " + isFound + ", expected = true");
        }

        int[] resBad = new int[]{-1, 61};
        for (int i = 0; i < resBad.length; i++) {
            boolean isFound = searchMatrix.searchMatrix(arr1, resBad[i]);
            System.out.println("The return is = " + isFound + ", expected = false");
        }
    }

}
