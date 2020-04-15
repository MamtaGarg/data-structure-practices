package data.structure.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoronaInfection {

	public static void main(String[] args) {
		List<List<Boolean>> mat = new ArrayList<List<Boolean>>();
		int n = 3, m = 3;

		Scanner scanner = new Scanner(System.in);

		for (int row = 0; row < n; row++) {
			List<Boolean> list = new ArrayList<Boolean>();
			for (int col = 0; col < m; col++) {
				boolean temp = scanner.nextBoolean();
				list.add(temp);
			}
			mat.add(list);
		}
		findNoOfDaysLeft(mat);
	}

	static int findNoOfDaysLeft(List<List<Boolean>> mat) {
		int countDays = 0;
		int rows = mat.size();
		int cols = mat.get(0).size();
		boolean checkAllHousesInfected = true;
		Boolean[][] matCopy = new Boolean[rows][cols];
		addListDataToArray(mat, matCopy, rows, cols);
		do {
			checkAllHousesInfected = true;
			for (int row = 0; row < rows; row++) {
				List<Boolean> list = mat.get(row);
				for (int col = 0; col < cols; col++) {
					if (matCopy[row][col]) {
						if (row - 1 >= 0) {
							List<Boolean> previousRowList = mat.get(row - 1);
							previousRowList.set(col, true);
						}
						if (row + 1 < rows) {
							List<Boolean> nextRowList = mat.get(row + 1);
							nextRowList.set(col, true);
						}
						if (col - 1 >= 0) {
							list.set(col - 1, true);
						}
						if (col + 1 < cols) {
							list.set(col + 1, true);
						}

					}
				}
			}
			addListDataToArray(mat, matCopy, rows, cols);
			for (int row = 0; row < rows; row++) {
				List<Boolean> list = mat.get(row);
				for (int col = 0; col < cols; col++) {
					if (!list.get(col)) {
						checkAllHousesInfected = false;
					}
				}
			}

			countDays++;
		} while (!checkAllHousesInfected);
		System.out.println("Number of days : " + countDays);
		return countDays;

	}

	private static void addListDataToArray(List<List<Boolean>> mat, Boolean[][] matCopy, int rows, int cols) {
		for (int row = 0; row < rows; row++) {
			List<Boolean> list = mat.get(row);
			for (int col = 0; col < cols; col++) {
				matCopy[row][col] = list.get(col);
			}
		}
	}
}
