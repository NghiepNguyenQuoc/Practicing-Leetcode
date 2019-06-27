package com.nghiepnguyen.Array;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> lst = new ArrayList<Integer>();
        int m = matrix.length;
        if (m == 0)
            return null;
        int n = matrix[0].length;

        int i = 0, k = 0, l = 0;
        while (k < m && l < n) {
            for (i = l; i < n; ++i)
                lst.add(matrix[k][i]);
            k++;

            for (i = k; i < m; ++i)
                lst.add(matrix[i][n - 1]);
            n--;
            if (l < n) {
                for (i = n - 1; i >= l; --i) {
                    lst.add(matrix[m - 1][i]);
                }
                m--;
            }

            if (k < m) {
                for (i = m - 1; i >= k; --i) {
                    lst.add(matrix[i][l]);
                }
                l++;
            }
        }
        return lst;
    }

    public static void main(String[] args) {
        int a[][] = {{1}};

        System.out.print(spiralOrder(a).toString());
    }
}
