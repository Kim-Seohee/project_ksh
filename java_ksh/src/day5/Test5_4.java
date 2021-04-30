package day5;

import java.util.Scanner;

public class Test5_4 {

	public static void main(String[] args) {
		/* 학생 세 명의 성적을 입력받은 후 총점과 평균을 출력하는 코드를 작성하세요. */
		// 학생 세 명의 성적을 입력
		Scanner scan = new Scanner(System.in);
		int score[] = new int[3];
		int i;
		for(i = 0; i < score.length; i += 1) {
			System.out.print("성적 입력: ");
			score[i] = scan.nextInt();
		}
		// 총점을 구함
		/* sum = 0
		 * sum = 0 + score[0]
		 * sum = 0 + score[0] + score[1]
		 * sum = 0 + score[0] + score[1] + score[2]
		 * */
		int sum = 0;
		for(i = 0; i < score.length; i += 1) {
			sum += score[i];
		}
		// 평균을 구함
		double avg = (double)sum / score.length;
		// 출력
		System.out.println("총점: " + sum + "점, 평균: " + avg + "점");
		scan.close();
		
/*		int []arr = new int[3];
		int i;
		Scanner scan = new Scanner(System.in);
		for(i = 0; i < arr.length; i += 1) {
			System.out.print("학생의 점수를 입력하세요: ");
			arr[i] = scan.nextInt();
		}
		int tScore = 0;
		for(i = 0; i < arr.length; i += 1) {
			tScore += arr[i];
		}
		System.out.println("총점: " + tScore);
		System.out.println("평균: " + (double)tScore/arr.length);
			
		
		scan.close(); */
	}

}
