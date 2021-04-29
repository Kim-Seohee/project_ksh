package day4;

public class For8 {

	public static void main(String[] args) {
		
		/* a부터 z까지 출력하는 코드를 작성하세요.
		 * 반복 횟수: i는 0부터 26보다 작을(25보다 작거나 같을) 때까지 1씩 증가
		 * 규칙성: (char)('a'+i)를 출력
		 * 반복문 종료 후: 없음
		 * */
/*		char ch = 'a' + 0;
		System.out.println(ch); // a
		ch = 'a' + 1;
		System.out.println(ch); // b
		ch = 'a' + 2;
		System.out.println(ch); // c
*/
		int i;
		for(i = 0; i < 26; i += 1) {
			System.out.print((char)('a'+i)+ " ");
		}
		
		/* a부터 z까지 출력하는 코드를 작성하세요.
		 * 반복 횟수: ch는 'a'부터 'z'까지 1씩 증가
		 * 규칙성: ch를 출력
		 * 반복문 종료 후: 없음
		 * */
		System.out.println();
		char ch;
		for(ch = 'a'; ch <= 'z'; ch += 1) {
			System.out.print(ch+ " ");
		}
		
	}

}
