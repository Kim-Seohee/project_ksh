package day8;

import java.util.Scanner;

public class Test8_5 {

	public static void main(String[] args) {
		/* 10개짜리 배열에 1부터 10을 저장한 후 출력하는 코드를 작성하세요.
		 * */
		int []arr1 = new int[10];
		for(int i = 0; i < arr1.length; i += 1) {
			arr1[i] = i + 1;
			System.out.print(arr1[i] + " ");
		}
		
		/*int []arr1 = new int[10];
		for(int i = 0; i < arr1.length; i += 1) {
			arr1[i] = i + 1;
		}
		for(int tmp : arr1) {
			System.out.print(tmp + " ");
		}*/
		
		/* 10개짜리 배열에 피보나치 수열을 저장한 후 출력하는 코드를 작성하세요.
		 * 피보나치 수열
		 *  - 앞의 두 수를 더하여 나열함
		 *  - 0번지: 1, 1번지 : 1
		 *  - 1 1 2 3 5 8 13 21 34 55
		 * 힌트: arr[i] = arr[i - 2] + arr[i - 1]
		 * */
		System.out.println();
		int []arr2 = new int[10];
		arr2[0] = arr2[1] = 1;
		// 피보나치 수열 값을 배열에 저장
		for(int i = 2; i < arr2.length; i += 1) {
			arr2[i] = arr2[i - 2] + arr2[i - 1];
		}
		// 배열의 값을 출력
		for(int i = 0; i < arr2.length; i += 1) {
			System.out.print(arr2[i] + " ");
		}
		
		/*int []arr2 = new int[10];
		for(int i = 0; i < arr2.length; i += 1) {
			if(i < 2) {
				arr2[i] = 1;
			} else{
				arr2[i] = arr2[i - 2] + arr2[i - 1];
			}
		}
		for(int tmp : arr2) {
			System.out.print(tmp + " ");
		}*/
		
		/* 5개짜리 배열에 저장된 숫자들 중 연속된 숫자가 3개 이상인지 아닌지 확인하는 코드를 작성하세요
		 * 단 숫자들은 정렬되었다고 가정
		 * 예시
		 * 입력: 1 1 2 3 4
		 * 연속
		 * 예시
		 * 입력: 1 2 4 5 8
		 * 연속 아님
		 * 예시: 1 3 5 6 7
		 * 연속
		 * 뒷 번지의 값과 1 차이가 나면 count 변수를 1 증가,
		 * 1 차이가 나지 않으면 count를 0으로
		 * count가 3이 되면(연속) 반복문 종료
		 * */
		System.out.println();
		int []arr3 = new int[] {1, 1, 2, 3, 4};
		int count = 1; // 연속된 숫자의 개수
		for(int i = 0; i < arr3.length - 1 ; i += 1) {
			// i번지의 값과 i + 1번지의 값의 차이가 1이면 count를 1 증가
			if(arr3[i] + 1 == arr3[i + 1]) {
				count += 1;
			} 
			// 아니면 count를 1로 초기화
			else {
				count = 1;
			}
			// count가 3이면 반복문 종료
			if(count == 3) {
				break;
			}
		}
		// count가 3이면 연속이라고 출력
		if(count == 3) {
			System.out.println("연속");
		}
		// count가 3이 아니면 연속 아님이라고 출력
		else {
			System.out.println("연속 아님");
		}
		/*System.out.println();
		Scanner scan = new Scanner(System.in);
		int []arr3 = new int[5];
		System.out.print("입력: ");
		for(int i = 0; i < arr3.length; i += 1) {
			arr3[i] = scan.nextInt();
		}
		scan.close();
		
		int cnt = 1;
		for(int i = 0; i < arr3.length - 1; i += 1) {
			if(arr3[i + 1] - arr3[i] == 1) {
				cnt += 1;
			} else {
				cnt = 1;
			}
			if(cnt == 3) {
				break;
			}
		}
		
		if(cnt == 3) {
			System.out.println("연속");
		} else {
			System.out.println("연속 아님");
		}*/
	}

}
