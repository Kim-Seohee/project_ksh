package day13;

import board.Board;

public class VariableTest {

	public static void main(String[] args) {
		int num5 = 0; // num5: 일반변수(정수), main 메소드의 지역변수 
		String str3 = "Hello"; // str3: 참조변수, String 클래스의 객체, main 메소드의 지역변수
		int []arr = new int[5]; // arr: 참조변수, 배열, main 메소드의 지역변수
		Board []board = new Board[5]; // arr: 참조변수, 배열, main 메소드의 지역변수
	}
}
class A{
	int num1; // num1: 일반변수(정수), 객체 멤버 변수
	static int num2; // num2: 일반변수(정수), 클래스 멤버 변수
	String str1; // str1: 참조변수(문자열), String 클래스의 객체, 객체 멤버 변수
	static String str2; // str2: 참조변수(문자열), String 클래스의 객체, 클래스 멤버 변수
	public A(int num3, int num4) { // num3, num4: 일반변수(정수), 매개변수
		num1 = num3;
		num2 = num4;
	}
}