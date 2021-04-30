package day5;

import java.util.Scanner;

public class Practice5_2 {

	public static void main(String[] args) {
		
		/* 콘솔에서 정수를 다섯번 입력받아 입력받은 값을 출력하는 코드를 작성하세요.
		 * */
		int i;		
		Scanner scan = new Scanner(System.in);
		int []arr4 = new int[5];
		for(i = 0; i < arr4.length; i += 1) {
			System.out.print("정수를 입력하세요: ");
			arr4[i] = scan.nextInt();
			System.out.println("출력: " + arr4[i]);
		}
		scan.close();

	}

}
