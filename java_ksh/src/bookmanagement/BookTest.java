package bookmanagement;

import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
		BookProgram bp = new BookProgram();
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		
		do {
			bp.printMenu();
			menu = scan.nextInt();
			switch(menu) {
			case 1:
				bp.insert();
				break;
			case 2:
				bp.update();
				break;
			case 3:
				bp.delete();
				break;
			case 4:
				bp.printBookList();
				break;
			case 5:
				bp.printBookDetail();
				break;
			case 6:
				bp.quit();
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		}while(menu != 6);
		
		scan.close();
	}

}
