package day4;

public class For15 {

	public static void main(String[] args) {
		/* 100 이하의 모든 소수를 출력하는 코드를 작성하세요
		 * 2 3 5 7 11 13 17 19 ...
		 * 기존 소수 판별 예제에서 출력 부분을 수정
		 * => 소수이면 num를 출력하고 아니면 아무것도 안함
		 * */
		int num, i, cnt;
		/* cnt의 초기화가 없으면 num가 1일 때 약수의 개수 cnt는 1
		 * 그리고 num가 2일 때 약수의 개수 cnt는 앞의 수에 누적되어 더해짐
		 * 따라서 cnt를 초기화시켜줘야 함
		 * */
		for(num = 1; num <= 100; num += 1) {
			for(i = 1, cnt = 0; i <= num; i += 1) {
				if(num % i == 0) {
					cnt += 1;
				}
			}
			if(cnt == 2) {
			System.out.print(num + " ");
			}
		}

	}
}
