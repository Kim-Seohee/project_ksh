package day7;

public class Practice7_3 {

	public static void main(String[] args) {
		/* 다음과 같이 출력하는 메소드를 만드세요.
		 * *
		 * **
		 * ***
		 * ****
		 * *****
		 * */
		leftTri('*', 5);
		/* 다음과 같이 출력하는 메소드를 만드세요.
		 *     *
		 *    **
		 *   ***
		 *  ****
		 * *****
		 * */
		rightTri('*', 5);
		printTriangle('*', 5, TriangleShape2.LEFT);
		printTriangle('*', 5, TriangleShape2.RIGHT);
	}
	/* 기능: 문자 ch로 된 왼쪽으로 붙은 삼각형을 n줄 출력
	 * 매개변수: char ch, int n
	 * 리턴타입: void
	 * 메소드명: leftTri
	 * */
	public static void leftTri(char ch, int n) {
		for(int i = 1; i <= n; i += 1) {
			for(int j = 1; j <= i; j += 1) {
				System.out.print(ch);
			}
			System.out.println();
		}
	}
	/* 기능: 문자 ch로 된 오른쪽으로 붙은 삼각형을 n줄 출력
	 * 매개변수: char ch, int n
	 * 리턴타입: void
	 * 메소드명: rightTri
	 * */
	public static void rightTri(char ch, int n) {
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
	public static void printTriangle(char ch, int n, TriangleShape2 shape) {
		switch(shape) {
		case LEFT:
			leftTri(ch, n);
			break;
		case RIGHT:
			rightTri(ch, n);
			break;
		}
	}
}
enum TriangleShape2{LEFT, RIGHT}