package day8;

public class Test8_7 {

	public static void main(String[] args) {
		/* 5개짜리 배열에 페어가 몇 개 있는지 판별하는 코드를 작성하세요.
		 * 단 숫자는 정렬되어 있다고 가정
		 * 예시: 1 1 2 3 4
		 * 1
		 * 예시: 1 2 3 4 5
		 * 0
		 * 예시: 1 1 2 2 4
		 * 2
		 * 예시: 1 1 1 2 3
		 * 0
		 * i번지의 값과 i+1번지의 값이 같으면 count를 1 증가
		 * 다르면
		 * 		count의 값이 2와 같으면 res를 += 1
		 * 		count를 1로 초기화
		 * 	반복문 종료 후
		 * 	count가 2와 같으면 res에 1을 더해줌
		 * 	res를 출력
		 * */
		int []arr = new int[] {1,1,2,4,4};
		int count = 1;
		int res = 0; // 페어의 수를 나타내는 변수
		for(int i = 0; i < arr.length - 1; i += 1) {
			if(arr[i] == arr[i + 1]) {
				count += 1;
			} else {
				if(count == 2) {
					res += 1;
				}
				count = 1;
			}
		}
		if(count == 2) {
			res += 1;
		}
		
		System.out.println("페어의 수: " + res);
	}

}
