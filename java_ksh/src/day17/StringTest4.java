package day17;

import java.util.Scanner;

public class StringTest4 {

	public static void main(String[] args) {
		// System.out.println("제 이름은 홍길동입니다.".replace("홍길동", "임꺽정"));
		/* 문자열 C를 입력받고, 문자열 A와 문자열 B를 입력받아 
		 * 문자열 C에 있는 문자열 A를 문자열 B로 바꾸는 코드를 작성하세요.*/
		Scanner scan = new Scanner(System.in);
		System.out.print("문자열을 입력하세요(예: 제 이름은 홍길동입니다.): ");
		String str1 = scan.nextLine();
		System.out.print("수정할 곳의 단어와 수정될 단어을 입력하세요(예: 홍길동 임꺽정): ");
		String str2 = scan.next();
		String str3 = scan.next();
		if(str1 != null && str1.indexOf(str2) != -1) {
			str1 = str1.replace(str2, str3); // 원본이 바뀌는 게 아니라 단어를 바꾼 문자열을 만들어주는 것이기 때문에 저장해줘야 함
			System.out.println("바뀐 단어: " + str1);	
		} else {
			System.out.println("단어를 바꿀 수 없습니다.");
		}
		scan.close();

	}

}
