package data.structure.practice.strings;

public class InterleaveTwoStrings {

	public static void main(String[] args) {
		String str1 = "AB", str2 = "CD";
		String[] strArr = new String[5];
		printInterleaveString(str1, str2, strArr, str1.length(), str2.length(), 0, 0, 0);
	}

	private static void printInterleaveString(String str1, String str2, String[] strArr, int m, int n, int i, int startIndex, int endIndex) {
		if (m == 0 && n == 0) {
			for (int index = 0; index < strArr.length; index++) {
				System.out.print(strArr[index]);
				System.out.println("\n");
			}
		}
		if (m != 0) {
			// builder.setCharAt(i, str1.charAt(0));
			strArr[i] = String.valueOf(str1.charAt(0));
			printInterleaveString(str1.substring(startIndex + 1), str2, strArr, m - 1, n, i + 1, startIndex + 1, endIndex);
		}
		if (n != 0) {
			// builder.setCharAt(i-1, str2.charAt(0));
			strArr[i] = String.valueOf(str2.charAt(0));
			printInterleaveString(str2.substring(endIndex + 1), str2, strArr, m, n - 1, i + 1, startIndex, endIndex + 1);
		}
	}
	/*
	 * ABCD ACBD ACDB CABD CADB CDAB
	 */
}
