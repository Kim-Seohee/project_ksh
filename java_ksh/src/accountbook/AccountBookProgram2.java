package accountbook;

import java.util.Scanner;

public class AccountBookProgram2 {
	AccountBook2 book;
	Scanner scan = new Scanner(System.in);

	/* 기능: 메뉴를 출력하는 메소드
	 * */
	public void menu() {
		System.out.println("-----메뉴-----");
		System.out.println("1. 가계부 입력");
		System.out.println("2. 가계부 수정");
		System.out.println("3. 가계부 삭제");
		System.out.println("4. 가계부 확인");
		System.out.println("5. 종료");
		System.out.println("-------------");
		System.out.print("메뉴 선택: ");
	}
	public void submenu() {
		System.out.println("-----확인-----");
		System.out.println("1. 전체 상세 내역");
		System.out.println("2. 전체 내역 요약");
		System.out.println("3. 선택 내역 상세");
		System.out.println("4. 내역 합계");
		System.out.println("-------------");
	}
	/* 기능: 내역을 입력받아 가계부에 저장하는 메소드
	 * 매개변수: 없음
	 * 리턴타입: 없음 => void
	 * 메소드명: insert
	 * */
	public void insert() {
		System.out.println("가계부 내역을 입력하세요.");
		Item item = createItem();
		book.insert(item);		
	}

	/* 기능: 수정할 내역의 번호와 내역정보를 입력받아 내역을 수정하는 메소드
	 * */
	public void scanUpdate() {
		System.out.print("수정할 번호를 입력하세요: ");
		int index = scan.nextInt();
		if(index < 1 || index > book.getCount()) {
			System.out.println("없는 내역입니다. 수정할 수 없습니다.");
			return;
		}
		System.out.println("수정할 내역을 입력하세요.");
		Item item = createItem();
		book.update(index - 1, item);
		System.out.println("수정이 완료되었습니다.");
	}
	/* 기능: 내역 정보를 입력받아 내역을 생성하여 알려주는 메소드
	 * 매개변수: 없음
	 * 리턴타입: 생성된 내역 => Item
	 * 메소드명: createItem
	 * */
	// 프로그램 내에서만 쓸 것이기 때문에 private으로 만든다.
	private Item createItem() {
		System.out.print("타입을 입력하세요: ");
		String type = scan.next();
		System.out.print("날짜를 입력하세요: ");
		String date = scan.next();
		System.out.print("자산 형태를 입력하세요: ");
		String paymentType = scan.next();
		System.out.print("분류를 입력하세요: ");
		String category = scan.next();
		System.out.print("금액을 입력하세요: ");
		int cost = scan.nextInt();
		System.out.print("내용을 입력하세요: ");
		String contents = scan.next();
		Item tmpItem = new Item(type, date, paymentType, category, cost, contents);
		return tmpItem;
	}
	/* 기능: 삭제할 번호를 입력받아 내역을 삭제하는 메소드
	 * */
	public void scanDelete() {
		System.out.print("삭제할 번호를 입력하세요: ");
		int index = scan.nextInt();
		if(index < 1 || index > book.getCount()) {
			System.out.println("없는 내역입니다. 삭제할 수 없습니다.");
			return;
		}
		book.delete(index - 1);
	}
	/* 기능: 내역 전체를 상세 출력하는 메소드
	 * */
	public void printItemListDetail() {
		book.printItemListDetail();
	}
	
	/* 기능: 내역 전체를 간략히 출력하는 메소드
	 * */
	public void printItemSimple() {
		book.printItemSimple();
	}
	
	/* 기능: 확인할 내역 번호를 입력받아 내역을 상세히 출력하는 메소드
	 * */
	public void scanPrintItem() {
		System.out.print("확인할 번호를 입력하세요: ");
		int index = scan.nextInt();
		if(index < 1 || index > book.getCount()) {
			System.out.println("없는 내역입니다. 확인할 수 없습니다.");
			return;
		}
		book.printItem(index - 1);
	}
	
	/* 기능: 가계부 금액을 출력하는 메소드
	 * */
	public void asset() {
		System.out.println("내역 합계: " + book.getTotal() + "원");
	}
	
	// 생성자
	public AccountBookProgram2(int max) {
		book = new AccountBook2(max);
	}
	public AccountBookProgram2() {
		book = new AccountBook2();
	}
	

}
