package com.nghiepnguyen.Grokking;

public class MaxSumSubArrayOfSizek {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 1, 3, 2};
        System.out.println("max sum sub: " + findSum2(arr, 3));
    }

    /**
     * better approach using slide window
     * */
    private static int findSum2(int[] arr, int k) {
        int maxSum = 0;
        int windowSum = 0;
        int windowStart = 0;
        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i];
            System.out.println("sub sum: " + windowSum);
            if (i >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return maxSum;
    }

    /**
     * brute force solution
     * */
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

