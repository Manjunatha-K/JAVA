package com.basic.Java.streams;

import java.util.Arrays;
import java.util.Scanner;

public class Sorting {
    private static void sort(int[] arr){
        Arrays.stream(arr).sorted().forEach(System.out::println);
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
        sort(arr);
    }
}
