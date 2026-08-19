package com.basic.Java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RemoveDuplicatesPreserveOrder {
    private static void removeDuplicates(int[] arr) {
        List<Integer> distinctArray = Arrays.stream(arr).boxed().distinct().toList();
        System.out.println("After removing duplicates");
        distinctArray.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the elements");
        for (int i = 0; i < size; i++)
            arr[i] = sc.nextInt();
        removeDuplicates(arr);
    }
}
