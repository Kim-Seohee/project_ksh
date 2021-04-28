package day3;

public class Test3_1 {

	public static void main(String[] args) {
		int num1 = 1, num2 = 0;
//		int res = num1 / num2;
//		System.out.println(res); // Exception 발생(/ by zero)
		System.out.println(1.0/0); // Infinity, Exception 발생하지 않음
	}

}
