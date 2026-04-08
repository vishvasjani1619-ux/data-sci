package com.crud.project.test;

public class PrimeCheck {
    public static void main(String[] args) {
        int num = 7;
        boolean isPrime = true;

        if (num <= 1) isPrime = false;

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }

        System.out.println(isPrime ? "Prime" : "Not Prime");
    }

}
