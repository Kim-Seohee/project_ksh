package day17;

import java.util.Scanner;

public class StringTest5 {

	public static void main(String[] args) {
		/*
		String str = "안녕하세요";
		// 2번지부터 마지막 번지까지 부분 문자열 생성
		System.out.println(str.substring(2));
		// substring은 원본을 수정하는 것이 아니라 새로운 문자열을 생성
		System.out.println(str);
		// 2번지부터 3번지 전까지(2번지까지) 새로운 부분 문자열을 생성
		System.out.println(str.substring(2, 3));
		*/
		/* 주민등록번호를 입력해서 생년월일 부분을 추출하여 년도 월 일을 출력하는 코드를 작성하세요
		 * 예시
		 * 주민번호를 입력하세요: 020101-3234567
		 * 2002년 01월 01일
		 * 예시
		 * 주민번호를 입력하세요: 020101-1234567
		 * 1902년 01월 01일*/
		Scanner scan = new Scanner(System.in);
		System.out.print("주민번호를 입력하세요(예: 020101-3234567): ");
		String reg = scan.next();
		String year = reg.substring(0, 2);
		String month = reg.substring(2, 4);
		String day = reg.substring(4, 6);
		String gender = reg.substring(7, 8);
		// String gender = reg.charAt(7);
		/*
		if(reg != null && (reg.charAt(7) == '1' || reg.charAt(7) == '2')) {
			year = "19" + year;
		}else if(reg != null && (reg.charAt(7) == '3' || reg.charAt(7) == '4')) {
			year = "20" + year;
		}
		*/
		switch(gender) {
		case "1", "2" :
			year = "19" + year;
			break;
		case "3", "4" :
			year = "20" + year;
			break;
		}
		System.out.println(year + "년 " + month + "월 " + day + "일"); 
		scan.close();
	}

}
