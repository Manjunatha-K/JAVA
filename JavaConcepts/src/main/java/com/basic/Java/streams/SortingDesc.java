package com.basic.Java.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SortingDesc {
    private static void sortDesc(int[] arr){
        Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).forEach(System.out::println);
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
        sortDesc(arr);
    }
}
