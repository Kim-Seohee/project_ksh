package day2;

public class ArithmeticOperator {

	public static void main(String[] args) {
		// 산술연산자 / 예제
		System.out.println(" 1   / 2   = " + 1/2); // 혼자만 결과 다름. 정수 나누기 정수이기 때문
		System.out.println(" 1.0 / 2   = " + 1.0/2);
		System.out.println(" 1   / 2.0 = " + 1/2.0);
		System.out.println(" 1.0 / 2.0 = " + 1.0/2.0);
		
		int num1 = 1, num2 = 2;
		// num1을 일시적으로 실수로 변환하여 계산함
		System.out.println((double)num1 / num2); // 강제 타입 변환, 0.5
		
		System.out.println("7 % 4 = " + 7 % 4); // 3

		char ch = 'A';
		ch = (char)(ch + 1); // char + int 타입은 int 타입이 됨. char 타입은 2바이트이므로 강제 타입 변환 필요
		// 더하기 연산을 하면 큰 타입에 맞춰진다.
		System.out.println(ch); // B
	}

}
