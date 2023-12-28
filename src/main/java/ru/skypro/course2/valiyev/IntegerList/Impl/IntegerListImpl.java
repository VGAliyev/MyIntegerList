package ru.skypro.course2.valiyev.IntegerList.Impl;

import ru.skypro.course2.valiyev.IntegerList.IntegerList;
import ru.skypro.course2.valiyev.IntegerList.exception.IntegerListIndexOutOfRangeException;
import ru.skypro.course2.valiyev.IntegerList.exception.IntegerListItemNullException;
import ru.skypro.course2.valiyev.IntegerList.exception.IntegerListNullException;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    private Integer[] integerArray;
    private int listSize;

    public IntegerListImpl() {
        this.integerArray = new Integer[10];
        this.listSize = 0;
    }

    @Override
    public Integer add(Integer item) {
        validateItem(item);
        if (listSize >= integerArray.length) {
            increaseArray();
        }
        listSize++;
        return integerArray[listSize - 1] = item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        if (listSize >= integerArray.length) {
            increaseArray();
        }
        if (!(index == listSize - 1)) {
            for (int i = listSize; i > index; i--) {
                integerArray[i] = integerArray[i - 1];
            }
        }
        listSize++;
        return integerArray[index] = item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        return integerArray[index] = item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer tmp = integerArray[index];
        if (!(index == listSize - 1)) {
            for (int i = index; i < listSize; i++) {
                integerArray[i] = integerArray[i + 1];
            }
        }
        listSize--;
        if (integerArray.length > 10 && integerArray.length > listSize * 1.3F) {
            decreaseArray();
        }
        return tmp;
    }

    @Override
    public boolean contains(Integer item) {
        validateItem(item);
        sort();
        return binarySearch(item);
    }

    @Override
    public int indexOf(Integer item) {
        validateItem(item);
        for (int i = 0; i < listSize; i++) {
            if (integerArray[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        validateItem(item);
        for (int i = listSize - 1; i >= 0; i--) {
            if (integerArray[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return this.integerArray[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        validateIntegerList(otherList);
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return listSize;
    }

    @Override
    public boolean isEmpty() {
        return listSize == 0;
    }

    @Override
    public void clear() {
        listSize = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(this.integerArray, listSize);
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= listSize) {
            throw new IntegerListIndexOutOfRangeException("Index out of range!");
        }
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new IntegerListItemNullException("Item cannot be null!");
        }
    }

    private void validateIntegerList(IntegerList integerList) {
        if (integerList == null) {
            throw new IntegerListNullException("IntegerList cannot be null!");
        }
    }

    private void sort() {
        integerArray = Arrays.copyOf(integerArray, listSize); // decrease array length to listSize
        for (int i = 0; i < integerArray.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < integerArray.length; j++) {
                if (integerArray[j] < integerArray[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            int tmp = integerArray[i];
            integerArray[i] = integerArray[minElementIndex];
            integerArray[minElementIndex] = tmp;
        }
    }

    private boolean binarySearch(Integer item) {
        int min = 0;
        int max = integerArray.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (item.equals(integerArray[mid])) {
                return true;
            }
            if (item < integerArray[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    /**
     * Increase Integer[] array with a size 30% larger than the previous one
     */
    private void increaseArray() {
        integerArray = Arrays.copyOf(integerArray, (int) (listSize * 1.3F));
    }

    private void decreaseArray() {
        integerArray = Arrays.copyOf(integerArray, listSize + 10);
    }
}
