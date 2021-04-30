package day5;

import java.util.Scanner;

public class Practice5_3 {

	public static void main(String[] args) {
		/* 학생 세 명의 성적을 입력받은 후 총점과 평균을 출력하는 코드를 작성하세요. */
		Scanner scan = new Scanner(System.in);
		int []score = new int[3];
		int i;
		for(i = 0; i < score.length; i += 1) {
			System.out.print("성적을 입력하세요: ");
			score[i] = scan.nextInt();
		}
		scan.close();
		
		int sum = 0;
		for(i = 0; i < score.length; i += 1) {
			sum += score[i];
		}
		
		double avg = (double)sum / score.length; // 강제 타입 변환을 까먹었다..!
		System.out.println("총점: " + sum);
		System.out.println("평균: " + avg);
		
		/* 1부터 10까지의 랜덤한 수를 6개 생성하여 배열에 저장한 후 출력하는 코드를 작성하세요
		 * 단 생성된 랜덤한 수는 중복될 수 있음
		 * */
		
		int min = 1, max = 10;
		int []arr = new int[6];
		//(int)(Math.random() * (max - min + 1) + min);
		for(i = 0; i < arr.length; i += 1) {
			arr[i] = (int)(Math.random() * (max - min + 1) + min);
		}
		for(i = 0; i < arr.length; i += 1) {
			System.out.print(arr[i] + " ");
		}
	}

}
