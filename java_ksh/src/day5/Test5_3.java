package day5;

import java.util.Scanner;

public class Test5_3 {

	public static void main(String[] args) {
		/* 콘솔에서 정수를 다섯번 입력받아 입력받은 값을 출력하는 코드를 작성하세요.
		 * */
		Scanner scan = new Scanner(System.in);
		int i, num;
		for(i = 1; i <= 5; i += 1) {
			System.out.print("정수를 입력하세요: ");
			num = scan.nextInt();
			System.out.println("출력: " + num);
		}
		
		/* 콘솔에서 정수를 5번 입력받아 저장한 후 저장된 값을 출력하는 코드를 작성하세요
		 * */
		int []arr = new int[5];
		for(i = 0; i < arr.length; i += 1) {
			System.out.print("정수를 입력하세요: ");
			arr[i] = scan.nextInt();
			System.out.println("출력: " + arr[i]);
		}
/*		
		for(i = 0; i < 5; i += 1) {
			System.out.print("정수를 입력하세요: ");
			arr[i] = scan.nextInt();
		}
		System.out.print("저장된 값: ");
		for(i = 0; i < 5; i += 1) {
			System.out.print(arr[i] + " ");
		}
*/		
		scan.close();
	}

}
