package org.icims.dsa.logical;


public class NumberConverter {

    // Function to convert a decimal number to binary using bit manipulation
    static String decimalToBinary(int number) {
        StringBuilder binary = new StringBuilder();

        // Iterate through each bit of the number
        for (int i = 31; i >= 0; i--) {
            // Shift the number by 'i' positions and check if the result is 1 or 0
            int bit = (number >> i) & 1;
            // Append the bit to the binary string
            binary.append(bit);
        }

        // Remove leading zeros
        int startIndex = 0;
        while (startIndex < binary.length() && binary.charAt(startIndex) == '0') {
            startIndex++;
        }
        if (startIndex == binary.length()) {
            return "0"; // if the number is 0
        }
        return binary.substring(startIndex);
    }

    // Function to convert a binary number to decimal using bit manipulation
    static int binaryToDecimal(String binary) {
        int decimal = 0;

        // Iterate through each character of the binary string
        for (int i = 0; i < binary.length(); i++) {
            // Convert the character to its numeric value
            int digit = binary.charAt(i) - '0';
            // Shift the current decimal value by one position to the left and add the current bit
            decimal = (decimal << 1) | digit;
        }

        return decimal;
    }

    public static void main(String[] args) {
        int decimalNumber = 45; // Example decimal number
        String binaryNumber = "101101"; // Example binary number

        // Convert decimal to binary
        String binaryResult = decimalToBinary(decimalNumber);
        System.out.println(decimalNumber + " in binary: " + binaryResult);

        // Convert binary to decimal
        int decimalResult = binaryToDecimal(binaryNumber);
        System.out.println(binaryNumber + " in decimal: " + decimalResult);
    }
}

