package data.structure.practice;

import java.util.Scanner;

public class FindKthSmallest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter total number of elements : ");
		int n = scanner.nextInt();
		System.out.println("Initialize Array!!");
		int[] arr = new int[n];
		System.out.println("Enter Array : ");
		for (int index = 0; index < n; index++) {
			arr[index] = scanner.nextInt();
		}
		System.out.println("Enter the kth element to be found : ");
		int k = scanner.nextInt();
		MergeSort mergeSort = new MergeSort();
		mergeSort.mergeSort(arr, 0, n-1);
		System.out.println(k + " smallest element is : " + arr[k-1]);
	}

}
