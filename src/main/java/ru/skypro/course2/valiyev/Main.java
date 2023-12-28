package ru.skypro.course2.valiyev;

import ru.skypro.course2.valiyev.IntegerList.TestSpeedSortMethods.TestSpeedSortMethods;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testing sort methods!\n");

        TestSpeedSortMethods testSpeedSortMethods = new TestSpeedSortMethods();

        System.out.println("Bubble sort!");
        long start = System.currentTimeMillis();
        testSpeedSortMethods.bubbleSort();
        System.out.println(System.currentTimeMillis() - start);
        System.out.println();

        System.out.println("Selection sort!");
        start = System.currentTimeMillis();
        testSpeedSortMethods.selectionSort();
        System.out.println(System.currentTimeMillis() - start);
        System.out.println();

        System.out.println("Insertion sort!");
        start = System.currentTimeMillis();
        testSpeedSortMethods.insertionSort();
        System.out.println(System.currentTimeMillis() - start);
        System.out.println();
    }
}