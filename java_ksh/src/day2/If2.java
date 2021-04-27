package day2;

import java.util.Scanner;

public class If2 {

	public static void main(String[] args) {
		/* 변수 num에 양의 정수를 입력받아 입력받은 정수가 짝수이면 짝수라고 출력하는 코드를 작성하세요. 
		 * 조건식: 정수가 짝수이다.
		 * 실행문: 짝수라고 출력
		 * */
		System.out.print("양의 정수를 입력하세요: ");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		if(num % 2 == 0) {
			System.out.println("짝수");
		}
		
		/* 입력받은 정수가 홀수이면 홀수라고 출력하는 코드를 작성하세요. */
		if(num % 2 == 1) {
			System.out.println("홀수"); // if문을 두 번 써서 하면 만약 짝수라도 무조건 두 번 비교하게 됨
			
		if(num % 2 == 0) { // 조건이 맞으면 더 이상 비교하지 않음
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
			
		scan.close();
		}
	}

}
