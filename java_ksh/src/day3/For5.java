package day3;

public class For5 {

	public static void main(String[] args) {
		/* 1부터 5까지의 합을 구하는 예제
		 * 반복 횟수: i는 1부터 5까지 1씩 증가
		 * 규칙성: sum = sum + i를 실행(sum += i)
		 * 		sum0 = 0 // sum0~5는 편의상 붙인 이름 실제로는 sum
		 * i=1  sum1 = 0 + 1                 = sum0 + 1
		 * i=2  sum2 = 0 + 1 + 2             = sum1 + 2
		 * i=3  sum3 = 0 + 1 + 2 + 3         = sum2 + 3
		 * i=4  sum4 = 0 + 1 + 2 + 3 + 4     = sum3 + 4
		 * i=5  sum5 = 0 + 1 + 2 + 3 + 4 + 5 = sum4 + 5
		 * */
		int i, sum = 0;
		for(i = 1; i <= 5; i++) {
			sum += i;
		}
		System.out.println("1부터 5까지의 합: " + sum);
	}

}
