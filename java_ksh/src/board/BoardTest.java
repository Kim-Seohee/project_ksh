package board;

import java.util.Scanner;

public class BoardTest {

	public static void main(String[] args) {
		/* 다음 메뉴를 가지는 게시글 콘솔 프로그램을 만드세요.
		 * 1. 게시글 등록
		 * 2. 게시글 수정
		 * 3. 게시글 삭제
		 * 4. 게시글 목록 확인
		 * 5. 게시글 상세 확인
		 * 6. 프로그램 종료
		 * */
		// 반복문을 이용하여 메뉴를 출력하고 메뉴를 선택하는 작업, 프로그램 종료를 선택할때까지
			// 선택한 메뉴가 1이면 게시글 등록이라고 출력
			// 선택한 메뉴가 2이면 게시글 수정이라고 출력
			// 선택한 메뉴가 3이면 게시글 삭제라고 출력
			// 선택한 메뉴가 4이면 게시글 목록 확인이라고 출력
			// 선택한 메뉴가 5이면 게시글 상세 확인이라고 출력
			// 선택한 메뉴가 6이면 프로그램 종료라고 출력
			// 선택한 메뉴가 1~6이 아니면 잘못된 메뉴라고 출력
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		do {
			// 메뉴를 출력
			System.out.println("-----메뉴-----");
			System.out.println("1. 게시글 등록");
			System.out.println("2. 게시글 수정");
			System.out.println("3. 게시글 삭제");
			System.out.println("4. 게시글 목록 확인");
			System.out.println("5. 게시글 상세 확인");
			System.out.println("6. 프로그램 종료");
			System.out.println("------------");
			System.out.print("메뉴를 선택하세요: ");
			// 메뉴를 선택
			menu = scan.nextInt();
			// 선택된 메뉴에 따라 기능 안내문 출력
			switch(menu) {
			case 1 : 
				System.out.println("등록");
				break;
			case 2 : 
				System.out.println("수정");
				break;
			case 3 : 
				System.out.println("삭제");
				break;
			case 4 : 
				System.out.println("목록");
				break;
			case 5 : 
				System.out.println("상세");
				break;
			case 6 : 
				System.out.println("프로그램 종료");
				break;
			default : 
				System.out.println("잘못된 메뉴");
			}		
		} while(menu != 6);
		scan.close();
	}
}
