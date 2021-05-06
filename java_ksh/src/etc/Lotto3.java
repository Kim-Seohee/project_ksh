package etc;

import java.util.Scanner;

public class Lotto3 {

	public static void main(String[] args) {
		// 당첨 번호를 생성(0~6번지, 6번지의 값은 보너스 번호)
		int []lotto = new int[7];
		int min = 1, max = 45;
		init(lotto, min, max);
		for(int tmp : lotto) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		// 번호 입력
		int []user = new int[] {1, 2, 3, 4, 5, 6};
		System.out.print("번호를 입력하세요: ");
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < user.length; i += 1) {
			user[i] = scan.nextInt();
		}
		scan.close();
		// 당첨 등수 확인
		printRank(user, lotto, lotto[6]);

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
	/* 기능: 두 배열이 주어지면 두 배열에서 같은 숫자가 몇 개인지 알려주는 메소드
	 * 매개변수: 두 배열 => int []arr1, int []arr2
	 * 리턴타입: 같은 숫자의 개수 => 정수 => int
	 * 메소드명: getSameCount
	 * */
	public static int getSameCount(int []arr1, int []arr2) {
		int cnt = 0;
		for(int tmp : arr1) {
			if(contains(arr2, arr2.length - 1, tmp)) { // lotto 배열의 6번째 자리까지만 비교한다
				cnt += 1;
			}
		}
		return cnt;
	}
	/* 기능: 자동 생성 번호와 당첨 번호, 보너스 번호가 주어지면 몇등인지 알려주는 메소드, 단 꽝은 0등으로 표현
	 * 매개변수: 자동 생성 번호 배열, 당첨 번호 배열, 보너스 번호 => int []user, int []lotto, int bonus
	 * 리턴타입: 당첨 등수 => 정수 => int
	 * 메소드명: rank
	 * */
	public static int rank(int []user, int []lotto, int bonus) {
		int res = 0;
		int count = getSameCount(user, lotto);
		switch(count) {
		case 6 : res = 1;	break;
		case 5 : 
			if(contains(user, user.length, bonus)) {
				res = 2;
			} else {
				res = 3;
			}
			// res = contains(user, user.length, bonus)? 2 : 3;
			break;
		case 4 : res = 4;	break;
		case 3 : res = 5;	break;
		}
		return res;
	}
	/* 기능: 자동생성 번호와 당첨 번호, 보너스가 주어지면 당첨 등수를 출력하는 메소드
	 * 매개변수: 자동생성 번호, 당첨 번호, 보너스 번호 => int []user, int []lotto, int bonus
	 * 리턴타입: 없음 => void
	 * 메소드명: printRank
	 * */
	public static void printRank(int []user, int []lotto, int bonus) {
		int rank = rank(user, lotto, bonus);
		switch(rank) {
		case 1, 2, 3, 4, 5 :
			System.out.println(rank + "등입니다.");
			break;
		default :
			System.out.println("꽝입니다.");		
		}
	}
}
