package com.basic.Java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FindAvgAge {

    private static void findAvgAgefromList(int[] age) {
        Double avgage = Arrays.stream(age).average().orElse(0);
        System.out.println("Average age is : " + avgage);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of persons to be added into the list");
        int size = sc.nextInt();
        int[] age = new int[size];
        System.out.println("Enter the age of each person");
        for (int i = 0; i < size; i++)
            age[i] = sc.nextInt();
        findAvgAgefromList(age);

       List<Person> persons=  Arrays.asList(new Person("Manju",30),
                new Person("Nandhu", 28),
                new Person("Naresh", 31));
        findAvgAgefromList(persons);
    }

    private static void findAvgAgefromList(List<Person> persons) {
        double average = persons.stream().mapToInt(Person::getAge).average().orElse(-1);
        System.out.println("Average age is : "+average);
    }
}

class Person{
    String name;
    int age;
    Person(){}
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}