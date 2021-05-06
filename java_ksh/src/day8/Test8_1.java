package day8;

import java.util.Scanner;

public class Test8_1 {

	public static void main(String[] args) {
		/* 1 ~ 9 사이의 정수를 입력받아 각 숫자가 몇 번 입력됐는지 출력하는 코드를 작성하세요.
		 * -1이 입력되면 입력 종료하고 각 숫자가 몇번 입력됐는지 출력
		 * 예시
		 * 입력: 1
		 * 입력: 1
		 * 입력: 9
		 * 입력: 3
		 * 입력: 2
		 * 입력: -1
		 * 1: 2번
		 * 2: 1번
		 * 3: 1번
		 * 4: 0번
		 * 5: 0번
		 * 6: 0번
		 * 7: 0번
		 * 8: 0번
		 * 9: 1번
		 * */
/*		[첫 시도]
 * 		Scanner scan = new Scanner(System.in);
		int []num = new int[100];
		for(int i = 0; ; i += 1) {
			System.out.print("입력: ");
			num[i] = scan.nextInt();
			if(num[i] == -1) {
				break;
			}
		}
		
		scan.close();
		
		int []count = new int[9];
		
		
		for(int j = 1; j <= 9; j += 1) {
			for(int i = 0; i < num.length; i += 1) {
				if(num[i] == j) {
					count[j - 1] += 1;
				}
			}
		}
		
				
		for(int i = 0; i < 9; i += 1) {
			System.out.println((i + 1) + ": " + count[i] + "번");
		}
*/
		// 반복문을 이용하여 정수를 입력받음
		int num;
		int []arr = new int[10];
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("입력(1 ~ 9): ");
			num = scan.nextInt();
			if(num < 1 || num > 9) {
				break;
			}
			arr[num] += 1;
		}
		for(int i = 1; i < arr.length; i += 1) {
			System.out.println(i + ": " + arr[i] + "번");
		}
		scan.close();
	}

}
