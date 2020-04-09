package data.structure.practice;

public class RepetitiveAddition {

	public static void main(String[] args) {
		int num = 510876;
		int result = num;
		while (result > 9) {
			result = addDigits(result);
		}
		System.out.println("The final result is : " +result);
	}
	
	private static int addDigits(int number) {
		int result = 0;
		while(number > 0) {
			result  += number % 10;
			number /= 10;
		}
		return result;
	}
}
