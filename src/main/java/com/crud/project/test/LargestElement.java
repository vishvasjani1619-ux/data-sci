package com.crud.project.test;

public class LargestElement {
    public static void main(String[] args) {
        int[] arr = {10, 25, 5, 40, 15};
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }



        System.out.println(max);
    }
}
