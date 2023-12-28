package ru.skypro.course2.valiyev.IntegerList.TestSpeedSortMethods;

import java.util.Arrays;
import java.util.Random;

public class TestSpeedSortMethods {
    Integer[] testArray_1;
    Integer[] testArray_2;
    Integer[] testArray_3;
    Random random;

    public TestSpeedSortMethods() {
        this.testArray_1 = new Integer[100_000];
        this.random = new Random();
        for (int i = 0; i < testArray_1.length; i++) {
            testArray_1[i] = random.nextInt(100_000);
        }
        this.testArray_2 = Arrays.copyOf(testArray_1, testArray_1.length);
        this.testArray_3 = Arrays.copyOf(testArray_1, testArray_1.length);
    }

    public void bubbleSort() {
        for (int i = 0; i < testArray_1.length - 1; i++) {
            for (int j = 0; j < testArray_1.length - 1 - i; j++) {
                if (testArray_1[j] > testArray_1[j + 1]) {
                    int tmp = testArray_1[j];
                    testArray_1[j] = testArray_1[j + 1];
                    testArray_1[j + 1] = tmp;
                }
            }
        }
    }

    public void selectionSort() {
        for (int i = 0; i < testArray_2.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < testArray_2.length; j++) {
                if (testArray_2[j] < testArray_2[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            int tmp = testArray_2[i];
            testArray_2[i] = testArray_2[minElementIndex];
            testArray_2[minElementIndex] = tmp;
        }
    }

    public void insertionSort() {
        for (int i = 1; i < testArray_3.length; i++) {
            int temp = testArray_3[i];
            int j = i;
            while (j > 0 && testArray_3[j - 1] >= temp) {
                testArray_3[j] = testArray_3[j - 1];
                j--;
            }
            testArray_3[j] = temp;
        }
    }
}
