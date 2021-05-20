package day17;

import java.util.Scanner;

public class StringTest3 {

	public static void main(String[] args) {
		System.out.println("abcdef".indexOf("bc")); // 문자열이 시작하는 번지를 알려줌
		System.out.println("abcdef".indexOf("ad"));
		/* 두 단어 단어 A와 단어 B를 입력받고 단어 A에 단어 B가 있는지 없는지 확인하는 코드를 작성하세요. */
		Scanner scan = new Scanner(System.in);
		System.out.print("두 단어를 입력하세요(예: abcde bcd): ");
		String str1 = scan.next();
		String str2 = scan.next();
		if(str1 != null && str1.indexOf(str2) != -1) { // 또는 >= 0
			System.out.println("단어 " + str1 + "의 " + str1.indexOf(str2) + "번지에 단어 " + str2 + "가 있습니다.");
		} else {
			System.out.println("단어 " + str1 + "에 단어 " + str2 + "가 없습니다.");
		}
		if(str1 != null) {
			System.out.println(str1 + "의 길이: " + str1.length()); // 괄호 있다
		}
		int []arr = new int[5];
		System.out.println(arr.length); // 괄호 없다
		scan.close();
	}

}
