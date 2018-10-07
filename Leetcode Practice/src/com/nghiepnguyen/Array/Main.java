package com.nghiepnguyen.Array;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{3, 4, 5, 6, 1, 2};
        int value = privotedBinarySearch(a, a.length, 6);
        System.out.print(value);
    }

    public static void rotateArray(int[] array, int d, int n) {
        for (int i = 0; i < d; i++) {
            int temp = array[0];
            for (int j = 0; j < n - 1; j++) {
                array[j] = array[j + 1];
            }
            array[n - 1] = temp;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + "\t");
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public static void rotateArray2(int[] array, int d, int n) {
        for (int i = 0; i < gcd(d, n); i++) {
            int temp = array[0];
            int j = i, k;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                array[j] = array[k];
                j = k;
            }
            array[j] = temp;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + "\t");
        }
    }

    static int privotedBinarySearch(int[] a, int n, int k) {
        int privot = findPrivot(a, 0, n - 1);
        if (privot == -1)
            return binarySearch(a, 0, n - 1, k);
        if (k == a[privot])
            return privot;
        if (a[privot] > k)
            return binarySearch(a, privot + 1, n - 1, k);
        return binarySearch(a, 0, privot - 1, k);
    }

    static int binarySearch(int[] a, int l, int r, int k) {
        if (l >= r)
            return -1;
        int m = (l + r) / 2;
        if (a[m] == k)
            return m;
        if (a[m] < k)
            return binarySearch(a, l, m - 1, k);
        return binarySearch(a, m + 1, r, k);
    }

    static int findPrivot(int[] a, int l, int r) {
        if (l > r)
            return -1;
        if (l == r)
            return l;
        int m = (l + r) / 2;
        if (m < r && a[m] > a[m + 1])
            return m;
        if (m > l && a[m] < a[m - 1])
            return m - 1;
        if (a[l] >= a[m])
            return findPrivot(a, l, m - 1);
        return findPrivot(a, m + 1, r);
    }

    static int binarySearchRotateArray(int[] a, int l, int r, int k) {
        if (l > r)
            return -1;
        int m = (l + r) / 2;
        if (a[m] == k)
            return m;
        if (a[l] <= a[m]) {
            if (k >= a[l] && k <= a[m])
                return binarySearchRotateArray(a, l, m - 1, k);
            return binarySearchRotateArray(a, m + 1, r, k);
        }
        if (k >= a[m] && k <= a[r])
            return binarySearchRotateArray(a, m + 1, r, k);
        return binarySearchRotateArray(a, l, m - 1, k);
    }

//    public static void main(String[] args) {
//        int[] a = new int[]{3, 4, 5, 6, 1, 2};
//        int value = binarySearchRotateArray(a, 0, a.length, 1);
//        System.out.print(value);
//    }
}
