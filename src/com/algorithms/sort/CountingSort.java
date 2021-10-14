package com.algorithms.sort;

import java.util.Arrays;

import com.common.utils.MyArrayUtils;
import com.common.utils.PrintUtils;

public class CountingSort {

	public static void main(String[] args) {
		// int[][] arr = { 2, 5, 9, 8, 2, 8, 7, 10, 4, 3 };
		for (int i = 0; i < MyArrayUtils.getPositiveArrays().length; i++) {
			int[] arr = MyArrayUtils.getPositiveArrays()[i];
			countingSort(arr);
		}
		countingSortWithZeroAllowed();
	}

	static int getHighestValue(int[] arr) {
		int temp = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (temp < arr[i]) {
				temp = arr[i];
			}
		}
		return temp;
	}

	static void countingSort(int[] arr) {
		System.out.print("Unsorted Array : ");
		PrintUtils.printArrays(arr);
		
		//we take highest value from the array suppose 10
		//the we create array of 10 zeroes
		int highest = getHighestValue(arr);
		int[] countingArr = new int[highest];
		int index;

		Arrays.fill(countingArr, 0);
		//for every value in arr we increment counting array's
		//that particular index/index -1 
		for (int i = 0; i < arr.length; i++) {
			index = arr[i] - 1;
			countingArr[index]++;
		}
		//PrintUtils.printArrays(arr);
		//PrintUtils.printArrays(countingArr);

		//then we traverse through counting array and
		//insert the each index of counting array until 
		// counting array[index] becomes zero
		int arrIndex = 0;
		for (int i = 0; i < countingArr.length; i++) {
			while (countingArr[i] > 0) {
				arr[arrIndex++] = i + 1;
				countingArr[i]--;
			}
		}
		System.out.print("Sorted Array   : ");
		PrintUtils.printArrays(arr);
	}
	
	//above algo supports only positive integers
	//but this algo supports 0 as well
	static void countingSortWithZeroAllowed() {
		 int[] arr = { 0, 5, 9, 8, 0, 8, 7, 10, 4, 3,1,2 };
		 System.out.print("Unsorted Array : ");
		 PrintUtils.printArrays(arr);
		 int highest = getHighestValue(arr);
			int[] countingArr = new int[highest+1];
			int index;

			Arrays.fill(countingArr, 0);
			for (int i = 0; i < arr.length; i++) {
				index = arr[i];
				countingArr[index]++;
			}			

			int arrIndex = 0;
			for (int i = 0; i < countingArr.length; i++) {
				while (countingArr[i] > 0) {
					arr[arrIndex++] = i;
					countingArr[i]--;
				}
			}
			System.out.print("Sorted Array   : ");
			PrintUtils.printArrays(arr);
	}

}
