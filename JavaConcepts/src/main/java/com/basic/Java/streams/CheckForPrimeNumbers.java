package com.basic.Java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CheckForPrimeNumbers {

    private void FindPrimeNumbers(int[] arr) {
        System.out.println("Prime Numbers from the list are ");
 Arrays.stream(arr).filter(this::CheckPrime).forEach(System.out::println);
    }
    private boolean CheckPrime(int x){
        int counter =0;
        for(int i =1;i<= x;i++){
            if(x%i ==0)
                counter++;
        }
        if(counter == 2)
            return true;
        else
            return false;
    }
    public static void main(String[] args){
        CheckForPrimeNumbers obj = new CheckForPrimeNumbers();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the elements of an array");
        for (int i =0;i<size;i++){
            arr[i] = sc.nextInt();
        }
        obj.FindPrimeNumbers(arr);
    }


}
