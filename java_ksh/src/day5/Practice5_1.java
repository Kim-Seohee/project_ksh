package day5;

import java.util.Scanner;

public class Practice5_1 {

	public static void main(String[] args) {
		// 5개짜리 정수 배열에 1부터 5까지 차례대로 저장 후 출력하는 예제
		// 5개짜리 정수 배열 생성
		int []arr1 = new int[5];
		int i;
		for(i = 0; i < arr1.length; i += 1) {
			arr1[i] = i + 1;
			System.out.print(arr1[i] + " ");
		}
		
		/* 정수 num의 약수를 배열에 저장한 후 출력하는 코드를 작성하세요.
		 * 단, 약수의 갯수가 10개를 넘어가는 경우 최대 10개만 출력하면 됩니다.
		 * */
		System.out.println();
		System.out.println("-------------------");
		int num = 12, cnt = 0;
		int []arr2 = new int[10];
		for(i = 1; i <= num; i += 1) {
			if(num % i == 0) {
				arr2[cnt] = i;
				cnt += 1;
				if(cnt == 10) {
					break;
				}
			}
		}
		for(i = 0; i < cnt; i += 1) {
			System.out.print(arr2[i] + " ");
		}
		
		/* 1~10 사이의 정수 3개를 랜덤으로 생성하여 배열에 저장한 후
		 * 생성된 값들이 중복되었는지 안 되었는지 확인하는 코드를 작성하세요.
		 * 예시: 
		 * 랜덤: 3 8 2
		 * 중복되지 않음
		 * 예시: 
		 * 랜덤: 2 8 8
		 * 중복
		 * */
		System.out.println();
		System.out.println("-------------------");
		int j;
		int min = 1, max = 10;
		int []arr3 = new int[3];
		//(int)(Math.random() * (max - min + 1) + min);
		for(i = 0; i < arr3.length; i += 1) {
			arr3[i] = (int)(Math.random() * (max - min + 1) + min);
		}
		System.out.print("랜덤: ");
		for(i = 0; i < arr3.length; i += 1) {
			System.out.print(arr3[i] + " ");
		}
		
		boolean isDup = false;
		for(i = 0; i < arr3.length - 1; i += 1) {
			for(j = i + 1; j < arr3.length; j += 1) {
				if(arr3[i] == arr3[j]) {
					isDup = true;
				}
			}
		}
		System.out.println();
		if(isDup) {
			System.out.println("중복");
		} else {
			System.out.println("중복이 아님");
		}
		
		/* 입력받은 문자가 q 또는 Q이면 종료하는 예제
		 * */
		System.out.println();
		System.out.println("-------------------");
		Scanner scan = new Scanner(System.in);
		char ch = 'q';
		do {
			System.out.print("문자를 입력하세요(q/Q 입력시 종료): ");
			ch = scan.next().charAt(0);
		} while (ch != 'q' && ch != 'Q');
		scan.close();
		
		/* ****
		 * ****
		 * ****
		 * ****
		 * ****
		 * */
		System.out.println();
		System.out.println("-------------------");
		for(i = 1; i <= 5; i += 1) {
			for(j = 1; j <= 4; j += 1) {
				System.out.print('*');
			}
			System.out.println();
		}
		/* *
		 * **
		 * ***
		 * ****
		 * *****				
		 */
		System.out.println("-------------------");
		for(i = 1; i <= 5; i += 1) {
			for(j = 1; j <= i; j += 1) {
				System.out.print('*');
			}
			System.out.println();
		}
		/*     ****
		 *     ****
		 *     ****
		 *     ****
		 *     ****
		 * */
		System.out.println("-------------------");
		for(i = 1; i <= 5; i += 1) {
			for(j = 1; j <= 4; j += 1) {
				System.out.print(" ");
			}
			for(j = 1; j <= 4; j += 1) {
				System.out.print('*');
			}
			System.out.println();
		}
		/*     *
		 *    **
		 *   ***
		 *  ****
		 * ***** 
		 * */
		System.out.println("-------------------");
		for(i = 1; i <= 5; i += 1) {
			for(j = 1; j <= 5 - i; j += 1) {
				System.out.print(" ");
			}
			for(j = 1; j <= i; j += 1) {
				System.out.print('*');
			}
			System.out.println();
		}
		
		/*     *
		 *    ***
		 *   *****
		 *  *******
		 * *********   
		 * */
		System.out.println("-------------------");
		for(i = 1; i <= 5; i += 1) {
			for(j = 1; j <= 5 - i; j += 1) {
				System.out.print(" ");
			}
			for(j = 1; j <= 2 * i - 1; j += 1) {
				System.out.print('*');
			}
			System.out.println();
		}
		
		/* ********* 1 9
		 *  *******  2 7
		 *   *****   3 5
		 *    ***    4 3
		 *     *     5 1
		 * */
		System.out.println("-------------------");
		for(i = 1; i <= 5; i += 1) {
			for(j = 1; j <= i - 1; j += 1) {
				System.out.print(" ");
			}
			for(j = 1; j <= 11 - 2 * i; j += 1) {
				System.out.print('*');
			}
			System.out.println();
		}
		
		/* while문을 이용하여 구구단 7단을 출력하는 코드를 작성하세요.
		 * */
		System.out.println("-------------------");
		int k = 1;
		while (k <= 9) {
			System.out.println("7 x " + k + " = " + 7 * k);
			k += 1;
		}
		

	}

}
