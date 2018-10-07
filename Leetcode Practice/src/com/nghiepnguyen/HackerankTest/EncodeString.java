package com.nghiepnguyen.HackerankTest;

import java.util.HashMap;
import java.util.Map;

public class EncodeString {
    public static void main(String[] args) {
        // write your code here
        System.out.print(encode("hello world"));
    }

    static char[] vowelsArr = new char[]{'a', 'i', 'u', 'e', 'o'};
    static Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('a', 1);
        put('e', 2);
        put('i', 3);
        put('o', 4);
        put('u', 5);
    }};


    public static String encode(String stringToEncode) {
        String result = "";
        char[] input = stringToEncode.toLowerCase().toCharArray();
        for (int i = 0; i < input.length; i++) {
            if (isVowel(input[i])) {
                result += map.get(input[i]);
            } else if (input[i] == 'y') {
                result += ' ';
            } else if (input[i] == ' ') {
                result += 'y';
            } else if (Character.isLetter(input[i])) {
                result += (char) (input[i] - 1);
            } else if (Character.isDigit(input[i])) {
                int j = i;
                String revert = "";
                while (j < input.length && Character.isDigit(input[j])) {
                    revert = input[j] + revert;
                    j++;
                }
                result += revert;
                i = j - 1;
            } else {
                result += input[i];
            }

        }
        return result;
    }

    private static boolean isVowel(char c) {
        boolean isVowel = false;
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            isVowel = true;
        return isVowel;
    }
}
