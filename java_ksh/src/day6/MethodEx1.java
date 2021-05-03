package day6;

public class MethodEx1 {

	public static void main(String[] args) {
		// 메소드 예제
		// 메소드명(값);
		add(1, 2); // 3;과 같다.
		System.out.println(add(1, 2));
		add2(1, 2);
		printMultiTable(7); // 7단 출력
		printMultiTable(8); // 8단 출력
		int num1 = 8, num2 = 12;
		int res = gcd(num1, num2);
		System.out.println(num1 + "과/와 " + num2 + "의 최대 공약수: " + res); // 최대공약수
	}
	// Method의 위치: main 바깥 class 안
	/* 기능: 두 정수가 주어지면 두 정수의 합을 알려주는 메소드
	 * 매개변수: 두 정수 => int num1, int num2
	 * 리턴타입: 정수의 합 => 정수 => int
	 * 메소드명: add
	 * */
	//public static 붙여주기
	public static int add(int num1, int num2) {
		int res = num1 + num2;
		return res;
	}
	/* 기능: 두 정수가 주어지면 두 정수의 합을 콘솔에 출력하는 메소드
	 * 매개변수: 두 정수 => int num1, int num2
	 * 리턴타입: 없음 => void
 	 * 메소드명: add2
	 * */
	public static void add2(int num1, int num2) {
		int res = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + res);
	}
	/* 기능: 두 정수와 산술 연산자가 주어지면 두 정수의 산술 연산 결과를 알려주는 메소드
	 * 매개변수: 두 정수와 산술 연산자 하나 => int num1, char op, int num2
	 * 리턴타입: 산술 연산 결과 정수 => 실수 => double
 	 * 메소드명: calculate
	 * */
	public static double calculate(int num1, char op, int num2) {
		return 0.0;
	}
	/* 기능: 두 정수의 최대 공약수를 알려주는 메소드
	 * 매개변수: 두 정수 => int num1, int num2
	 * 리턴타입: 두 정수의 최대 공약수 => 정수 => int
	 * 메소드명: gcd
	 * */
	public static int gcd(int num1, int num2) {
		int i, gcd1 = 0; // 변수 이름 gcd여도 됨.
		for (i = 1; i <= num1; i += 1) {
			if(num1 % i == 0 && num2 % i == 0) {
				gcd1 = i;
			}
		}
		return gcd1;
	}
	/* 기능: num단을 출력하는 메소드
	 * 매개변수: 정수 num => int num
	 * 리턴타입: 없음 => void
	 * 메소드명: printMultiTable
	 * */
	public static void printMultiTable(int num) {
		int i;
		System.out.println(num + "단");
		for(i = 1; i <= 9; i += 1) {
			System.out.println(num + " x " + i + " = " + num * i);
		}
	}
}
