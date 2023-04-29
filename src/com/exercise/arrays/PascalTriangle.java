package com.exercise.arrays;

import java.util.ArrayList;
 import java.util.List;

public class PascalTriangle {


    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ret = new ArrayList<>(rowIndex + 1);
        List<Integer> row = new ArrayList<>(1);
        row.add(1);
        ret.add(row);
        int rowLength = 1;
        for (int i = 1; i < rowIndex + 1; i++) {
            List<Integer> prev = ret.get(i - 1);
            row = new ArrayList<>();
            rowLength++;
            for (int j = 0; j < rowLength; j++) {
                if (j == 0 || j == rowLength - 1) {
                    row.add(1);
                    continue;
                }
                row.add(prev.get(j - 1) + prev.get(j));
            }
            System.out.println(row);
            ret.add(row);
        }
        return ret.get(rowIndex);
    }


    public static void main(String[] args) {
        PascalTriangle ex = new PascalTriangle();
        System.out.println(ex.getRow(6));
    }


}
