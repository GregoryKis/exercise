package com.exercise.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidSudoku {

    public boolean validate(String[][] arr) {
        boolean ans = true;

        for (int i = 0; ans && i < 9; ++i) {
            System.out.println(Arrays.asList(arr[i]));
            ans = ans && validateNine(arr[i]);
        }

        for (int i = 0; ans && i < 9; ++i) {
            String[] a = new String[9];
            for (int h = 0; h < 9; ++h) {
                a[h] = arr[h][i];
            }
            System.out.println(Arrays.asList(a));
            ans = ans && validateNine(a);
        }

        for (int x = 0; ans && x < 3; ++x) {
            for (int y = 0; ans && y < 3; ++y) {
                String[] a = buildArrFromSquare(arr, x, y);
                for (int t = 0; t < 9; ++t) {
                    if (a[t] == null) {
                        System.out.println("row=" + x + ", column=" + y);
                    }
                }
                ans = ans && validateNine(a);
            }
        }
        return ans;
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

    private boolean validateNine(String[] arr) {
        Map<Integer, Boolean> nine = getNineMap();

        for (String s : arr) {
            if (!".".equals(s)) {
                int val = Integer.parseInt(s);
                if (nine.get(val)) {
                    nine.put(val, false);
                } else {
                    return false;
                }
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
        ValidSudoku validSudoku = new ValidSudoku();
        String arr1[][] = {
                {"5", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                {".", "9", "8", ".", ".", ".", ".", "6", "."},
                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                {".", ".", ".", ".", "8", ".", ".", "7", "9"}
        };
        boolean isValid1 = validSudoku.validate(arr1);
        System.out.println("The return is = " + isValid1);

        String arr2[][] = {
                {"8", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                {".", "9", "8", ".", ".", ".", ".", "6", "."},
                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                {".", ".", ".", ".", "8", ".", ".", "7", "9"}
        };
        boolean isValid2 = validSudoku.validate(arr2);
        System.out.println("The return is = " + isValid2);
    }

}
