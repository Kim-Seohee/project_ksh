package day8;

import java.util.Scanner;

public class Practice8_1 {

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
		int []num = new int[10];
		int tmp;
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("입력(1 ~ 9): ");
			tmp = scan.nextInt();
			if(tmp < 1 || tmp > 9) {
				scan.close();
				break;
			}
			num[tmp] += 1;
		}
		for(int i = 1; i < num.length; i += 1) {
			System.out.println(i + ": " + num[i] + "번");
		}
		
		/* 다음과 같이 출력되도록 작성하세요.
		 * a
		 * ab
		 * abc
		 * abcd
		 * abcde
		 * ...
		 * abcdefg ... xyz
		 * 
		 * abc...xyz 예제와
		 * *
		 * **
		 * ***
		 * **** 예제의 혼합
		 * */
		for(char i = 'a'; i <= 'z'; i += 1) {
			for(char j = 'a'; j <= i; j += 1) {
				System.out.print(j);
			}
			System.out.println();
		}
		
		String str = "";
		for(char i = 'a'; i <= 'z'; i += 1) {
			str += i;
			System.out.println(str);
		}
		
		
	}

}
