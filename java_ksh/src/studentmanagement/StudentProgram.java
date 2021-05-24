package studentmanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentProgram {
	private ArrayList<Student> list;
	private Scanner scan;
	
	public StudentProgram() {
		list = new ArrayList<Student>();
		scan = new Scanner(System.in);	
	}
	
	// 학생 정보를 추가하는 기능
	public void insert() {
		System.out.println("추가할 학생 정보를 입력하세요.");
		System.out.print("이름: ");
		String name = scan.next();
		System.out.print("성별: ");
		String gender = scan.next();
		System.out.print("생년월일: ");
		String birth = scan.next();
		System.out.print("수업명: ");
		String className = scan.next();
		System.out.print("연락처: ");
		String phone = scan.next();
		System.out.print("주소: ");
		String address = scan.next();
		System.out.print("등록일자: ");
		String regDay = scan.next();
		Student student = new Student(name, gender, birth, className, phone, address, regDay);
		list.add(student);
	}
	
	// 학생 정보를 수정하는 기능
	public void update() {
		System.out.print("수정할 학생 정보의 번호를 입력하세요: ");
		int num = scan.nextInt();
		if(num >= 1 && num <= list.size()) {
			System.out.print("이름: ");
			String name = scan.next();
			System.out.print("성별: ");
			String gender = scan.next();
			System.out.print("생년월일: ");
			String birth = scan.next();
			System.out.print("수업명: ");
			String className = scan.nextLine();
			System.out.print("연락처: ");
			String phone = scan.next();
			System.out.print("주소: ");
			String address = scan.nextLine();
			System.out.print("등록일자: ");
			String regDay = scan.next();
			Student student = new Student(name, gender, birth, className, phone, address, regDay);
			list.set(num - 1, student);
		}else {
			System.out.println("잘못된 번호입니다.");
		}
	}
	
	// 학생 정보를 삭제하는 기능
	public void delete() {
		System.out.print("삭제할 학생 정보의 번호를 입력하세요: ");
		int num = scan.nextInt();
		if(num < 1 || num > list.size()) {
			System.out.println("잘못된 번호입니다.");
			return;
		}
		list.remove(num - 1);
	}
	
	// 책 정보를 열람하는 기능(전체 요약, 상세)
	public void printStudentList() {
		System.out.println("이름    성별    생년월일    수업명");
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getName() + "  ");
			System.out.print(list.get(i).getGender() + "  ");
			System.out.print(list.get(i).getBirth() + "  ");
			System.out.print(list.get(i).getClassName());
			System.out.println();
		}
	}
	
	public void printStudentDetail() {
		System.out.print("열람할 학생 정보의 번호를 입력하세요: ");
		int num = scan.nextInt();
		if(num >= 1 && num <= list.size()) {
			System.out.println("====" + num + "====");
			System.out.println("이름: " + list.get(num - 1).getName());
			System.out.println("성별: " + list.get(num - 1).getGender());
			System.out.println("생년월일: " + list.get(num - 1).getBirth());
			System.out.println("연락처: " + list.get(num - 1).getPhone());
			System.out.println("주소: " + list.get(num - 1).getAddress());
			System.out.println("수업명: " + list.get(num - 1).getClassName());
			System.out.println("등록일자: " + list.get(num - 1).getRegDay());
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
		System.out.println("1. 학생 정보 추가");
		System.out.println("2. 학생 정보 수정");
		System.out.println("3. 학생 정보 삭제");
		System.out.println("4. 전체 학생 정보 열람");
		System.out.println("5. 선택한 학생 상세 정보 열람");
		System.out.println("6. 종료");
		System.out.println("------------");
		System.out.print("메뉴를 선택하세요: ");
	}
}
