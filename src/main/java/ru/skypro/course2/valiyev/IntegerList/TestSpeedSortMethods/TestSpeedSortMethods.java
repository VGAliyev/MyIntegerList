package ru.skypro.course2.valiyev.IntegerList.TestSpeedSortMethods;

import java.util.Arrays;
import java.util.Random;

public class TestSpeedSortMethods {
    Integer[] testArray_1;
    Integer[] testArray_2;
    Integer[] testArray_3;
    Integer[] testArray_4;
    Integer[] testArray_5;
    Random random;

    public TestSpeedSortMethods() {
        this.testArray_1 = new Integer[100_000];
        this.random = new Random();
        for (int i = 0; i < testArray_1.length; i++) {
            testArray_1[i] = random.nextInt(100_000);
        }
        this.testArray_2 = Arrays.copyOf(testArray_1, testArray_1.length);
        this.testArray_3 = Arrays.copyOf(testArray_1, testArray_1.length);
        this.testArray_4 = Arrays.copyOf(testArray_1, testArray_1.length);
        this.testArray_5 = Arrays.copyOf(testArray_1, testArray_1.length);
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

    public void quickSort() {
        quickSort(testArray_4, 0, testArray_4.length - 1);
    }

    public void mergeSort() {
        mergeSort(testArray_5);
    }

    private void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                swapElements(arr, i, j);
            }
        }
        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private void swapElements(Integer[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private void mergeSort(Integer[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        Integer[] left = new Integer[mid];
        Integer[] right = new Integer[arr.length - mid];
        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private void merge(Integer[] arr, Integer[] left, Integer[] right) {
        int mainP = 0;
        int leftP = 0;
        int rightP = 0;
        while (leftP < left.length && rightP < right.length) {
            if (left[leftP] <= right[rightP]) {
                arr[mainP++] = left[leftP++];
            } else {
                arr[mainP++] = right[rightP++];
            }
        }
        while (leftP < left.length) {
            arr[mainP++] = left[leftP++];
        }
        while (rightP < right.length) {
            arr[mainP++] = right[rightP++];
        }
    }
}
