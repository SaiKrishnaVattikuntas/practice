package org.example;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Reverse a String
        System.out.println("Enter a String to Reverse");
        Scanner scanner = new Scanner(System.in);
        String reverseString = scanner.next();
       System.out.println("Reversed String is " + reverseString(reverseString));
    }

    private static String reverseString(String reverseString) {
        if(reverseString== null || reverseString.length()==1)
            return reverseString;
        char[] chars = reverseString.toCharArray();
        int left =0;
        int right = chars.length-1;
        while(left < right){
            char temp = chars[left];
            chars[left] = chars [right];
            chars[right] = temp;
            right --;
            left ++;
        }
        return new String(chars);
    }
}