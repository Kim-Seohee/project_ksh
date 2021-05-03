package day5;

import java.util.Scanner;

public class Dowhile {

	public static void main(String[] args) {
		/* 입력받은 문자가 q 또는 Q이면 종료하는 예제
		 * */
		char ch;
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.print("입력(종료하려면 q/Q 입력): ");
			ch = scan.next().charAt(0);
			if(ch == 'q' || ch == 'Q') {
				System.out.println("종료하겠습니다.");
			}
		} while (ch != 'q' && ch != 'Q');
		
		scan.close(); 
	}

}
