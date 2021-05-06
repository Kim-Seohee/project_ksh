package etc;

import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		/* 사용자 번호를 랜덤으로 생성하고, 당첨 번호를 입력하면
		 * 당첨 등수를 출력하는 코드를 작성하세요.
		 * - 사용자 번호: 1~45 사이의 수, 중복되지 않음, 6개
		 * - 당첨 번호: 1~45 사이의 수, 중복되지 않음, 6개 + 1개(보너스)
		 * - 1등: 당첨번호 6개가 일치
		 * - 2등: 당첨번호 5개 + 보너스 번호 일치
		 * - 3등: 당첨번호 5개 일치
		 * - 4등: 당첨번호 4개 일치
		 * - 5등: 당첨번호 3개 일치
		 * - 꽝: 당첨번호 2개 이하
		 * */
		int []user = new int[6];
		int min = 1, max = 45;
		init(user, min, max);
		for(int tmp : user) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		int []win = new int[7];
		Scanner scan = new Scanner(System.in);
		System.out.print("당첨 번호를 입력하세요(6개 + 마지막 1개): ");
		for(int i = 0; i < win.length; i += 1) {
			win[i] = scan.nextInt();
		}
		scan.close();
//		System.out.println(sameNumCount(user, win));
		System.out.println(winner(user, win));
	}
	public static boolean contains(int []arr, int count, int num) {
		for(int i = 0; i < count; i += 1) {
			if(arr[i] == num) {
				return true;
			}
		}
		return false;
	}
	
	public static void init(int []arr, int min, int max) {
		int cnt = 0; // 저장된 숫자의 개수
		while(cnt < arr.length) {
			int r = (int)(Math.random() * (max - min + 1) + min);
			// 배열 arr에 있는 값들 cnt개를 r과 비교
			if(!contains(arr, cnt, r)) {
				arr[cnt] = r;
				cnt += 1;
			}
		}
	}
	/* 기능: 랜덤으로 생성된 내 번호 6개 길이의 배열과 당첨 번호 7개 중 6개의 길이를 비교하여
	 *      같은 숫자의 개수를 출력함 
	 * 매개변수: 내 번호 배열, 당첨 번호 배열 => int []arr1, int []arr2
	 * 리턴타입: 정수 => int
	 * 메소드명: sameNumCount
	 * */
	public static int sameNumCount(int []arr1, int []arr2) {
		int cnt = 0;
		for(int i = 0; i < arr1.length; i += 1) {
			if(contains(arr2, arr2.length - 1, arr1[i])) {
				cnt += 1;
			}
		}
		return cnt;
	}
	
	// 보너스 번호가 일치하는지 여부를 알려주는 메소드
	public static boolean bonus(int []arr1, int []arr2) {
		if(contains(arr1, arr1.length, arr2[6])) {
			return true;
		}
		return false;
	}
	
	// 등수와 꽝을 알려주는 메소드
	public static String winner(int []arr1, int []arr2) {
		if(sameNumCount(arr1, arr2) == 6) {
			return "1등";
		} else if(sameNumCount(arr1, arr2) == 5 && bonus(arr1, arr2)) {
			return "2등";
		} else if(sameNumCount(arr1, arr2) == 5) {
			return "3등";
		} else if(sameNumCount(arr1, arr2) == 4) {
			return "4등";
		} else if(sameNumCount(arr1, arr2) == 3) {
			return "5등";
		} else {
			return "꽝";
		}
	}
}
