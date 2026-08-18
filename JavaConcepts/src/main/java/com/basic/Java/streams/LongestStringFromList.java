package com.basic.Java.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

public class LongestStringFromList {

    private static void findLongest(String[] arr) {
        Optional<String> longest =  Arrays.stream(arr).max(Comparator.comparingInt(String::length));
        System.out.println("longest is : "+longest.get());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array");
        int size = sc.nextInt();
        String[] arr = new String[size];
        System.out.println("Enter the elements");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.next();
        }
        findLongest(arr);
    }

}
