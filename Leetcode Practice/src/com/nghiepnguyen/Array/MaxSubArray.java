package com.nghiepnguyen.Array;

import java.util.Arrays;
import java.util.List;

public class MaxSubArray {
    public static int maxSubArray(final List<Integer> A) {
        if (A.size() == 0) return 0;
        int max = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += A.get(j);
            }
            if (sum > max)
                max = sum;
        }
        return max;
    }


    public static void main(String[] args) {
        List<Integer> lst = Arrays.asList(-2, 1, -3, 3, -1, 2, 1, -5, 4);
        System.out.print(maxSubArray(lst));
    }
}
