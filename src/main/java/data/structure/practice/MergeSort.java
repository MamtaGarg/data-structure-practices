package data.structure.practice;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 45, 28, 12, 56, 90, 19, 34 };
		System.out.print("Before Sorting : ");
		printArr(arr);
		mergeSort(arr, 0, arr.length - 1);
		System.out.print("\nAfter Sorting : ");
		printArr(arr);
	}

	private static void printArr(int[] arr) {
		for (int index = 0; index < arr.length; index++) {
			System.out.print(arr[index] + "  ");
		}
	}

	public static void mergeSort(int[] arr, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		int n1 = mid - low + 1;
		int n2 = high - mid;
		int[] leftArr = new int[n1];
		int[] rightArr = new int[n2];
		int i = 0, j = 0;
		int k = low;
		for (int index = 0; index < n1; index++) {
			leftArr[index] = arr[low + index];
		}
		for (int index = 0; index < n2; index++) {
			rightArr[index] = arr[mid + 1 + index];
		}
		while (i < n1 && j < n2) {
			if (leftArr[i] <= rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			} else {
				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			arr[k] = leftArr[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = rightArr[j];
			j++;
			k++;
		}
	}
}
