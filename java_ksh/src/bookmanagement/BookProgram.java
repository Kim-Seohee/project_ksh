package bookmanagement;

import java.util.Scanner;

public class BookProgram {
	private Book []arr; // 책 정보를 저장할 배열
	private int count; // 저장된 책 정보의 개수
	private Scanner scan;
	
	public BookProgram() {
		this(10);
	}
	public BookProgram(int max) {
		if(max <= 10) {
			max = 10;
		}
		arr = new Book[max];
		scan = new Scanner(System.in);
	}
	
	// 책 정보를 추가하는 기능
	public void insert() {
		if(count < arr.length) {
			System.out.println("추가할 책 정보를 입력하세요");
			System.out.print("제목: ");
			String title = scan.nextLine();
			System.out.print("작가: ");
			String wrtier = scan.nextLine();
			System.out.print("역자: ");
			String translator = scan.nextLine();
			System.out.print("출판사: ");
			String publisher = scan.next();
			System.out.print("ISBN: ");
			int isbn = scan.nextInt();
			System.out.print("쪽수: ");
			int pages = scan.nextInt();
			System.out.print("장르: ");
			String genre = scan.next();
			Book tmpBook = new Book(title, wrtier, translator, publisher, isbn, pages, genre);
			arr[count] = tmpBook;
			count++;
		}
	}
	// 책 정보를 수정하는 기능
	public void update() {
		System.out.print("수정할 책 정보의 번호를 입력하세요: ");
		int index = scan.nextInt();
		if(index <= count && index >= 1) {
			System.out.print("제목: ");
			String title = scan.nextLine();
			System.out.print("작가: ");
			String wrtier = scan.nextLine();
			System.out.print("역자: ");
			String translator = scan.nextLine();
			System.out.print("출판사: ");
			String publisher = scan.next();
			System.out.print("ISBN: ");
			int isbn = scan.nextInt();
			System.out.print("쪽수: ");
			int pages = scan.nextInt();
			System.out.print("장르: ");
			String genre = scan.next();
			Book tmpBook = new Book(title, wrtier, translator, publisher, isbn, pages, genre);
			arr[index - 1] = tmpBook;
		}else {
			System.out.println("잘못된 번호입니다.");
		}
	}
	// 책 정보를 삭제하는 기능
	public void delete() {
		System.out.print("삭제할 책 정보의 번호를 입력하세요: ");
		int index = scan.nextInt();
		if(index > count || index < 1) {
			System.out.println("잘못된 번호입니다.");
			return;
		}
		// 삭제된 공간을 제거하기 위해 앞으로 하나씩 당겨줌
		for(int i = index - 1; i < count - 1; i++) {
			arr[i] = arr[i + 1];
		}
		// 삭제한 후 내역 개수를 줄여줌
		count--;		
	}
	// 책 정보를 열람하는 기능(전체 요약, 상세)
	public void printBookList() {
		System.out.println("번호    제목    저자   출판사");
		for(int i = 0; i < count; i++) {
			System.out.print((i + 1) + "   ");
			System.out.print(arr[i].getTitle() + "  ");
			System.out.print(arr[i].getWriter() + "  ");
			System.out.print(arr[i].getPublisher());
			System.out.println();
		}
	}
	public void printBookDetail() {
		System.out.print("열람할 책 정보의 번호를 입력하세요: ");
		int index = scan.nextInt();
		if(index <= count) {
			System.out.println("----" + index + "----");
			System.out.println("제목: " + arr[index - 1].getTitle());
			System.out.println("저자: " + arr[index - 1].getWriter());
			System.out.println("역자: " + arr[index - 1].getTranslator());
			System.out.println("출판사: " + arr[index - 1].getPublisher());
			System.out.println("ISBN: " + arr[index - 1].getIsbn());
			System.out.println("쪽수: " + arr[index - 1].getPages());
			System.out.println("장르: " + arr[index - 1].getGenre());
		}else {
			System.out.println("잘못된 번호입니다.");
		}
	}
	// 종료하는 기능
	public void quit() {
		System.out.println("프로그램을 종료합니다.");
		scan.close();
	}
	// 메뉴 출력 기능
	public void printMenu() {
		System.out.println("----메뉴----");
		System.out.println("1. 책 정보 추가");
		System.out.println("2. 책 정보 수정");
		System.out.println("3. 책 정보 삭제");
		System.out.println("4. 전체 책 정보 열람");
		System.out.println("5. 선택한 책 상세 정보 열람");
		System.out.println("6. 종료");
		System.out.println("------------");
		System.out.print("메뉴를 선택하세요: ");
	}
}
