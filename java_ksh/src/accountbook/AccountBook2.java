package accountbook;

import java.util.Scanner;

/* 클래스명: AccountBook2
 * - 수입 내역, 지출 내역을 관리하기 위한 가계부 클래스
 * */
public class AccountBook2 {
	private AccountBook2 []book;
	private Scanner scan;
	private int count;
	public AccountBook2() {
		this(10);
	}
	public AccountBook2(int max) {
		if(max <= 10) {
			max = 10;
		}
		book = new AccountBook2[max];
		scan = new Scanner(System.in);
	}
	// 수입/지출 내역을 입력받아 저장하는 메소드
	public void saveItem() {
		System.out.println("수입/지출을 입력하세요: ");
		String type = scan.next();
		System.out.println("날짜를 입력하세요: ");
		String date = scan.next();
		System.out.println("결제 타입을 입력하세요: ");
	}
}
