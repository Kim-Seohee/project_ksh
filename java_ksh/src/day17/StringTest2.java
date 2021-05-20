package day17;

import java.util.Scanner;

public class StringTest2 {

	public static void main(String[] args) {
		// System.out.println("홍길동".equals("홍길동")); // 문자열 상수에도 String 클래스 메소드를 사용할 수 있다.
		/* 두 단어를 입력받아 두 단어가 같은 단어인지 확인하는 코드를 작성하세요. */
		Scanner scan = new Scanner(System.in);
		System.out.print("두 단어를 입력하세요(예: abc cde): ");
		String str1 = scan.next();
		String str2 = scan.next();
		// str1과 str2가 같다면 같은 단어라고 출력하고 다르면 다른 단어라고 출력
		if(str1 != null && str1.equals(str2)) { // null 체크를 항상 해주자(지금은 필요하지 않지만 하는게 좋은 습관임)
			System.out.println("단어 " + str1 + "과/와 단어 " + str2 + "은/는 같음");
		}else {
			System.out.println("단어 " + str1 + "과/와 단어 " + str2 + "은/는 다름");
		}
		scan.close();
	}

}
