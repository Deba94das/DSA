package org.icims.dsa.logical;

// Write a program to find if a number is a power of 2 or not.
// Note- Using Bitwise Operator
public class PowerOfTwoChecker {

    // Function to check if a number is a power of 2
    static boolean isPowerOfTwo(int n) {
        // A number is a power of 2 if and only if it has exactly one bit set in its binary representation
        // So, we can use bitwise AND to check if n & (n - 1) is 0
        // If n & (n - 1) is 0, then n is a power of 2
        // Otherwise, it's not a power of 2

        // Return true if n is greater than 0 and n & (n - 1) is 0
        return (n > 0) && ((n & (n - 1)) == 0);
    }

    public static void main(String[] args) {
        int num = 16; // Change this number to test different cases
        if (isPowerOfTwo(num)) {
            System.out.println(num + " is a power of 2.");
        } else {
            System.out.println(num + " is not a power of 2.");
        }
    }
}


// Explanation
/**
 * 16= 10000(In binary)
 * 15= 1111
 * 
 * 10000 &
 * 01111
 * ======
 * 00000 = 0
 */
