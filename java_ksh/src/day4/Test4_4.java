package day4;

import java.util.Scanner;

public class Test4_4 {

	public static void main(String[] args) {
		/* 
		 * */
		int min = 1, max = 100;
		// Math.random()은 0보다 크거나 같고 1보다 작은 임의의 실수를 생성하는 기능
		/* Math.random(): A
		 * 0 <= A < 1
		 * 0 * (max - min + 1) <= A * (max - min + 1) < 1 * (max - min + 1)
		 * 0 <= A * (max - min + 1) < (max - min + 1)
		 * min <= A * (max - min + 1) + min < (max + 1)
		 * */
		int r = (int)(Math.random() * (max - min + 1) + min);
		/* 정수를 랜덤으로 생성하여 생성된 숫자를 맞추는 게임
		 * 예시 (랜덤하게 생성된 숫자가 25인 경우)
		 * 정수가 랜덤으로 생성되었습니다. 게임 시작!
		 * 정수를 입력하세요: 100
		 * down
		 * 정수를 입력하세요: 40
		 * down
		 * 정수를 입력하세요: 10
		 * up
		 * 정수를 입력하세요: 20
		 * up
		 * 정수를 입력하세요: 25
		 * 정답입니다.
		 * 반복 횟수: 없음
		 * 규칙성: 정수를 입력하세요라는 문자열을 출력
		 *       콘솔에서 정수를 입력받음
		 *       입력받은 정수가 랜덤한 수보다 크면 down이라고 출력하고
		 *       입력받은 정수가 랜덤한 수보다 작으면 up이라고 출력하고
		 *       입력받은 정수가 랜덤한 수와 같으면 정답입니다라고 출력 후 반복문 종료
		 * 반복문 종료 후: 없음
		 * */
		int num;
		System.out.println("정수가 랜덤으로 생성되었습니다. 게임 시작!");
		Scanner scan = new Scanner(System.in);
		System.out.println(r); // Test
		for(;;) {
			// 정수를 입력하세요라는 문자열을 출력
			System.out.print("정수를 입력하세요(" + min + "~" + max + "): ");
			// 콘솔에서 정수를 입력 받음
			num = scan.nextInt();
			if(num > r) {
				System.out.println("down");
			} else if(num < r) {
				System.out.println("up");
			} else if(num == r) {
				System.out.println("정답입니다.");
				scan.close();
				break;
			}
		}
				
	}

}
