package com.basic.Java.streams;

import java.util.Optional;

public class FindNonRepeatedCharacters {
    public static void main(String[] args){
        String input = "swiss";
        Optional<Character> firstNonRepeated = input.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> input.indexOf(c) == input.lastIndexOf(c))
                .findFirst();
        System.out.println(firstNonRepeated.orElse(null));
    }
}
