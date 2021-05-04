package day7;

public class Practice7_2 {

	public static void main(String[] args) {
		// *****를 출력하도록 메소드를 생성하여 테스트해보세요.
		printChar1('*', 5);
		System.out.println(printChar2('*', 5));
	}
	/* 기능: 문자 ch를 num번 출력한다.
	 * 매개변수: 문자 ch, 정수 num => char ch, int num
	 * 리턴타입: 없음 => void
	 * 메소드명: printChar1
	 * */
	public static void printChar1(char ch, int num) {
		for(int i = 0; i < num; i += 1) {
			System.out.print(ch);
		}
		System.out.println();
	}
	/* 기능: 주어진 문자(ch)를 주어진 정수(count)번 반복하여 하나의 문자열로 알려주는 메소드
	 * 매개변수: 주어진 문자, 정수번(횟수) => char ch, int num
	 * 리턴타입: 문자열 => String
	 * 메소드명: printChar2
	 * */
	public static String printChar2(char ch, int num) {
		String tmp = "";
		for(int i = 0; i < num; i += 1) {
			tmp += ch;
		}
		return tmp;
	}
}
