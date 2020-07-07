package com.nghiepnguyen.Grokking;

public class FindMinSubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 2, 3, 2};
        System.out.println("max sum sub: " + findMinSum(arr, 7));
    }

    private static int findMinSum(int[] arr, int s) {
        int sum = 0;
        int size = 0;
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            size++;
            while (sum >= s) {
                sum -= arr[start];
                start++;
                size = Math.min(size, i - start + 1);
            }
        }
        return size;
    }

}

