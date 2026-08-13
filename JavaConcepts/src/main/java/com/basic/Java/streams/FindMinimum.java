package com.basic.Java.streams;

import java.util.Arrays;
import java.util.Scanner;

public class FindMinimum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the elements");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        findMinimum(arr);
    }

    private static void findMinimum(int[] arr) {
        System.out.println("Minimum element is : "+ Arrays.stream(arr).min().getAsInt());
    }
}
