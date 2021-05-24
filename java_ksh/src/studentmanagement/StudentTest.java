package studentmanagement;

import java.util.Scanner;

public class StudentTest {

	public static void main(String[] args) {
		StudentProgram sp = new StudentProgram();
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		
		do {
			sp.printMenu();
			menu = scan.nextInt();
			switch(menu) {
			case 1:
				sp.insert();
				break;
			case 2:
				sp.update();
				break;
			case 3:
				sp.delete();
				break;
			case 4:
				sp.printStudentList();
				break;
			case 5:
				sp.printStudentDetail();
				break;
			case 6:
				sp.quit();
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		}while(menu != 6);
		
		scan.close();

	}

}
