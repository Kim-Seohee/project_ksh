package day8;

public class Practice8_2 {

	public static void main(String[] args) {
		/* 4개의 성적을 입력받아 합격인지 불합격인지 판별하는 코드를 작성하세요.
		 * 합격 기준
		 *  - 모든 성적이 과락이 없어야 함
		 *  - 평균 60점 이상
		 * 과락: 성적이 40점 미만
		 * 예시 (과락이 있는 경우)
		 * 성적: 40 30 100 100
		 * 불합격입니다.
		 * 예시 (합격)
		 * 성적: 60 40 100 100
		 * 합격입니다.
		 * 예시 (평균이 60 미만인 경우)
		 * 성적: 40 50 40 60
		 * 불합격입니다.
		 * */
		int []score = new int[] {40, 30, 100, 100};
		int sum = 0;
		for(int tmp : score) {
			sum += tmp;
		}
		double avg = (double)sum / score.length;
		
		boolean pass = true;
		if(avg < 60) {
			pass = false;
		}
		for(int i = 0; i < score.length; i += 1) {
			if(score[i] < 40) {
				pass = false;
				break;
			}
		}
		
		if(pass) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}

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
		 * */
		int []arr1 = new int[] {1, 1, 2, 3, 4};
		int count = 1;
		for(int i = 0; i < arr1.length - 1; i += 1) {
			if(arr1[i] + 1 == arr1[i + 1]) {
				count += 1;
			} else {
				count = 1;
			}
			if(count == 3) {
				break;
			}
		}
		if(count == 3) {
			System.out.println("연속");
		} else {
			System.out.println("연속 아님");
		}
		
		/* 5개짜리 배열에 같은 숫자가 2개 있는지 없는지 판별하는 코드를 작성하세요.
		 * 단 숫자는 정렬되어 있다고 가정
		 * 예시: 1 1 2 3 4
		 * 있음
		 * 예시: 1 2 3 4 5
		 * 없음
		 * 예시: 1 1 2 2 4
		 * 있음
		 * 예시: 1 1 1 2 3
		 * 없음
		 * 예시: 1 1 1 2 2
		 */
		int []arr2 = new int[] {1, 1, 2, 3, 4};
		int count2 = 1;
		boolean res = false;
		for(int i = 0; i < arr2.length - 1; i += 1) {
			if(arr2[i] == arr2[i + 1]) {
				count2 += 1;
			} else {
				if(count2 == 2) {
					res = true;
				}
				count2 = 1;
			}
		}
		if(count2 == 2) {
			res = true;
		}
		if(res) {
			System.out.println("있음");
		} else {
			System.out.println("없음");
		}
		
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
		 */
		int []arr3 = new int[] {1, 1, 2, 3, 4};
		int count3 = 1;
		int res2 = 0;
		for(int i = 0; i < arr3.length - 1; i += 1) {
			if(arr3[i] == arr3[i + 1]) {
				count3 += 1;
			} else {
				if(count3 == 2) {
					res2 += 1;
				}
				count3 = 1;
			}
		}
		if(count3 == 2) {
			res2 += 1;
		}
		System.out.println(res2);
	}

}
