package com.nghiepnguyen.Array;

import java.util.ArrayList;
import java.util.function.Consumer;

public class AddOneNumber {
    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        for (int i = A.size() - 1; i >= 0; i--) {
            if (A.get(i) < 9) {
                A.set(i, A.get(i) + 1);
                return A;
            }
            A.set(i, 0);
        }
        ArrayList<Integer> b = new ArrayList<Integer>();
        for (int i=0;i<A.size()+1;i++){
            b.add(0);
        }
        b.set(0,1);
        return b;
//        int a = 0, k = 0, greater = 0;
//        for (int i = A.size() - 1; i >= 0; i--) {
//            a += (Integer) A.get(i) * Math.pow(10, k++);
//        }
//        a++;
//        ArrayList<Integer> b = new ArrayList<Integer>();
//        while (a / 10 > 0){
//            b.add(a % 10);
//            a = a / 10;
//        }
//        b.add(a % 10);
//        return b;
    }


    public static void main(String[] args) {
        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(9);
        lst.add(9);
        lst.add(9);
        System.out.print(plusOne(lst).toString());
    }
}
