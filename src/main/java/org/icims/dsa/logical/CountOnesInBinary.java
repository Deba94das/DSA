package org.icims.dsa.logical;

//Write a program to count the number of 1’s in a binary representation of the number.
public class CountOnesInBinary {
    public static void main(String[] args) {
        int number = 156; // Change this number to test with different values
        int count = countOnes(number);
        System.out.println("Number of 1's in binary representation of " + number + ": " + count);
    }

    public static int countOnes(int num) {
        int count = 0;
        while (num != 0) {
            // Using bitwise AND operation to check if the last bit is 1
            // If it is, increment the count
            count += num & 1;
            // Right shifting the number by 1 bit to the right
            num >>= 1;
        }
        return count;
    }
}

/**
 * 156= 10011100
 * step-1: count= 0+ 10011100 & 1
 * 				= 0+ 0
 * 				=0
 * 10011100 >>1= 01001110
 * step-2: count= 0+ 01001110 & 1
 * 				= 0+ 0
 * 				=0
 * 01001110 >>1= 00100111
 * step-3: count= 0+ 00100111 & 1
 * 				= 0+ 1
 * 				=1
 * 00100111 >>1= 00010011
 * step-4: count= 1+ 00010011 & 1
 * 				= 1+ 1
 * 				=2
 * 00010011 >>1=00001001
 * step-5: count= 2+ 00001001 & 1
 * 				= 2+ 1
 * 				=3
 * 00001001 >>1= 00000100
 * step-6: count= 3+ 00000100 & 1
 * 				= 3+ 0
 * 				=3
 * 00000100>>1= 00000010
 * step-7: count= 3+ 00000010 & 1
 * 				= 3+ 0
 * 				=3
 * 00000010 >>1=00000001
 * step-8: count= 3+ 00000001 & 1
 * 				= 3+ 1
 * 				=4
 * 00000001 >>1=00000000
 * step-9: count= 00000000==0
 * 
 * 
 * 
*/
