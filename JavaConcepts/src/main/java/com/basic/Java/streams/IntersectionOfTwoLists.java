package com.basic.Java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntersectionOfTwoLists {
    private static void findintersection(int[] arr, int[] arr2) {

        List<Integer> intersection = Arrays.stream(arr).
                filter(Arrays.stream(arr2).boxed().toList()::contains).boxed().toList();
        System.out.println("Intersection of two streams is ");
        intersection.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 8, 10};
        findintersection(arr, arr2);
    }
}
