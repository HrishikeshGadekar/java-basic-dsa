package org.javadsa.basicDataStructures;

import java.util.Arrays;

public class ArrayImpl {

    public int[] addElement(int[] array, int elementToAdd, int indexToAdd) {
        int[] arrayToReturn = new int[array.length + 1];
        for (int i = 0; i < array.length + 1; i++) {
            if (i == indexToAdd) {
                arrayToReturn[i] = elementToAdd;
            } else if (i < indexToAdd) {
                arrayToReturn[i] = array[i];
            } else {
                arrayToReturn[i] = array[i - 1];
            }
        }
        return arrayToReturn;
    }

    public int[] removeElement(int[] array, int elementToRemove) {
        int indexToRemove = this.searchElement(array, elementToRemove);
        if (indexToRemove == -1) {
            return array;
        }
        int[] arrayToReturn = new int[array.length - 1];
        boolean isElementRemoved = false;
        for (int i = 0; i < array.length; i++) {
            if (i == indexToRemove) {
                isElementRemoved = true;
            } else if (!isElementRemoved) {
                arrayToReturn[i] = array[i];
            } else {
                arrayToReturn[i - 1] = array[i];
            }
        }
        return arrayToReturn;
    }

    public int searchElement(int[] array, int elementToSearch) {
        int index = 0;
        for (int element : array) {
            if (element == elementToSearch) {
                return index;
            } else {
                index++;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        int[] array = {1, 3, 4, 6, 5, 3, 2, 6, 7, 9};
        System.out.println("The Array is: " + Arrays.toString(array));

        ArrayImpl arrayImpl = new ArrayImpl();

        array = arrayImpl.addElement(array, 21, 4);
        System.out.println("The Array after adding 21 at index 4 is: " + Arrays.toString(array));

        array = arrayImpl.addElement(array, 78, 0);
        System.out.println("The Array after adding 78 at index 0 is: " + Arrays.toString(array));

        array = arrayImpl.addElement(array, 56, 11);
        System.out.println("The Array after adding 56 at index 11 is: " + Arrays.toString(array));

        array = arrayImpl.removeElement(array, 6);
        System.out.println("The Array after removing 6 is: " + Arrays.toString(array));

        array = arrayImpl.removeElement(array, 78);
        System.out.println("The Array after removing 78 is: " + Arrays.toString(array));

        array = arrayImpl.removeElement(array, 5);
        System.out.println("The Array after removing 5 is: " + Arrays.toString(array));

        array = arrayImpl.removeElement(array, 9);
        System.out.println("The Array after removing 9 is: " + Arrays.toString(array));

        array = arrayImpl.removeElement(array, 60);
        System.out.println("The Array after removing 60 is: " + Arrays.toString(array));

        int index = arrayImpl.searchElement(array, 21);
        System.out.println("21 is present at index: " + index);

        int indexNotPresent = arrayImpl.searchElement(array, 212);
        System.out.println("212 is present at index: " + indexNotPresent);
    }

}
