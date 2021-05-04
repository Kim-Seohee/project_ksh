package day7;

public class MethodEx6 {

	public static void main(String[] args) {
		/* 다음과 같이 출력하는 메소드를 만드세요.
		 * *
		 * **
		 * ***
		 * ****
		 * *****
		 * */
		printLeftTriangle('+', 6);
		/* 다음과 같이 출력하는 메소드를 만드세요.
		 *     *
		 *    **
		 *   ***
		 *  ****
		 * *****
		 * */
		printRightTriangle('+', 6);
		pringTriangle('*', 5, TriangleShape.LEFT_TRIANGLE); // 열거형 사용
		pringTriangle('*', 5, TriangleShape.RIGHT_TRIANGLE);

	}
	/* 기능: 주어진 문자를 이용하여 왼쪽으로 붙은 삼각형을 n줄 출력하는 메소드
	 * 매개변수: 문자, n줄 => char ch, int n
	 * 리턴타입: 없음
	 * 메소드명: printLeftTriangle
	 * */
	public static void printLeftTriangle(char ch, int n) {
		for(int i = 1; i <= n; i += 1) {
			for(int j = 1; j <= i; j += 1) {
				System.out.print(ch);
			}
			System.out.println();
		}
	}
	/* 기능: 주어진 문자를 이용하여 오른쪽으로 붙은 삼각형을 n줄 출력하는 메소드
	 * 매개변수: 문자, n줄 => char ch, int n
	 * 리턴타입: 없음
	 * 메소드명: printRightTriangle
	 * */
	public static void printRightTriangle(char ch, int n) {
		for(int i = 1; i <= n; i += 1) {
			for(int j = 1; j <= n - i; j += 1) {
				System.out.print(" ");
			}
			for(int j = 1; j <= i; j += 1) {
				System.out.print(ch);
			}
			System.out.println();
		}
	}
	/* 기능: 주어진 문자를 이용하여 n줄 삼각형을 출력하는데 주어진 삼각형 종류에 맞게 출력하는 메소드
	 * 매개변수: 문자, n줄, 삼각형 종류 => char ch, int n, TriangleShape shape
	 * 리턴타입: 없음 => void
	 * 메소드명: printTriangle
	 * */
	public static void pringTriangle(char ch, int n, TriangleShape shape) {
		switch(shape) {
		case LEFT_TRIANGLE:
			printLeftTriangle(ch, n);
			break;
		case RIGHT_TRIANGLE:
			printRightTriangle(ch, n);
			break;
		}
	}
}
enum TriangleShape{LEFT_TRIANGLE, RIGHT_TRIANGLE}
