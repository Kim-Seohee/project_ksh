package day5;

public class Test5_5 {

	public static void main(String[] args) {
		/* 1부터 10까지의 랜덤한 수를 6개 생성하여 배열에 저장한 후 출력하는 코드를 작성하세요
		 * 단 생성된 랜덤한 수는 중복될 수 있음
		 * */
		// 반복문
			// 랜덤으로 1~10 사이의 수 생성
			// 생성된 랜덤한 수를 배열에 저장
		int min = 1, max = 10;
		int i, r;
		int[] arr = new int[6];
		for(i = 0; i < arr.length; i += 1) {
			r = (int)(Math.random() * (max - min + 1) + min);
			arr[i] = r;
		}
		// int r = (int)(Math.random() * (max - min + 1) + min);
		for(i = 0; i < arr.length; i += 1) {
			System.out.print(arr[i] + " ");
		}
		// 반복문
			// 배열 값 출력
		
/*		int i, min = 1, max = 10;
		int[] num = new int[6];
		for(i = 0; i < num.length; i += 1) {
			num[i] = (int)(Math.random() * (max - min + 1) + min);
		}
		for(i = 0; i < num.length; i += 1) {
			System.out.print(num[i] + " ");
		}
*/
		
	}

}
