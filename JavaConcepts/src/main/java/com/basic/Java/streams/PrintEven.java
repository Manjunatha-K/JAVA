package com.basic.Java.streams;

import java.util.Arrays;
import java.util.Scanner;

public class PrintEven {
    private static void filterEven(int[] arr) {
        System.out.println("Even numbers are ");
        Arrays.stream(arr).filter(i -> i % 2 == 0).forEach(System.out::println);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++){
            System.out.println("Enter the "+i+"th value");
            arr[i] = sc.nextInt();
            }
        filterEven(arr);
    }
}
