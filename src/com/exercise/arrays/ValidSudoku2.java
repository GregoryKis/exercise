package com.exercise.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidSudoku2 {

    public boolean isValidSudoku(char[][] board) {
        // row validate
        for (int i = 0; i < 9; i++) {
            char[] list = new char[9];
            for (int j = 0; j < 9; j++) {
                list[j] = board[i][j];
            }
            if (!validateNine(list))
                return false;
        }

        //columns validate
        for (int i = 0; i < 9; i++) {
            char[] list = new char[9];
            for (int j = 0; j < 9; j++) {
                list[j] = board[j][i];
            }
            if (!validateNine(list))
                return false;
        }

        //3x3 validate
        for (int t = 0; t < 9; t++) {
            char[] list = new char[9];
            int index = 0;
            for (int i = (t % 3) * 3; i < (t % 3) * 3 + 3; i++) {
                for (int j = (t / 3) * 3; j < (t / 3) * 3 + 3; j++) {
                    list[index++] = board[i][j];
                }
            }

            if (!validateNine(list))
                return false;
        }

        return true;
    }

    private String[] buildArrFromSquare(String[][] arr, int row, int column) {
        String[] a = new String[9];
        int i = 0;
        for (int x = row * 3; x < row * 3 + 3; ++x) {
            for (int y = column * 3; y < column * 3 + 3; ++y) {
                a[i] = arr[x][y];
                ++i;
            }
        }
        System.out.println(Arrays.asList(a));
        return a;
    }

    private boolean validateNine(char[] list) {
        // all are 1-9 and '.'
        for (int i = 0; i < 9; i++) {
            char c = list[i];
            if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8' && c != '9' && c != '.')
                return false;
        }

        // all are different
        for (int i = 0; i < 9; i++) {
            char c = list[i];
            if (c == '.')
                continue;
            for (int j = 0; j < 9; j++) {
                if (i == j || list[j] == '.')
                    continue;
                if (c == list[j])
                    return false;
            }
        }

        return true;
    }

    private Map<Integer, Boolean> getNineMap() {
        Map<Integer, Boolean> nine = new HashMap<>();
        nine.put(1, true);
        nine.put(2, true);
        nine.put(3, true);
        nine.put(4, true);
        nine.put(5, true);
        nine.put(6, true);
        nine.put(7, true);
        nine.put(8, true);
        nine.put(9, true);
        return nine;
    }


    public static void main(String[] args) {
        ValidSudoku2 validSudoku = new ValidSudoku2();
        char arr1[][] = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean isValid1 = validSudoku.isValidSudoku(arr1);
        System.out.println("The return is = " + isValid1 + ", expected = true");

        char arr2[][] = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean isValid2 = validSudoku.isValidSudoku(arr2);
        System.out.println("The return is = " + isValid2 + ", expected = false");
    }

}
