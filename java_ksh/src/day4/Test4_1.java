package day4;

public class Test4_1 {

	public static void main(String[] args) {
		/* 11부터 20까지 출력하는 코드를 작성하세요.
		 * 반복 횟수: i는 11부터 20보다 작거나 같을 때까지 1씩 증가
		 * 규칙성: i를 콘솔에 출력
		 * 반복문 종료 후: 없음
		 * */
		int i;
		for(i = 11; i <= 20; i += 1) {
			System.out.print(i + " ");
		}
		
		/* 20부터 11까지 출력하는 코드를 작성하세요.
		 * 반복 횟수: i는 20부터 11보다 크거나 같을 때까지 1씩 감소
		 * 규칙성: i를 콘솔에 출력
		 * 반복문 종료 후: 없음
		 * */
		System.out.println();
		for(i = 20; i >= 11; i -= 1) { //j--, --j, j = j - 1
			System.out.print(i + " ");
		}
		
		/* 1부터 100까지의 숫자 중 1의 자리가 3, 6, 9로 끝나는 수들을 출력하는 코드를 작성하세요
		 * 3 6 9 13 16 19 ...
		 * 반복 횟수: i는 1부터 100보다 작거나 같을 때까지 1씩 증가
		 * 규칙성: i를 10으로 나누었을 때 나머지가 3과 같거나
		 *       i를 10으로 나누었을 때 나머지가 6과 같거나
		 *       i를 10으로 나누었을 때 나머지가 9과 같으면 i를 출력
		 * 반복문 종료 후: 없음
		 * */
		System.out.println();
		int k; // 출력된 숫자의 갯수
 		for(i = 1, k = 0; i <= 100; i += 1) {
			if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
				System.out.print(i + " ");
				k += 1;
				if(k % 3 == 0) {
					System.out.println();
				}
			}
		}
		
/*		System.out.println();
		for(i = 1; i <= 100; i += 1) {
			if(i % 10 == 3 || i % 10 == 6) {
				System.out.print(i + " ");
			} else if (i % 10 == 9) {
				System.out.println(i);
			}
		}
*/
		
	}

}
