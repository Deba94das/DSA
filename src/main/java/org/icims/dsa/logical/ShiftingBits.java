package org.icims.dsa.logical;

import java.util.Scanner;

public class ShiftingBits {

	public static void main(String[] args) {
		int number=5;// 0101
		int position=1;
		
		int bitMask=1<<position;
		Scanner sc= new Scanner(System.in);
		int operation=sc.nextInt();
		//getBits(number,position);
		//setBits(number,position);
		//clearBits(number,position);
		updateBits(number,bitMask,operation);
		
		
	}

	private static void updateBits(int number, int bitMask,int operation) {
		if(operation==1) {
			//setBit
			int newNumber=bitMask |number;
			System.out.println("new Number is:"+ newNumber);
		}else {
			int notOfBitMask= ~bitMask;
			
			int newNumber= notOfBitMask & number;
			System.out.println("new number is:"+newNumber);
		}
		
		
	}


	private static void clearBits(int number, int position) {
		int bitMask=1<<position;
		int notOfBitMask= ~bitMask;
		
		int newNumber= notOfBitMask &number;
		System.out.println("new Number is: "+newNumber);
	}

	private static void setBits(int number, int position) {
		int bitMask=1<<position;
		 
		int newNumber=bitMask | number;
		System.out.println("new Number is: "+newNumber);
	}

	private static void getBits(int number, int position) {
		int bitMask=1<<position;
		
		if((bitMask & number) == 0) {
			System.out.println("bit was zero");
		}else {
			System.out.println("bit was one");
		}
	}

}
