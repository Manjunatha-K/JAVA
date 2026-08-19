package com.basic.Java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MergeTwoSortedLists {

    private static void MergeTwoLists(int[] arr, int[] arr2) {
     List<Integer> merged= IntStream.concat(Arrays.stream(arr),Arrays.stream(arr2))
             .sorted().boxed().toList();
        System.out.println("Sorted list is ");
        merged.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1, 3, 5, 7, 9};
        int[] arr2 = {2, 4, 6, 8, 10};
        MergeTwoLists(arr, arr2);
    }

}
