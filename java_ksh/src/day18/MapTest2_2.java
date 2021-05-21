package day18;

import java.util.HashMap;
import java.util.Scanner;

public class MapTest2_2 {

	public static void main(String[] args) {
		/* 다음 두 기능을 가진 프로그램을 작성하세요.
		 * 1. 회원가입
		 * 2. 로그인
		 * 3. 종료
		 * 예시
		 * 1. 회원가입
		 * 2. 로그인
		 * 3. 종료
		 * 메뉴 선택: 1
		 * 회원가입
		 * 아이디: abc123
		 * 비밀번호: abc123
		 * 회원가입이 되었습니다.
		 * 1. 회원가입
		 * 2. 로그인
		 * 3. 종료
		 * 메뉴 선택: 1
		 * 아이디: abc123
		 * =====이미 가입된 회원입니다.=====
		 * 1. 회원가입
		 * 2. 로그인
		 * 3. 종료
		 * 메뉴 선택: 2
		 * 아이디: abc123
		 * 비밀번호: abc123
		 * =====로그인 성공=====
		 * 1. 회원가입
		 * 2. 로그인
		 * 3. 종료
		 * 메뉴 선택: 2
		 * 아이디: abc123
		 * 비밀번호: 1234
		 * =====로그인 실패=====
		 * */
		HashMap<String, String> info = new HashMap<String, String>();
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		// 반복문
		do {
			// 메뉴 출력
			menu();
			// 메뉴 입력
			System.out.print("메뉴 선택: ");
			menu = scan.nextInt();
			switch(menu) {
			// 회원가입 기능
			case 1 :
				System.out.println("회원가입");
				// 아이디 입력
				System.out.print("아이디: ");
				String id = scan.next();
				// 가입된 아이디이면 이미 가입된 아이디라고 출력
				if(info.containsKey(id)) {
					System.out.println("=====이미 가입된 회원입니다.=====");
					break;
				}
				// 가입된 아이디가 아니면 비밀번호 입력 후 아이디와 비밀번호를 저장
				System.out.print("비밀번호: ");
				String pw = scan.next();				
				info.put(id, pw);
				System.out.println("회원가입되었습니다.");
				break;
			case 2 :
				System.out.println("로그인");
				// 아이디 입력
				System.out.print("아이디: ");
				String id2 = scan.next();
				// 비밀번호 입력
				System.out.print("비밀번호: ");
				String pw2 = scan.next();
				// 아이디와 비밀번호가 일치하는지 확인하여 같으면 로그인 성공
				try {
					if(info.get(id2).equals(pw2)) {
						System.out.println("=====로그인 성공=====");
					}
					// 다르면 로그인 실패라고 출력
					else {
						System.out.println("=====로그인 실패=====");
					}
				} catch(NullPointerException e) {
					System.out.println("존재하지 않는 아이디입니다.");
				}
				break;
			case 3 :
				System.out.println("종료합니다.");
			}
			
		}while(menu != 3);
		scan.close();

	}
public static void menu() {
	System.out.println("1. 회원가입");
	System.out.println("2. 로그인");
	System.out.println("3. 종료");
}
/* 기능: 아이디를 입력받아 가입된 아이디가 아니면 비밀번호 입력 후 아이디와 비밀번호를 저장하고,
 * 		가입된 아이디이면 이미 가입된 아이디라고 출력하는 메소드*/
}
