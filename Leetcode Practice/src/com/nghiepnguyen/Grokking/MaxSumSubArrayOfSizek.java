package com.nghiepnguyen.Grokking;

public class MaxSumSubArrayOfSizek {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 1, 3, 2};
        System.out.println("max sum sub: " + findSum(arr, 3));
    }

    private static int findSum(int[] arr, int k) {
        int sum = 0;
        for (int i = 0; i <= arr.length - k; i++) {
            int subSum = 0;
            for (int j = i; j < i + k; j++) {
                subSum += arr[j];
            }
            System.out.println("sub sum: " + subSum);
            if (subSum > sum) {
                sum = subSum;
            }
        }
        return sum;
    }

}

