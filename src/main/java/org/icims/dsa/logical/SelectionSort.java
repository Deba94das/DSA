package org.icims.dsa.logical;

public class SelectionSort {

	public static void main(String[] args) {

		int arr[]= {7,8,3,1,2,0,5,-1};
		System.out.print("Before sort the array is: ");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		//bubble sort O(n^2)
		for(int i=0;i<arr.length-1;i++) {// n-1
			int smallest=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[smallest]>arr[j]) {
					smallest=j;
				}
			}
			int temp=arr[smallest];
			arr[smallest]=arr[i];
			arr[i]=temp;
		}
		printArray(arr);
	}

	private static void printArray(int[] arr) {
		System.out.print("After sort the array Using selection sort is: ");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
