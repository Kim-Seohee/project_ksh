package accountbook;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountBookTest {

	public static void main(String[] args) {
		/* 가계부 프로그램을 구현하려고 한다. 이 때 필요한 클래스를 만들어보세요.
		 * 수입: 수입/지출
		 * 날짜: 
		 * 자산: 현금/은행/카드
		 * 분류: 식비/교통/건강
		 * 금액: 
		 * 내용: 
		 * */
		AccountBookProgram2 abp = new AccountBookProgram2();
		int menu = 0;
		int subMenu = 0;
		Scanner scan = new Scanner(System.in);
		
		do {
			try {
				abp.menu();
				menu = scan.nextInt();
				switch(menu) {
				case 1: abp.insert(); break;
				case 2: abp.scanUpdate(); break;
				case 3: abp.scanDelete(); break;
				case 4:
					abp.submenu();
					subMenu = scan.nextInt();
					switch(subMenu) {
					case 1: abp.printItemListDetail(); break;
					case 2: abp.printItemSimple(); break;
					case 3: abp.scanPrintItem(); break;
					case 4: abp.asset(); break;
					default: System.out.println("잘못된 메뉴");
					}
					break;
				case 5: System.out.println("종료합니다."); break;
				default: System.out.println("잘못된 메뉴");
				}
			}catch(InputMismatchException e) {
				System.out.println("값을 잘못 입력했습니다.");
				// 공백(스페이스)를 포함한 문자열을 엔터까지 가져옴, 가져와서 저장하지 않고 버림(입력 버퍼를 비워주는 역할)
				scan.nextLine();
				menu = 0;
			}
		} while(menu != 5);
		scan.close();
	}

}
