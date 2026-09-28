package com.basic.Java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConcatStrings {
    public static void main(String[] args){
        List<String> words = Arrays.asList("Stream", "API", "is", "powerful");
        String concatenated = words.stream()
                .reduce("", (s1, s2) -> s1 + " " + s2).trim();
        System.out.println(concatenated);
    }
}
