package org.icims.dsa.logical;

// Write a program to toggle a bit a position = “pos” in a number “n”.

public class BitToggler {

    // Function to toggle the bit at a specified position in a number
    static int toggleBit(int n, int pos) {
        // Create a Bit mask with the bit at the specified position set to 1
        int bitMask = 1 << pos;

        // Toggle the bit at the specified position using XOR (^) operator
        return n ^ bitMask;
    }

    public static void main(String[] args) {
        int num = 10; // Number to toggle a bit in (example)
        int position = 2; // Bit position to toggle (example)

        // Output the original number
        System.out.println("Original number: " + num);

        // Toggle the bit at the specified position
        int result = toggleBit(num, position);

        // Output the result after toggling the bit
        System.out.println("Number after toggling bit at position " + position + ": " + result);
    }
}

//Explanation
/**
 * 10= 1010
 * bitmask = 1<<2 = 0100
 * 
 * 1010 ^(xor)
 * 0100
 * ====
 * 1110= 14
 * 
 */
